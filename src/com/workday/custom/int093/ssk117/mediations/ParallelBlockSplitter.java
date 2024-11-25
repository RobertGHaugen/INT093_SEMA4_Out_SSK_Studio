package com.workday.custom.int093.ssk117.mediations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.activation.DataHandler;

import org.apache.commons.lang3.StringUtils;

import com.capeclear.assembly.impl.AssemblyUtils;
import com.capeclear.assembly.model.SplitterStrategyType;
import com.capeclear.capeconnect.attachments.io.FileBackedManagedData;
import com.capeclear.logger.LogControl;
import com.capeclear.logger.Logger;
import com.capeclear.mediation.MediationContext;
import com.capeclear.mediation.MediationContextSplitter;
import com.capeclear.mediation.MediationMessage;
import com.capeclear.mediation.MediationMessageSplitter;
import com.capeclear.mediation.impl.DataHandlerSource;
import com.capeclear.mediation.impl.cc.MediationTube;
import com.workday.custom.int093.ssk117.parsers.IParser;
import com.workday.custom.int093.ssk117.writers.DefaultTransformer;
import com.workday.custom.int093.ssk117.writers.ITransformer;

public class ParallelBlockSplitter implements MediationContextSplitter, MediationMessageSplitter {
	private Logger log = LogControl.getLogger(getClass());
	
	private FileBackedManagedData fbmdOfOriginal;
	private FileBackedManagedData fbmdOfBlock;
	private String[] parsedData = null;
	private String priorKeyValue = null;
	private int blockCount = 0;
	
	private boolean isFirstLineColumnNames;
	private int blockSize;
	private String lineGroupColumnName;
	private boolean isNoBlockSplitError;
	
	private String [] headers = null;
	private int lineGroupColumnIndex = -1;

	private EnhancedBufferedReader enhancedReader;
	
	private IParser parser;
	private ITransformer transformer;
	
	private String propertyNameIsFirstLineColumnNames;
	private String propertyNameBlockSize;
	private String propertyNameBlockGroupColumnName;
	private String propertyNameParser;
	private String propertyNameTransformer;
	private String propertyNameNoBlockSplitIsError;
	
	private String propertyNameBlockCount;
	private String propertyNameBlockLineCount;
	private String propertyNameBlockGroupKeyValue;
	
	private String propertyValueBlockCount;
	private String propertyValueBlockLineCount;
	private String propertyValueBlockGroupKeyValue;
	
	private final String c2pBlockCount = "c2pBlockCount117";
	private final String c2pLineCount = "c2pBlockLineCount117";
	private final String c2pGropuKey = "c2pGroupKeyValue117";
	
	@Override
	public void setMediationMessage(MediationMessage message) throws Exception {
		MediationContext mc = MediationTube.getCurrentMediationContext();
		
		initializeProperties(mc);
		initializeFileBackedManagedData(message);
		initializeReader(message);
		
		parser.setReader(enhancedReader);
		
		try {
			headers = parser.getHeaders(isFirstLineColumnNames);
			
			if (isNoBlockSplitError && !parser.hasNext()) {
				throw new RuntimeException("No Block Split Error: There were no data lines found in the input.");
			}
						
			if (lineGroupColumnName != null) {
				setGroupColumnIndex(); 
			}
			
			transformer.setFieldNames(headers);
		} catch (Exception e) {
			log.error("An exception occurred attempting to initialize " + getClass().getCanonicalName() + " with a MediationMessage.", e);

			if (enhancedReader != null) {
				enhancedReader.close();
				enhancedReader = null;
			}
			
			throw new RuntimeException(e.getMessage(), e);
		} finally {

		}		
	}
	
	private void initializeProperties(MediationContext mc) throws Exception {
		if (StringUtils.isBlank(propertyNameIsFirstLineColumnNames)) {
			throw new IllegalStateException("The name of the property from which the flag indicating header line presence is provided cannot be blank.");
		} 
		if (StringUtils.isBlank(propertyNameBlockSize)) {
			throw new IllegalStateException("The name of the property from which the block size may be provided cannot be blank.");
		} 
		if (StringUtils.isBlank(propertyNameBlockGroupColumnName)) {
			throw new IllegalStateException("The name of the property from which the line grouping field id may be provided cannot be blank.");
		} 

		Object objFirstLineColumnNames = mc.getProperty(propertyNameIsFirstLineColumnNames);
		isFirstLineColumnNames = (objFirstLineColumnNames == null) ? false : (boolean)objFirstLineColumnNames;
		
		if (mc.containsProperty(propertyNameBlockSize) && mc.getProperty(propertyNameBlockSize) != null && ((int)mc.getProperty(propertyNameBlockSize) > 0)) {
			if (mc.containsProperty(propertyNameBlockGroupColumnName) && mc.getProperty(propertyNameBlockGroupColumnName) != null) {
				throw new IllegalStateException("The block size property and the line grouping field id are mutually exclusive.  Only one of the two values should be set.");
			}
			blockSize = (int)mc.getProperty(propertyNameBlockSize);
		}
		
		if (mc.containsProperty(propertyNameBlockGroupColumnName) && mc.getProperty(propertyNameBlockGroupColumnName) != null) {
			if (mc.containsProperty(propertyNameBlockSize) && mc.getProperty(propertyNameBlockSize) != null && ((int)mc.getProperty(propertyNameBlockSize) > 0)) {
				throw new IllegalStateException("The block size property and the line grouping field id are mutually exclusive.  Only one of the two values should be set.");
			}
			lineGroupColumnName = (String)mc.getProperty(propertyNameBlockGroupColumnName);
		}
		
		propertyValueBlockCount = (mc.getProperty((String)mc.getProperty(propertyNameBlockCount)) != null) ? (String)mc.getProperty((String)mc.getProperty(propertyNameBlockCount)) : c2pBlockCount;
		propertyValueBlockLineCount = (mc.getProperty((String)mc.getProperty(propertyNameBlockLineCount)) != null) ? (String)mc.getProperty((String)mc.getProperty(propertyNameBlockLineCount)) : c2pLineCount;
		propertyValueBlockGroupKeyValue = (mc.getProperty((String)mc.getProperty(propertyNameBlockGroupKeyValue)) != null) ? (String)mc.getProperty((String)mc.getProperty(propertyNameBlockGroupKeyValue)) : c2pGropuKey;
		
		Object objParser = mc.getProperty(propertyNameParser);
		parser = (IParser)objParser;
		
		Object objTransformer = mc.getProperty(propertyNameTransformer);
		if (mc.containsProperty(propertyNameTransformer)) {
			if (objTransformer != null) {
				transformer = (ITransformer)objTransformer;
			} else {
				transformer = new DefaultTransformer();
			}
		} else {
			transformer = new DefaultTransformer();
		}
		
		isNoBlockSplitError = mc.containsProperty(propertyNameNoBlockSplitIsError) ? (boolean)mc.getProperty(propertyNameNoBlockSplitIsError) : false;
	}

	private void initializeReader(MediationMessage message) throws Exception {
		enhancedReader = new EnhancedBufferedReader(
				new BufferedReader(
						new InputStreamReader(
								fbmdOfOriginal.getInputStream())));
	}

	private void initializeFileBackedManagedData(MediationMessage message) throws Exception {
		@SuppressWarnings("unchecked")
		DataHandlerSource dhs = (DataHandlerSource)message.getMessage(new Class[] {DataHandlerSource.class});
		DataHandler dh = dhs.getDataHandler();
		
		fbmdOfOriginal = FileBackedManagedData.getFBMDFromDataHandler(dh);
		setLongLived(fbmdOfOriginal, true);
	}
	
	private void setGroupColumnIndex() {
		for (int i = 0; i < headers.length; i++) {
			if (lineGroupColumnName.equalsIgnoreCase(headers[i])) {
				lineGroupColumnIndex = i;
				break;
			}
		}
	}
	
	/**
	 * If the specified message is stored with FileBackedManagedData then set this to be long lived in order to prevent
	 * garbage collection whilst we are still interested in using it. 
	 * 
	 * @param isLongLived
	 */
	private void setLongLived(FileBackedManagedData fbmd, boolean isLongLived) {
		if (fbmd != null) {
			fbmd.setLongLived(isLongLived);
		}
	}
	
	private MediationMessage getNextBlockMessage(MediationContext mc) throws Exception {
		MediationMessage returnValue = null;
		
		try {
			if (enhancedReader != null) {
				int blockRowCount = 0;

				initializeBlockOutput(mc);
				
				if (parsedData != null) {
					priorKeyValue = getCurrentKeyValue();
					transformer.transformRecordToOutputStream(parsedData);
					blockRowCount++;
				}
				
				while (parser.hasNext()) {
					parsedData = parser.next();
					if (priorKeyValue == null) {
						priorKeyValue = getCurrentKeyValue();
					}
					
					if (isEndOfBlock(getCurrentKeyValue(), blockRowCount)) {
						break;
					} else {
						transformer.transformRecordToOutputStream(parsedData);
						blockRowCount++;
					}
				}
				
				transformer.batch();
				returnValue = createMessage(fbmdOfBlock);
				blockCount++;
				fbmdOfBlock = null;
				
				if (lineGroupColumnIndex > -1) {
					mc.setProperty(propertyValueBlockGroupKeyValue, priorKeyValue);
				}
				mc.setProperty(propertyValueBlockCount, blockCount);
				mc.setProperty(propertyValueBlockLineCount, blockRowCount);
			}
		} catch (Throwable t) {
			log.error("An exception occurred during the parsing and transformation of the next block of data for a worker thread.", t);
			throw new RuntimeException(t.getMessage(), t);
		} finally {
			if (!parser.hasNext()) {
				if (enhancedReader != null) {
					enhancedReader.close();
					enhancedReader = null;
				}
				
				setLongLived(fbmdOfOriginal, false);
			}
		}
		
		return returnValue;
	}
	
	private String getCurrentKeyValue() {
		return (lineGroupColumnIndex < 0) ?
				null :
					parsedData[lineGroupColumnIndex];
	}
	
	private boolean isEndOfBlock(String currentKeyValue, int rowCount) {
		return (lineGroupColumnIndex >= 0) ? 
				(priorKeyValue != null && !priorKeyValue.equals(currentKeyValue)) : 
					(rowCount == blockSize);
	}
	
	private void initializeBlockOutput(MediationContext mc) throws Exception {
		if (fbmdOfBlock == null) { 
			fbmdOfBlock = createManagedData(mc);
			transformer.setOutputTarget(fbmdOfBlock);
		}
	}

    private FileBackedManagedData createManagedData(MediationContext mc) {
    	FileBackedManagedData returnValue = new FileBackedManagedData(transformer.getContentType());
        mc.addDisposable(returnValue);
        
        return returnValue;
    }

	/**
	 * Create a MediationMessage to wrap the output to our FilebackedManagedData root part
	 * 
	 * @param fbmd
	 * @return
	 * @throws IOException
	 */
	private MediationMessage createMessage(FileBackedManagedData fbmd) throws IOException {
		MediationMessage returnValue = AssemblyUtils.getMediationHelper().createMessage();
        returnValue.setRootPart(new DataHandlerSource(fbmd.getDataSource()), fbmd.getContentType());
        returnValue.setHeader("Content-Type", fbmd.getContentType());

        return returnValue;
	}

	@Override
	public boolean hasMore() throws Exception {
		return parser.hasNext();
	}

	/**
	 * Handle the message in a parallel child context
	 */
	@Override
	public boolean splitIntoContext(MediationContext childContext) throws Exception {
		MediationMessage returnValue = getNextBlockMessage(childContext);

		if (returnValue != null) {
			childContext.setMessage(returnValue);
		}

		return hasMore();
	}

	public void setPropertyNameIsFirstLineColumnNames(String propertyNameIsFirstLineColumnNames) {
		this.propertyNameIsFirstLineColumnNames = propertyNameIsFirstLineColumnNames;
	}

	public void setPropertyNameBlockSize(String propertyNameBlockSize) {
		this.propertyNameBlockSize = propertyNameBlockSize;
	}

	public void setPropertyNameBlockGroupColumnName(String propertyNameBlockGroupColumnName) {
		this.propertyNameBlockGroupColumnName = propertyNameBlockGroupColumnName;
	}

	public void setPropertyNameParser(String propertyNameParser) {
		this.propertyNameParser = propertyNameParser;
	}

	public void setPropertyNameTransformer(String propertyNameTransformer) {
		this.propertyNameTransformer = propertyNameTransformer;
	}
	
	public void setPropertyNameBlockCount(String propertyNameBlockCount) {
		this.propertyNameBlockCount = propertyNameBlockCount;
	}

	
	public void setPropertyNameBlockLineCount(String propertyNameBlockLineCount) {
		this.propertyNameBlockLineCount = propertyNameBlockLineCount;
	}

	
	public void setPropertyNameBlockGroupKeyValue(String propertyNameBlockGroupKeyValue) {
		this.propertyNameBlockGroupKeyValue = propertyNameBlockGroupKeyValue;
	}
	

	public void setPropertyNameNoBlockSplitIsError(String propertyNameNoBlockSplitIsError) {
		this.propertyNameNoBlockSplitIsError = propertyNameNoBlockSplitIsError;
	}

	/**
	 * Interface methods unused by this implementation.  This block splitter implicitly assumes
	 * a parallel context, and provides no support for classic splitter behavior.
	 */

	@Override
	public void setMediationContext(MediationContext mc) { }

	@Override
	public void setConfig(SplitterStrategyType config) { }

	@Override
	public MediationMessage getNextMessage() throws Exception {
		return null;
	}
	
	@Override
	public String getFooterForReport() throws Exception {
		return null;
	}

	@Override
	public String getHeaderForReport() throws Exception {
		return null;
	}
}

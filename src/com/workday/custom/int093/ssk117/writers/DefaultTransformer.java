package com.workday.custom.int093.ssk117.writers;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.apache.commons.lang.StringUtils;

import com.capeclear.capeconnect.attachments.io.FileBackedManagedData;
import com.workday.custom.int093.ssk117.Constants;

public class DefaultTransformer implements ITransformer {

	private final String contentType = "text/csv";
	
	private PrintWriter writer;
	private StringBuilder outputLine = new StringBuilder();

	@Override
	public String getContentType() {
		return contentType;
	}

	@Override
	public void setOutputTarget(FileBackedManagedData fbmd) throws Exception {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(fbmd.getOutputStream(), "utf-8")));
	}

	@Override
	public void transformRecordToOutputStream(String[] parsedRecordData) throws Exception {
		outputLine.setLength(0);

		for (int i = 0; i < parsedRecordData.length; i++) {
			if (i > 0) {
				outputLine.append(",");
			}
			
			boolean isContainsSeperator = parsedRecordData[i].contains(",");
			boolean isContainsEncapsulator = parsedRecordData[i].contains("\"");
			boolean isContainsLineBreak = parsedRecordData[i].contains(Constants.CRLF);
			
			if (isContainsSeperator || isContainsEncapsulator || isContainsLineBreak) {
				outputLine.append("\"")
					.append(StringUtils.replace(parsedRecordData[i], "\"", "\"\""))
					.append("\"");
			} else if (isContainsSeperator && !isContainsEncapsulator) {
				outputLine.append("\"")
					.append(parsedRecordData[i])
					.append("\"");
			} else {
				outputLine.append(parsedRecordData[i]);
			}
		}
		
		outputLine.append(Constants.CRLF);
		writer.write(outputLine.toString());
	}

	@Override
	public void batch() throws Exception {
		try {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
		} catch (Throwable t) {
			throw new RuntimeException(t.getMessage(), t);
		} finally {
			writer = null;
		}
	}

	@Override
	public void setFieldNames(String[] fieldNames) {
		// TODO Auto-generated method stub
		
	}
}

package com.workday.custom.int093.ssk117.writers;

import java.util.HashSet;
import java.util.Set;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.Namespace;
import javax.xml.stream.events.StartElement;

import org.apache.commons.lang3.StringUtils;

import com.capeclear.capeconnect.attachments.io.FileBackedManagedData;
import com.capeclear.xml.utils.XmlUtils;
import com.workday.custom.int093.ssk117.Constants;

public class XmlTransformer implements ITransformer {
	
	private final String contentType = "text/xml";
	
	private XMLEventWriter writer = null;
    private XMLEventFactory eventFactory;
	
	private String prefix = null;
	private String namespaceUri = null;
	
	private StartElement rootStart;
	private EndElement rootEnd;
	
	private StartElement rowStart;
	private EndElement rowEnd;

//	private String xmlElementNamePattern = "[A-Z] | \"_\" | [a-z] | [#xC0-#xD6] | [#xD8-#xF6] | [#xF8-#x2FF] | [#x370-#x37D] | [#x37F-#x1FFF] | [#x200C-#x200D] | [#x2070-#x218F] | [#x2C00-#x2FEF] | [#x3001-#xD7FF] | [#xF900-#xFDCF] | [#xFDF0-#xFFFD] | [#x10000-#xEFFFF] ([A-Z] | \"_\" | [a-z] | [#xC0-#xD6] | [#xD8-#xF6] | [#xF8-#x2FF] | [#x370-#x37D] | [#x37F-#x1FFF] | [#x200C-#x200D] | [#x2070-#x218F] | [#x2C00-#x2FEF] | [#x3001-#xD7FF] | [#xF900-#xFDCF] | [#xFDF0-#xFFFD] | [#x10000-#xEFFFF] | \"-\" | \".\" | [0-9] | #xB7 | [#x0300-#x036F] | [#x203F-#x2040])*";
//	private Pattern regex = Pattern.compile(xmlElementNamePattern);
	
	private String[] elementNames = null;
	
	public XmlTransformer(String rootName, String rootNamespace, String otherNamespaces, String rowName) throws Exception {
		String safeRootName = getValidElementName(rootName);
		String safeRowName = getValidElementName(rowName);
		
		eventFactory = XmlUtils.getXMLEventFactory();
		
		Set<Namespace> namespaces = new HashSet<Namespace>();
		
		if (StringUtils.isNotBlank(rootNamespace)) {
			if (StringUtils.countMatches(rootNamespace, ' ') != 1) {
				throw new IllegalArgumentException("The rootNamespace argument must be of the format \"alias namespace\", e.g. \"wd urn:com.workday/bsvc\".  More than one space was found in the value [" + rootNamespace + "].");
			}
			String[] splitRootNamespace = StringUtils.split(rootNamespace, " ");
			prefix = splitRootNamespace[0];
			namespaceUri = splitRootNamespace[1];
		}
		
		if (StringUtils.isNotBlank(otherNamespaces)) {
			if (StringUtils.countMatches(rootNamespace, ' ') % 2 != 1) {
				throw new IllegalArgumentException("The rootNamespace argument must be of the format \"alias namespace\", e.g. \"wd urn:com.workday/bsvc\".  More than one space was found in the value [" + rootNamespace + "].");
			}
			String[] splitNamespace = StringUtils.split(otherNamespaces, " ");
			for (int i = 0; i < splitNamespace.length; i = i + 2) {
				namespaces.add(eventFactory.createNamespace(splitNamespace[i], splitNamespace[i + 1]));
			}
		}
		
		rootStart = eventFactory.createStartElement(prefix, namespaceUri, safeRootName, null, namespaces.iterator());
		rootEnd = eventFactory.createEndElement(prefix, namespaceUri, safeRootName);
		
		rowStart = eventFactory.createStartElement(prefix, namespaceUri, safeRowName);
		rowEnd = eventFactory.createEndElement(prefix, namespaceUri, safeRowName);
	}
	
	private String getValidElementName(String name) {
		String[] originalCharacters = ((StringUtils.startsWithIgnoreCase(name, "xml")) ? ("___" + name.substring(3, name.length() - 1)) : name).split("");
		String[] returnValue = new String[originalCharacters.length];

		for (int i = 0; i < originalCharacters.length; i++) {
			returnValue[i] = (i == 0) ? getStartToken(originalCharacters[i]) : getToken(originalCharacters[i]);
		}
		
		return StringUtils.join(returnValue);
	}
	
	private String getStartToken(String token) {
		return isValidStartToken(token) ? token : "_";
	}

	private String getToken(String token) {
		return isValidToken(token) ? token : "_";
	}

	private boolean isValidStartToken(String token) {
        if (token == null || token.length() == 0) {
            return false;
        }

        char testChar = token.charAt(0);
        if (Character.isLetter(testChar) ||
        		testChar == Constants.UNDERSCORE) {
            return true;
        }
        
        return false;
	}
	
	private boolean isValidToken(String token) {
        if (token == null || token.length() == 0) {
            return false;
        }

        char testChar = token.charAt(0);
        if (Character.isLetterOrDigit(testChar) ||
        		testChar == Constants.UNDERSCORE ||
        		testChar == Constants.HYPHEN ||
        		testChar == Constants.PERIOD) {
            return true;
        }
        
        return false;
	}
	
	@Override
	public String getContentType() {
		return contentType;
	}

	@Override
	public void setOutputTarget(FileBackedManagedData fbmd) throws Exception {
		writer = XmlUtils.getXMLOutputFactory().createXMLEventWriter(fbmd.getOutputStream());
		writer.add(eventFactory.createStartDocument("UTF-8", "1.0"));
		writer.add(rootStart);
	}

	@Override
	public void setFieldNames(String[] fieldNames) {
		elementNames = new String[fieldNames.length];
		
		for (int i = 0; i < fieldNames.length; i++) {
			elementNames[i] = getValidElementName(fieldNames[i]);
		}
	}

	@Override
	public void transformRecordToOutputStream(String[] parsedRecordData) throws Exception {
		writer.add(rowStart);
		
		for (int i = 0; i < parsedRecordData.length; i++) {
			writer.add(eventFactory.createStartElement(prefix, namespaceUri, elementNames[i]));
			writer.add(eventFactory.createCharacters(parsedRecordData[i]));
			writer.add(eventFactory.createEndElement(prefix, namespaceUri, elementNames[i]));
		}
		
		writer.add(rowEnd);
	}

	@Override
	public void batch() throws Exception {
		try {
			if (writer != null) {
				writer.add(rootEnd);
				writer.add(eventFactory.createEndDocument());
				writer.flush();
				writer.close();
			}
		} catch (Throwable t) {
			throw new RuntimeException(t.getMessage(), t);
		} finally {
			writer = null;
		}
	}
}

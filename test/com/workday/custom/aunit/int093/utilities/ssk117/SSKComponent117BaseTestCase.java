package com.workday.custom.aunit.int093.utilities.ssk117;

import java.util.Map;

import com.capeclear.mediation.MediationContext;
import com.workday.custom.aunit.int093.CommonTestCase;
import com.workday.custom.aunit.int093.utilities.UtilitiesTestCase;
import com.workday.utils.collections.ConcurrentHashSet;

public abstract class SSKComponent117BaseTestCase extends UtilitiesTestCase {
	public static final String VAR_DATA_LOCATION = "someVariableName";
	
	public static final String PROP_PARAMETER_IN_DATA_LOCATION = "inDataLocation";
	public static final String PROP_PARAMETER_IN_BLOCK_SIZE = "inBlockSize";
	public static final String PROP_PARAMETER_IN_GROUPBY_COLUMN = "inGroupByColumnName";
	public static final String PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER = "inIsFirstLineHeader";
	public static final String PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR = "inCsvFieldSeparator";
	public static final String PROP_PARAMETER_IN_FIXED_WIDTH_POSITIONS = "inFixedWidthPositions";
	public static final String PROP_PARAMETER_IN_TRANSFORMER = "inTransformer";
	public static final String PROP_PARAMETER_IN_PROCESS_ENDPOINT = "inProcessEndpoint";
	public static final String PROP_PARAMETER_IN_AGGREGATION_ENDPOINT = "inAggregationEndpoint";
	public static final String PROP_PARAMETER_IN_THREAD_COUNT = "inParallelThreadCount";
	public static final String PROP_PARAMETER_IN_THREAD_TIMEOUT = "inParallelThreadTimeout";
	public static final String PROP_PARAMETER_IN_SPLITTER_TIMEOUT = "inParallelSplitterTimeout";	
	public static final String PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR = "inIsNoBlockSplitAnError";
	public static final String PROP_PARAMETER_IN_THREAD_BLOCK_COUNT = "inThreadPropertyBlockCount";
	public static final String PROP_PARAMETER_IN_THREAD_BLOCK_LINE_COUNT = "inThreadPropertyBlockLineCount";
	public static final String PROP_PARAMETER_IN_THREAD_GROUP_KEY_VALUE = "inThreadPropertyGroupKeyValue";

	public static final String VALUE_PROPERTY_NAME_BLOCK_COUNT = "c2pBlockCount117";
	public static final String VALUE_PROPERTY_NAME_LINE_COUNT = "c2pBlockLineCount117";
	public static final String VALUE_PROPERTY_NAME_GROUP_KEY = "c2pGroupKeyValue117";

	public static final String MOCK_SSK117_PROCESS_ENDPOINT = "vm://INT093_SEMA4_Out_SSK_Studio/WorkerEndpoint_117";
	public static final String MOCK_SSK117_AGGREGATION_ENDPOINT = "vm://INT093_SEMA4_Out_SSK_Studio/AggregatorEndpoint_117";

	public static final String MOCK_SSK117_CSV_COMPLEX_NO_HEADER = "test/ssk/ssk117/ComplexNoHeader.csv";
	
	public static final String RESPONSE_SSK117_XML_COMPLEX_NO_HEADER_1 = "test/ssk/ssk117/Results_ComplexNoHeader_1.xml";
	public static final String RESPONSE_SSK117_XML_COMPLEX_NO_HEADER_2 = "test/ssk/ssk117/Results_ComplexNoHeader_2.xml";
	public static final String RESPONSE_SSK117_XML_COMPLEX_NO_HEADER_3 = "test/ssk/ssk117/Results_ComplexNoHeader_3.xml";
	public static final String RESPONSE_SSK117_XML_COMPLEX_NO_HEADER_4 = "test/ssk/ssk117/Results_ComplexNoHeader_4.xml";
	public static final String RESPONSE_SSK117_XML_COMPLEX_NO_HEADER_5 = "test/ssk/ssk117/Results_ComplexNoHeader_5.xml";

	public static final String MOCK_SSK117_CSV_COMPLEX_WITH_HEADER = "test/ssk/ssk117/ComplexWithHeader.csv";
	
	public static final String RESPONSE_SSK117_XML_COMPLEX_WITH_HEADER_1 = "test/ssk/ssk117/Results_ComplexWithHeader_1.xml";
	public static final String RESPONSE_SSK117_XML_COMPLEX_WITH_HEADER_2 = "test/ssk/ssk117/Results_ComplexWithHeader_2.xml";
	public static final String RESPONSE_SSK117_XML_COMPLEX_WITH_HEADER_3 = "test/ssk/ssk117/Results_ComplexWithHeader_3.xml";
	public static final String RESPONSE_SSK117_XML_COMPLEX_WITH_HEADER_4 = "test/ssk/ssk117/Results_ComplexWithHeader_4.xml";
	public static final String RESPONSE_SSK117_XML_COMPLEX_WITH_HEADER_5 = "test/ssk/ssk117/Results_ComplexWithHeader_5.xml";
	
	public static final String MOCK_SSK117_CSV_EMPTY_NO_HEADER = "test/ssk/ssk117/EmptyNoHeader.csv";
	
	public static final String MOCK_SSK117_CSV_EMPTY_WITH_HEADER = "test/ssk/ssk117/EmptyWithHeader.csv";
	
	public static final String RESPONSE_SSK117_XML_EMPTY = "test/ssk/ssk117/Results_Empty.xml";

	public static final String MOCK_SSK117_CSV_JOURNALS_NO_HEADER = "test/ssk/ssk117/JournalsNoHeader.csv";
	
	public static final String RESPONSE_SSK117_XML_JOURNALS_NO_HEADER_1 = "test/ssk/ssk117/Results_Journal_NoHeader_1.xml";
	public static final String RESPONSE_SSK117_XML_JOURNALS_NO_HEADER_2 = "test/ssk/ssk117/Results_Journal_NoHeader_2.xml";
	public static final String RESPONSE_SSK117_XML_JOURNALS_NO_HEADER_3 = "test/ssk/ssk117/Results_Journal_NoHeader_3.xml";
	public static final String RESPONSE_SSK117_XML_JOURNALS_NO_HEADER_4 = "test/ssk/ssk117/Results_Journal_NoHeader_4.xml";

	public static final String MOCK_SSK117_CSV_JOURNALS_WITH_HEADER = "test/ssk/ssk117/JournalsWithHeader.csv";
	
	public static final String RESPONSE_SSK117_XML_JOURNALS_WITH_HEADER_1 = "test/ssk/ssk117/Results_Journal_WithHeader_1.xml";
	public static final String RESPONSE_SSK117_XML_JOURNALS_WITH_HEADER_2 = "test/ssk/ssk117/Results_Journal_WithHeader_2.xml";
	public static final String RESPONSE_SSK117_XML_JOURNALS_WITH_HEADER_3 = "test/ssk/ssk117/Results_Journal_WithHeader_3.xml";
	public static final String RESPONSE_SSK117_XML_JOURNALS_WITH_HEADER_4 = "test/ssk/ssk117/Results_Journal_WithHeader_4.xml";

	public static final String MOCK_SSK117_CSV_MALFORMED_NO_HEADER = "test/ssk/ssk117/MalformedNoHeader.csv";

	public static final String RESPONSE_SSK117_XML_MALFORMED_NO_HEADER_1 = "test/ssk/ssk117/Results_MalformedNoHeader_1.xml";
	public static final String RESPONSE_SSK117_XML_MALFORMED_NO_HEADER_2 = "test/ssk/ssk117/Results_MalformedNoHeader_2.xml";

	public static final String MOCK_SSK117_CSV_MALFORMED_WITH_HEADER = "test/ssk/ssk117/MalformedWithHeader.csv";
	
	public static final String RESPONSE_SSK117_XML_MALFORMED_WITH_HEADER_ALL = "test/ssk/ssk117/Results_Malformed_WithHeader_0.xml";
	public static final String RESPONSE_SSK117_XML_MALFORMED_WITH_HEADER_1 = "test/ssk/ssk117/Results_Malformed_WithHeader_1.xml";
	public static final String RESPONSE_SSK117_XML_MALFORMED_WITH_HEADER_2 = "test/ssk/ssk117/Results_Malformed_WithHeader_2.xml";
	public static final String RESPONSE_SSK117_XML_MALFORMED_WITH_HEADER_3 = "test/ssk/ssk117/Results_Malformed_WithHeader_3.xml";
	public static final String RESPONSE_SSK117_XML_MALFORMED_WITH_HEADER_4 = "test/ssk/ssk117/Results_Malformed_WithHeader_4.xml";
	public static final String RESPONSE_SSK117_XML_MALFORMED_WITH_HEADER_5 = "test/ssk/ssk117/Results_Malformed_WithHeader_5.xml";
	public static final String RESPONSE_SSK117_XML_MALFORMED_WITH_HEADER_6 = "test/ssk/ssk117/Results_Malformed_WithHeader_6.xml";
	
	public static final String MOCK_SSK117_CSV_ONE_ROW_NO_HEADER = "test/ssk/ssk117/OneRowNoHeader.csv";

	public static final String RESPONSE_SSK117_XML_ONE_ROW_NO_HEADER = "test/ssk/ssk117/Results_OneRow_NoHeader_1.xml";
	
	public static final String MOCK_SSK117_CSV_ONE_ROW_WITH_HEADER = "test/ssk/ssk117/OneRowWithHeader.csv";
	
	public static final String RESPONSE_SSK117_XML_ONE_ROW_WITH_HEADER = "test/ssk/ssk117/Results_OneRow_WithHeader_1.xml";

	public static final String MOCK_SSK117_CSV_SIMPLE_NO_HEADER = "test/ssk/ssk117/SimpleNoHeader.csv";

	public static final String RESPONSE_SSK117_XML_SIMPLE_NO_HEADER_1 = "test/ssk/ssk117/Results_SimpleNoHeader_1.xml";
	public static final String RESPONSE_SSK117_XML_SIMPLE_NO_HEADER_2 = "test/ssk/ssk117/Results_SimpleNoHeader_2.xml";
	public static final String RESPONSE_SSK117_XML_SIMPLE_NO_HEADER_3 = "test/ssk/ssk117/Results_SimpleNoHeader_3.xml";

	public static final String MOCK_SSK117_CSV_SIMPLE_NO_EOL_EOF = "test/ssk/ssk117/SimpleNoEOLAtEOF.csv";
	
	public static final String RESPONSE_SSK117_XML_SIMPLE_EOL_EOF_1 = "test/ssk/ssk117/Results_SimpleNoEOLAtEOF_1.xml";
	public static final String RESPONSE_SSK117_XML_SIMPLE_EOL_EOF_2 = "test/ssk/ssk117/Results_SimpleNoEOLAtEOF_2.xml";
	public static final String RESPONSE_SSK117_XML_SIMPLE_EOL_EOF_3 = "test/ssk/ssk117/Results_SimpleNoEOLAtEOF_3.xml";
	
	public static final String MOCK_SSK117_CSV_SIMPLE_WITH_HEADER = "test/ssk/ssk117/SimpleWithHeader.csv";
	
	public static final String RESPONSE_SSK117_XML_SIMPLE_WITH_HEADER_1 = "test/ssk/ssk117/Results_SimpleWithHeader_1.xml";
	public static final String RESPONSE_SSK117_XML_SIMPLE_WITH_HEADER_2 = "test/ssk/ssk117/Results_SimpleWithHeader_2.xml";
	public static final String RESPONSE_SSK117_XML_SIMPLE_WITH_HEADER_3 = "test/ssk/ssk117/Results_SimpleWithHeader_3.xml";
	
	protected ConcurrentHashSet<Integer> blockCounts = new ConcurrentHashSet<Integer>();
	protected Map<Integer, String> mapBlockToExpectedResult;

	protected void initializeComplexNoHeaderResultMap() {
		mapBlockToExpectedResult.put(1, RESPONSE_SSK117_XML_COMPLEX_NO_HEADER_1);
		mapBlockToExpectedResult.put(2, RESPONSE_SSK117_XML_COMPLEX_NO_HEADER_2);
		mapBlockToExpectedResult.put(3, RESPONSE_SSK117_XML_COMPLEX_NO_HEADER_3);
		mapBlockToExpectedResult.put(4, RESPONSE_SSK117_XML_COMPLEX_NO_HEADER_4);
		mapBlockToExpectedResult.put(5, RESPONSE_SSK117_XML_COMPLEX_NO_HEADER_5);
	}
	
	protected void initializeComplexWithHeaderResultMap() {
		mapBlockToExpectedResult.put(1, RESPONSE_SSK117_XML_COMPLEX_WITH_HEADER_1);
		mapBlockToExpectedResult.put(2, RESPONSE_SSK117_XML_COMPLEX_WITH_HEADER_2);
		mapBlockToExpectedResult.put(3, RESPONSE_SSK117_XML_COMPLEX_WITH_HEADER_3);
		mapBlockToExpectedResult.put(4, RESPONSE_SSK117_XML_COMPLEX_WITH_HEADER_4);
		mapBlockToExpectedResult.put(5, RESPONSE_SSK117_XML_COMPLEX_WITH_HEADER_5);
	}
	
	protected void initializeJournalsNoHeaderResultMap() {
		mapBlockToExpectedResult.put(1, RESPONSE_SSK117_XML_JOURNALS_NO_HEADER_1);
		mapBlockToExpectedResult.put(2, RESPONSE_SSK117_XML_JOURNALS_NO_HEADER_2);
		mapBlockToExpectedResult.put(3, RESPONSE_SSK117_XML_JOURNALS_NO_HEADER_3);
		mapBlockToExpectedResult.put(4, RESPONSE_SSK117_XML_JOURNALS_NO_HEADER_4);
	}
	
	protected void initializeJournalsWithHeaderResultMap() {
		mapBlockToExpectedResult.put(1, RESPONSE_SSK117_XML_JOURNALS_WITH_HEADER_1);
		mapBlockToExpectedResult.put(2, RESPONSE_SSK117_XML_JOURNALS_WITH_HEADER_2);
		mapBlockToExpectedResult.put(3, RESPONSE_SSK117_XML_JOURNALS_WITH_HEADER_3);
		mapBlockToExpectedResult.put(4, RESPONSE_SSK117_XML_JOURNALS_WITH_HEADER_4);
	}
	
	protected void initializeMalformedNoHeaderResultMap() {
		mapBlockToExpectedResult.put(1, RESPONSE_SSK117_XML_MALFORMED_NO_HEADER_1);
		mapBlockToExpectedResult.put(2, RESPONSE_SSK117_XML_MALFORMED_NO_HEADER_2);
	}
	
	protected void initializeOneRowNoHeaderResultMap() {
		mapBlockToExpectedResult.put(1, RESPONSE_SSK117_XML_ONE_ROW_NO_HEADER);
	}
	
	protected void initializeOneRowWithHeaderResultMap() {
		mapBlockToExpectedResult.put(1, RESPONSE_SSK117_XML_ONE_ROW_WITH_HEADER);
	}
	
	protected void initializeSimpleNoHeaderResultMap() {
		mapBlockToExpectedResult.put(1, RESPONSE_SSK117_XML_SIMPLE_NO_HEADER_1);
		mapBlockToExpectedResult.put(2, RESPONSE_SSK117_XML_SIMPLE_NO_HEADER_2);
		mapBlockToExpectedResult.put(3, RESPONSE_SSK117_XML_SIMPLE_NO_HEADER_3);
	}
	
	protected void initializeSimpleWithHeaderResultMap() {
		mapBlockToExpectedResult.put(1, RESPONSE_SSK117_XML_SIMPLE_WITH_HEADER_1);
		mapBlockToExpectedResult.put(2, RESPONSE_SSK117_XML_SIMPLE_WITH_HEADER_2);
		mapBlockToExpectedResult.put(3, RESPONSE_SSK117_XML_SIMPLE_WITH_HEADER_3);
	}
	
	protected void initializeMalformedWithHeaderByKeyResultMap() {
		mapBlockToExpectedResult.put(1, RESPONSE_SSK117_XML_MALFORMED_WITH_HEADER_1);
		mapBlockToExpectedResult.put(2, RESPONSE_SSK117_XML_MALFORMED_WITH_HEADER_2);
		mapBlockToExpectedResult.put(3, RESPONSE_SSK117_XML_MALFORMED_WITH_HEADER_3);
		mapBlockToExpectedResult.put(4, RESPONSE_SSK117_XML_MALFORMED_WITH_HEADER_4);
		mapBlockToExpectedResult.put(5, RESPONSE_SSK117_XML_MALFORMED_WITH_HEADER_5);
		mapBlockToExpectedResult.put(6, RESPONSE_SSK117_XML_MALFORMED_WITH_HEADER_6);
	}
	
	protected void initializeMalformedWithHeaderByCountResultMap() {
		mapBlockToExpectedResult.put(1, RESPONSE_SSK117_XML_MALFORMED_WITH_HEADER_ALL);
	}
	
	protected Integer validateSplitterToThreadProperties(MediationContext childContext, int blocks, int lines, String keyPrefix, String keyLiteral) throws Exception {
		
		return validateSplitterToThreadProperties(childContext, blocks, lines, null, keyPrefix, keyLiteral);
	}

	protected Integer validateSplitterToThreadProperties(MediationContext childContext, int blocks, int lines, String keyPrefix) throws Exception {
		
		return validateSplitterToThreadProperties(childContext, blocks, lines, null, keyPrefix, null);
	}

	protected void validateThreadEntryCsvComplexNoHeaderGroupByToXml(MediationContext childContext, int threadCounter) throws Exception {
		Integer blockCounter = validateSplitterToThreadProperties(childContext, threadCounter, 100, null);
		String expectedResult = mapBlockToExpectedResult.get(blockCounter);

		switch (threadCounter) {
			case 1 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 2 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 3 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 4 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 5 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			default :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + threadCounter));
				break;
		}
	}

	protected void validateThreadEntryCsvComplexNoHeaderCountToXml(MediationContext childContext, int threadCounter) throws Exception {
		Integer blockCounter = validateSplitterToThreadProperties(childContext, threadCounter, 100, null);
		String expectedResult = mapBlockToExpectedResult.get(blockCounter);

		switch (threadCounter) {
			case 1 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 2 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 3 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 4 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 5 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			default :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + threadCounter));
				break;
		}
	}

	protected void validateThreadEntryCsvComplexWithHeaderGroupByToXml(MediationContext childContext, int threadCounter) throws Exception {
		Integer blockCounter = validateSplitterToThreadProperties(childContext, threadCounter, 100, "ComplexKey00");
		String expectedResult = mapBlockToExpectedResult.get(blockCounter);

		switch (threadCounter) {
			case 1 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 2 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 3 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 4 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 5 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			default :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + threadCounter));
				break;
		}
	}

	protected void validateThreadEntryCsvComplexWithHeaderCountToXml(MediationContext childContext, int threadCounter) throws Exception {
		Integer blockCounter = validateSplitterToThreadProperties(childContext, threadCounter, 100, null);
		String expectedResult = mapBlockToExpectedResult.get(blockCounter);

		switch (threadCounter) {
			case 1 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 2 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 3 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 4 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 5 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			default :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + threadCounter));
				break;
		}
	}

	protected void validateThreadEntryCsvJournalsNoHeaderGroupByToXml(MediationContext childContext, int threadCounter) throws Exception {
		Integer blockCounter = validateSplitterToThreadProperties(childContext, threadCounter, 0, getJournalBlockLineCounts(), "Journal_", null);
		String expectedResult = mapBlockToExpectedResult.get(blockCounter);

		switch (threadCounter) {
			case 1 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 2 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 3 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 4 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			default :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + threadCounter));
				break;
		}
	}

	protected void validateThreadEntryCsvJournalsWithHeaderGroupByToXml(MediationContext childContext, int threadCounter) throws Exception {
		Integer blockCounter = validateSplitterToThreadProperties(childContext, threadCounter, 0, getJournalBlockLineCounts(), "Journal_", null);
		String expectedResult = mapBlockToExpectedResult.get(blockCounter);

		switch (threadCounter) {
			case 1 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 2 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 3 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 4 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			default :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + threadCounter));
				break;
		}
	}

	protected void validateThreadEntryCsvMalformedWithHeaderGroupByToXml(MediationContext childContext, int threadCounter) throws Exception {
		Integer blockCounter = validateSplitterToThreadProperties(childContext, threadCounter, 1, null);
		String expectedResult = mapBlockToExpectedResult.get(blockCounter);

		switch (threadCounter) {
			case 1 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 2 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 3 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 4 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 5 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 6 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			default :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + threadCounter));
				break;
		}
	}

	protected void validateThreadEntryCsvMalformedWithHeaderCountToXml(MediationContext childContext, int threadCounter) throws Exception {
		Integer blockCounter = validateSplitterToThreadProperties(childContext, threadCounter, 6, null);
		String expectedResult = mapBlockToExpectedResult.get(blockCounter);

		switch (threadCounter) {
			case 1 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			default :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + threadCounter));
				break;
		}
	}

	protected void validateThreadEntryCsvOneRowNoHeaderGroupByToXml(MediationContext childContext, int threadCounter) throws Exception {
		Integer blockCounter = validateSplitterToThreadProperties(childContext, threadCounter, 1, "Data 1.2");
		String expectedResult = mapBlockToExpectedResult.get(blockCounter);

		switch (threadCounter) {
			case 1 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			default :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + threadCounter));
				break;
		}
	}

	protected void validateThreadEntryCsvOneRowNoHeaderCountToXml(MediationContext childContext, int threadCounter) throws Exception {
		Integer blockCounter = validateSplitterToThreadProperties(childContext, threadCounter, 1, null);
		String expectedResult = mapBlockToExpectedResult.get(blockCounter);

		switch (threadCounter) {
			case 1 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			default :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + threadCounter));
				break;
		}
	}

	protected void validateThreadEntryCsvOneRowWithHeaderGroupByToXml(MediationContext childContext, int threadCounter) throws Exception {
		Integer blockCounter = validateSplitterToThreadProperties(childContext, threadCounter, 1, null, "Data 1.2");
		String expectedResult = mapBlockToExpectedResult.get(blockCounter);

		switch (threadCounter) {
			case 1 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			default :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + threadCounter));
				break;
		}
	}

	protected void validateThreadEntryCsvOneRowWithHeaderCountToXml(MediationContext childContext, int threadCounter) throws Exception {
		Integer blockCounter = validateSplitterToThreadProperties(childContext, threadCounter, 1, null);
		String expectedResult = mapBlockToExpectedResult.get(blockCounter);

		switch (threadCounter) {
			case 1 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			default :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + threadCounter));
				break;
		}
	}

	protected void validateThreadEntryCsvSimpleNoHeaderGroupByToXml(MediationContext childContext, int threadCounter) throws Exception {
		Integer blockCounter = validateSplitterToThreadProperties(childContext, threadCounter, 100, null);
		String expectedResult = mapBlockToExpectedResult.get(blockCounter);

		switch (threadCounter) {
			case 1 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 2 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 3 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			default :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + threadCounter));
				break;
		}
	}

	protected void validateThreadEntryCsvSimpleNoHeaderCountToXml(MediationContext childContext, int threadCounter) throws Exception {
		Integer blockCounter = validateSplitterToThreadProperties(childContext, threadCounter, 100, null);
		String expectedResult = mapBlockToExpectedResult.get(blockCounter);
		switch (threadCounter) {
			case 1 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 2 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 3 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			default :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + threadCounter));
				break;
		}
	}

	protected void validateThreadEntryCsvSimpleWithHeaderGroupByToXml(MediationContext childContext, int threadCounter) throws Exception {
		Integer blockCounter = validateSplitterToThreadProperties(childContext, threadCounter, 100, "");
		String expectedResult = mapBlockToExpectedResult.get(blockCounter);

		switch (threadCounter) {
			case 1 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 2 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 3 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			default :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + threadCounter));
				break;
		}
	}

	protected void validateThreadEntryCsvSimpleWithHeaderCountToXml(MediationContext childContext, int threadCounter) throws Exception {
		Integer blockCounter = validateSplitterToThreadProperties(childContext, threadCounter, 100, "");
		String expectedResult = mapBlockToExpectedResult.get(blockCounter);

		switch (threadCounter) {
			case 1 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 2 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			case 3 :
				assertMessageContent(childContext, expectedResult, CONTENT_TYPE_TEXT_XML, Comparator.dom);
				break;
			default :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + threadCounter));
				break;
		}
	}
	
	protected void assertMessageContent(MediationContext childContext, String resourcePathForExpectedValue, String contentType, Comparator c) throws Exception {
		assertTrue(String.format(MESSAGE_ROOT_UNEXPECTED_VALUE, resourcePathForExpectedValue), 
				compareAgainstSource(getMessageInputStream(childContext), contentType, resourcePathForExpectedValue, contentType, c));
	}

	protected Integer validateSplitterToThreadProperties(MediationContext childContext, int blocks, int lines, int[] lineCountByBlock, String keyPrefix, String keyLiteral) throws Exception {
		Object blockCount = childContext.getProperty(SSKComponent117BaseTestCase.VALUE_PROPERTY_NAME_BLOCK_COUNT);
		Object lineCount = childContext.getProperty(SSKComponent117BaseTestCase.VALUE_PROPERTY_NAME_LINE_COUNT);

		assertNotNull(String.format(CommonTestCase.MESSAGE_UNEXPECTED_NULL, SSKComponent117BaseTestCase.VALUE_PROPERTY_NAME_BLOCK_COUNT), blockCount);
		assertNotNull(String.format(MESSAGE_UNEXPECTED_NULL, SSKComponent117BaseTestCase.VALUE_PROPERTY_NAME_LINE_COUNT), lineCount);

		Integer thisBlock = Integer.valueOf(String.valueOf(blockCount));
		
		assertFalse(String.format("Current thread received a block counter that has already been received by another thread [%1$s]", String.valueOf(blockCount)), blockCounts.contains(thisBlock));
		blockCounts.add(thisBlock);
		
		if (lineCountByBlock == null) {
			assertEquals(String.format(MESSAGE_UNEXPECTED_VALUE_PROPERTY, SSKComponent117BaseTestCase.VALUE_PROPERTY_NAME_LINE_COUNT), lines, (int)lineCount);
		} else {
			assertEquals(String.format(MESSAGE_UNEXPECTED_VALUE_PROPERTY, SSKComponent117BaseTestCase.VALUE_PROPERTY_NAME_LINE_COUNT), lineCountByBlock[thisBlock - 1], (int)lineCount);
		}
		
		if (keyPrefix != null || keyLiteral != null) {
			Object groupKey = childContext.getProperty(SSKComponent117BaseTestCase.VALUE_PROPERTY_NAME_GROUP_KEY);
			
			assertNotNull(String.format(MESSAGE_UNEXPECTED_NULL, SSKComponent117BaseTestCase.VALUE_PROPERTY_NAME_GROUP_KEY), groupKey);

			if (keyPrefix != null) {
				assertEquals(String.format(MESSAGE_UNEXPECTED_VALUE_PROPERTY, SSKComponent117BaseTestCase.VALUE_PROPERTY_NAME_GROUP_KEY), keyPrefix + thisBlock, (String)groupKey);
			} else {
				assertEquals(String.format(MESSAGE_UNEXPECTED_VALUE_PROPERTY, SSKComponent117BaseTestCase.VALUE_PROPERTY_NAME_GROUP_KEY), keyLiteral, (String)groupKey);
			}
		}
		
		return thisBlock;
	}

	protected int[] getJournalBlockLineCounts() {
		int[] returnValue = new int[4];
		returnValue[0] = 112;
		returnValue[1] = 106;
		returnValue[2] = 112;
		returnValue[3] = 102;
		
		return returnValue;
	}

}

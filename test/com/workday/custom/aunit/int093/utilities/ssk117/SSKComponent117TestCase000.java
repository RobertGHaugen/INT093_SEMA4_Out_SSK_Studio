package com.workday.custom.aunit.int093.utilities.ssk117;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.capeclear.capeconnect.attachments.io.FileBackedManagedData;
import com.capeclear.logger.LogControl;
import com.capeclear.logger.Logger;
import com.capeclear.mediation.MediationContext;
import com.capeclear.mediation.impl.cc.MediationTube;
import com.workday.aunit.annotations.AssemblyTest;
import com.workday.aunit.annotations.AssertAfter;
import com.workday.aunit.annotations.UnitTest;
import com.workday.custom.int093.ssk117.writers.XmlTransformer;

@AssemblyTest(project="INT093_SEMA4_Out_SSK_Studio", displayLabel="Test runner for Text block splitter")
public class SSKComponent117TestCase000 extends SSKComponent117BaseTestCase {
	private Logger log = LogControl.getLogger(getClass());

	int	blockSize;
	String processEndpoint;
	AtomicInteger threadSpawnCounter;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		super.setupGlobalInitialization();
		mockTracker.addComponentTracking("InitializeAndFinalize_XSLT_112");

		ctx.setProperty(PROP_PARAMETER_IN_ABORT_ON_ERROR, true);

		processEndpoint = null;

		//this is set just to satisfy the dependencies of using 108.  108 was chosen to make things simple for the test.
		ctx.setProperty("inProgressPercentage", "10");
		threadSpawnCounter = new AtomicInteger(0);
		blockCounts.clear();
		
		mapBlockToExpectedResult = new HashMap<Integer, String>();
	}
	
	/**************************************************************************************************************
	 ************************************************************************************************************** 
	 * 
	 * Test Entry Points
	 * 
	 **************************************************************************************************************
	 **************************************************************************************************************/
	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexNoHeaderMessageGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_COMPLEX_NO_HEADER, CONTENT_TYPE_TEXT_CSV);

		initializeComplexNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexNoHeaderMessageGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_COMPLEX_NO_HEADER, CONTENT_TYPE_TEXT_CSV);

		initializeComplexNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexNoHeaderMessageGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_COMPLEX_NO_HEADER, CONTENT_TYPE_TEXT_CSV);

		initializeComplexNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexNoHeaderMessageGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_COMPLEX_NO_HEADER, CONTENT_TYPE_TEXT_CSV);

		initializeComplexNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexNoHeaderMessageCountPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_COMPLEX_NO_HEADER, CONTENT_TYPE_TEXT_CSV);

		initializeComplexNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexNoHeaderMessageCountPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_COMPLEX_NO_HEADER, CONTENT_TYPE_TEXT_CSV);

		initializeComplexNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexNoHeaderMessageCountSecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_COMPLEX_NO_HEADER, CONTENT_TYPE_TEXT_CSV);

		initializeComplexNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexNoHeaderMessageCountSecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_COMPLEX_NO_HEADER, CONTENT_TYPE_TEXT_CSV);

		initializeComplexNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexNoHeaderVariableGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col8");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_COMPLEX_NO_HEADER, CONTENT_TYPE_TEXT_CSV);

		initializeComplexNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexNoHeaderVariableGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col8");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_COMPLEX_NO_HEADER, CONTENT_TYPE_TEXT_CSV);

		initializeComplexNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexNoHeaderVariableGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col8");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_COMPLEX_NO_HEADER, CONTENT_TYPE_TEXT_CSV);

		initializeComplexNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexNoHeaderVariableGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col8");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_COMPLEX_NO_HEADER, CONTENT_TYPE_TEXT_CSV);

		initializeComplexNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexNoHeaderVariableCountPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_COMPLEX_NO_HEADER, CONTENT_TYPE_TEXT_CSV);

		initializeComplexNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexNoHeaderVariableCountPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_COMPLEX_NO_HEADER, CONTENT_TYPE_TEXT_CSV);

		initializeComplexNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexNoHeaderVariableCountSecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_COMPLEX_NO_HEADER, CONTENT_TYPE_TEXT_CSV);

		initializeComplexNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexNoHeaderVariableCountSecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_COMPLEX_NO_HEADER, CONTENT_TYPE_TEXT_CSV);

		initializeComplexNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexWithHeaderMessageGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_COMPLEX_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeComplexWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexWithHeaderMessageGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_COMPLEX_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeComplexWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexWithHeaderMessageGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_COMPLEX_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeComplexWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexWithHeaderMessageGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_COMPLEX_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeComplexWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexWithHeaderMessageCountPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_COMPLEX_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeComplexWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexWithHeaderMessageCountPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_COMPLEX_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeComplexWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexWithHeaderMessageCountSecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_COMPLEX_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeComplexWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexWithHeaderMessageCountSecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_COMPLEX_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeComplexWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexWithHeaderVariableGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_COMPLEX_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeComplexWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexWithHeaderVariableGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_COMPLEX_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeComplexWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexWithHeaderVariableGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_COMPLEX_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeComplexWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexWithHeaderVariableGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_COMPLEX_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeComplexWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexWithHeaderVariableCountPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_COMPLEX_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeComplexWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexWithHeaderVariableCountPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_COMPLEX_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeComplexWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexWithHeaderVariableCountSecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_COMPLEX_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeComplexWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvComplexWithHeaderVariableCountSecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_COMPLEX_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeComplexWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyNoHeaderMessageGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyNoHeaderMessageGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyNoHeaderMessageGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyNoHeaderMessageGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyNoHeaderMessageCountPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyNoHeaderMessageCountPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyNoHeaderMessageCountSecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyNoHeaderMessageCountSecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyNoHeaderVariableGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyNoHeaderVariableGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyNoHeaderVariableGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyNoHeaderVariableGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyNoHeaderVariableCountPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyNoHeaderVariableCountPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyNoHeaderVariableCountSecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyNoHeaderVariableCountSecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyWithHeaderMessageGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyWithHeaderMessageGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyWithHeaderMessageGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyWithHeaderMessageGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyWithHeaderMessageCountPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	

		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyWithHeaderMessageCountPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	

		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyWithHeaderMessageCountSecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	

		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyWithHeaderMessageCountSecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	

		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyWithHeaderVariableGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyWithHeaderVariableGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyWithHeaderVariableGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyWithHeaderVariableGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyWithHeaderVariableCountPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyWithHeaderVariableCountPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyWithHeaderVariableCountSecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvEmptyWithHeaderVariableCountSecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvJournalsNoHeaderMessageGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_JOURNALS_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeJournalsNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvJournalsNoHeaderMessageGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_JOURNALS_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeJournalsNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvJournalsNoHeaderMessageGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_JOURNALS_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeJournalsNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvJournalsNoHeaderMessageGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_JOURNALS_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeJournalsNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvJournalsNoHeaderVariableGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_JOURNALS_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeJournalsNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvJournalsNoHeaderVariableGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_JOURNALS_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeJournalsNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvJournalsNoHeaderVariableGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_JOURNALS_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeJournalsNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvJournalsNoHeaderVariableGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_JOURNALS_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeJournalsNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvJournalsWithHeaderMessageGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	

		setMessagePart(0, MOCK_SSK117_CSV_JOURNALS_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeJournalsWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvJournalsWithHeaderMessageGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	

		setMessagePart(0, MOCK_SSK117_CSV_JOURNALS_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeJournalsWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvJournalsWithHeaderMessageGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	

		setMessagePart(0, MOCK_SSK117_CSV_JOURNALS_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeJournalsWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvJournalsWithHeaderMessageGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	

		setMessagePart(0, MOCK_SSK117_CSV_JOURNALS_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeJournalsWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvJournalsWithHeaderVariableGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_JOURNALS_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeJournalsWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvJournalsWithHeaderVariableGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_JOURNALS_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeJournalsWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvJournalsWithHeaderVariableGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_JOURNALS_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeJournalsWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvJournalsWithHeaderVariableGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_JOURNALS_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeJournalsWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedNoHeaderMessageGroupByPrimaryLogToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_MALFORMED_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedNoHeaderMessageGroupByPrimaryLogDebugToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_MALFORMED_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedNoHeaderMessageGroupBySecondaryLogToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_MALFORMED_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedNoHeaderMessageGroupBySecondaryLogDebugToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_MALFORMED_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedNoHeaderMessageCountPrimaryLogToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	

		setMessagePart(0, MOCK_SSK117_CSV_MALFORMED_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedNoHeaderMessageCountPrimaryLogDebugToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	

		setMessagePart(0, MOCK_SSK117_CSV_MALFORMED_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedNoHeaderMessageCountSecondaryLogToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	

		setMessagePart(0, MOCK_SSK117_CSV_MALFORMED_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedNoHeaderMessageCountSecondaryLogDebugToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	

		setMessagePart(0, MOCK_SSK117_CSV_MALFORMED_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedNoHeaderVariableGroupByPrimaryLogToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_MALFORMED_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedNoHeaderVariableGroupByPrimaryLogDebugToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_MALFORMED_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedNoHeaderVariableGroupBySecondaryLogToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_MALFORMED_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedNoHeaderVariableGroupBySecondaryLogDebugToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_MALFORMED_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedNoHeaderVariableCountPrimaryLogToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_MALFORMED_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedNoHeaderVariableCountPrimaryLogDebugToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_MALFORMED_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedNoHeaderVariableCountSecondaryLogToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_MALFORMED_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedNoHeaderVariableCountSecondaryLogDebugToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_MALFORMED_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedWithHeaderMessageGroupByPrimaryLogToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "MF1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_MALFORMED_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedWithHeaderByKeyResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedWithHeaderMessageGroupByPrimaryLogDebugToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "MF1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_MALFORMED_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedWithHeaderByKeyResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedWithHeaderMessageGroupBySecondaryLogToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "MF1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_MALFORMED_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedWithHeaderByKeyResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedWithHeaderMessageGroupBySecondaryLogDebugToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "MF1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_MALFORMED_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedWithHeaderByKeyResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedWithHeaderMessageCountPrimaryLogToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	

		setMessagePart(0, MOCK_SSK117_CSV_MALFORMED_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedWithHeaderByCountResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedWithHeaderMessageCountPrimaryLogDebugToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	

		setMessagePart(0, MOCK_SSK117_CSV_MALFORMED_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedWithHeaderByCountResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedWithHeaderMessageCountSecondaryLogToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	

		setMessagePart(0, MOCK_SSK117_CSV_MALFORMED_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedWithHeaderByCountResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedWithHeaderMessageCountSecondaryLogDebugToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	

		setMessagePart(0, MOCK_SSK117_CSV_MALFORMED_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedWithHeaderByCountResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedWithHeaderVariableGroupByPrimaryLogToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_MALFORMED_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedWithHeaderByKeyResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedWithHeaderVariableGroupByPrimaryLogDebugToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_MALFORMED_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedWithHeaderByKeyResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedWithHeaderVariableGroupBySecondaryLogToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_MALFORMED_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedWithHeaderByKeyResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedWithHeaderVariableGroupBySecondaryLogDebugToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_MALFORMED_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedWithHeaderByKeyResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedWithHeaderVariableCountPrimaryLogToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_MALFORMED_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedWithHeaderByCountResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedWithHeaderVariableCountPrimaryLogDebugToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_MALFORMED_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedWithHeaderByCountResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedWithHeaderVariableCountSecondaryLogToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_MALFORMED_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedWithHeaderByCountResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvMalformedWithHeaderVariableCountSecondaryLogDebugToXml() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_MALFORMED_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeMalformedWithHeaderByCountResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowNoHeaderMessageGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col2");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_ONE_ROW_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowNoHeaderMessageGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col2");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_ONE_ROW_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowNoHeaderMessageGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col2");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_ONE_ROW_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowNoHeaderMessageGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col2");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_ONE_ROW_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowNoHeaderMessageCountPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	

		setMessagePart(0, MOCK_SSK117_CSV_ONE_ROW_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowNoHeaderMessageCountPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	

		setMessagePart(0, MOCK_SSK117_CSV_ONE_ROW_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowNoHeaderMessageCountSecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	

		setMessagePart(0, MOCK_SSK117_CSV_ONE_ROW_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowNoHeaderMessageCountSecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	

		setMessagePart(0, MOCK_SSK117_CSV_ONE_ROW_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowNoHeaderVariableGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col2");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_ONE_ROW_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowNoHeaderVariableGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col2");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_ONE_ROW_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowNoHeaderVariableGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col2");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_ONE_ROW_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowNoHeaderVariableGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col2");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_ONE_ROW_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowNoHeaderVariableCountPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_ONE_ROW_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowNoHeaderVariableCountPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_ONE_ROW_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowNoHeaderVariableCountSecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_ONE_ROW_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowNoHeaderVariableCountSecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_ONE_ROW_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowWithHeaderMessageGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "F2");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_ONE_ROW_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowWithHeaderMessageGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "F2");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_ONE_ROW_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowWithHeaderMessageGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "F2");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_ONE_ROW_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowWithHeaderMessageGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "F2");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_ONE_ROW_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowWithHeaderMessageCountPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	

		setMessagePart(0, MOCK_SSK117_CSV_ONE_ROW_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowWithHeaderMessageCountPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	

		setMessagePart(0, MOCK_SSK117_CSV_ONE_ROW_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowWithHeaderMessageCountSecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	

		setMessagePart(0, MOCK_SSK117_CSV_ONE_ROW_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowWithHeaderMessageCountSecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	

		setMessagePart(0, MOCK_SSK117_CSV_ONE_ROW_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowWithHeaderVariableGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "F2");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_ONE_ROW_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowWithHeaderVariableGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "F2");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_ONE_ROW_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowWithHeaderVariableGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "F2");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_ONE_ROW_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowWithHeaderVariableGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "F2");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_ONE_ROW_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowWithHeaderVariableCountPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_ONE_ROW_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowWithHeaderVariableCountPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_ONE_ROW_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowWithHeaderVariableCountSecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_ONE_ROW_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvOneRowWithHeaderVariableCountSecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_ONE_ROW_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeOneRowWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleNoHeaderMessageGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_SIMPLE_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleNoHeaderMessageGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_SIMPLE_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleNoHeaderMessageGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_SIMPLE_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleNoHeaderMessageGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_SIMPLE_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleNoHeaderMessageCountPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	

		setMessagePart(0, MOCK_SSK117_CSV_SIMPLE_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleNoHeaderMessageCountPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	

		setMessagePart(0, MOCK_SSK117_CSV_SIMPLE_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleNoHeaderMessageCountSecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	

		setMessagePart(0, MOCK_SSK117_CSV_SIMPLE_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleNoHeaderMessageCountSecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	

		setMessagePart(0, MOCK_SSK117_CSV_SIMPLE_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleNoHeaderVariableGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_SIMPLE_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleNoHeaderVariableGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_SIMPLE_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleNoHeaderVariableGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_SIMPLE_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleNoHeaderVariableGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "col1");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_SIMPLE_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleNoHeaderVariableCountPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_SIMPLE_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleNoHeaderVariableCountPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_SIMPLE_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleNoHeaderVariableCountSecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_SIMPLE_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleNoHeaderVariableCountSecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_SIMPLE_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleNoHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleWithHeaderMessageGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_SIMPLE_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleWithHeaderMessageGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_SIMPLE_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleWithHeaderMessageGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_SIMPLE_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleWithHeaderMessageGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_SIMPLE_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleWithHeaderMessageCountPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	

		setMessagePart(0, MOCK_SSK117_CSV_SIMPLE_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleWithHeaderMessageCountPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	

		setMessagePart(0, MOCK_SSK117_CSV_SIMPLE_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleWithHeaderMessageCountSecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	

		setMessagePart(0, MOCK_SSK117_CSV_SIMPLE_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleWithHeaderMessageCountSecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	

		setMessagePart(0, MOCK_SSK117_CSV_SIMPLE_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleWithHeaderVariableGroupByPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_SIMPLE_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleWithHeaderVariableGroupByPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_SIMPLE_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleWithHeaderVariableGroupBySecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_SIMPLE_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleWithHeaderVariableGroupBySecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_SIMPLE_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleWithHeaderVariableCountPrimaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_SIMPLE_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleWithHeaderVariableCountPrimaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_SIMPLE_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleWithHeaderVariableCountSecondaryLogToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_SIMPLE_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleWithHeaderResultMap();
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testCsvSimpleWithHeaderVariableCountSecondaryLogDebugToXml() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, VAR_DATA_LOCATION);
		ctx.setProperty(PROP_PARAMETER_IN_BLOCK_SIZE, 100);
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, false);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);

		setVariable(VAR_DATA_LOCATION, MOCK_SSK117_CSV_SIMPLE_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
		
		initializeSimpleWithHeaderResultMap();
	}
	

	
	
	
	
	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testErrorNoSplitCsvEmptyNoHeaderMessagePrimaryLog() throws Exception {
		expectHandledException();

		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testErrorNoSplitCsvEmptyNoHeaderMessagePrimaryLogDebug() throws Exception {
		expectHandledException();

		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testErrorNoSplitCsvEmptyNoHeaderMessageSecondaryLog() throws Exception {
		expectHandledException();

		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testErrorNoSplitCsvEmptyNoHeaderMessageSecondaryLogDebug() throws Exception {
		expectHandledException();

		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_NO_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testErrorNoSplitCsvEmptyWithHeaderMessagePrimaryLog() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, "|");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testErrorNoSplitCsvEmptyWithHeaderMessagePrimaryLogDebug() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testErrorNoSplitCsvEmptyWithHeaderMessageSecondaryLog() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}

	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testErrorNoSplitCsvEmptyWithHeaderMessageSecondaryLogDebug() throws Exception {
		expectHandledException();
		
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, false);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);	
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, true);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_SECONDARY);	
		
		setMessagePart(0, MOCK_SSK117_CSV_EMPTY_WITH_HEADER, CONTENT_TYPE_TEXT_CSV);
	}


	
	
	
	
	@UnitTest(startComponent="Text2ParallelSplitter")
	public void testJournalWithHeaderCsvToXmlAtScale() throws Exception {
		ctx.setProperty(PROP_PARAMETER_IN_DATA_LOCATION, "message");
		ctx.setProperty(PROP_PARAMETER_IN_GROUPBY_COLUMN, "JournalKey");
		ctx.setProperty(PROP_PARAMETER_IN_IS_NO_BLOCK_SPLIT_AN_ERROR, true);
		ctx.setProperty(PROP_PARAMETER_IN_IS_FIRST_LINE_HEADER, true);
		ctx.setProperty(PROP_PARAMETER_IN_CSV_FIELD_SEPARATOR, ",");
		ctx.setProperty(PROP_PARAMETER_IN_TRANSFORMER, new XmlTransformer("root", "wd urn:com.workday/bsvc", "ns0 urn:namespace0 ns1 urn:namespace1", "data"));
		ctx.setProperty(PROP_PARAMETER_IN_PROCESS_ENDPOINT, processEndpoint = MOCK_SSK117_PROCESS_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_AGGREGATION_ENDPOINT, MOCK_SSK117_AGGREGATION_ENDPOINT);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_COUNT, 4);
		ctx.setProperty(PROP_PARAMETER_IN_THREAD_TIMEOUT, 600);
		ctx.setProperty(PROP_PARAMETER_IN_SPLITTER_TIMEOUT, 3600);
		ctx.setProperty(PROP_PARAMETER_IN_DEBUG_MODE, false);	
		ctx.setProperty(PROP_PARAMETER_IN_LOG_TARGET, VALUE_LOG_PRIMARY);	

		FileBackedManagedData fbmd = new FileBackedManagedData(CONTENT_TYPE_TEXT_CSV);
        ctx.addDisposable(fbmd);

        DataGenerator data = new DataGenerator(50000, ",");
        data.generateJournalLines(fbmd.getOutputStream());
        
        ctx.getMessage().setMessagePart(0, fbmd.getContentType(), fbmd.getDataSource());
		
		log.info("~~~~~~~~~~ SETUP COMPLETE ~~~~~~~~~~ BEGINNING TEST ~~~~~~~~~~");
	}

	
	/**************************************************************************************************************
	 ************************************************************************************************************** 
	 * 
	 * Test Validations
	 * 
	 **************************************************************************************************************
	 **************************************************************************************************************/
	@Override
	protected void extendedExitStateVerification(Throwable t) throws Exception {
		log.info("~~~~~~~~~~ TEST COMPLETE ~~~~~~~~~~ TEST COMPLETE ~~~~~~~~~~");

	}

	@AssertAfter(id="ChildThread_117")
	public void verifyWorkerThread() throws Exception {
		int threadCounter = threadSpawnCounter.incrementAndGet();
		
		MediationContext childContext = MediationTube.getCurrentMediationContext();
		int blockCount = (int) childContext.getProperty((String)childContext.getProperty(PROP_PARAMETER_IN_THREAD_BLOCK_COUNT));
		
		log.info("TEST " + getName() + ": Thread " + Thread.currentThread().getName() + " as number " + threadCounter + " with blockCount = " + blockCount + " and blockLineCount = " + childContext.getProperty((String)childContext.getProperty(PROP_PARAMETER_IN_THREAD_BLOCK_LINE_COUNT)) + ((childContext.containsProperty(PROP_PARAMETER_IN_THREAD_GROUP_KEY_VALUE) ? " for group key = " + childContext.getProperty(PROP_PARAMETER_IN_THREAD_GROUP_KEY_VALUE) : "")));
		
		switch (getName()) {
			case "testCsvComplexNoHeaderMessageGroupByPrimaryLogToXml" :
				validateThreadEntryCsvComplexNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexNoHeaderMessageGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvComplexNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexNoHeaderMessageGroupBySecondaryLogToXml" :
				validateThreadEntryCsvComplexNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexNoHeaderMessageGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvComplexNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexNoHeaderMessageCountPrimaryLogToXml" :
				validateThreadEntryCsvComplexNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexNoHeaderMessageCountPrimaryLogDebugToXml" :
				validateThreadEntryCsvComplexNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexNoHeaderMessageCountSecondaryLogToXml" :
				validateThreadEntryCsvComplexNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexNoHeaderMessageCountSecondaryLogDebugToXml" :
				validateThreadEntryCsvComplexNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexNoHeaderVariableGroupByPrimaryLogToXml" :
				validateThreadEntryCsvComplexNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexNoHeaderVariableGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvComplexNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexNoHeaderVariableGroupBySecondaryLogToXml" :
				validateThreadEntryCsvComplexNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexNoHeaderVariableGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvComplexNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexNoHeaderVariableCountPrimaryLogToXml" :
				validateThreadEntryCsvComplexNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexNoHeaderVariableCountPrimaryLogDebugToXml" :
				validateThreadEntryCsvComplexNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexNoHeaderVariableCountSecondaryLogToXml" :
				validateThreadEntryCsvComplexNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexNoHeaderVariableCountSecondaryLogDebugToXml" :
				validateThreadEntryCsvComplexNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexWithHeaderMessageGroupByPrimaryLogToXml" :
				validateThreadEntryCsvComplexWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexWithHeaderMessageGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvComplexWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexWithHeaderMessageGroupBySecondaryLogToXml" :
				validateThreadEntryCsvComplexWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexWithHeaderMessageGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvComplexWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexWithHeaderMessageCountPrimaryLogToXml" :
				validateThreadEntryCsvComplexWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexWithHeaderMessageCountPrimaryLogDebugToXml" :
				validateThreadEntryCsvComplexWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexWithHeaderMessageCountSecondaryLogToXml" :
				validateThreadEntryCsvComplexWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexWithHeaderMessageCountSecondaryLogDebugToXml" :
				validateThreadEntryCsvComplexWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexWithHeaderVariableGroupByPrimaryLogToXml" :
				validateThreadEntryCsvComplexWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexWithHeaderVariableGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvComplexWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexWithHeaderVariableGroupBySecondaryLogToXml" :
				validateThreadEntryCsvComplexWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexWithHeaderVariableGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvComplexWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexWithHeaderVariableCountPrimaryLogToXml" :
				validateThreadEntryCsvComplexWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexWithHeaderVariableCountPrimaryLogDebugToXml" :
				validateThreadEntryCsvComplexWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexWithHeaderVariableCountSecondaryLogToXml" :
				validateThreadEntryCsvComplexWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvComplexWithHeaderVariableCountSecondaryLogDebugToXml" :
				validateThreadEntryCsvComplexWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvEmptyNoHeaderMessageGroupByPrimaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyNoHeaderMessageGroupByPrimaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyNoHeaderMessageGroupBySecondaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyNoHeaderMessageGroupBySecondaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyNoHeaderMessageCountPrimaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyNoHeaderMessageCountPrimaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyNoHeaderMessageCountSecondaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyNoHeaderMessageCountSecondaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyNoHeaderVariableGroupByPrimaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyNoHeaderVariableGroupByPrimaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyNoHeaderVariableGroupBySecondaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyNoHeaderVariableGroupBySecondaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyNoHeaderVariableCountPrimaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyNoHeaderVariableCountPrimaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyNoHeaderVariableCountSecondaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyNoHeaderVariableCountSecondaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyWithHeaderMessageGroupByPrimaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyWithHeaderMessageGroupByPrimaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyWithHeaderMessageGroupBySecondaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyWithHeaderMessageGroupBySecondaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyWithHeaderMessageCountPrimaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyWithHeaderMessageCountPrimaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyWithHeaderMessageCountSecondaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyWithHeaderMessageCountSecondaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyWithHeaderVariableGroupByPrimaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyWithHeaderVariableGroupByPrimaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyWithHeaderVariableGroupBySecondaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyWithHeaderVariableGroupBySecondaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyWithHeaderVariableCountPrimaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyWithHeaderVariableCountPrimaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyWithHeaderVariableCountSecondaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvEmptyWithHeaderVariableCountSecondaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvJournalsNoHeaderMessageGroupByPrimaryLogToXml" :
				validateThreadEntryCsvJournalsNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvJournalsNoHeaderMessageGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvJournalsNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvJournalsNoHeaderMessageGroupBySecondaryLogToXml" :
				validateThreadEntryCsvJournalsNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvJournalsNoHeaderMessageGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvJournalsNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvJournalsNoHeaderVariableGroupByPrimaryLogToXml" :
				validateThreadEntryCsvJournalsNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvJournalsNoHeaderVariableGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvJournalsNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvJournalsNoHeaderVariableGroupBySecondaryLogToXml" :
				validateThreadEntryCsvJournalsNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvJournalsNoHeaderVariableGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvJournalsNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvJournalsWithHeaderMessageGroupByPrimaryLogToXml" :
				validateThreadEntryCsvJournalsWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvJournalsWithHeaderMessageGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvJournalsWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvJournalsWithHeaderMessageGroupBySecondaryLogToXml" :
				validateThreadEntryCsvJournalsWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvJournalsWithHeaderMessageGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvJournalsWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvJournalsWithHeaderVariableGroupByPrimaryLogToXml" :
				validateThreadEntryCsvJournalsWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvJournalsWithHeaderVariableGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvJournalsWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvJournalsWithHeaderVariableGroupBySecondaryLogToXml" :
				validateThreadEntryCsvJournalsWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvJournalsWithHeaderVariableGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvJournalsWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvMalformedNoHeaderMessageGroupByPrimaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvMalformedNoHeaderMessageGroupByPrimaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvMalformedNoHeaderMessageGroupBySecondaryLogToXml" :
				if (blockCount > 2) {
					fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				}
				break;
	
			case "testCsvMalformedNoHeaderMessageGroupBySecondaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvMalformedNoHeaderMessageCountPrimaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvMalformedNoHeaderMessageCountPrimaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvMalformedNoHeaderMessageCountSecondaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvMalformedNoHeaderMessageCountSecondaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvMalformedNoHeaderVariableGroupByPrimaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvMalformedNoHeaderVariableGroupByPrimaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvMalformedNoHeaderVariableGroupBySecondaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvMalformedNoHeaderVariableGroupBySecondaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvMalformedNoHeaderVariableCountPrimaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvMalformedNoHeaderVariableCountPrimaryLogDebugToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvMalformedNoHeaderVariableCountSecondaryLogToXml" :
				fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				break;
	
			case "testCsvMalformedNoHeaderVariableCountSecondaryLogDebugToXml" :
				if (blockCount > 2) {
					fail(String.format(MESSAGE_UNEXPECTED_EXECUTION_PATH, getName() + " on threadCount = " + blockCount));
				}
				break;
	
			case "testCsvMalformedWithHeaderMessageGroupByPrimaryLogToXml" :
				validateThreadEntryCsvMalformedWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvMalformedWithHeaderMessageGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvMalformedWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvMalformedWithHeaderMessageGroupBySecondaryLogToXml" :
				validateThreadEntryCsvMalformedWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvMalformedWithHeaderMessageGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvMalformedWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvMalformedWithHeaderMessageCountPrimaryLogToXml" :
				validateThreadEntryCsvMalformedWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvMalformedWithHeaderMessageCountPrimaryLogDebugToXml" :
				validateThreadEntryCsvMalformedWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvMalformedWithHeaderMessageCountSecondaryLogToXml" :
				validateThreadEntryCsvMalformedWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvMalformedWithHeaderMessageCountSecondaryLogDebugToXml" :
				validateThreadEntryCsvMalformedWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvMalformedWithHeaderVariableGroupByPrimaryLogToXml" :
				validateThreadEntryCsvMalformedWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvMalformedWithHeaderVariableGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvMalformedWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvMalformedWithHeaderVariableGroupBySecondaryLogToXml" :
				validateThreadEntryCsvMalformedWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvMalformedWithHeaderVariableGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvMalformedWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvMalformedWithHeaderVariableCountPrimaryLogToXml" :
				validateThreadEntryCsvMalformedWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvMalformedWithHeaderVariableCountPrimaryLogDebugToXml" :
				validateThreadEntryCsvMalformedWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvMalformedWithHeaderVariableCountSecondaryLogToXml" :
				validateThreadEntryCsvMalformedWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvMalformedWithHeaderVariableCountSecondaryLogDebugToXml" :
				validateThreadEntryCsvMalformedWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowNoHeaderMessageGroupByPrimaryLogToXml" :
				validateThreadEntryCsvOneRowNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowNoHeaderMessageGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvOneRowNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowNoHeaderMessageGroupBySecondaryLogToXml" :
				validateThreadEntryCsvOneRowNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowNoHeaderMessageGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvOneRowNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowNoHeaderMessageCountPrimaryLogToXml" :
				validateThreadEntryCsvOneRowNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowNoHeaderMessageCountPrimaryLogDebugToXml" :
				validateThreadEntryCsvOneRowNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowNoHeaderMessageCountSecondaryLogToXml" :
				validateThreadEntryCsvOneRowNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowNoHeaderMessageCountSecondaryLogDebugToXml" :
				validateThreadEntryCsvOneRowNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowNoHeaderVariableGroupByPrimaryLogToXml" :
				validateThreadEntryCsvOneRowNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowNoHeaderVariableGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvOneRowNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowNoHeaderVariableGroupBySecondaryLogToXml" :
				validateThreadEntryCsvOneRowNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowNoHeaderVariableGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvOneRowNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowNoHeaderVariableCountPrimaryLogToXml" :
				validateThreadEntryCsvOneRowNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowNoHeaderVariableCountPrimaryLogDebugToXml" :
				validateThreadEntryCsvOneRowNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowNoHeaderVariableCountSecondaryLogToXml" :
				validateThreadEntryCsvOneRowNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowNoHeaderVariableCountSecondaryLogDebugToXml" :
				validateThreadEntryCsvOneRowNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowWithHeaderMessageGroupByPrimaryLogToXml" :
				validateThreadEntryCsvOneRowWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowWithHeaderMessageGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvOneRowWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowWithHeaderMessageGroupBySecondaryLogToXml" :
				validateThreadEntryCsvOneRowWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowWithHeaderMessageGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvOneRowWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowWithHeaderMessageCountPrimaryLogToXml" :
				validateThreadEntryCsvOneRowWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowWithHeaderMessageCountPrimaryLogDebugToXml" :
				validateThreadEntryCsvOneRowWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowWithHeaderMessageCountSecondaryLogToXml" :
				validateThreadEntryCsvOneRowWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowWithHeaderMessageCountSecondaryLogDebugToXml" :
				validateThreadEntryCsvOneRowWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowWithHeaderVariableGroupByPrimaryLogToXml" :
				validateThreadEntryCsvOneRowWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowWithHeaderVariableGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvOneRowWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowWithHeaderVariableGroupBySecondaryLogToXml" :
				validateThreadEntryCsvOneRowWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowWithHeaderVariableGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvOneRowWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowWithHeaderVariableCountPrimaryLogToXml" :
				validateThreadEntryCsvOneRowWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowWithHeaderVariableCountPrimaryLogDebugToXml" :
				validateThreadEntryCsvOneRowWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowWithHeaderVariableCountSecondaryLogToXml" :
				validateThreadEntryCsvOneRowWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvOneRowWithHeaderVariableCountSecondaryLogDebugToXml" :
				validateThreadEntryCsvOneRowWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleNoHeaderMessageGroupByPrimaryLogToXml" :
				validateThreadEntryCsvSimpleNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleNoHeaderMessageGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvSimpleNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleNoHeaderMessageGroupBySecondaryLogToXml" :
				validateThreadEntryCsvSimpleNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleNoHeaderMessageGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvSimpleNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleNoHeaderMessageCountPrimaryLogToXml" :
				validateThreadEntryCsvSimpleNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleNoHeaderMessageCountPrimaryLogDebugToXml" :
				validateThreadEntryCsvSimpleNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleNoHeaderMessageCountSecondaryLogToXml" :
				validateThreadEntryCsvSimpleNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleNoHeaderMessageCountSecondaryLogDebugToXml" :
				validateThreadEntryCsvSimpleNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleNoHeaderVariableGroupByPrimaryLogToXml" :
				validateThreadEntryCsvSimpleNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleNoHeaderVariableGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvSimpleNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleNoHeaderVariableGroupBySecondaryLogToXml" :
				validateThreadEntryCsvSimpleNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleNoHeaderVariableGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvSimpleNoHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleNoHeaderVariableCountPrimaryLogToXml" :
				validateThreadEntryCsvSimpleNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleNoHeaderVariableCountPrimaryLogDebugToXml" :
				validateThreadEntryCsvSimpleNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleNoHeaderVariableCountSecondaryLogToXml" :
				validateThreadEntryCsvSimpleNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleNoHeaderVariableCountSecondaryLogDebugToXml" :
				validateThreadEntryCsvSimpleNoHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleWithHeaderMessageGroupByPrimaryLogToXml" :
				validateThreadEntryCsvSimpleWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleWithHeaderMessageGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvSimpleWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleWithHeaderMessageGroupBySecondaryLogToXml" :
				validateThreadEntryCsvSimpleWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleWithHeaderMessageGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvSimpleWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleWithHeaderMessageCountPrimaryLogToXml" :
				validateThreadEntryCsvSimpleWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleWithHeaderMessageCountPrimaryLogDebugToXml" :
				validateThreadEntryCsvSimpleWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleWithHeaderMessageCountSecondaryLogToXml" :
				validateThreadEntryCsvSimpleWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleWithHeaderMessageCountSecondaryLogDebugToXml" :
				validateThreadEntryCsvSimpleWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleWithHeaderVariableGroupByPrimaryLogToXml" :
				validateThreadEntryCsvSimpleWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleWithHeaderVariableGroupByPrimaryLogDebugToXml" :
				validateThreadEntryCsvSimpleWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleWithHeaderVariableGroupBySecondaryLogToXml" :
				validateThreadEntryCsvSimpleWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleWithHeaderVariableGroupBySecondaryLogDebugToXml" :
				validateThreadEntryCsvSimpleWithHeaderGroupByToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleWithHeaderVariableCountPrimaryLogToXml" :
				validateThreadEntryCsvSimpleWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleWithHeaderVariableCountPrimaryLogDebugToXml" :
				validateThreadEntryCsvSimpleWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleWithHeaderVariableCountSecondaryLogToXml" :
				validateThreadEntryCsvSimpleWithHeaderCountToXml(childContext, blockCount);
				break;
	
			case "testCsvSimpleWithHeaderVariableCountSecondaryLogDebugToXml" :
				validateThreadEntryCsvSimpleWithHeaderCountToXml(childContext, blockCount);
				break;

			default :
				break;
		}
	}
	

	/**************************************************************************************************************
	 ************************************************************************************************************** 
	 * 
	 * Mocks
	 * 
	 **************************************************************************************************************
	 **************************************************************************************************************/

}

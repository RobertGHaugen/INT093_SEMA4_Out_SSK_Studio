package com.workday.custom.aunit.int093.utilities.ssk117;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.capeclear.logger.LogControl;
import com.capeclear.logger.Logger;
import com.capeclear.mediation.MediationContext;
import com.capeclear.mediation.impl.cc.MediationTube;
import com.workday.aunit.annotations.AssemblyTest;
import com.workday.aunit.annotations.AssertAfter;
import com.workday.aunit.annotations.UnitTest;
import com.workday.custom.int093.ssk117.writers.XmlTransformer;

@AssemblyTest(project="INT093_SEMA4_Out_SSK_Studio", displayLabel="Test runner for Text block splitter")
public class SSKComponent117TestCase005 extends SSKComponent117BaseTestCase {
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

	@AssertAfter(id="ChildThread_117", step="No-Op")
	public void verifyWorkerThread() throws Exception {
		int threadCounter = threadSpawnCounter.incrementAndGet();
		
		MediationContext childContext = MediationTube.getCurrentMediationContext();
		int blockCount = (int) childContext.getProperty((String)childContext.getProperty(PROP_PARAMETER_IN_THREAD_BLOCK_COUNT));
		
		log.info("TEST " + getName() + ": Thread " + Thread.currentThread().getName() + " as number " + threadCounter + " with blockCount = " + blockCount + " and blockLineCount = " + childContext.getProperty((String)childContext.getProperty(PROP_PARAMETER_IN_THREAD_BLOCK_LINE_COUNT)) + ((childContext.containsProperty(PROP_PARAMETER_IN_THREAD_GROUP_KEY_VALUE) ? " for group key = " + childContext.getProperty(PROP_PARAMETER_IN_THREAD_GROUP_KEY_VALUE) : "")));
		
		validateThreadEntryCsvComplexNoHeaderGroupByToXml(childContext, blockCount);
	}

	/**************************************************************************************************************
	 ************************************************************************************************************** 
	 * 
	 * Mocks
	 * 
	 **************************************************************************************************************
	 **************************************************************************************************************/

}

package com.workday.custom.aunit.int093.main;

import com.workday.aunit.annotations.AssemblyTest;
import com.workday.aunit.annotations.AssertAfter;
import com.workday.aunit.annotations.UnitTest;
import com.workday.custom.aunit.int093.CommonTestCase;

@AssemblyTest(project="INT093_SEMA4_Out_SSK_Studio")
public class FoundationTestCase extends CommonTestCase {


	/**************************************************************************************************************
	 ************************************************************************************************************** 
	 * 
	 * Test Entry Points
	 * 
	 **************************************************************************************************************
	 **************************************************************************************************************/
	@UnitTest(startComponent="ConfigurationSetup")
	public void testFoundation() throws Exception { }

	
	/**************************************************************************************************************
	 ************************************************************************************************************** 
	 * 
	 * Test Validations
	 * 
	 **************************************************************************************************************
	 **************************************************************************************************************/
	@Override
	protected void extendedExitStateVerification(Throwable t) throws Exception { }
	
	@AssertAfter(id="Foundation_152", step="SetConstantValues")
	public void verifyInitialization() throws Exception {
		assertTrue(String.format(MESSAGE_UNEXPECTED_TYPE, PROP_GLOBAL_API_VERSION), ctx.getProperty(PROP_GLOBAL_API_VERSION) instanceof String);
		assertEquals(String.format(MESSAGE_UNEXPECTED_VALUE_PROPERTY, PROP_GLOBAL_API_VERSION), VALUE_API_VERSION, (String)ctx.getProperty(PROP_GLOBAL_API_VERSION));
	}
	
	/**************************************************************************************************************
	 ************************************************************************************************************** 
	 * 
	 * Mocks
	 * 
	 **************************************************************************************************************
	 **************************************************************************************************************/
}

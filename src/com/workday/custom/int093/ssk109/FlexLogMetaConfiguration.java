package com.workday.custom.int093.ssk109;

import com.capeclear.mediation.impl.mediators.MVELUtilHelper;

public class FlexLogMetaConfiguration {
	private String xmlConfigurationFile = "xslt/ssk147/SSK147_FlexLogs.xml";
	private String xsdConfigurationSchema = "xslt/ssk147/SSK147_FlexLogs.xsd";

	public String getConfigurationFile() {
		return xmlConfigurationFile;
	}
	
	public String getSchema() {
		return xsdConfigurationSchema;
	}
	
	public void readConfigurationToVariable(MVELUtilHelper util, String variableName, String configurationFile) throws Throwable {
    	util.readFileToVar(variableName, configurationFile, "text/xml");
	}

	public void readSchemaToVariable(MVELUtilHelper util, String variableName, String schemaFile) throws Throwable {
    	util.readFileToVar(variableName, schemaFile, "text/xml");
	}
}

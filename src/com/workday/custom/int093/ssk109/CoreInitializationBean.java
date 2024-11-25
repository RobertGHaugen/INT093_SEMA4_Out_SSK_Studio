package com.workday.custom.int093.ssk109;

import static com.capeclear.assembly.annotation.Component.Type.mediation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.jms.IllegalStateException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;

import com.capeclear.assembly.annotation.Component;
import com.capeclear.assembly.annotation.ComponentMethod;
import com.capeclear.logger.LogControl;
import com.capeclear.logger.Logger;
import com.capeclear.mediation.MediationContext;
import com.capeclear.mediation.impl.mediators.MVELUtilHelper;
import com.capeclear.mediation.impl.mediators.utils.XPath;
import com.workday.custom.int093.MediationConstants;
import com.workday.custom.int093.SSKUtils;
import com.workday.custom.int093.ssk144.StringDeduplicator;
import com.workday.esb.intsys.ParsedIntegrationSystems;
import com.workday.integration.launch.LaunchParametersHelper;


/**
 * Custom mediation
 *
 * @author john.smail
 */
@Component(
        name = "CoreInitializationBean",
        type = mediation,
        toolTip = "",
        scope = "prototype",
        smallIconPath = "icons/CoreInitializationBean_16.png",
        largeIconPath = "icons/CoreInitializationBean_24.png"
        )
public class CoreInitializationBean {

	//Logging at a Java level to the server.log file
	private Logger log = LogControl.getLogger(getClass());
	//Cross-initialization tracking for properties to add to default debug configuration
	private Set<String> initializedAttributesAndParameters = new HashSet<String>();
	
	private String sskServiceGeneral = MediationConstants.SERVICE_GENERAL;
	private String sskServiceFunctional = MediationConstants.SERVICE_FUNCTIONAL;
	private String sskServiceMessageQueue = MediationConstants.SERVICE_MESSAGE_QUEUE;
	private String sskServicePrimaryLog = MediationConstants.SERVICE_PRIMARY_LOG;
	private String sskServiceSecondaryLog = MediationConstants.SERVICE_SECONDARY_LOG;
	private String sskServiceWorkdayExtend = MediationConstants.SERVICE_WORKDAY_EXTEND;
	private String sskServiceWorkdayRest = MediationConstants.SERVICE_WORKDAY_REST;
	private String sskServiceListener = MediationConstants.SERVICE_LISTENER;
	
//	private String sskFlegLogMetaBeanProperty = MediationConstants.PROPERTY_SSK_FLEX_LOG_META_BEAN;
	
    /**
     * This method is called by the Assembly framework.
     * 
     * The functional purpose of this method to the SSK Framework is to initialize the following:
     * <ul>
     * <li>Integration Attribute Services</li>
     * <li>Launch Parameters</li>
     * <li>Helper Objects expected and used by SSK</li>
     * </ul>
     * Some Services, Attributes and/or Launch Parameters are required by SSK, while others are not.  If a required Service, Attribute or Launch Parameter is removed, then a <code>RuntimeException</code> will be thrown and the integration will not advance.  
     * If the Service, Attribute or Launch Parameter is not required, initialization will be handled on a case-by-case basis.  The property based on that Attribute or Launch Parameter may be initialized to a default value, or it may not be created at all.
     * 
     * If Launch Parameters or Attributes on existing SSK services are added to the Workday-In, those values will have be configured separately.  This class is SSK Framework specific and handles only that which is predefined by SSK.
     *
     * Use the <code>MediationContext</code> to access objects in the context,
     * such as the message, properties and variables e.g.
     * <ul>
     * <li><code>MediationMessage msg = arg0.getMessage();</code></li>
     * <li><code>String myPropValue = (String)arg0.getProperty("myprop");</code></li>
     * <li><code>Source myVar = arg0.getVariables().getVariable("myvar");</code></li>
     * </ul>    
     */
    @ComponentMethod
    public void process(MediationContext mc) throws Throwable {    	
    	MVELUtilHelper util = new MVELUtilHelper(mc);
    	LaunchParametersHelper lp = new LaunchParametersHelper(mc);
    	ParsedIntegrationSystems intsys = (ParsedIntegrationSystems)mc.getProperty(ParsedIntegrationSystems.INTEGRATION_SYSTEM_PROPERTY);
    	
   		configureVersion(mc, util);
   		boolean isFlexLog = configureFlexLogUsage(mc, util);
   		
   		configureIntegrationServiceNames(mc);
    	boolean isListenerService = intsys.getIntegrationServices().containsKey(sskServiceListener);
		
   		configureXsltLibraryPaths(mc, isFlexLog);
    	
   		configureLaunchParameters(mc, lp, isListenerService);
  		configureIntegrationAttributes(mc, intsys, isListenerService);
  		
  		configureGeneralSettings(mc);

  		// configureDebug should always be the last call in process so that any additionally configured parameters or attributes can be included in default debugging configuration.
  		configureDebug(mc, util);
    }
    
    private void configureVersion(MediationContext mc, MVELUtilHelper util) throws Throwable {
    	String wsApplicationFile = "ws-application.xml";
    	String temporaryVariableName = "sskWsApplication";
    	String xpathToSskVersion = "/*:CapeConnect/ws-application/initParams/property[name=\"cc.originator.type\"]/value";

    	try {
        	util.readFileToVar(temporaryVariableName, wsApplicationFile, "text/xml");
        	
        	Document varAsDocument = SSKUtils.getVariableAsXmlDocument(mc, temporaryVariableName);
        	String valueFromFile = new XPath(xpathToSskVersion, MediationConstants.ASSEMBLY_VERSION, mc).stringValueOf(varAsDocument);
        	
        	mc.setProperty(MediationConstants.PROPERTY_SSK_VERSION, valueFromFile);
        	mc.getVariables().remove(temporaryVariableName);
    	} catch (Throwable xcpn) {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to set the ["+ MediationConstants.PROPERTY_SSK_VERSION +"] property.  Confirm the " + wsApplicationFile + " is present under the ws/WSAR-INF folder.", 
    				xcpn); 
    	}
    }
    
    private boolean configureFlexLogUsage(MediationContext mc, MVELUtilHelper util) throws Throwable {
    	boolean returnValue = false;
    	
    	try {
    		returnValue = SSKUtils.configureFlexLog(mc, util);
    	} catch (Exception xcpn) {
        	SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"FlexLog Initialization Error", 
    				xcpn); 
		}
    	
    	return returnValue;
    }
    
    private void configureXsltLibraryPaths(MediationContext mc, boolean isFlexLog) throws Throwable {
    	mc.setProperty(MediationConstants.PROPERTY_SSK_XSLT_FUNCTION_LIBRARY_MESSAGES, SSKUtils.getContextualURL(mc, MediationConstants.VALUE_XSLT_LIB_MESSAGE));
    	
    	if (isFlexLog) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_XSLT_FUNCTION_LIBRARY_FLEX_EXT, SSKUtils.getContextualURL(mc, MediationConstants.VALUE_XSLT_LIB_FLEXLOG_EXTENSIONS));
        	mc.setProperty(MediationConstants.PROPERTY_SSK_XSLT_FUNCTION_LIBRARY_FLEX_MSG, SSKUtils.getContextualURL(mc, MediationConstants.VALUE_XSLT_LIB_FLEXLOG_MESSAGES));
    	}
    }
    
    private void configureLaunchParameters(MediationContext mc, LaunchParametersHelper lp, boolean isListenerService) throws Throwable {
    	// This value insulates the scenario where the code is running under AUnit test and the Launch Parameters have not been initialized.
    	// A default state is assumed per LP.
    	boolean isSet = lp.isSet();
    	
    	configureLaunchParameterRunWithDebugLogging(mc, lp, isSet, isListenerService);
    	configureLaunchParameterRunInValidationMode(mc, lp, isSet, isListenerService);
    	configureLaunchParameterSourceIntegrationEventWID(mc, lp, isSet);
    	configureLaunchParameterLogAggregationChainEventWID(mc, lp, isSet);
    	configureLaunchParameterIntegrationEventWID(mc, lp, isSet);
    }
    
    private void configureLaunchParameterRunWithDebugLogging(MediationContext mc, LaunchParametersHelper lp, boolean isSet, boolean isListenerService) throws Throwable {
    	try {
    		if (!isListenerService) {
	    		if (isSet) {
		        	if (lp.exists(MediationConstants.LAUNCH_PARAMETER_DEBUG_MODE)) {
		            	mc.setProperty(MediationConstants.PROPERTY_SSK_IS_DEBUG_MODE, "1".equals(lp.getSimpleData(MediationConstants.LAUNCH_PARAMETER_DEBUG_MODE)));
			    		initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_IS_DEBUG_MODE);
		    		} else if (mc.containsProperty(MediationConstants.PROPERTY_SSK_IS_DEBUG_MODE)) {
		        		log.info("The '" + MediationConstants.LAUNCH_PARAMETER_DEBUG_MODE + "' launch parameter appears to have been removed from the Workday-In.  The SSK Framework property '" + MediationConstants.PROPERTY_SSK_IS_DEBUG_MODE + "' has been manually set in the Mediation Context to a default value.");
		        	} else {
		        		throw new IllegalStateException("The '" + MediationConstants.LAUNCH_PARAMETER_DEBUG_MODE + "' launch parameter is required but appears to have been removed.  Please restore this launch parameter on the Workday-In.  The launch parameter is a core part of the SSK Framework and required for correct behavior.");
		        	}
	    		} else if (!mc.containsProperty(MediationConstants.PROPERTY_SSK_IS_DEBUG_MODE)) {
		    		mc.setProperty(MediationConstants.PROPERTY_SSK_IS_DEBUG_MODE, Boolean.FALSE);
	    		}
    		}
    	} catch (Throwable xcpn) {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to configure the '"+ MediationConstants.PROPERTY_SSK_IS_DEBUG_MODE +"' property.", 
    				xcpn); 
    	}
    }
    
    private void configureLaunchParameterRunInValidationMode(MediationContext mc, LaunchParametersHelper lp, boolean isSet, boolean isListenerService) throws Throwable {
    	try {
    		if (!isListenerService) {
	    		if (isSet) {
		        	if (lp.exists(MediationConstants.LAUNCH_PARAMETER_VALIDATION_MODE)) {
		            	mc.setProperty(MediationConstants.PROPERTY_SSK_IS_VALIDATION_MODE, "1".equals(lp.getSimpleData(MediationConstants.LAUNCH_PARAMETER_VALIDATION_MODE)));
			    		initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_IS_VALIDATION_MODE);
		    		} else if (!mc.containsProperty(MediationConstants.PROPERTY_SSK_IS_VALIDATION_MODE)) {
			    		mc.setProperty(MediationConstants.PROPERTY_SSK_IS_VALIDATION_MODE, Boolean.FALSE);
		        		log.info("The '" + MediationConstants.LAUNCH_PARAMETER_VALIDATION_MODE + "' launch parameter appears to have been removed from the Workday-In.  The SSK Framework property '" + MediationConstants.PROPERTY_SSK_IS_VALIDATION_MODE + "' will be initialized to a default value.");
		        	} else {
		        		log.info("The '" + MediationConstants.LAUNCH_PARAMETER_VALIDATION_MODE + "' launch parameter appears to have been removed from the Workday-In.  The SSK Framework property '" + MediationConstants.PROPERTY_SSK_IS_VALIDATION_MODE + "' has been manually set in the Mediation Context to a default value.");
		        	}
	    		} else if (!mc.containsProperty(MediationConstants.PROPERTY_SSK_IS_VALIDATION_MODE)) {
		    		mc.setProperty(MediationConstants.PROPERTY_SSK_IS_VALIDATION_MODE, Boolean.FALSE);
	    		}
    		}
    	} catch (Throwable xcpn) {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to configure the '"+ MediationConstants.PROPERTY_SSK_IS_VALIDATION_MODE +"' property.", 
    				xcpn); 
    	}
    }
    
    private void configureLaunchParameterSourceIntegrationEventWID(MediationContext mc, LaunchParametersHelper lp, boolean isSet) throws Throwable {
    	try {
    		if (isSet) {
	    		if (lp.exists(MediationConstants.LAUNCH_PARAMETER_SOURCE_EVENT_WID)) {
	            	mc.setProperty(MediationConstants.PROPERTY_SSK_DEBUG_EVENT_WID, lp.getSimpleData(MediationConstants.LAUNCH_PARAMETER_SOURCE_EVENT_WID));
		    		initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_DEBUG_EVENT_WID);
	        	} else {
	        		log.info("The '" + MediationConstants.LAUNCH_PARAMETER_SOURCE_EVENT_WID + "' launch parameter appears to have been removed from the Workday-In.  The SSK Framework property '" + MediationConstants.PROPERTY_SSK_DEBUG_EVENT_WID + "' will not be initialized.");
	        	}
    		} else if (!mc.containsProperty(MediationConstants.PROPERTY_SSK_DEBUG_EVENT_WID)) {
	    		mc.setProperty(MediationConstants.PROPERTY_SSK_DEBUG_EVENT_WID, null);
    		}
    	} catch (Throwable xcpn) {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to configure the '"+ MediationConstants.PROPERTY_SSK_DEBUG_EVENT_WID +"' property.", 
    				xcpn); 
    	}
    }
    
    private void configureLaunchParameterLogAggregationChainEventWID(MediationContext mc, LaunchParametersHelper lp, boolean isSet) throws Throwable {
    	try {
    		if (isSet) {
	    		if (lp.exists(MediationConstants.LAUNCH_PARAMETER_LOG_AGGREGATION_CHAIN_WID)) {
	            	mc.setProperty(MediationConstants.PROPERTY_SSK_LOG_CHAIN_WID, lp.getSimpleData(MediationConstants.LAUNCH_PARAMETER_LOG_AGGREGATION_CHAIN_WID));
		    		initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_LOG_CHAIN_WID);
	        	} else {
	        		log.info("The '" + MediationConstants.LAUNCH_PARAMETER_LOG_AGGREGATION_CHAIN_WID + "' launch parameter appears to have been removed from the Workday-In.  The SSK Framework property '" + MediationConstants.PROPERTY_SSK_LOG_CHAIN_WID + "' will not be initialized.");
	        	}
    		} else if (!mc.containsProperty(MediationConstants.PROPERTY_SSK_LOG_CHAIN_WID)) {
	    		mc.setProperty(MediationConstants.PROPERTY_SSK_LOG_CHAIN_WID, null);
    		}
    	} catch (Throwable xcpn) {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to configure the '"+ MediationConstants.PROPERTY_SSK_LOG_CHAIN_WID +"' property.", 
    				xcpn); 
    	}
    }
    
    private void configureLaunchParameterIntegrationEventWID(MediationContext mc, LaunchParametersHelper lp, boolean isSet) throws Throwable {
    	try {
    		if (isSet) {
		    	mc.setProperty(MediationConstants.PROPERTY_SSK_EVENT_WID, lp.getIntegrationEventWID());
	    		initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_EVENT_WID);
    		} else if (!mc.containsProperty(MediationConstants.PROPERTY_SSK_EVENT_WID)) {
	    		mc.setProperty(MediationConstants.PROPERTY_SSK_EVENT_WID, null);
    		}
    	} catch (Throwable xcpn) {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to configure the '"+ MediationConstants.PROPERTY_SSK_EVENT_WID +"' property.", 
    				xcpn); 
    	}
    }
    
    private void configureIntegrationServiceNames(MediationContext mc) throws Throwable {
    	Object overrideProperty = null;
    	String overrideName = null;
    	
    	if (mc.containsProperty(MediationConstants.PROPERTY_SSK_SERVICE_GENERAL)) {
    		overrideProperty = mc.getProperty(MediationConstants.PROPERTY_SSK_SERVICE_GENERAL);
    		if (overrideProperty != null) {
    			overrideName = (String)overrideProperty;
    			sskServiceGeneral = StringUtils.isNotBlank(overrideName) ? overrideName : sskServiceGeneral;
    		}
    	}

    	if (mc.containsProperty(MediationConstants.PROPERTY_SSK_SERVICE_FUNCTIONAL)) {
    		overrideProperty = mc.getProperty(MediationConstants.PROPERTY_SSK_SERVICE_FUNCTIONAL);
    		if (overrideProperty != null) {
    			overrideName = (String)overrideProperty;
    			sskServiceFunctional = StringUtils.isNotBlank(overrideName) ? overrideName : sskServiceFunctional;
    		}
    	}

    	if (mc.containsProperty(MediationConstants.PROPERTY_SSK_SERVICE_MESSAGE_QUEUE)) {
    		overrideProperty = mc.getProperty(MediationConstants.PROPERTY_SSK_SERVICE_MESSAGE_QUEUE);
    		if (overrideProperty != null) {
    			overrideName = (String)overrideProperty;
    			sskServiceMessageQueue = StringUtils.isNotBlank(overrideName) ? overrideName : sskServiceMessageQueue;
    		}
    	}

    	if (mc.containsProperty(MediationConstants.PROPERTY_SSK_SERVICE_PRIMARY_LOG)) {
    		overrideProperty = mc.getProperty(MediationConstants.PROPERTY_SSK_SERVICE_PRIMARY_LOG);
    		if (overrideProperty != null) {
    			overrideName = (String)overrideProperty;
    			sskServicePrimaryLog = StringUtils.isNotBlank(overrideName) ? overrideName : sskServicePrimaryLog;
    		}
    	}

    	if (mc.containsProperty(MediationConstants.PROPERTY_SSK_SERVICE_SECONDARY_LOG)) {
    		overrideProperty = mc.getProperty(MediationConstants.PROPERTY_SSK_SERVICE_SECONDARY_LOG);
    		if (overrideProperty != null) {
    			overrideName = (String)overrideProperty;
    			sskServiceSecondaryLog = StringUtils.isNotBlank(overrideName) ? overrideName : sskServiceSecondaryLog;
    		}
    	}

    	if (mc.containsProperty(MediationConstants.PROPERTY_SSK_SERVICE_WORKDAY_EXTEND)) {
    		overrideProperty = mc.getProperty(MediationConstants.PROPERTY_SSK_SERVICE_WORKDAY_EXTEND);
    		if (overrideProperty != null) {
    			overrideName = (String)overrideProperty;
    			sskServiceWorkdayExtend = StringUtils.isNotBlank(overrideName) ? overrideName : sskServiceWorkdayExtend;
    		}
    	}

    	if (mc.containsProperty(MediationConstants.PROPERTY_SSK_SERVICE_WORKDAY_REST)) {
    		overrideProperty = mc.getProperty(MediationConstants.PROPERTY_SSK_SERVICE_WORKDAY_REST);
    		if (overrideProperty != null) {
    			overrideName = (String)overrideProperty;
    			sskServiceWorkdayRest = StringUtils.isNotBlank(overrideName) ? overrideName : sskServiceWorkdayRest;
    		}
    	}

    	if (mc.containsProperty(MediationConstants.PROPERTY_SSK_SERVICE_LISTENER)) {
    		overrideProperty = mc.getProperty(MediationConstants.PROPERTY_SSK_SERVICE_LISTENER);
    		if (overrideProperty != null) {
    			overrideName = (String)overrideProperty;
    			sskServiceListener = StringUtils.isNotBlank(overrideName) ? overrideName : sskServiceListener;
    		}
    	}
    }
    
    private void configureIntegrationAttributes(MediationContext mc, ParsedIntegrationSystems intsys, boolean isListenerService) throws Throwable {
    	if (intsys.isServiceEnabled(sskServicePrimaryLog)) {
    		configurePrimaryLogIntegrationService(mc, intsys);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the primary log.", 
    				new IllegalStateException("The '" + sskServicePrimaryLog + "' service is required but appears to have been removed.  Please restore this service, as well as the attributes it contained, on the Workday-In component.  The service is a core part of the SSK Framework and required for correct behavior.")); 
    	}
    	
    	if (intsys.isServiceEnabled(sskServiceSecondaryLog)) {
    		mc.setProperty(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_IS_ENABLED, Boolean.TRUE);
    		configureSecondaryLogIntegrationService(mc, intsys);
    	} else {
    		mc.setProperty(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_IS_ENABLED, Boolean.FALSE);
    		log.info("The '" + sskServiceSecondaryLog + "' service appears to have been removed from the Workday-In.  The SSK Framework will skip initialization of the associated properties on that service.");
    	}
    	
    	if (intsys.isServiceEnabled(sskServiceGeneral)) {
    		configureGeneralIntegrationService(mc, intsys, isListenerService);
    	} else {
    		log.info("The '" + sskServiceGeneral + "' service appears to have been removed from the Workday-In.  The SSK Framework will skip initialization of the associated properties on that service.  SSK Components dependent on properties related to this service may use Component-specific default values when the global properties are not defined.");
    	}
    	
    	if (intsys.isServiceEnabled(sskServiceFunctional)) {
    		configureFunctionalIntegrationService(mc, intsys);
    	} else {
    		log.info("The '" + sskServiceFunctional + "' service appears to have been removed from the Workday-In.  The SSK Framework will skip initialization of the associated properties on that service.  SSK Components dependent on properties related to this service may use Component-specific default values when the global properties are not defined.");
    	}
    	
    	if (intsys.isServiceEnabled(sskServiceMessageQueue)) {
    		configureMessageQueueIntegrationService(mc, intsys);
    	} else {
    		log.info("The '" + sskServiceMessageQueue + "' service appears to have been removed from the Workday-In.  The SSK Framework will skip initialization of the associated properties on that service.  SSK Components dependent on properties related to this service may use Component-specific default values when the global properties are not defined.");
    	}
    	
    	boolean isRestExtend = intsys.isServiceEnabled(sskServiceWorkdayExtend);
    	boolean isRestTenant = intsys.isServiceEnabled(sskServiceWorkdayRest);
    	
    	if (isRestExtend && isRestTenant) {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the SSK Integration Services.", 
    				new IllegalStateException("Both of the '" + sskServiceWorkdayExtend + "' and '" + sskServiceWorkdayRest + "' services are defined.  Workday REST functions in SSK only use one of these services - the other should be deleted from the Workday-In.  If you are not using Workday REST services at all, please delete both services.  If this integration is a part of a Workday Extend App, then keep the '" + sskServiceWorkdayExtend + "' service.  Otherwise, if not using Workday Extend, then keep the '" + sskServiceWorkdayRest + "' service.")); 
    	} else {
	    	if (intsys.isServiceEnabled(sskServiceWorkdayExtend)) {
	    		configureWorkdayExtendIntegrationService(mc, intsys);
	        	mc.setProperty(MediationConstants.PROPERTY_SSK_REST_PROVIDER, MediationConstants.VALUE_REST_PROVIDER_EXTEND);

	    	} else {
	    		log.info("The '" + sskServiceWorkdayExtend + "' service has been removed from the Workday-In.  The SSK Framework will use the '" + sskServiceWorkdayRest + "' service for configuration.");
	    	}

	    	if (intsys.isServiceEnabled(sskServiceWorkdayRest)) {
	    		configureWorkdayRestIntegrationService(mc, intsys);
	        	mc.setProperty(MediationConstants.PROPERTY_SSK_REST_PROVIDER, MediationConstants.VALUE_REST_PROVIDER_TENANT);
	    	} else {
	    		log.info("The '" + sskServiceWorkdayRest + "' service has been removed from the Workday-In.  The SSK Framework will use the '" + sskServiceWorkdayExtend + "' service for configuration.");
	    	}
    	}
    }
    
    private void configurePrimaryLogIntegrationService(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	configurePrimaryLogFilename(mc, intsys);
    	configurePrimaryLogRetention(mc, intsys);
    	configurePrimaryLogMaxSize(mc, intsys);
    	boolean isFormatDecidedByAggregation = configurePrimaryLogAggregationTag(mc, intsys);
    	if (!isFormatDecidedByAggregation) {
        	configurePrimaryLogFormat(mc, intsys);
    	}
    	configurePrimaryLogAggregationTabName(mc, intsys);
    	
    	mc.setProperty(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_COUNT_BY_FILE, 0);
    	mc.setProperty(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_COUNT_DEBUG, 0);
    	mc.setProperty(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_COUNT_ERROR, 0);
    	mc.setProperty(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_COUNT_CRITICAL, 0);
    	mc.setProperty(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_COUNT_INFO, 0);
    	mc.setProperty(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_COUNT_TOTAL, 0);
    	mc.setProperty(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_COUNT_WARN, 0);
    	mc.setProperty(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_FILES_STORED, 0);
    }
    
    private void configurePrimaryLogFilename(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	if (intsys.integrationAttributeExists(sskServicePrimaryLog, MediationConstants.ATTRIBUTE_LOG_FILENAME)) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_FILENAME, 
        			intsys.getAttribute(sskServicePrimaryLog, MediationConstants.ATTRIBUTE_LOG_FILENAME) != null ? 
        					intsys.getAttribute(sskServicePrimaryLog, MediationConstants.ATTRIBUTE_LOG_FILENAME) : 
        						"Log");
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_FILENAME);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the primary log.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_LOG_FILENAME + "' on the '" + sskServicePrimaryLog + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The service and its attributes are a core part of the SSK Framework and required for correct behavior.")); 
    	}
    }
    
    private void configurePrimaryLogRetention(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	if (intsys.integrationAttributeExists(sskServicePrimaryLog, MediationConstants.ATTRIBUTE_LOG_RETENTION)) {
        	StringBuilder sb = new StringBuilder();
        	sb.append("P")
        		.append(intsys.getAttribute(sskServicePrimaryLog, MediationConstants.ATTRIBUTE_LOG_RETENTION) != null ? 
        				intsys.getAttribute(sskServicePrimaryLog, MediationConstants.ATTRIBUTE_LOG_RETENTION) : 
        					"30")
        		.append("D");
        	mc.setProperty(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_RETENTION, sb.toString());
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_RETENTION);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the primary log.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_LOG_RETENTION + "' on the '" + sskServicePrimaryLog + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The service and its attributes are a core part of the SSK Framework and required for correct behavior.")); 
    	}
    }

    private void configurePrimaryLogMaxSize(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	if (intsys.integrationAttributeExists(sskServicePrimaryLog, MediationConstants.ATTRIBUTE_LOG_MAX_SIZE)) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_MAX_SIZE, 
        			intsys.getAttribute(sskServicePrimaryLog, MediationConstants.ATTRIBUTE_LOG_MAX_SIZE) != null ? 
        					Integer.valueOf(intsys.getAttribute(sskServicePrimaryLog, MediationConstants.ATTRIBUTE_LOG_MAX_SIZE)) : 
        						0);
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_MAX_SIZE);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the primary log.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_LOG_MAX_SIZE + "' on the '" + sskServicePrimaryLog + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The service and its attributes are a core part of the SSK Framework and required for correct behavior.")); 
    	}
    }
    
    private boolean configurePrimaryLogAggregationTag(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	boolean returnValue = false;
    	
    	if (intsys.integrationAttributeExists(sskServicePrimaryLog, MediationConstants.ATTRIBUTE_LOG_AGGREGATION_TAG)) {
    		List<String> tags = intsys.getAttributeReferenceDataList(sskServicePrimaryLog, MediationConstants.ATTRIBUTE_LOG_AGGREGATION_TAG, "Document_Tag_Name");
    		
    		returnValue = CollectionUtils.isNotEmpty(tags); 
        	
    		mc.setProperty(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_AGGREGATION_TAG, 
        			returnValue ? 
        					tags : 
        						null);
        	
    		mc.setProperty(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_FORMAT, MediationConstants.PROPERTY_SSK_CLOUD_LOG_FORMAT_CSV);
    		
    		initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_AGGREGATION_TAG);
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_FORMAT);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the primary log.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_LOG_AGGREGATION_TAG + "' on the '" + sskServicePrimaryLog + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The service and its attributes are a core part of the SSK Framework and required for correct behavior.")); 
    	}
    	
    	return returnValue;
    }
    
    private void configurePrimaryLogFormat(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	if (intsys.integrationAttributeExists(sskServicePrimaryLog, MediationConstants.ATTRIBUTE_LOG_FORMAT)) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_FORMAT, 
        			intsys.getAttribute(sskServicePrimaryLog, MediationConstants.ATTRIBUTE_LOG_FORMAT) != null ? 
        					intsys.getAttribute(sskServicePrimaryLog, MediationConstants.ATTRIBUTE_LOG_FORMAT) : 
        						MediationConstants.PROPERTY_SSK_CLOUD_LOG_FORMAT_HTML);
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_FORMAT);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the primary log.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_LOG_FORMAT + "' on the '" + sskServicePrimaryLog + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The service and its attributes are a core part of the SSK Framework and required for correct behavior.")); 
    	}
    }
    
    private void configurePrimaryLogAggregationTabName(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	if (intsys.integrationAttributeExists(sskServicePrimaryLog, MediationConstants.ATTRIBUTE_LOG_AGGREGATION_TAB_NAME)) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_AGGREGATION_TAB_NAME, 
        			intsys.getAttribute(sskServicePrimaryLog, MediationConstants.ATTRIBUTE_LOG_AGGREGATION_TAB_NAME) != null ? 
        					intsys.getAttribute(sskServicePrimaryLog, MediationConstants.ATTRIBUTE_LOG_AGGREGATION_TAB_NAME) : 
        						StringUtils.substringBefore(intsys.getName(), "_"));
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_PRIMARY_LOG_AGGREGATION_TAB_NAME);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the primary log.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_LOG_AGGREGATION_TAB_NAME + "' on the '" + sskServicePrimaryLog + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The service and its attributes are a core part of the SSK Framework and required for correct behavior.")); 
    	}
    }
    
    private void configureSecondaryLogIntegrationService(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	configureSecondaryLogFilename(mc, intsys);
    	configureSecondaryLogRetention(mc, intsys);
    	configureSecondaryLogMaxSize(mc, intsys);
    	boolean isFormatDecidedByAggregation = configureSecondaryLogAggregationTag(mc, intsys);
    	if (!isFormatDecidedByAggregation) {
    		configureSecondaryLogFormat(mc, intsys);
    	}
    	configureSecondaryLogAggregationTabName(mc, intsys);
    	
    	mc.setProperty(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_COUNT_BY_FILE, 0);
    	mc.setProperty(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_COUNT_DEBUG, 0);
    	mc.setProperty(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_COUNT_ERROR, 0);
    	mc.setProperty(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_COUNT_CRITICAL, 0);
    	mc.setProperty(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_COUNT_INFO, 0);
    	mc.setProperty(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_COUNT_TOTAL, 0);
    	mc.setProperty(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_COUNT_WARN, 0);
    	mc.setProperty(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_FILES_STORED, 0);
    }
    
    private void configureSecondaryLogFilename(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	if (intsys.integrationAttributeExists(sskServiceSecondaryLog, MediationConstants.ATTRIBUTE_LOG_FILENAME)) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_FILENAME, 
        			intsys.getAttribute(sskServiceSecondaryLog, MediationConstants.ATTRIBUTE_LOG_FILENAME) != null ? 
        					intsys.getAttribute(sskServiceSecondaryLog, MediationConstants.ATTRIBUTE_LOG_FILENAME) : 
        						"Log");
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_FILENAME);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the secondary log.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_LOG_FILENAME + "' on the '" + sskServiceSecondaryLog + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The attribute is a core part of the SSK Framework and required for correct behavior when the '" + sskServiceSecondaryLog + "' service is in use.")); 
    	}
    }
    
    private void configureSecondaryLogRetention(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	if (intsys.integrationAttributeExists(sskServiceSecondaryLog, MediationConstants.ATTRIBUTE_LOG_RETENTION)) {
        	StringBuilder sb = new StringBuilder();
        	sb.append("P")
        		.append(intsys.getAttribute(sskServiceSecondaryLog, MediationConstants.ATTRIBUTE_LOG_RETENTION) != null ? 
        				intsys.getAttribute(sskServiceSecondaryLog, MediationConstants.ATTRIBUTE_LOG_RETENTION) : 
        					"30")
        		.append("D");
        	mc.setProperty(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_RETENTION, sb.toString());
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_RETENTION);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the secondary log.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_LOG_RETENTION + "' on the '" + sskServiceSecondaryLog + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The attribute is a core part of the SSK Framework and required for correct behavior when the '" + sskServiceSecondaryLog + "' service is in use.")); 
    	}
    }
    
    private void configureSecondaryLogMaxSize(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	if (intsys.integrationAttributeExists(sskServiceSecondaryLog, MediationConstants.ATTRIBUTE_LOG_MAX_SIZE)) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_MAX_SIZE, 
        			intsys.getAttribute(sskServiceSecondaryLog, MediationConstants.ATTRIBUTE_LOG_MAX_SIZE) != null ? 
        					Integer.valueOf(intsys.getAttribute(sskServiceSecondaryLog, MediationConstants.ATTRIBUTE_LOG_MAX_SIZE)) : 
        						0);
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_MAX_SIZE);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the secondary log.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_LOG_MAX_SIZE + "' on the '" + sskServiceSecondaryLog + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The attribute is a core part of the SSK Framework and required for correct behavior when the '" + sskServiceSecondaryLog + "' service is in use.")); 
    	}
    }
    
    private boolean configureSecondaryLogAggregationTag(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	boolean returnValue = false;
    	
    	if (intsys.integrationAttributeExists(sskServiceSecondaryLog, MediationConstants.ATTRIBUTE_LOG_AGGREGATION_TAG)) {
    		List<String> tags = intsys.getAttributeReferenceDataList(sskServiceSecondaryLog, MediationConstants.ATTRIBUTE_LOG_AGGREGATION_TAG, "Document_Tag_Name");
    		
    		returnValue = CollectionUtils.isNotEmpty(tags); 
        	
    		mc.setProperty(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_AGGREGATION_TAG, 
        			returnValue ? 
        					tags : 
        						null);
        	
    		mc.setProperty(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_FORMAT, MediationConstants.PROPERTY_SSK_CLOUD_LOG_FORMAT_CSV);
    		
    		initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_AGGREGATION_TAG);
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_FORMAT);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the secondary log.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_LOG_AGGREGATION_TAG + "' on the '" + sskServiceSecondaryLog + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The attribute is a core part of the SSK Framework and required for correct behavior when the '" + sskServiceSecondaryLog + "' service is in use.")); 
    	}
    	
    	return returnValue;
    }
    
    private void configureSecondaryLogFormat(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	if (intsys.integrationAttributeExists(sskServiceSecondaryLog, MediationConstants.ATTRIBUTE_LOG_FORMAT)) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_FORMAT, 
        			intsys.getAttribute(sskServiceSecondaryLog, MediationConstants.ATTRIBUTE_LOG_FORMAT) != null ? 
        					intsys.getAttribute(sskServiceSecondaryLog, MediationConstants.ATTRIBUTE_LOG_FORMAT) : 
        						MediationConstants.PROPERTY_SSK_CLOUD_LOG_FORMAT_HTML);
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_FORMAT);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the secondary log.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_LOG_FORMAT + "' on the '" + sskServiceSecondaryLog + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The attribute is a core part of the SSK Framework and required for correct behavior when the '" + sskServiceSecondaryLog + "' service is in use.")); 
    	}
    }
    
    private void configureSecondaryLogAggregationTabName(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	if (intsys.integrationAttributeExists(sskServiceSecondaryLog, MediationConstants.ATTRIBUTE_LOG_AGGREGATION_TAB_NAME)) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_AGGREGATION_TAB_NAME, 
        			intsys.getAttribute(sskServiceSecondaryLog, MediationConstants.ATTRIBUTE_LOG_AGGREGATION_TAB_NAME) != null ? 
        					intsys.getAttribute(sskServiceSecondaryLog, MediationConstants.ATTRIBUTE_LOG_AGGREGATION_TAB_NAME) : 
        						StringUtils.substringBefore(intsys.getName(), "_"));
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_SECONDARY_LOG_AGGREGATION_TAB_NAME);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the secondary log.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_LOG_AGGREGATION_TAB_NAME + "' on the '" + sskServiceSecondaryLog + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The service and its attributes are a core part of the SSK Framework and required for correct behavior.")); 
    	}
    }
    
    private void configureGeneralIntegrationService(MediationContext mc, ParsedIntegrationSystems intsys, boolean isListenerService) throws Throwable {
    	configureGeneralDocumentRetention(mc, intsys);
    	if (isListenerService) {
    		configureGeneralRunWithDebugLogging(mc, intsys);
    		configureGeneralRunInValidationMode(mc, intsys);
    	}
    }
    
    private void configureGeneralDocumentRetention(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	try {
    		if (intsys.integrationAttributeExists(sskServiceGeneral, MediationConstants.ATTRIBUTE_DOCUMENT_RETENTION)) {
	        	StringBuilder sb = new StringBuilder();
	        	sb.append("P")
	        		.append(intsys.getAttribute(sskServiceGeneral, MediationConstants.ATTRIBUTE_DOCUMENT_RETENTION) != null ? 
	        				intsys.getAttribute(sskServiceGeneral, MediationConstants.ATTRIBUTE_DOCUMENT_RETENTION) : 
	        					"30")
	        		.append("D");
	        	mc.setProperty(MediationConstants.PROPERTY_SSK_DOCUMENT_RETENTION_PERIOD, sb.toString());
	        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_DOCUMENT_RETENTION_PERIOD);
        	} else {
        		log.info("The '" + MediationConstants.ATTRIBUTE_DOCUMENT_RETENTION + "' attribute on the '" + sskServiceGeneral + "' service appears to have been removed.  The SSK Framework property '" + MediationConstants.PROPERTY_SSK_DOCUMENT_RETENTION_PERIOD + "' will not be initialized.  SSK Components dependent on properties related to this service may use Component-specific default values when the global properties are not defined.");
	    	}
    	} catch (Throwable xcpn) {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to configure the ["+ MediationConstants.PROPERTY_SSK_DOCUMENT_RETENTION_PERIOD +"] property.", 
    				xcpn); 
    	}
    }
    
    private void configureGeneralRunWithDebugLogging(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	try {
    		if (intsys.integrationAttributeExists(sskServiceGeneral, MediationConstants.ATTRIBUTE_DEBUG_MODE_LISTENER_SERVICE)) {
	        	mc.setProperty(MediationConstants.PROPERTY_SSK_IS_DEBUG_MODE, intsys.getAttributeAsBoolean(sskServiceGeneral, MediationConstants.ATTRIBUTE_DEBUG_MODE_LISTENER_SERVICE, true));
	        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_IS_DEBUG_MODE);
        	} else {
	        	mc.setProperty(MediationConstants.PROPERTY_SSK_IS_DEBUG_MODE, Boolean.FALSE);
        		log.info("The '" + MediationConstants.ATTRIBUTE_DEBUG_MODE_LISTENER_SERVICE + "' attribute on the '" + sskServiceGeneral + "' service appears to have been removed.  The SSK Framework property '" + MediationConstants.PROPERTY_SSK_IS_DEBUG_MODE + "' will be initialized to FALSE.  To enable optional Debug functionality offered by SSK when using a Studio Listener Service, this attribute must be restored.");
	    	}
    	} catch (Throwable xcpn) {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to configure the ["+ MediationConstants.PROPERTY_SSK_IS_DEBUG_MODE +"] property.", 
    				xcpn); 
    	}
    }
    
    private void configureGeneralRunInValidationMode(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	try {
    		if (intsys.integrationAttributeExists(sskServiceGeneral, MediationConstants.ATTRIBUTE_VALIDATION_MODE_LISTENER_SERVICE)) {
	        	mc.setProperty(MediationConstants.PROPERTY_SSK_IS_VALIDATION_MODE, intsys.getAttributeAsBoolean(sskServiceGeneral, MediationConstants.ATTRIBUTE_VALIDATION_MODE_LISTENER_SERVICE, true));
	        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_IS_VALIDATION_MODE);
        	} else {
	        	mc.setProperty(MediationConstants.PROPERTY_SSK_IS_VALIDATION_MODE, Boolean.FALSE);
        		log.info("The '" + MediationConstants.ATTRIBUTE_VALIDATION_MODE_LISTENER_SERVICE + "' attribute on the '" + sskServiceGeneral + "' service appears to have been removed.  The SSK Framework property '" + MediationConstants.PROPERTY_SSK_IS_VALIDATION_MODE + "' will be initialized to FALSE.  To allow integration events to run without committing data to the tenant when using a Studio Listener Service, this attribute must be restored.");
	    	}
    	} catch (Throwable xcpn) {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to configure the ["+ MediationConstants.PROPERTY_SSK_IS_VALIDATION_MODE +"] property.", 
    				xcpn); 
    	}
    }
    
    private void configureFunctionalIntegrationService(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	configureFunctionalRetrievalDocumentTagType(mc, intsys);
    	configureFunctionalRetrievalDocumentTag(mc, intsys);
    	configureFunctionalOutputFilename(mc, intsys);
    	configureFunctionalDeliveryDocumentTag(mc, intsys);
    }
    
    private void configureFunctionalRetrievalDocumentTagType(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	try {
	    	if (intsys.integrationAttributeExists(sskServiceFunctional, MediationConstants.ATTRIBUTE_DOCUMENT_RETRIEVAL_TAG_TYPE)) {
	        	mc.setProperty(MediationConstants.PROPERTY_SSK_RETRIEVAL_DOCUMENT_TAG_TYPE, 
	        			intsys.getAttribute(sskServiceFunctional, MediationConstants.ATTRIBUTE_DOCUMENT_RETRIEVAL_TAG_TYPE) != null ? 
	        					intsys.getAttribute(sskServiceFunctional, MediationConstants.ATTRIBUTE_DOCUMENT_RETRIEVAL_TAG_TYPE) : 
	        						MediationConstants.PROPERTY_SSK_RETRIEVAL_MATCH_ALL);
	        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_RETRIEVAL_DOCUMENT_TAG_TYPE);
	    	} else {
        		log.info("The '" + MediationConstants.ATTRIBUTE_DOCUMENT_RETRIEVAL_TAG_TYPE + "' attribute on the '" + sskServiceFunctional + "' service appears to have been removed.  The SSK Framework property '" + MediationConstants.ATTRIBUTE_DOCUMENT_RETRIEVAL_TAG_TYPE + "' will not be initialized.  SSK Components dependent on properties related to this service may use Component-specific default values when the global properties are not defined.");
	    	}
    	} catch (Throwable xcpn) {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to configure the ["+ MediationConstants.ATTRIBUTE_DOCUMENT_RETRIEVAL_TAG_TYPE +"] property.", 
    				xcpn); 
    	}
    }
    
    private void configureFunctionalRetrievalDocumentTag(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	try {
	    	if (intsys.integrationAttributeExists(sskServiceFunctional, MediationConstants.ATTRIBUTE_DOCUMENT_RETRIEVAL_TAG)) {
	    		List<String> tags = intsys.getAttributeReferenceDataList(sskServiceFunctional, MediationConstants.ATTRIBUTE_DOCUMENT_RETRIEVAL_TAG, "WID");
	    		
	        	mc.setProperty(MediationConstants.PROPERTY_SSK_RETRIEVAL_DOCUMENT_TAG, 
	        			CollectionUtils.isNotEmpty(tags) ? 
	        					tags : 
	        						null);
	        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_RETRIEVAL_DOCUMENT_TAG);
        	} else {
        		log.info("The '" + MediationConstants.ATTRIBUTE_DOCUMENT_RETRIEVAL_TAG + "' attribute on the '" + sskServiceFunctional + "' service appears to have been removed.  The SSK Framework property '" + MediationConstants.PROPERTY_SSK_RETRIEVAL_DOCUMENT_TAG + "' will not be initialized.  SSK Components dependent on properties related to this service may use Component-specific default values when the global properties are not defined.");
	    	}
    	} catch (Throwable xcpn) {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to configure the ["+ MediationConstants.PROPERTY_SSK_RETRIEVAL_DOCUMENT_TAG +"] property.", 
    				xcpn); 
    	}
    }
    
    private void configureFunctionalOutputFilename(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	try {
	    	if (intsys.integrationAttributeExists(sskServiceFunctional, MediationConstants.ATTRIBUTE_DOCUMENT_OUTPUT_FILENAME)) {
	        	mc.setProperty(MediationConstants.PROPERTY_SSK_OUTPUT_FILENAME, 
	        			intsys.getAttribute(sskServiceFunctional, MediationConstants.ATTRIBUTE_DOCUMENT_OUTPUT_FILENAME) != null ? 
	        					intsys.getAttribute(sskServiceFunctional, MediationConstants.ATTRIBUTE_DOCUMENT_OUTPUT_FILENAME) : 
	        						"INT_Results");
	        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_OUTPUT_FILENAME);
        	} else {
        		log.info("The '" + MediationConstants.ATTRIBUTE_DOCUMENT_OUTPUT_FILENAME + "' attribute on the '" + sskServiceFunctional + "' service appears to have been removed.  The SSK Framework property '" + MediationConstants.PROPERTY_SSK_OUTPUT_FILENAME + "' will not be initialized.  SSK Components dependent on properties related to this service may use Component-specific default values when the global properties are not defined.");
	    	}
    	} catch (Throwable xcpn) {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to configure the ["+ MediationConstants.PROPERTY_SSK_OUTPUT_FILENAME +"] property.", 
    				xcpn); 
    	}
    }
    
    private void configureFunctionalDeliveryDocumentTag(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	try {
	    	if (intsys.integrationAttributeExists(sskServiceFunctional, MediationConstants.ATTRIBUTE_DOCUMENT_DELIVERY_TAG)) {
	    		List<String> tags = intsys.getAttributeReferenceDataList(sskServiceFunctional, MediationConstants.ATTRIBUTE_DOCUMENT_DELIVERY_TAG, "Document_Tag_Name");
	    		
	        	mc.setProperty(MediationConstants.PROPERTY_SSK_DELIVERY_DOCUMENT_TAG, 
	        			CollectionUtils.isNotEmpty(tags) ? 
	        					tags : 
	        						null);
	        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_DELIVERY_DOCUMENT_TAG);
        	} else {
        		log.info("The '" + MediationConstants.ATTRIBUTE_DOCUMENT_DELIVERY_TAG + "' attribute on the '" + sskServiceFunctional + "' service appears to have been removed.  The SSK Framework property '" + MediationConstants.PROPERTY_SSK_DELIVERY_DOCUMENT_TAG + "' will not be initialized.  SSK Components dependent on properties related to this service may use Component-specific default values when the global properties are not defined.");
	    	}
    	} catch (Throwable xcpn) {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to configure the ["+ MediationConstants.PROPERTY_SSK_DELIVERY_DOCUMENT_TAG +"] property.", 
    				xcpn); 
    	}
    }
    
    private void configureMessageQueueIntegrationService(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	configureMessageQueueEndpoint(mc, intsys);
    	configureMessageQueueUsername(mc, intsys);
    	configureMessageQueuePassword(mc, intsys);
    	configureMessageQueueName(mc, intsys);
    }
    
    private void configureMessageQueueEndpoint(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	if (intsys.integrationAttributeExists(sskServiceMessageQueue, MediationConstants.ATTRIBUTE_QUEUE_ENDPOINT)) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_QUEUE_ENDPOINT, intsys.getAttribute(sskServiceMessageQueue, MediationConstants.ATTRIBUTE_QUEUE_ENDPOINT));
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_QUEUE_ENDPOINT);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the message queue.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_QUEUE_ENDPOINT + "' on the '" + sskServiceMessageQueue + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The attribute is a core part of the SSK Framework and required for correct behavior when the '" + sskServiceMessageQueue + "' service is in use.")); 
    	}
    }
    
    private void configureMessageQueueUsername(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	if (intsys.integrationAttributeExists(sskServiceMessageQueue, MediationConstants.ATTRIBUTE_QUEUE_USERNAME)) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_QUEUE_USERNAME, intsys.getAttribute(sskServiceMessageQueue, MediationConstants.ATTRIBUTE_QUEUE_USERNAME) + "@" + (String)mc.getProperty(MediationConstants.STUDIO_PROPERTY_TENANT_ID));
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_QUEUE_USERNAME);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the message queue.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_QUEUE_USERNAME + "' on the '" + sskServiceMessageQueue + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The attribute is a core part of the SSK Framework and required for correct behavior when the '" + sskServiceMessageQueue + "' service is in use.")); 
    	}
    }
    
    private void configureMessageQueuePassword(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	if (intsys.integrationAttributeExists(sskServiceMessageQueue, MediationConstants.ATTRIBUTE_QUEUE_PASSWORD)) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_QUEUE_PASSWORD, intsys.getAttribute(sskServiceMessageQueue, MediationConstants.ATTRIBUTE_QUEUE_PASSWORD));
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the message queue.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_QUEUE_PASSWORD + "' on the '" + sskServiceMessageQueue + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The attribute is a core part of the SSK Framework and required for correct behavior when the '" + sskServiceMessageQueue + "' service is in use.")); 
    	}
    }
    
    private void configureMessageQueueName(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	if (intsys.integrationAttributeExists(sskServiceMessageQueue, MediationConstants.ATTRIBUTE_QUEUE_NAME)) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_QUEUE_NAME, intsys.getAttribute(sskServiceMessageQueue, MediationConstants.ATTRIBUTE_QUEUE_NAME));
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_QUEUE_NAME);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete configuration of the message queue.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_QUEUE_NAME + "' on the '" + sskServiceMessageQueue + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The attribute is a core part of the SSK Framework and required for correct behavior when the '" + sskServiceMessageQueue + "' service is in use.")); 
    	}
    }
    
    private void configureWorkdayExtendIntegrationService(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	configureWorkdayRestClientId(mc, intsys, sskServiceWorkdayExtend);
    	configureWorkdayRestClientSecret(mc, intsys, sskServiceWorkdayExtend);
    	configureWorkdayRestRefreshToken(mc, intsys, sskServiceWorkdayExtend, false);
    	configureWorkdayRestTenantAlias(mc, intsys, sskServiceWorkdayExtend);
    	configureWorkdayRestTokenEndpoint(mc, intsys, sskServiceWorkdayExtend);
    	configureWorkdayRestGatewayEndpoint(mc, intsys, sskServiceWorkdayExtend);
    }
    
    private void configureWorkdayRestIntegrationService(MediationContext mc, ParsedIntegrationSystems intsys) throws Throwable {
    	configureWorkdayRestClientId(mc, intsys, sskServiceWorkdayRest);
    	configureWorkdayRestClientSecret(mc, intsys, sskServiceWorkdayRest);
    	configureWorkdayRestRefreshToken(mc, intsys, sskServiceWorkdayRest, true);
    	configureWorkdayRestTokenEndpoint(mc, intsys, sskServiceWorkdayRest);
    	configureWorkdayRestApiEndpoint(mc, intsys, sskServiceWorkdayRest);
    }
    
    private void configureWorkdayRestClientId(MediationContext mc, ParsedIntegrationSystems intsys, String serviceName) throws Throwable {
    	if (intsys.integrationAttributeExists(serviceName, MediationConstants.ATTRIBUTE_EXTEND_REST_CLIENT_ID)) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_REST_CLIENT_ID, intsys.getAttribute(serviceName, MediationConstants.ATTRIBUTE_EXTEND_REST_CLIENT_ID));
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_REST_CLIENT_ID);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete Workday/Extend REST configuration.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_EXTEND_REST_CLIENT_ID + "' on the '" + serviceName + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The attribute is a core part of the SSK Framework and required for correct behavior when the '" + serviceName + "' service is in use.")); 
    	}
    }
    
    private void configureWorkdayRestClientSecret(MediationContext mc, ParsedIntegrationSystems intsys, String serviceName) throws Throwable {
    	if (intsys.integrationAttributeExists(serviceName, MediationConstants.ATTRIBUTE_EXTEND_REST_CLIENT_SECRET)) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_REST_CLIENT_SECRET, intsys.getAttribute(serviceName, MediationConstants.ATTRIBUTE_EXTEND_REST_CLIENT_SECRET));
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete Workday/Extend REST configuration.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_EXTEND_REST_CLIENT_SECRET + "' on the '" + serviceName + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The attribute is a core part of the SSK Framework and required for correct behavior when the '" + serviceName + "' service is in use.")); 
    	}
    }
    
    private void configureWorkdayRestRefreshToken(MediationContext mc, ParsedIntegrationSystems intsys, String serviceName, boolean isRequired) throws Throwable {
    	if (intsys.integrationAttributeExists(serviceName, MediationConstants.ATTRIBUTE_EXTEND_REST_REFRESH_TOKEN)) {
        	try {
	        	mc.setProperty(MediationConstants.PROPERTY_SSK_REST_REFRESH_TOKEN, intsys.getAttribute(serviceName, MediationConstants.ATTRIBUTE_EXTEND_REST_REFRESH_TOKEN));
        	} catch (Throwable xcpn) {
        		SSKUtils.logErrorAndThrowRuntimeException(
        				log, 
        				"Unable to configure the ["+ MediationConstants.PROPERTY_SSK_REST_REFRESH_TOKEN +"] property.", 
        				xcpn); 
        	}
    	} else if (isRequired) {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete Workday/Extend REST configuration.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_EXTEND_REST_REFRESH_TOKEN + "' on the '" + serviceName + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The attribute is a core part of the SSK Framework and required for correct behavior when the '" + serviceName + "' service is in use.")); 
    	} else {
    		log.info("The '" + MediationConstants.ATTRIBUTE_EXTEND_REST_REFRESH_TOKEN + "' attribute on the '" + serviceName + "' service appears to have been removed.  The SSK Framework property '" + MediationConstants.PROPERTY_SSK_REST_REFRESH_TOKEN + "' will not be initialized.  SSK Components dependent on properties related to this service may use Component-specific default values when the global properties are not defined.");
    	}
    }
    
    private void configureWorkdayRestTenantAlias(MediationContext mc, ParsedIntegrationSystems intsys, String serviceName) throws Throwable {
    	if (intsys.integrationAttributeExists(serviceName, MediationConstants.ATTRIBUTE_EXTEND_REST_TENANT_ALIAS)) {
    		String alias = intsys.getAttribute(serviceName, MediationConstants.ATTRIBUTE_EXTEND_REST_TENANT_ALIAS);
        	mc.setProperty(MediationConstants.PROPERTY_SSK_REST_TENANT_ALIAS, StringUtils.isNotBlank(alias) ? alias : (String)mc.getProperty(MediationConstants.STUDIO_PROPERTY_TENANT_ID));
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_REST_TENANT_ALIAS);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete Workday/Extend REST configuration.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_EXTEND_REST_TENANT_ALIAS + "' on the '" + serviceName + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The attribute is a core part of the SSK Framework and required for correct behavior when the '" + serviceName + "' service is in use.")); 
    	}
    }
    
    private void configureWorkdayRestTokenEndpoint(MediationContext mc, ParsedIntegrationSystems intsys, String serviceName) throws Throwable {
    	if (intsys.integrationAttributeExists(serviceName, MediationConstants.ATTRIBUTE_EXTEND_REST_TOKEN_ENDPOINT)) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_REST_ENDPOINT_TOKEN, intsys.getAttribute(serviceName, MediationConstants.ATTRIBUTE_EXTEND_REST_TOKEN_ENDPOINT));
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_REST_ENDPOINT_TOKEN);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete Workday/Extend REST configuration.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_EXTEND_REST_TOKEN_ENDPOINT + "' on the '" + serviceName + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The attribute is a core part of the SSK Framework and required for correct behavior when the '" + serviceName + "' service is in use.")); 
    	}
    }
    
    private void configureWorkdayRestGatewayEndpoint(MediationContext mc, ParsedIntegrationSystems intsys, String serviceName) throws Throwable {
    	if (intsys.integrationAttributeExists(serviceName, MediationConstants.ATTRIBUTE_EXTEND_REST_GATEWAY_ENDPOINT)) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_REST_ENDPOINT_API, intsys.getAttribute(serviceName, MediationConstants.ATTRIBUTE_EXTEND_REST_GATEWAY_ENDPOINT));
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_REST_ENDPOINT_API);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete Workday/Extend REST configuration.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_EXTEND_REST_GATEWAY_ENDPOINT + "' on the '" + serviceName + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The attribute is a core part of the SSK Framework and required for correct behavior when the '" + serviceName + "' service is in use.")); 
    	}
    }
    
    private void configureWorkdayRestApiEndpoint(MediationContext mc, ParsedIntegrationSystems intsys, String serviceName) throws Throwable {
    	if (intsys.integrationAttributeExists(serviceName, MediationConstants.ATTRIBUTE_EXTEND_REST_API_ENDPOINT)) {
        	mc.setProperty(MediationConstants.PROPERTY_SSK_REST_ENDPOINT_API, intsys.getAttribute(serviceName, MediationConstants.ATTRIBUTE_EXTEND_REST_API_ENDPOINT));
        	initializedAttributesAndParameters.add(MediationConstants.PROPERTY_SSK_REST_ENDPOINT_API);
    	} else {
    		SSKUtils.logErrorAndThrowRuntimeException(
    				log, 
    				"Unable to complete Workday/Extend REST configuration.", 
    				new IllegalStateException("The '" + MediationConstants.ATTRIBUTE_EXTEND_REST_API_ENDPOINT + "' on the '" + serviceName + "' service is required but appears to have been removed.  Please restore this attribute to the service on the Workday-In component.  The attribute is a core part of the SSK Framework and required for correct behavior when the '" + serviceName + "' service is in use.")); 
    	}
    }
    
    private void configureGeneralSettings(MediationContext mc) throws Throwable {
    	mc.setProperty(MediationConstants.PROPERTY_SSK_STATIC_ANALYSIS_EXEMPTIONS, new ArrayList<String>());
    }
    
    private void configureDebug(MediationContext mc, MVELUtilHelper util) throws Throwable {
  		configureDebugTypes(mc);
   		configureDebugNames(mc);
   		configureDefaultDebugProperties(mc);
    	
    	mc.setProperty(MediationConstants.PROPERTY_SSK_DEDUPLICATOR, new StringDeduplicator());
    	mc.setProperty(MediationConstants.PROPERTY_SSK_DEBUG_ARCHIVE, "DebugFiles-INT093_SEMA4_Out_SSK_Studio-" + StringUtils.replaceAll(util.currentDateTimeAsString(), ":", "") + ".zip");
    }

    private void configureDebugTypes(MediationContext mc) throws Throwable {
    	Set<String> debugTypes = new HashSet<String>();
    	debugTypes.add("message");
    	debugTypes.add("property");
    	debugTypes.add("properties");
    	debugTypes.add("variable");
    	debugTypes.add("map");
    	debugTypes.add("list");
    	debugTypes.add("set");
    	debugTypes.add("finalize");
    	
    	mc.setProperty(MediationConstants.PROPERTY_SSK_DEBUG_TARGET_TYPE_VALIDATION, debugTypes);
    }
    
    private void configureDebugNames(MediationContext mc) throws Throwable {
    	Set<String> debugNames = new HashSet<String>();
    	debugNames.add("message");
    	debugNames.add("property");
    	debugNames.add("properties");
    	debugNames.add("variable");
    	debugNames.add("map");
    	debugNames.add("list");
    	debugNames.add("set");
    	
    	mc.setProperty(MediationConstants.PROPERTY_SSK_DEBUG_TARGET_NAME_VALIDATION, debugNames);
    }
    
    private void configureDefaultDebugProperties(MediationContext mc) throws Throwable {
    	List<String> propertyNames = new ArrayList<String>();
    	propertyNames.add(MediationConstants.PROPERTY_SSK_VERSION);
    	propertyNames.add(MediationConstants.PROPERTY_GLOBAL_API_VERSION);
    	
    	for (Iterator<String> iterator = initializedAttributesAndParameters.iterator(); iterator.hasNext();) {
    		propertyNames.add(iterator.next());			
		}
    	
    	mc.setProperty(MediationConstants.PROPERTY_SSK_DEBUG_LIST, propertyNames);
    }
}

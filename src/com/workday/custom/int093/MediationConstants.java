package com.workday.custom.int093;

public class MediationConstants {
	
	public static final String ASSEMBLY_VERSION = "2022.37";
	public static final String API_VERSION = "v39.0";
	public static final String SSK_VERSION = "Studio StarterKit 2022r2.02";

	// Names of Workday Studio built-in properties
	public static final String STUDIO_PROPERTY_TOKEN_USERNAME = "wss.usernametoken.username";
	public static final String STUDIO_PROPERTY_TOKEN_PASSWORD = "wss.usernametoken.password";
	public static final String STUDIO_PROPERTY_TENANT_ID = "cc.customer.id";
	public static final String STUDIO_PROPERTY_UNIT_TEST = "atf.aunit.test";
	public static final String STUDIO_PROPERTY_HTTP_RESPONSE_CODE = "http.response.code";

	// Names of SSK-provided Integration Services
	public static final String SERVICE_GENERAL = "INT093 SEMA4 Out SSK Studio - Attribute and Map Service - General";
	public static final String SERVICE_FUNCTIONAL = "INT093 SEMA4 Out SSK Studio - Attribute and Map Service - Functional";
	public static final String SERVICE_MESSAGE_QUEUE = "INT093 SEMA4 Out SSK Studio - Attribute and Map Service - Message Queue";
	public static final String SERVICE_PRIMARY_LOG = "INT093 SEMA4 Out SSK Studio - Attribute and Map Service - Primary Logging";
	public static final String SERVICE_SECONDARY_LOG = "INT093 SEMA4 Out SSK Studio - Attribute and Map Service - Secondary Logging";
	public static final String SERVICE_WORKDAY_EXTEND = "INT093 SEMA4 Out SSK Studio - Attribute and Map Service - Workday Extend";
	public static final String SERVICE_WORKDAY_REST = "INT093 SEMA4 Out SSK Studio - Attribute and Map Service - Workday REST";
	public static final String SERVICE_LISTENER = "INT093 SEMA4 Out SSK Studio - Listener Service";

	// Names of context properties defining overridden names for SSK-provided Integration Services
	public static final String PROPERTY_SSK_SERVICE_GENERAL = "sskServiceNameGeneral";
	public static final String PROPERTY_SSK_SERVICE_FUNCTIONAL = "sskServiceNameFunctional";
	public static final String PROPERTY_SSK_SERVICE_MESSAGE_QUEUE = "sskServiceNameMessageQueue";
	public static final String PROPERTY_SSK_SERVICE_PRIMARY_LOG = "sskServiceNameLogPrimary";
	public static final String PROPERTY_SSK_SERVICE_SECONDARY_LOG = "sskServiceNameLogSecondary";
	public static final String PROPERTY_SSK_SERVICE_WORKDAY_EXTEND = "sskServiceNameExtend";
	public static final String PROPERTY_SSK_SERVICE_WORKDAY_REST = "sskServiceNameRest";
	public static final String PROPERTY_SSK_SERVICE_LISTENER = "sskServiceNameListener";

	// Names of SSK-provided Integration Attributes - General
	public static final String ATTRIBUTE_DOCUMENT_RETENTION = "Document Retention in Days";
	public static final String ATTRIBUTE_VALIDATION_MODE_LISTENER_SERVICE = "Run in Validation Mode (Listener Service Only)";
	public static final String ATTRIBUTE_DEBUG_MODE_LISTENER_SERVICE = "Run with Debug Logging (Listener Service Only)";

	// Names of SSK-provided Integration Attributes - Functional
	public static final String ATTRIBUTE_DOCUMENT_RETRIEVAL_TAG = "Retrieval Document Tag(s)";
	public static final String ATTRIBUTE_DOCUMENT_RETRIEVAL_TAG_TYPE = "Retrieval Document Tag Match Strategy";
	public static final String ATTRIBUTE_DOCUMENT_OUTPUT_FILENAME = "Output File Name (Include File Extension)";
	public static final String ATTRIBUTE_DOCUMENT_DELIVERY_TAG = "Delivery Document Tag(s)";

	// Names of SSK-provided Integration Attributes - Cloud Logs
	public static final String ATTRIBUTE_LOG_FILENAME = "Log File Name (Exclude File Extension)";
	public static final String ATTRIBUTE_LOG_RETENTION = "Log Retention in Days";
	public static final String ATTRIBUTE_LOG_MAX_SIZE = "Max Entries per Log File";
	public static final String ATTRIBUTE_LOG_FORMAT = "Cloud Log Output File Type";
	public static final String ATTRIBUTE_LOG_AGGREGATION_TAG = "Tag for Log Aggregator (overrides Cloud Log Output File Type)";
	public static final String ATTRIBUTE_LOG_AGGREGATION_TAB_NAME = "Tab Name for Log Aggregator";

	// Names of SSK-provided Integration Attributes - Message Queue
	public static final String ATTRIBUTE_QUEUE_ENDPOINT = "Message Queue Endpoint";
	public static final String ATTRIBUTE_QUEUE_USERNAME = "Message Queue Endpoint Login Username";
	public static final String ATTRIBUTE_QUEUE_PASSWORD = "Message Queue Endpoint Login Password";
	public static final String ATTRIBUTE_QUEUE_NAME = "Message Queue Name";

	// Names of SSK-provided Integration Attributes - Workday Extend and Workday REST
	public static final String ATTRIBUTE_EXTEND_REST_CLIENT_ID = "API Client ID";
	public static final String ATTRIBUTE_EXTEND_REST_CLIENT_SECRET = "API Client Secret";
	public static final String ATTRIBUTE_EXTEND_REST_REFRESH_TOKEN = "Refresh Token";
	public static final String ATTRIBUTE_EXTEND_REST_TENANT_ALIAS = "Tenant Alias";	//Extend only
	public static final String ATTRIBUTE_EXTEND_REST_TOKEN_ENDPOINT = "Token Endpoint";
	public static final String ATTRIBUTE_EXTEND_REST_GATEWAY_ENDPOINT = "Gateway Endpoint";	//Extend only
	public static final String ATTRIBUTE_EXTEND_REST_API_ENDPOINT = "API Endpoint";	//REST only

	public static final String VALUE_REST_PROVIDER_EXTEND = "extend";
	public static final String VALUE_REST_PROVIDER_TENANT = "tenant";

	// Names of SSK-provided Launch Parameters
	public static final String LAUNCH_PARAMETER_VALIDATION_MODE = "Run in Validation Mode";
	public static final String LAUNCH_PARAMETER_DEBUG_MODE = "Run with Debug Logging";
	public static final String LAUNCH_PARAMETER_SOURCE_EVENT_WID = "Source Integration Event WID (Build and Debug Only)";
	public static final String LAUNCH_PARAMETER_LOG_AGGREGATION_CHAIN_WID = "Log Aggregation Chain Event";

	// SSK Properties that have meta-level influence on framework behavior
	public static final String PROPERTY_SSK_VERSION = "sskVersion";
	public static final String PROPERTY_SSK_DEDUPLICATOR = "sskStringDeduplicator";
	public static final String PROPERTY_SSK_DEBUG_TARGET_TYPE_VALIDATION = "sskDebugTargetTypeValidation";
	public static final String PROPERTY_SSK_DEBUG_TARGET_NAME_VALIDATION = "sskDebugTargetNameValidation";
	public static final String PROPERTY_SSK_STATIC_ANALYSIS_EXEMPTIONS = "sskStaticCodeAnalysisExemptionList";
	public static final String PROPERTY_SSK_DEBUG_LIST = "sskDebugPropertyList";
	public static final String PROPERTY_SSK_DEBUG_ARCHIVE = "sskDebugArchiveFilename";
	public static final String PROPERTY_SSK_XSLT_FUNCTION_LIBRARY_MESSAGES = "sskXsltLibMessage";
	public static final String PROPERTY_SSK_XSLT_FUNCTION_LIBRARY_FLEX_EXT = "sskXsltLibFlexLogExtensions";
	public static final String PROPERTY_SSK_XSLT_FUNCTION_LIBRARY_FLEX_MSG = "sskXsltLibFlexLogMessages";
	public static final String PROPERTY_SSK_FLEX_LOG = "sskFlexLog";
	public static final String PROPERTY_SSK_FLEX_LOG_META_BEAN = "sskFlexLogMetaBean";

	public static final String VARIABLE_FLEXLOG_TEMP_CONFIG = "sskFlexLogConfiguration147";
	public static final String VARIABLE_FLEXLOG_TEMP_SCHEMA = "sskFlexLogSchema147";

	// SSK Properties populated from Launch Parameters
	public static final String PROPERTY_SSK_IS_DEBUG_MODE = "sskIsDebugMode";
	public static final String PROPERTY_SSK_IS_VALIDATION_MODE = "sskIsValidationMode";
	public static final String PROPERTY_SSK_DEBUG_EVENT_WID = "sskDebugWID";
	public static final String PROPERTY_SSK_LOG_CHAIN_WID = "sskLogChainWID";
	public static final String PROPERTY_SSK_EVENT_WID = "sskEventWID";

	// SSK Properties populated from Integration Attributes
	public static final String PROPERTY_SSK_DOCUMENT_RETENTION_PERIOD = "sskDocumentRetentionPeriod";
	public static final String PROPERTY_SSK_RETRIEVAL_DOCUMENT_TAG = "sskRetrievalDocTag";
	public static final String PROPERTY_SSK_RETRIEVAL_DOCUMENT_TAG_TYPE = "sskRetrievalDocTagType";
	public static final String PROPERTY_SSK_OUTPUT_FILENAME = "sskOutputFilename";
	public static final String PROPERTY_SSK_DELIVERY_DOCUMENT_TAG = "sskDeliveryDocTag";
	public static final String PROPERTY_SSK_QUEUE_ENDPOINT = "sskQueueEndpoint";
	public static final String PROPERTY_SSK_QUEUE_USERNAME = "sskQueueUsername";
	public static final String PROPERTY_SSK_QUEUE_PASSWORD = "sskQueuePassword";
	public static final String PROPERTY_SSK_QUEUE_NAME = "sskQueueName";
	public static final String PROPERTY_SSK_REST_PROVIDER = "sskRestProvider";
	public static final String PROPERTY_SSK_REST_CLIENT_ID = "sskRestClientId";
	public static final String PROPERTY_SSK_REST_CLIENT_SECRET = "sskRestClientSecret";
	public static final String PROPERTY_SSK_REST_REFRESH_TOKEN = "sskRestRefreshToken";
	public static final String PROPERTY_SSK_REST_TENANT_ALIAS = "sskRestTenantAlias";
	public static final String PROPERTY_SSK_REST_ENDPOINT_TOKEN = "sskRestTokenEndpoint";
	public static final String PROPERTY_SSK_REST_ENDPOINT_API = "sskRestBaseApiEndpoint";
	
	// SSK Properties used globally, but not derived from Attributes or Launch Parameters
	public static final String PROPERTY_GLOBAL_API_VERSION = "globalApiVersion";

	// SSK Properties related to Primary Log
	public static final String PROPERTY_SSK_PRIMARY_LOG_FILENAME = "sskPrimaryLogFilename";
	public static final String PROPERTY_SSK_PRIMARY_LOG_RETENTION = "sskPrimaryLogExpires";
	public static final String PROPERTY_SSK_PRIMARY_LOG_MAX_SIZE = "sskPrimaryLogMaxCountPerFile";
	public static final String PROPERTY_SSK_PRIMARY_LOG_FORMAT = "sskPrimaryLogFileFormat";
	public static final String PROPERTY_SSK_PRIMARY_LOG_AGGREGATION_TAG = "sskPrimaryLogAggregationTag";
	public static final String PROPERTY_SSK_PRIMARY_LOG_AGGREGATION_TAB_NAME = "sskPrimaryLogAggregationTabName";
	public static final String PROPERTY_SSK_PRIMARY_LOG_COUNT_BY_FILE = "sskPrimaryLogCountByLogFile";
	public static final String PROPERTY_SSK_PRIMARY_LOG_COUNT_DEBUG = "sskPrimaryLogCountDebug";
	public static final String PROPERTY_SSK_PRIMARY_LOG_COUNT_INFO = "sskPrimaryLogCountInfo";
	public static final String PROPERTY_SSK_PRIMARY_LOG_COUNT_WARN = "sskPrimaryLogCountWarn";
	public static final String PROPERTY_SSK_PRIMARY_LOG_COUNT_ERROR = "sskPrimaryLogCountError";
	public static final String PROPERTY_SSK_PRIMARY_LOG_COUNT_CRITICAL = "sskPrimaryLogCountCritical";
	public static final String PROPERTY_SSK_PRIMARY_LOG_COUNT_TOTAL = "sskPrimaryLogCountTotal";
	public static final String PROPERTY_SSK_PRIMARY_LOG_FILES_STORED = "sskPrimaryLogFilesStored";

	// SSK Variables related to Primary Log
	public static final String VARIABLE_SSK_CLOUD_LOG_PRIMARY = "cloud-log-primary";

	// SSK Properties related to Secondary Log
	public static final String PROPERTY_SSK_SECONDARY_LOG_IS_ENABLED = "sskIsSecondaryLogEnabled";
	
	public static final String PROPERTY_SSK_SECONDARY_LOG_FILENAME = "sskSecondaryLogFilename";
	public static final String PROPERTY_SSK_SECONDARY_LOG_RETENTION = "sskSecondaryLogExpires";
	public static final String PROPERTY_SSK_SECONDARY_LOG_MAX_SIZE = "sskSecondaryLogMaxCountPerFile";
	public static final String PROPERTY_SSK_SECONDARY_LOG_FORMAT = "sskSecondaryLogFileFormat";
	public static final String PROPERTY_SSK_SECONDARY_LOG_AGGREGATION_TAG = "sskSecondaryLogAggregationTag";
	public static final String PROPERTY_SSK_SECONDARY_LOG_AGGREGATION_TAB_NAME = "sskSecondaryLogAggregationTabName";
	public static final String PROPERTY_SSK_SECONDARY_LOG_COUNT_BY_FILE = "sskSecondaryLogCountByLogFile";
	public static final String PROPERTY_SSK_SECONDARY_LOG_COUNT_DEBUG = "sskSecondaryLogCountDebug";
	public static final String PROPERTY_SSK_SECONDARY_LOG_COUNT_INFO = "sskSecondaryLogCountInfo";
	public static final String PROPERTY_SSK_SECONDARY_LOG_COUNT_WARN = "sskSecondaryLogCountWarn";
	public static final String PROPERTY_SSK_SECONDARY_LOG_COUNT_ERROR = "sskSecondaryLogCountError";
	public static final String PROPERTY_SSK_SECONDARY_LOG_COUNT_CRITICAL = "sskSecondaryLogCountCritical";
	public static final String PROPERTY_SSK_SECONDARY_LOG_COUNT_TOTAL = "sskSecondaryLogCountTotal";
	public static final String PROPERTY_SSK_SECONDARY_LOG_FILES_STORED = "sskSecondaryLogFilesStored";
	
	// SSK Variables related to Secondary Log
	public static final String VARIABLE_SSK_CLOUD_LOG_SECONDARY = "cloud-log-secondary";

	// Cloud Log format enumeration values
	public static final String PROPERTY_SSK_CLOUD_LOG_FORMAT_HTML = "HTML";
	public static final String PROPERTY_SSK_CLOUD_LOG_FORMAT_CSV = "CSV";
	public static final String PROPERTY_SSK_CLOUD_LOG_FORMAT_XLSX = "XLSX";
	
	// SSK Input Parameters related to General Cloud Logging
	public static final String PARAMETER_IN_SSK_CLOUD_LOG_LEVEL = "inLogLevel";
	public static final String PARAMETER_IN_SSK_CLOUD_LOG_FINALIZE = "inLogFinalize";

	// Document Retrieval Tag Match Strategy enumeration values
	public static final String PROPERTY_SSK_RETRIEVAL_MATCH_ANY = "Any";
	public static final String PROPERTY_SSK_RETRIEVAL_MATCH_ALL = "All";

	// SSK Variables related to Debug
	public static final String PROP_PARAMETER_IN_TARGET_TYPE = "inTargetType";
	public static final String PROP_PARAMETER_IN_TARGET_NAME = "inTargetName";
	public static final String PROPERTY_SSK_DEBUG_MESSAGE_FRAGMENT = "sskFileBackedManagedDataDebugFragment";
	public static final int DEBUG_FRAGMENT_SIZE_KB = 5;

	// SSK102 Input Parameters used in custom Java
	public static final String PROP_PARAMETER_IN_PROMPT_MAP = "inPropertyNameReportPromptMap";
	public static final String PROP_PARAMETER_IN_USE_JAVA_URL_ENCODER = "inIsUseJavaUrlEncoder";
	
	public static final String PROPERTY_102_URL = "localRestUrl";
	
	// SSK112 XSLT Function Libraries
	public static final String VALUE_XSLT_LIB_MESSAGE = "xslt/ssk112/SSK112_FunctionLib_Messages.xsl";
	
	// SSK130 Internal Component Context Properties
	public static final String PROP_PARAMETER_IN_FLOWCONTROL_UNIQUE_ID = "inUniqueKey";
	public static final String PROP_PARAMETER_IN_FLOWCONTROL_PROGRESS_START = "inStartingProgressPercent";
	public static final String PROP_PARAMETER_IN_FLOWCONTROL_PROGRESS_END = "inTargetEndingProgressPercent";
	public static final String PROP_PARAMETER_IN_FLOWCONTROL_PROGRESS_INCREMENT_THRESHOLD = "inUpdateProgressAfterPercentIncrease";
	
	public static final String PROP_LOCAL_FLOWCONTROL_ITEM_TOTAL = "localItemTotal130";
	public static final String PROP_LOCAL_FLOWCONTROL_ITEM_COUNTER = "localItemCounter130";
	public static final String PROP_LOCAL_FLOWCONTROL_UPDATE_COUNTER = "localUpdateCounter130";
	public static final String PROP_LOCAL_FLOWCONTROL_PERCENT_ACCUMULATOR = "localPercentAccumulator130";
	public static final String PROP_LOCAL_FLOWCONTROL_PERCENT_PER_ITEM = "localPercentPerItem130";
	public static final String PROP_LOCAL_FLOWCONTROL_NEXT_UPDATE_THRESHOLD = "localNextUpdateThreshold130";
	public static final String PROP_LOCAL_LOOPDETECT_WORKAROUND = "localProcessFlagLoopControl130";

	// SSK147 XSLT Function Libraries
	public static final String VALUE_XSLT_LIB_FLEXLOG_EXTENSIONS = "xslt/ssk147/SSK147_FunctionLib_Extensions.xsl";
	public static final String VALUE_XSLT_LIB_FLEXLOG_MESSAGES = "xslt/ssk147/SSK147_FunctionLib_Messages.xsl";
	
}

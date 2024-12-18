<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xsd="http://www.w3.org/2001/XMLSchema"
	xmlns:tube="java:com.capeclear.mediation.impl.cc.MediationTube"
	xmlns:ctx="java:com.capeclear.mediation.MediationContext"
	exclude-result-prefixes="xsd"
	version="3.0">
	
	<xsl:mode streamable="yes" use-accumulators="record-count" on-no-match="shallow-skip"/>
    <xsl:param name="inItemXPath" as="xsd:string" select="ctx:getProperty(tube:getCurrentMediationContext(),'inItemXPath')" static="yes"/>
	
	<xsl:output method="xml" indent="no" encoding="UTF-8"/>
	
	<xsl:accumulator name="record-count" as="xsd:integer" initial-value="0" streamable="yes">
		<xsl:accumulator-rule _match="{$inItemXPath}" select="$value+1"/>
	</xsl:accumulator>
	
	<xsl:template match="/">
		<xsl:apply-templates/>
		<totalRecords><xsl:value-of select="accumulator-after('record-count')"/></totalRecords>
	</xsl:template>
</xsl:stylesheet>

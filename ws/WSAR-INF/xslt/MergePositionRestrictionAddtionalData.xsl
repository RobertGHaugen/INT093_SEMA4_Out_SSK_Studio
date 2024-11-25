<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet xmlns:wd="urn:com.workday.report/bsvc"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:map="http://www.w3.org/2005/xpath-functions/map"
	exclude-result-prefixes="#all" version="2.0">

	<xsl:output method="xml" indent="no" />

	<!-- identity transform -->
	<xsl:template match="@*|node()">
		<xsl:copy>
			<xsl:apply-templates select="@*|node()" />
		</xsl:copy>
	</xsl:template>

   <!-- replace WORKER, POSITION_NBR and ACTION nodes if action is edit position restrictions additional data -->
   
	<xsl:template match="wd:POSITION_WORKER">
		<xsl:choose>
			<xsl:when
				test="../wd:ACTION[@wd:Descriptor='Edit Position Restrictions Additional Data']">
				<wd:WORKER>
					<xsl:apply-templates select="@*|node()" />
				</wd:WORKER>
			</xsl:when>
			<xsl:otherwise></xsl:otherwise>
		</xsl:choose>
	</xsl:template>


	<xsl:template match="wd:POSITION_POSITION_NBR">
		<xsl:choose>
			<xsl:when
				test="../wd:ACTION[@wd:Descriptor='Edit Position Restrictions Additional Data']">
				<wd:POSITION_NBR>
					<xsl:apply-templates select="@*|node()" />
				</wd:POSITION_NBR>
			</xsl:when>
			<xsl:otherwise></xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	
	<xsl:template match="wd:Worker_from_Position_group">
		<xsl:choose>
			<xsl:when
				test="../wd:ACTION[@wd:Descriptor='Edit Position Restrictions Additional Data']">
				<wd:Worker_group>
					<wd:SEMA4_ID>
						<xsl:attribute name="wd:Descriptor"><xsl:value-of
							select="wd:POSITION_SEMA4_ID/@wd:Descriptor" /></xsl:attribute>
						<wd:ID wd:type="WID"><xsl:value-of select="wd:POSITION_SEMA4_ID/wd:ID[@wd:type='WID']" /></wd:ID>
					</wd:SEMA4_ID>
        		</wd:Worker_group>
			</xsl:when>
			<xsl:otherwise></xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<xsl:template
		match="wd:Position_or_Hiring_Restrictions_group">
		<xsl:choose>
			<xsl:when
				test="../wd:ACTION[@wd:Descriptor='Edit Position Restrictions Additional Data'] and (wd:RETIREMENT_ACTION_REASON/@wd:Descriptor != 'No Action Reason')">
				<wd:ACTION_REASON>
					<xsl:attribute name="wd:Descriptor"><xsl:value-of
						select="wd:RETIREMENT_ACTION_REASON/@wd:Descriptor" /></xsl:attribute>
					<wd:ID wd:type="WID"><xsl:value-of select="wd:RETIREMENT_ACTION_REASON/wd:ID[@wd:type='WID']" /></wd:ID>
					<wd:ID wd:type="Event_Classification_Subcategory_ID">BLANK_<xsl:value-of select="substring-before(wd:RETIREMENT_ACTION_REASON/@wd:Descriptor, ' -')" />_<xsl:value-of select="wd:RETIREMENT_ACTION_REASON/wd:ID[@wd:parent_id='RETIREMENT_CODE_ACTION_REASON_LIST']" /></wd:ID>
					<wd:ID wd:type="General_Event_Subcategory_ID">BLANK_<xsl:value-of select="substring-before(wd:RETIREMENT_ACTION_REASON/@wd:Descriptor, ' -')" />_<xsl:value-of select="wd:RETIREMENT_ACTION_REASON/wd:ID[@wd:parent_id='RETIREMENT_CODE_ACTION_REASON_LIST']" /></wd:ID>
				</wd:ACTION_REASON>
			</xsl:when>
			<xsl:otherwise></xsl:otherwise>
		</xsl:choose>
		
		<xsl:choose>
			<xsl:when
				test="../wd:ACTION[@wd:Descriptor='Edit Position Restrictions Additional Data']">
				<wd:JRN><xsl:value-of select="wd:POSITION_JRN/wd:ID[@wd:type='Organization_Reference_ID']" /></wd:JRN>
				 <wd:All_Positions_group>
            		<wd:DEFAULT_JRN>
            			<xsl:attribute name="wd:Descriptor"><xsl:value-of
							select="wd:POSITION_JRN/@wd:Descriptor" /></xsl:attribute>
                		<wd:ID wd:type="WID"><xsl:value-of select="wd:POSITION_JRN/wd:ID[@wd:type='WID']" /></wd:ID>
                		<wd:ID wd:type="Organization_Reference_ID"><xsl:value-of select="wd:POSITION_JRN/wd:ID[@wd:type='Organization_Reference_ID']" /></wd:ID>
                		<wd:ID wd:type="Custom_Organization_Reference_ID"><xsl:value-of select="wd:POSITION_JRN/wd:ID[@wd:type='Custom_Organization_Reference_ID']" /></wd:ID>
            		</wd:DEFAULT_JRN>
        		</wd:All_Positions_group>
			</xsl:when>
			<xsl:otherwise></xsl:otherwise>
		</xsl:choose>
		
		
	</xsl:template>

</xsl:stylesheet>

<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:wd="urn:com.workday.report/bsvc"
    exclude-result-prefixes="xs" version="2.0">
    
    <xsl:output method="text" indent="yes"/>
    
    <xsl:variable name="vNewLine" select="'&#xD;&#xA;'"/>
    <xsl:variable name="vDelimiter" select="'&#34;,&#34;'"/>
    
    <xsl:template match="/">
        <xsl:apply-templates select="Results"/>
        <NewLine>
            <xsl:value-of select="$vNewLine"/>
        </NewLine>
        <xsl:apply-templates select="Results/wd:Report_Data/wd:Report_Entry[exists(wd:POSITION_NBR)]" />
        <xsl:apply-templates select="Results/wd:Report_Data/wd:Report_Entry[exists(wd:Position_group)]" />
        <xsl:apply-templates select="Results/wd:Report_Data/wd:Report_Entry[exists(wd:Questionnaire_Response_group)]" />
    </xsl:template>
    
    <xsl:template match="Results">
        <HEADER>&#34;POSITION_NBR&#34;,&#34;WORKER&#34;,&#34;EFFDT&#34;,&#34;ACTION&#34;,&#34;ACTION_COMPLETED&#34;,&#34;ACTION_DT&#34;,&#34;ACTION_REASON&#34;</HEADER>
    </xsl:template>
    
    <!-- The match of wd:Report_Entry[exists(wd:POSITION_NBR)] clearly points to the output of the Events report -->
    <xsl:template match="wd:Report_Entry[exists(wd:POSITION_NBR)]">
        
        <!--  <xsl:for-each select="wd:Report_Entry">-->
        <xsl:value-of select="'&#34;'"/>
        <POSITION_NBR>
            <xsl:value-of select="wd:POSITION_NBR/text()"/>
        </POSITION_NBR>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <WORKER>
            <xsl:value-of select="wd:WORKER/wd:ID[@wd:type = 'WID']"/>
        </WORKER>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <EFFDT>
            <xsl:value-of select="wd:EFFDT"/>
        </EFFDT>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <ACTION>
            <xsl:value-of select="substring-before(substring-after(wd:ACTION_REASON/wd:ID[@wd:type='General_Event_Subcategory_ID'],'_'),'_')"/>
            <!--  <xsl:value-of select="wd:ACTION/wd:ID[@wd:type = 'Business_Process_Type']"/>  -->
        </ACTION>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <ACTION_COMPLETED>
            <xsl:value-of select="wd:ACTION_COMPLETED"/>
        </ACTION_COMPLETED>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <ACTION_DT>
            <xsl:value-of select="wd:ACTION_DT"/>
        </ACTION_DT>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <ACTION_REASON>
            <xsl:value-of select="substring-after(substring-after(wd:ACTION_REASON/wd:ID[@wd:type='General_Event_Subcategory_ID'],'_'),'_')"/>
            <!--  <xsl:value-of select="wd:ACTION_REASON/wd:ID[@wd:type = 'Event_Classification_Subcategory_ID']"/>  -->
        </ACTION_REASON>
        <NewLine>
            <xsl:value-of select="'&#34;'"/>
            <xsl:value-of select="$vNewLine"/>
        </NewLine>
        <!--</xsl:for-each>-->
        
    </xsl:template>
    
    <!-- The match of wd:Report_Entry[exists(wd:Position_group)] clearly points to the output of the disbursement report -->
    <xsl:template match="wd:Report_Entry[exists(wd:Position_group)]">
        <xsl:value-of select="'&#34;'"/>
        <POSITION_NBR>
            <xsl:value-of select="wd:Position_group/wd:POSITION_NBR/text()"/>
        </POSITION_NBR>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <WORKER>
            <xsl:value-of select="wd:WORKER/wd:ID[@wd:type = 'WID']"/>
        </WORKER>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <EFFDT>
            <xsl:value-of select="wd:Position_group/wd:EFFDT"/>
        </EFFDT>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <ACTION>
            <xsl:value-of select="substring-before(substring-after(wd:Position_group/wd:ACTION_REASON/wd:ID[@wd:type='General_Event_Subcategory_ID'],'_'),'_')"/>
            <!-- <xsl:value-of select="wd:Position_group/wd:ACTION/text()"/> -->
        </ACTION>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <ACTION_COMPLETED>
            <xsl:value-of select="wd:Position_group/wd:ACTION_COMPLETED"/>
        </ACTION_COMPLETED>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <ACTION_DT>
            <xsl:value-of select="wd:Position_group/wd:ACTION_DT"/>
        </ACTION_DT>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <ACTION_REASON>
            <xsl:value-of select="substring-after(substring-after(wd:Position_group/wd:ACTION_REASON/wd:ID[@wd:type='General_Event_Subcategory_ID'],'_'),'_')"/>
            <!--  <xsl:value-of select="wd:Position_group/wd:ACTION_REASON/text()"/>  -->
        </ACTION_REASON>
        <NewLine>
            <xsl:value-of select="'&#34;'"/>
            <xsl:value-of select="$vNewLine"/>
        </NewLine>
    </xsl:template>
    
    <!-- The match of wd:Report_Entry[exists(wd:Questionnaire_Response_group)] clearly points to the output of the Return From LOA report -->
    <xsl:template match="wd:Report_Entry[exists(wd:Questionnaire_Response_group)]">
        <xsl:value-of select="'&#34;'"/>
        <POSITION_NBR>
            <xsl:value-of select="wd:Questionnaire_Response_group/wd:POSITION_NBR/text()"/>
        </POSITION_NBR>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <WORKER>
            <xsl:value-of select="wd:Questionnaire_Response_group/wd:WORKER/wd:ID[@wd:type = 'WID']"/>
        </WORKER>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <EFFDT>
            <xsl:value-of select="wd:Questionnaire_Response_group/wd:EFFDT"/>
        </EFFDT>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <ACTION>
            <xsl:value-of select="substring-before(substring-after(wd:ACTION/@wd:Descriptor,'('),'-')"/>
        </ACTION>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <ACTION_COMPLETED>
            <xsl:value-of select="wd:Questionnaire_Response_group/wd:ACTION_COMPLETED"/>
        </ACTION_COMPLETED>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <ACTION_DT>
            <xsl:value-of select="wd:Questionnaire_Response_group/wd:ACTION_DT"/>
        </ACTION_DT>
        <Delimiter>
            <xsl:value-of select="$vDelimiter"/>
        </Delimiter>
        <ACTION_REASON>
            <xsl:value-of select="substring-before(substring-after(wd:ACTION/@wd:Descriptor,'-'),')')"/>
        </ACTION_REASON>
        <NewLine>
            <xsl:value-of select="'&#34;'"/>
            <xsl:value-of select="$vNewLine"/>
        </NewLine>
    </xsl:template>
    
</xsl:stylesheet>

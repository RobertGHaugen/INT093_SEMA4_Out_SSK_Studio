<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:wd="urn:com.workday.report/bsvc"
    exclude-result-prefixes="xs" version="2.0">
    
    <xsl:output method="text"/>
    
    <xsl:variable name="vNewLine" select="'&#xD;&#xA;'"/>
    <xsl:variable name="vDelimiter" select="'&#34;,&#34;'"/>
    
    <xsl:template match="wd:Report_Data">
        <HEADER>&#34;POSITION_NBR&#34;,&#34;WORKER&#34;,&#34;EFFDT&#34;,&#34;ACTION&#34;,&#34;ACTION_COMPLETED&#34;,&#34;ACTION_DT&#34;,&#34;ACTION_REASON&#34;</HEADER>
        <NewLine>
            <xsl:value-of select="$vNewLine"/>
        </NewLine>
        <xsl:for-each select="wd:Report_Entry">
            <xsl:value-of select="'&#34;'"/>
            <POSITION_NBR>
                <xsl:value-of select="wd:POSITION_NBR/wd:ID[@wd:type = 'Position_ID']/text()"/>
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
                <xsl:value-of select="wd:ACTION/wd:ID[@wd:type = 'Business_Process_Type']"/>
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
                <xsl:value-of select="wd:ACTION_REASON/wd:ID[@wd:type = 'Event_Classification_Subcategory_ID']"/>
            </ACTION_REASON>
            <NewLine>
                <xsl:value-of select="'&#34;'"/>
                <xsl:value-of select="$vNewLine"/>
            </NewLine>
        </xsl:for-each>
        
    </xsl:template>
</xsl:stylesheet>

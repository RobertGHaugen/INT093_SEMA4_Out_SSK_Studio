<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:wd="urn:com.workday.report/bsvc"
    exclude-result-prefixes="xs" version="2.0">
    
    <xsl:output method="text"/>
    
    <xsl:variable name="vNewLine" select="'&#xD;&#xA;'"/>
    <xsl:variable name="vDelimiter" select="'&#34;,&#34;'"/>
    
    <xsl:template match="wd:Report_Data">
        <HEADER>&#34;WORKER&#34;,&#34;EMPLID&#34;,&#34;EMPL_RCD_NUMBER&#34;,&#34;M_WOC_JOBCODE&#34;,&#34;M_WOC_SAL_ADMIN_PL&#34;,&#34;STD_HOURS&#34;,&#34;M_WOC_GRADE&#34;,&#34;M_WOC_STEP_NAME&#34;,&#34;M_WOC_STEP_AMT&#34;,&#34;M_WOC_APPT_END_DT&#34;,&#34;COMP_RATECD2&#34;,&#34;POSITION_NBR&#34;</HEADER>
        <NewLine>
            <xsl:value-of select="$vNewLine"/>
        </NewLine>
        <xsl:for-each select="wd:Report_Entry">
            <WORKER>
                <xsl:value-of select="'&#34;'"/>
                <xsl:value-of select="wd:WORKER/wd:ID[@wd:type = 'WID']"/>
            </WORKER>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <EMPLID>
                <xsl:value-of select="wd:EMPLID"/>
            </EMPLID>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <EMPL_RCD_NUMBER>
                <xsl:value-of select="wd:Positions_group/wd:EMPL_RCD_NUMBER/wd:ID[@wd:type='Organization_Reference_ID']"/>
            </EMPL_RCD_NUMBER>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <M_WOC_JOBCODE>
                <xsl:value-of select="substring-before(wd:Positions_group/wd:M_WOC_JOBCODE/wd:ID[@wd:type='Job_Profile_ID'],'_')"/>
            </M_WOC_JOBCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <M_WOC_SAL_ADMIN_PL>
                <xsl:value-of select="wd:Positions_group/wd:M_WOC_SAL_ADMIN_PL/@wd:Descriptor"/>
            </M_WOC_SAL_ADMIN_PL>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <STD_HOURS>
                <xsl:value-of select="wd:Positions_group/wd:STD_HOURS"/>
            </STD_HOURS>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <M_WOC_GRADE>
                <xsl:value-of select="substring-after(wd:Positions_group/wd:CF_EE_Compensation_Grade_Profile/wd:ID[@wd:type='Compensation_Grade_Profile_ID'],'_')"/>
            </M_WOC_GRADE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <M_WOC_STEP_NAME>
                <xsl:value-of select="wd:Positions_group/wd:M_WOC_STEP_NAME"/>
            </M_WOC_STEP_NAME>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <M_WOC_STEP_AMT>
                <xsl:value-of select="wd:Positions_group/wd:M_WOC_STEP_AMT"/>
            </M_WOC_STEP_AMT>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <M_WOC_APPT_END_DT>
                <xsl:value-of select="wd:Positions_group/wd:M_WOC_APPT_END_DT"/>
            </M_WOC_APPT_END_DT>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <COMP_RATECD2>
                <xsl:value-of select="wd:COMP_RATECD2"/>				
            </COMP_RATECD2>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <POSITION_NBR>
                <xsl:value-of select="wd:Positions_group/wd:POSITION_NBR"/>
            </POSITION_NBR>
            
            <NewLine>
                <xsl:value-of select="'&#34;'"/>
                <xsl:value-of select="$vNewLine"/>
            </NewLine>
        </xsl:for-each>
        
    </xsl:template>
</xsl:stylesheet>

<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:wd="urn:com.workday.report/bsvc"
    exclude-result-prefixes="xs" version="2.0">

    <xsl:output method="text"/>

    <xsl:variable name="vNewLine" select="'&#xD;&#xA;'"/>
    <xsl:variable name="vDelimiter" select="'&#34;,&#34;'"/>

    <xsl:template match="wd:Report_Data">
        <HEADER>&#34;WORKER&#34;,&#34;EMPLID&#34;,&#34;EMPL_RCD_NUMBER&#34;,&#34;EFFDT&#34;,&#34;ACTION&#34;,&#34;ACTION_REASON&#34;,&#34;M_WOC_JOBCODE&#34;,&#34;M_WOC_SAL_ADMIN_PL&#34;,&#34;M_WOC_GRADE&#34;,&#34;M_WOC_STEP&#34;,&#34;M_WOC_APPT_END_DT&#34;,&#34;COMP_RATECD2&#34;,&#34;COMPRATE2&#34;</HEADER>
        <NewLine>
            <xsl:value-of select="$vNewLine"/>
        </NewLine>
        <xsl:for-each select="wd:Report_Entry/wd:Positions_group">
            <WORKER>
                <xsl:value-of select="'&#34;'"/>
                <xsl:value-of select="../wd:WORKER/wd:ID[@wd:type='WID']"/>
            </WORKER>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <EMPLID>
                <xsl:value-of select="../wd:EMPLID"/>
            </EMPLID>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <EMPL_RCD_NUMBER>
                <xsl:value-of select="wd:EMPL_RCD_NUMBER/@wd:Descriptor"/>
            </EMPL_RCD_NUMBER>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <EFFDT>
                <xsl:value-of select="../wd:Worker_Event_group/wd:EFFDT"/>
            </EFFDT>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <ACTION>
                <xsl:value-of select="../wd:Worker_Event_group/wd:ACTION/@wd:Descriptor"/>
            </ACTION>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <ACTION_REASON>
                <xsl:value-of select="../wd:Worker_Event_group/wd:ACTION_REASON/wd:ID[@wd:type='Event_Classification_Subcategory_ID']"/>
            </ACTION_REASON>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <M_WOC_JOBCODE>
                <xsl:value-of select="wd:M_WOC_JOBCODE/wd:ID[@wd:type='Job_Profile_ID']"/>
            </M_WOC_JOBCODE>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <M_WOC_SAL_ADMIN_PL>
                <xsl:value-of select="wd:M_WOC_SAL_ADMIN_PL/wd:ID[@wd:type='Compensation_Grade_Profile_ID']"/>
            </M_WOC_SAL_ADMIN_PL>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <M_WOC_GRADE>
                <xsl:value-of select="wd:M_WOC_GRADE/wd:ID[@wd:type='Compensation_Grade_ID']"/>
            </M_WOC_GRADE>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <M_WOC_STEP>
                <xsl:value-of select="wd:M_WOC_STEP/wd:ID[@wd:type='Compensation_Step_ID']"/>
            </M_WOC_STEP>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <M_WOC_APPT_END_DT>
                <xsl:value-of select="wd:M_WOC_APPT_END_DT"/>
            </M_WOC_APPT_END_DT>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <COMP_RATECD2>
                <xsl:value-of select="wd:COMP_RATECD2/wd:ID[@wd:type='Job_Classification_Reference_ID']"/>
            </COMP_RATECD2>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <COMPRATE2>
                <xsl:value-of select="wd:COMPRATE2/wd:ID[@wd:type='Pay_Rate_Type_ID']"/>
            </COMPRATE2> 
            <NewLine>
                <xsl:value-of select="'&#34;'"/>
                <xsl:value-of select="$vNewLine"/>
            </NewLine>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>

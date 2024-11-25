<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:wd="urn:com.workday.report/bsvc"
    exclude-result-prefixes="xs" version="2.0">
    
    <xsl:output method="text" indent="yes"/>
    
    <!-- ABOUT THIS FILE -->
    <!-- 
    
    This XSLT expects stream merged report outputs from multiple Custom Reports.
    The expected file structure is:
    <Results>
        <wd:Report_Data> [0-7]
            <wd:Report_Entry> [0-*]
        </wd:Report_Data>
        (...)
        <wd:Report_Data>
            <wd:Report_Entry> [0-*]
        </wd:Report_Data>
     </Results>
        
    Input reports list with their relevant Report ID (that matches the variable name of the report data in studio).
    CR INT093 SEMA4 Out Events                              Report ID: var.events.report
    CR INT093 SEMA4 Out Worker Disbursement Plan Period     Report ID: var.disbursement.report
    CR INT093 Return From Leave of Absence Events           Report ID: var.rloa.report
    CR_INT093 Supplemental Retirement  Events               Report ID: var.supretevents.report
    CR INT093 Termination Events                            Report ID: var.term.report
    CR_INT093 SEMA4 Out Leave Events                        Report ID: var.requestloa.report
    CR_INT093 SEMA4 Out Special Eligibility Events          Report ID: var.SpecialEligibilityEvents.report
    CR_INT093 Review Probation Events                       Report ID: var.ProbationReviewEvents.report
    
    OUTPUT:
    A CSV file with data ready to be loaded to Prism Table

    -->
    
    <xsl:variable name="vNewLine" select="'&#xD;&#xA;'"/>
    <xsl:variable name="vDelimiter" select="'&#34;,&#34;'"/>
    
    <xsl:variable name="vCountAll" select="count(Results/wd:Report_Data/wd:Report_Entry)"/>
    
    <xsl:template match="Results">
        <HEADER>&#34;POSITION_NBR&#34;,&#34;WORKER&#34;,&#34;EFFDT&#34;,&#34;ACTION&#34;,&#34;ACTION_COMPLETED&#34;,&#34;ACTION_DT&#34;,&#34;ACTION_REASON&#34;,&#34;JOB_RECORD_NUMBER&#34;</HEADER>
        <NewLine><xsl:value-of select="$vNewLine"/></NewLine>
        <xsl:apply-templates select="wd:Report_Data/wd:Report_Entry" />
    </xsl:template>
    
    <!-- Suppress any Reports that do not have a template combined with REPORT_ID -->
    <xsl:template match="wd:Report_Data/wd:Report_Entry"/>
    
    <xsl:template match="wd:Report_Data/wd:Report_Entry[
        (wd:REPORT_ID = 'var.events.report')
        or (wd:REPORT_ID = 'var.term.report')
        or (wd:REPORT_ID = 'var.SpecialEligibilityEvents.report')
        or (wd:REPORT_ID = 'var.requestloa.report')
        or (wd:REPORT_ID = 'var.supretevents.report')
        or (wd:REPORT_ID = 'var.ProbationReviewEvents.report')
        ]">
        
        <xsl:value-of select="'&#34;'"/>
        <POSITION_NBR>
            <xsl:value-of select="wd:POSITION_NBR"/>
        </POSITION_NBR>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <WORKER>
            <xsl:value-of select="wd:WORKER"/>
        </WORKER>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <EFFDT>
            <xsl:value-of select="wd:EFFDT"/>
        </EFFDT>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <ACTION>
            <xsl:value-of select="wd:ACTION"/>
        </ACTION>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <ACTION_COMPLETED>
            <xsl:value-of select="wd:ACTION_COMPLETED"/>
        </ACTION_COMPLETED>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <ACTION_DT>
            <xsl:value-of select="wd:ACTION_DT"/>
        </ACTION_DT>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <ACTION_REASON>
            <xsl:value-of select="wd:ACTION_REASON"/>
        </ACTION_REASON>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <JRN>
            <xsl:value-of select="wd:JRN"/>
        </JRN>
        <NewLine>
            <xsl:value-of select="'&#34;'"/>
            <xsl:value-of select="$vNewLine"/>
        </NewLine>
    </xsl:template>
    
    <!-- The match for the disbursement report -->
    <xsl:template match="wd:Report_Entry[
        (wd:REPORT_ID = 'var.disbursement.report')
        ]">
        <xsl:value-of select="'&#34;'"/>
        <POSITION_NBR>
            <xsl:value-of select="wd:Position_group/wd:POSITION_NBR/text()"/>
        </POSITION_NBR>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <WORKER>
            <xsl:value-of select="wd:WORKER/wd:ID[@wd:type = 'WID']"/>
        </WORKER>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <EFFDT>
            <xsl:value-of select="wd:Position_group/wd:EFFDT"/>
        </EFFDT>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <ACTION>
            <xsl:value-of select="wd:Position_group/wd:ACTION"/>
        </ACTION>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <ACTION_COMPLETED>
            <xsl:value-of select="wd:Position_group/wd:ACTION_COMPLETED"/>
        </ACTION_COMPLETED>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <ACTION_DT>
            <xsl:value-of select="wd:Position_group/wd:ACTION_DT"/>
        </ACTION_DT>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <ACTION_REASON>
            <xsl:value-of select="wd:Position_group/wd:ACTION_REASON"/>
        </ACTION_REASON>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <JRN>
            <xsl:value-of select="wd:JRN"/>
        </JRN>
        <NewLine>
            <xsl:value-of select="'&#34;'"/>
            <xsl:value-of select="$vNewLine"/>
        </NewLine>
    </xsl:template> 
    
    <!-- The match for the Return From LOA report -->
    <xsl:template match="wd:Report_Entry[
        (wd:REPORT_ID = 'var.rloa.report')
        ]">
        <xsl:value-of select="'&#34;'"/>
        <POSITION_NBR>
            <xsl:value-of select="wd:Questionnaire_Response_group/wd:POSITION_NBR/text()"/>
        </POSITION_NBR>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <WORKER>
            <xsl:value-of select="wd:Questionnaire_Response_group/wd:WORKER/wd:ID[@wd:type = 'WID']"/>
        </WORKER>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <EFFDT>
            <xsl:value-of select="wd:Questionnaire_Response_group/wd:EFFDT"/>
        </EFFDT>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <ACTION>
            <xsl:value-of select="substring-before(substring-after(wd:ACTION/@wd:Descriptor,'('),'-')"/>
        </ACTION>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <ACTION_COMPLETED>
            <xsl:value-of select="wd:Questionnaire_Response_group/wd:ACTION_COMPLETED"/>
        </ACTION_COMPLETED>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <ACTION_DT>
            <xsl:value-of select="wd:Questionnaire_Response_group/wd:ACTION_DT"/>
        </ACTION_DT>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <ACTION_REASON>
            <xsl:value-of select="substring-before(substring-after(wd:ACTION/@wd:Descriptor,'-'),')')"/>
        </ACTION_REASON>
        <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
        <JRN>
            <xsl:value-of select="wd:Questionnaire_Response_group/wd:JRN"/>
        </JRN>
        <NewLine>
            <xsl:value-of select="'&#34;'"/>
            <xsl:value-of select="$vNewLine"/>
        </NewLine>
    </xsl:template>
    
</xsl:stylesheet>

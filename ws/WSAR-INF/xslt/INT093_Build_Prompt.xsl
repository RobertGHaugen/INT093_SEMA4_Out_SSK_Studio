<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:wd="urn:com.workday.report/bsvc"
    exclude-result-prefixes="xs" version="2.0">

    <xsl:output method="xml" indent="no"/>
    
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
    CR INT093 Return From Leave of Absemce Events           Report ID: var.rloa.report
    CR_INT093 Supplemental Retirement  Events               Report ID: var.supretevents.report
    CR INT093 Termination Events                            Report ID: var.term.report
    CR_INT093 SEMA4 Out Leave Events                        Report ID: var.requestloa.report
    CR_INT093 SEMA4 Out Special Eligibility Events          Report ID: var.SpecialEligibilityEvents.report
    CR_INT093 SEMA4 Refresh Events							Report ID: var.refresh.report
    
    OUTPUT:
    At first a variable is created $allworkers that retrieves all Worker WIDs and puts them in the following structure:
    <AllWorkers>
        <WorkerIn><wid>xyz</wid></WorkerIn> [0-*]
    </AllWorkers>
    
    Next this variable is grouped by wid and unique list of WIDs from the input data is outputted in the following structure:
    <Prompts>
        <Worker>xyz[/Worker>
    </Prompts>
    
    This list of unique WIDs of Workers from the input reports will be used as a prompt for another report in Studio

    -->

    <xsl:variable name="allworkers">
        <AllWorkers>
            <xsl:apply-templates select="Results/wd:Report_Data/wd:Report_Entry"/>
        </AllWorkers>
    </xsl:variable>

    <xsl:template match="/">
        <Prompts>
            <xsl:for-each-group select="$allworkers/AllWorkers/WorkerIn" group-by="wid">
                 <xsl:for-each select="current-group()">
                    <xsl:if test="position() = 1">
                        <Worker>
                        <xsl:value-of select="wid" />
                        </Worker>
                    </xsl:if>
            </xsl:for-each>
            </xsl:for-each-group>
        </Prompts>
    </xsl:template>

    <xsl:template match="Results"/>

    <xsl:template match="wd:Report_Entry[
        (wd:REPORT_ID = 'var.events.report')
        or (wd:REPORT_ID = 'var.term.report')
        or (wd:REPORT_ID = 'var.SpecialEligibilityEvents.report')
        or (wd:REPORT_ID = 'var.requestloa.report')
        or (wd:REPORT_ID = 'var.supretevents.report')
        or (wd:REPORT_ID = 'var.refresh.report')
        ]">
        
        <xsl:if test="exists(wd:WORKER)">
            <WorkerIn>
                <wid><xsl:value-of select="wd:WORKER"/></wid>
            </WorkerIn>
        </xsl:if>
    </xsl:template>
    
    <xsl:template match="wd:Report_Entry[
        (wd:REPORT_ID = 'var.disbursement.report')
        ]">
        
        <xsl:if test="exists(wd:WORKER)">
            <WorkerIn>
                <wid><xsl:value-of select="wd:WORKER/wd:ID[@wd:type='WID']"/></wid>
            </WorkerIn>
        </xsl:if>
    </xsl:template>
    
    <xsl:template match="wd:Report_Entry[
        (wd:REPORT_ID = 'var.rloa.report')
        ]">
        
        <xsl:if test="exists(wd:Questionnaire_Response_group/wd:WORKER)">
            <WorkerIn>
                <wid><xsl:value-of select="wd:Questionnaire_Response_group/wd:WORKER/wd:ID[@wd:type='WID']"/></wid>
            </WorkerIn>
        </xsl:if>
    </xsl:template>
    
</xsl:stylesheet>
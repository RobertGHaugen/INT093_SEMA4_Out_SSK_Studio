<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:wd="urn:com.workday/bsvc" 
    exclude-result-prefixes="wd">
    <xsl:output method="xml" indent="yes"/>
    
    <xsl:param name="pPStartDate"/>
    <xsl:param name="pPEndDate"/>
    
    <!-- template to copy elements -->
    <xsl:template match="*">
        <!-- <xsl:element name="{local-name()}">-->
        <xsl:apply-templates select="@* | node()"/>
        <!--</xsl:element>-->
    </xsl:template>
    
    <xsl:template match="wd:Report_Data">
        <xsl:element name="{local-name()}">
            <xsl:attribute name="Report">
                <xsl:text>Compensation_Rate</xsl:text>
            </xsl:attribute>
            <xsl:apply-templates select="node() | @*"/>
        </xsl:element>
    </xsl:template>
    
    <xsl:template match="wd:Report_Entry/wd:Worker"/>
    
    
    <xsl:template match="wd:Report_Entry/wd:All_Positions___Jobs_group">
        <Report_Entry>
            <xsl:attribute name="Employee"><xsl:value-of select="wd:Worker/@wd:Descriptor"/></xsl:attribute>
            <EMPLID><xsl:value-of select="wd:Worker/wd:ID[@wd:type = 'Employee_ID']"/></EMPLID>
            <!-- <EMPLID><xsl:value-of select="wd:SEMA4_ID"/></EMPLID> -->
            <POSITID><xsl:value-of select="wd:Position_ID"/></POSITID>
            <EFFECTIVEDATE><xsl:value-of select="wd:Effective_Date"/></EFFECTIVEDATE>
            <BIWEEKLYAMOUNT><xsl:value-of select="format-number(wd:BW-Hourly_Rate,'#.00')"/></BIWEEKLYAMOUNT>
            <Job_Record_Number><xsl:value-of select="wd:Job_Record_Number/wd:ID[@wd:type='Custom_Organization_Reference_ID']"/></Job_Record_Number>
            <ChargeInsuranceRetirement><xsl:value-of select="wd:Position_Charge_Insurance"/></ChargeInsuranceRetirement>
            <WorkerWID><xsl:value-of select="wd:Worker/wd:ID[@wd:type='WID']"/></WorkerWID>
            <PAY_START_DATE>
                <xsl:value-of select="format-dateTime($pPStartDate, '[Y]-[M01]-[D01]-[H01]:[m01]')"/>
            </PAY_START_DATE>
            <PAY_END_DATE>
                <xsl:value-of select="format-dateTime($pPEndDate, '[Y]-[M01]-[D01]-[H01]:[m01]')"/>
            </PAY_END_DATE>
        </Report_Entry>
    </xsl:template>
    
    <!-- template to copy attributes -->
    <!--    <xsl:template match="@*">
        <xsl:attribute name="{local-name()}">
            <xsl:value-of select="."/>
        </xsl:attribute>
    </xsl:template>-->
    
    <!-- template to copy the rest of the nodes -->
    <!--    <xsl:template match="comment() | text() | processing-instruction()">
        <xsl:copy/>
    </xsl:template>-->
    
    
    
</xsl:stylesheet>

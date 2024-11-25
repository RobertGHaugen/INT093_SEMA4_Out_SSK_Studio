<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:wd="urn:com.workday/bsvc"
    exclude-result-prefixes="wd">
    <xsl:output method="xml" indent="yes"/>
    
    <xsl:param name="pPStartDate"/>
    <xsl:param name="pPEndDate"/>
    
    <!-- template to copy elements -->
    <xsl:template match="*">
        <xsl:apply-templates select="@* | node()"/>
    </xsl:template>
    
    <xsl:template match="wd:Report_Data">
        <xsl:element name="{local-name()}">
            <xsl:attribute name="Report">
                <xsl:text>Activity_Assignments</xsl:text>
            </xsl:attribute>
            <xsl:apply-templates select="node() | @*"/>
        </xsl:element>
    </xsl:template>
    
    <!-- <xsl:template match="wd:Report_Entry/wd:Worker"/>-->
    
    
    <xsl:template match="wd:Report_Entry">
        <Report_Entry>
            <xsl:attribute name="Employee"><xsl:value-of select="wd:Employee/@wd:Descriptor"/></xsl:attribute>
            <EMPLID><xsl:value-of select="wd:Employee/wd:ID[@wd:type = 'Employee_ID']"/></EMPLID>
            <!-- <EMPLID><xsl:value-of select="wd:SEMA4_ID"/></EMPLID> -->
            <POSITID><xsl:value-of select="wd:Position_group/wd:Position_ID"/></POSITID>
            <EFFECTIVEDATE><xsl:value-of select="wd:Payment_Schedule_group[last()]/wd:Effective_Date"/></EFFECTIVEDATE>
            <BIWEEKLYAMOUNT>
                <xsl:choose>
                    <xsl:when test="wd:Comp_Element/wd:ID[@wd:type='Period_Activity_Category_ID'] = 'Biweekly'">
                        <xsl:value-of select="format-number(wd:PAP_BW_Estimated,'#.00')"/>
                    </xsl:when>
                    <xsl:when test="wd:Do_Not_Pay = '1'">
                        <xsl:text>0</xsl:text>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:text>0</xsl:text>
                    </xsl:otherwise>
                </xsl:choose>
            </BIWEEKLYAMOUNT>
            <Job_Record_Number>
                <xsl:choose>
                    <xsl:when test="exists(wd:Allocation_Details_group/wd:Job_Record_Number)">
                        <xsl:value-of select="distinct-values(wd:Allocation_Details_group/wd:Job_Record_Number/wd:ID[@wd:type='Custom_Organization_Reference_ID'])"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="wd:Position_group/wd:Job_Record_Number_for_Position/wd:ID[@wd:type='Custom_Organization_Reference_ID']"/>
                    </xsl:otherwise>
                </xsl:choose>
            </Job_Record_Number>
            <ChargeInsuranceRetirement>
                <xsl:choose>
                    <xsl:when test="wd:Allocation_Details_group[1]/wd:Default_Charge_Insurance='CF12' and wd:Allocation_Details_group[1]/wd:Assigned_Charge_Insurance ='NA'">
                        <xsl:value-of select="wd:ELIG_CONFIG4[1]"/>
                    </xsl:when>
                    <xsl:when test="wd:Allocation_Details_group[1]/wd:Default_Charge_Insurance='CX' and wd:Allocation_Details_group[1]/wd:Assigned_Charge_Insurance ='NA'">
                        <xsl:value-of select="wd:Allocation_Details_group[1]/wd:Default_Charge_Insurance"/>
                    </xsl:when>
                    <xsl:when test="wd:Allocation_Details_group[1]/wd:Default_Charge_Insurance='NA' and wd:Allocation_Details_group[1]/wd:Assigned_Charge_Insurance='CF12'">
                        <xsl:value-of select="wd:ELIG_CONFIG4[1]"/>
                    </xsl:when>
                    <xsl:when test="wd:Allocation_Details_group[1]/wd:Default_Charge_Insurance='NA' and wd:Allocation_Details_group[1]/wd:Assigned_Charge_Insurance ='CX'">
                        <xsl:value-of select="wd:Allocation_Details_group[1]/wd:Assigned_Charge_Insurance"/>
                    </xsl:when>
                    <xsl:when test="not(wd:Allocation_Details_group)">
                        <xsl:value-of select="wd:ELIG_CONFIG4[1]"/>
                    </xsl:when>
                    <!--                    <xsl:otherwise>
                        <xsl:value-of select="wd:Allocation_Details_group/wd:Default_Charge_Insurance"/>
                    </xsl:otherwise>-->
                </xsl:choose>
            </ChargeInsuranceRetirement>
            <WorkerWID><xsl:value-of select="wd:Employee/wd:ID[@wd:type='WID']"/></WorkerWID>
            <Period_Activity_Start_Date><xsl:value-of select="wd:Period_Activity_Start_Date"/></Period_Activity_Start_Date>
            <Period_Activity_End_Date><xsl:value-of select="wd:Period_Activity_End_Date"/></Period_Activity_End_Date>
            <Activity_Type><xsl:value-of select="wd:Activity_Type/wd:ID[@wd:type='Period_Activity_ID']"/></Activity_Type>
            <PAY_START_DATE>
                <xsl:value-of select="format-dateTime($pPStartDate, '[Y]-[M01]-[D01]-[H01]:[m01]')"/>
            </PAY_START_DATE>
            <PAY_END_DATE>
                <xsl:value-of select="format-dateTime($pPEndDate, '[Y]-[M01]-[D01]-[H01]:[m01]')"/>
            </PAY_END_DATE>
            <EMPL_TYPE><xsl:value-of select="wd:EMPL_TYPE/wd:ID[@wd:type='Employee_Type_ID']"/></EMPL_TYPE> 
            <SEMA4_ID><xsl:value-of select="wd:SEMA4_ID/@wd:Descriptor"/></SEMA4_ID>             
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

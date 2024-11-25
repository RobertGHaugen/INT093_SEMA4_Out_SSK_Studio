<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:wd="urn:com.workday/bsvc"
    exclude-result-prefixes="xs" version="2.0">
    
    <xsl:output method="text"/>
    
    <xsl:variable name="vNewLine" select="'&#xD;&#xA;'"/>
    <xsl:variable name="vDelimiter" select="'&#34;,&#34;'"/>
    
    <xsl:template match="Results">
        <HEADER>&#34;EMPLID&#34;,&#34;POSITID&#34;,&#34;STARTDATE&#34;,&#34;ENDDATE&#34;,&#34;STARTFISCALYEAR&#34;,&#34;ENDFISCALYEAR&#34;,&#34;DISBURSEMENTPLANPERIOD&#34;,&#34;JOBPROFILE&#34;,&#34;EFFECTIVEDATE&#34;,&#34;COMPENSATIONPLAN&#34;,&#34;COMPELEMENT&#34;,&#34;BIWEEKLYAMOUNT&#34;,&#34;Job_Record_Number&#34;,&#34;ELIG_CONFIG4&#34;,&#34;WorkerWID&#34;,&#34;Period_Activity_Start_Date&#34;,&#34;Period_Activity_End_Date&#34;,&#34;Activity_Type&#34;,&#34;PAY_START_DATE&#34;,&#34;PAY_END_DATE&#34;,&#34;EMPL_TYPE&#34;,&#34;SEMA4_ID&#34;</HEADER>
        
        <NewLine>
            <xsl:value-of select="$vNewLine"/>
        </NewLine>
        <xsl:for-each select="Report_Data/Report_Entry">
            <EMPLID>
                <xsl:value-of select="'&#34;'"/>
                <xsl:value-of select="EMPLID"/>
            </EMPLID>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <POSITID>
                <xsl:value-of select="POSITID"/>
            </POSITID>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <STARTDATE><xsl:value-of select="''"/></STARTDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <ENDDATE><xsl:value-of select="''"/></ENDDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <STARTFISCALYEAR><xsl:value-of select="''"/></STARTFISCALYEAR><Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <ENDFISCALYEAR><xsl:value-of select="''"/></ENDFISCALYEAR><Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <DISBURSEMENTPLANPERIOD><xsl:value-of select="''"/></DISBURSEMENTPLANPERIOD>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JOBPROFILE><xsl:value-of select="''"/></JOBPROFILE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <EFFECTIVEDATE>
                <xsl:choose>
                    <xsl:when test="exists(EFFECTIVEDATE) and string-length(EFFECTIVEDATE) &gt; 0">
                        <xsl:value-of select="format-date(EFFECTIVEDATE, '[M01]/[D01]/[Y0001]')"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="''"/>
                    </xsl:otherwise>
                </xsl:choose>
            </EFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <COMPENSATIONPLAN><xsl:value-of select="''"/></COMPENSATIONPLAN>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <COMPELEMENT><xsl:value-of select="''"/></COMPELEMENT>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <BIWEEKLYAMOUNT>
                <xsl:value-of select="BIWEEKLYAMOUNT"/>
            </BIWEEKLYAMOUNT>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <Job_Record_Number>
            	<xsl:value-of select="Job_Record_Number"/>
            </Job_Record_Number>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <ChargeInsuranceRetirement>
            	<xsl:value-of select="ChargeInsuranceRetirement"/>
            </ChargeInsuranceRetirement>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <WorkerWID>
            	<xsl:value-of select="WorkerWID"/>
            </WorkerWID>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <Period_Activity_Start_Date><xsl:value-of select="Period_Activity_Start_Date"/></Period_Activity_Start_Date>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <Period_Activity_End_Date><xsl:value-of select="Period_Activity_End_Date"/></Period_Activity_End_Date>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <Activity_Type><xsl:value-of select="Activity_Type"/></Activity_Type>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <PAY_START_DATE><xsl:value-of select="PAY_START_DATE"/></PAY_START_DATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <PAY_END_DATE><xsl:value-of select="PAY_END_DATE"/></PAY_END_DATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <EMPL_TYPE><xsl:value-of select="EMPL_TYPE"/></EMPL_TYPE>  
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <SEMA4_ID><xsl:value-of select="SEMA4_ID"/></SEMA4_ID>    
            <NewLine>
                <xsl:value-of select="'&#34;'"/>
                <xsl:value-of select="$vNewLine"/>
            </NewLine>
        </xsl:for-each>
    </xsl:template>
    
    <!--<xsl:template match="Results/Report_Data[@Report='Activity_Assignments']" />-->
    <!--<xsl:template match="Results/Report_Data[@Report='Compensation_Events']" />-->
    
</xsl:stylesheet>

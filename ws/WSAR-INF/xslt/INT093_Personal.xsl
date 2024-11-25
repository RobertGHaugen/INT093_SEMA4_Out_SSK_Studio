<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:wd="urn:com.workday.report/bsvc"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:output method="text"/>
    
    <xsl:variable name="vNewLine" select="'&#xD;&#xA;'"/>
    <xsl:variable name="vDelimiter" select="'&#34;,&#34;'"/>
    <xsl:param name="DefaultEthnicGroup"/>
    <xsl:param name="DefaultMilitaryStatus"/>
    <xsl:param name="DefaultMaritalStatus"/>
    <xsl:param name="pTStartDate"/>
    <xsl:param name="LatinoHispanicEthnicityWID"/>
    <xsl:param name="pPEndDate"/>
    
    <xsl:template match="wd:Report_Data">
        <HEADER>&#34;WORKER&#34;,&#34;CHANGE&#34;,&#34;EMPLID&#34;,&#34;NAME&#34;,&#34;LAST_NAME_SRCH&#34;,&#34;COUNTRY&#34;,&#34;ADDRESS1&#34;,&#34;ADDRESS2&#34;,&#34;CITY&#34;,&#34;M_COUNTY_CD&#34;,&#34;STATE&#34;,&#34;POSTAL&#34;,&#34;PHONE&#34;,&#34;ORIG_HIRE_DT&#34;,&#34;ETHNIC_GROUP&#34;,&#34;SEX&#34;,&#34;MAR_STATUS&#34;,&#34;BIRTHDATE&#34;,&#34;DT_OF_DEATH&#34;,&#34;CITIZENSHIP_STATUS&#34;,&#34;MILITARY_STATUS&#34;,&#34;M_LV_ACCRL_DT&#34;,&#34;PREFERRED_NAME&#34;,&#34;SSN&#34;,&#34;DISABLED&#34;,&#34;JOB_FAMILY&#34;,&#34;COMPANY&#34;,&#34;EMPLOYEE_TYPE&#34;,&#34;PAY_START_DATE&#34;,&#34;JOB_PROFILE&#34;,&#34;PAY_END_DATE&#34;</HEADER>
        <NewLine><xsl:value-of select="$vNewLine"/></NewLine>   
        <xsl:for-each select="wd:Report_Entry">
            <xsl:variable name="ETHNICITY"> 
                <xsl:choose>
                <xsl:when test="wd:ETHNIC_GROUP/wd:ID[@wd:type='Ethnicity_ID'] = 'USA_Declined_to_Answer' and wd:Hispanic_or_Latino = '1'">
                    <xsl:value-of select="$LatinoHispanicEthnicityWID"/>
                </xsl:when>
                <xsl:when test="exists(wd:ETHNIC_GROUP) and wd:Hispanic_or_Latino = '0'">
                    <xsl:value-of select="distinct-values(wd:ETHNIC_GROUP/wd:ID[@wd:type='WID'])" separator="|"/>
                </xsl:when>
                <xsl:when test="exists(wd:ETHNIC_GROUP) and wd:Hispanic_or_Latino = '1'">
                    <xsl:value-of select="distinct-values(wd:ETHNIC_GROUP/wd:ID[@wd:type='WID'])" separator="|"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="$DefaultEthnicGroup"/>
                </xsl:otherwise>
            </xsl:choose>
            </xsl:variable>
            <WORKER>
                <xsl:value-of select="'&#34;'"/>
                <xsl:value-of select="wd:Worker/wd:ID[@wd:type='WID']"/>
            </WORKER>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <CHANGE>
                <xsl:value-of select="wd:CHANGE"/>
            </CHANGE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <EMPLID>
                <xsl:value-of select="wd:EMPLID"/>
            </EMPLID>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <NAME>
                <xsl:value-of select="wd:NAME"/>
            </NAME>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <LAST_NAME_SRCH>
                <xsl:value-of select="wd:LAST_NAME_SRCH"/>
            </LAST_NAME_SRCH>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <COUNTRY>
                <xsl:value-of select="wd:Home_Address_group/wd:COUNTRY"/>
            </COUNTRY>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <ADDRESS1>
                <xsl:value-of select="wd:Home_Address_group/wd:ADDRESS1"/>
            </ADDRESS1>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <ADDRESS2>
                <xsl:value-of select="wd:Home_Address_group/wd:ADDRESS2"/>
            </ADDRESS2>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <CITY>
                <xsl:value-of select="wd:Home_Address_group/wd:CITY"/>
            </CITY>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <M_COUNTY_CD>
                <xsl:value-of select="wd:Home_Address_group/wd:M_COUNTY_CD"/>
            </M_COUNTY_CD>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <STATE>
                <xsl:value-of select="wd:Home_Address_group/wd:STATE"/>
            </STATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <POSTAL>
                <xsl:value-of select="wd:Home_Address_group/wd:POSTAL"/>
            </POSTAL>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <PHONE>
                <xsl:value-of select="wd:PHONE"/>
            </PHONE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <ORIG_HIRE_DT>
                <xsl:value-of select="wd:ORIG_HIRE_DT"/>
            </ORIG_HIRE_DT>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <ETHNIC_GROUP>
                <xsl:choose>
                    <xsl:when test="wd:Hispanic_or_Latino = '1' and $ETHNICITY != $LatinoHispanicEthnicityWID">
                        <xsl:value-of select="concat($ETHNICITY,'|',$LatinoHispanicEthnicityWID)"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="$ETHNICITY"/>
                    </xsl:otherwise>
                </xsl:choose>
                              
                <!--<xsl:choose>
                    <xsl:when test="exists(wd:ETHNIC_GROUP)">
                        <xsl:value-of select="distinct-values(wd:ETHNIC_GROUP/wd:ID[@wd:type='WID'])" separator="|"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="$DefaultEthnicGroup"/>
                    </xsl:otherwise>
                </xsl:choose>-->
            </ETHNIC_GROUP>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <SEX>
                <xsl:value-of select="wd:SEX/wd:ID[@wd:type='WID']"/>
            </SEX>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <MAR_STATUS>
                <xsl:choose>
                    <xsl:when test="exists(wd:MAR_STATUS)">
                        <xsl:value-of select="wd:MAR_STATUS/wd:ID[@wd:type='WID']"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="$DefaultMaritalStatus"/>
                    </xsl:otherwise>
                </xsl:choose>
            </MAR_STATUS>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <BIRTHDATE>
                <xsl:value-of select="wd:BIRTHDATE"/>
            </BIRTHDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <DT_OF_DEATH>
                <xsl:value-of select="wd:DT_OF_DEATH"/>
            </DT_OF_DEATH>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <CITIZENSHIP_STATUS>
                <xsl:value-of select="wd:CITIZENSHIP_STATUS/wd:ID[@wd:type='WID']"/>
            </CITIZENSHIP_STATUS>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <MILITARY_STATUS>
                <xsl:choose>
                    <xsl:when test="exists(wd:MILITARY_STATUS)">
                        <xsl:value-of select="wd:MILITARY_STATUS/wd:ID[@wd:type='WID']"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="$DefaultMilitaryStatus"/>
                    </xsl:otherwise>
                </xsl:choose>
            </MILITARY_STATUS>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <M_LV_ACCRL_DT>
                <xsl:value-of select="wd:M_LV_ACCRL_DT"/>
            </M_LV_ACCRL_DT>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <PREFERRED_NAME>
                <xsl:value-of select="wd:PREFERRED_NAME/@wd:Descriptor"/>
            </PREFERRED_NAME>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <SSN>
                <xsl:value-of select="wd:SSN"/>
            </SSN>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <DISABLED>
                <xsl:value-of select="wd:DISABLED"/>
            </DISABLED>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <JOB_FAMILY>
                <xsl:value-of select="wd:JOB_FAMILY"/>
            </JOB_FAMILY>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <COST_CENTER>
                <xsl:value-of select="wd:COMPANY"/>
            </COST_CENTER>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <EMPLOYEE_TYPE>
                <xsl:value-of select="wd:EMPLOYEE_TYPE"/>
            </EMPLOYEE_TYPE>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <PAY_START_DATE>
                <xsl:value-of select="format-dateTime($pTStartDate, '[Y]-[M01]-[D01]-[H01]:[m01]')"/>
            </PAY_START_DATE>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <JOB_PROFILE>
                <xsl:value-of select="wd:JOB_PROFILE"/>
            </JOB_PROFILE>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <PAY_END_DATE>
                <xsl:value-of select="format-dateTime($pPEndDate, '[Y]-[M01]-[D01]-[H01]:[m01]')"/>
            </PAY_END_DATE>
            <NewLine>
                <xsl:value-of select="'&#34;'"/>
                <xsl:value-of select="$vNewLine"/>
            </NewLine>
        </xsl:for-each>
        
    </xsl:template>
</xsl:stylesheet>

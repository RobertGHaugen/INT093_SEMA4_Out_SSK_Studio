<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:wd="urn:com.workday.report/bsvc" exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:output method="text"/>
    
    <xsl:variable name="vNewLine" select="'&#xD;&#xA;'"/>
    <xsl:variable name="vDelimiter" select="'&#34;,&#34;'"/>
    <xsl:param name="pTStartDate"/>
    <xsl:param name="pPEndDate"/>
    
    <xsl:template match="wd:Report_Data">
        <xsl:variable name="HourlyWage" select="wd:HOURLY_RATE"/>
        <xsl:variable name="BeneBaseRt" select = "wd:ANNL_BENEF_BASE_RT/@wd:Descriptor"/>
        <HEADER>&#34;WORKER&#34;,&#34;SUPORG&#34;,&#34;EMPLID&#34;,&#34;EMPL_RCD&#34;,&#34;COMPANY_SENIORITY_DT&#34;,&#34;EXPECTED_RETURN_DT&#34;,&#34;BUSINESS_TITLE&#34;,&#34;REPORTS_TO&#34;,&#34;M_PROBATION_END_DT&#34;,&#34;M_APPT_END_DT&#34;,&#34;M_LAYOFF_EXP_DT&#34;,&#34;M_LAYOFF_NTC_DT&#34;,&#34;WORK_PHONE&#34;,&#34;EMAIL_ADDR&#34;,&#34;DEPTID&#34;,&#34;JOBCODE&#34;,&#34;POSITION_NBR&#34;,&#34;EMPL_STATUS&#34;,&#34;POSITION_ENTRY_DT&#34;,&#34;PAYGROUP&#34;,&#34;COMP_FREQUENCY&#34;,&#34;HOLIDAY_SCHEDULE&#34;,&#34;SAL_ADMIN_PLAN&#34;,&#34;GRADE&#34;,&#34;STEP&#34;,&#34;ANNL_BENEF_BASE_RT&#34;,&#34;M_EMPLOYMENT_STAT&#34;,&#34;M_WOC_STEP&#34;,&#34;M_WOC_APPT_END_DT&#34;,&#34;JOB_ENTRY_DT&#34;,&#34;M_SPECIAL_PROGRAM&#34;,&#34;SETID_JOBCODE&#34;,&#34;ELIG_CONFIG2&#34;,&#34;ELIG_CONFIG4&#34;,&#34;JOB_INDICATOR&#34;,&#34;OFFICER_CD&#34;,&#34;COMPRATE1&#34;,&#34;COMPRATE2&#34;,&#34;ELIG_CONFIG7&#34;,&#34;COMP_RATECD1&#34;,&#34;EMPL_TYPE&#34;,&#34;STD_HOURS&#34;,&#34;M_LEAVE AUTH&#34;,&#34;EMPL_CLASS&#34;,&#34;M_POSITION_FTE&#34;,&#34;JOB_FAMILY&#34;,&#34;COMPANY&#34;,&#34;EMPLOYEE_TYPE&#34;,&#34;PAY_START_DATE&#34;,&#34;JOB_PROFILE&#34;,&#34;PAY_END_DATE&#34;,&#34;EMPL_TYPE_TEXT&#34;,&#34;TIME_TYPE&#34;</HEADER>
        <NewLine>
            <xsl:value-of select="$vNewLine"/>
        </NewLine>
        <xsl:for-each select="wd:Report_Entry/wd:Positions_for_Worker_group">
            <xsl:value-of select="'&#34;'"/>
            <WORKER>
                <xsl:value-of select="wd:WORKER/wd:ID[@wd:type='WID']"/>
            </WORKER>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <SUPORG>
                <xsl:value-of select="wd:SUPORG/wd:ID[@wd:type='WID']"/>
            </SUPORG>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <EMPLID>
                <xsl:value-of select="wd:EMPLID/@wd:Descriptor"/>
            </EMPLID>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <EMPL_RCD>
                <xsl:value-of select="wd:EMPL_RCD"/>
            </EMPL_RCD>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <COMPANY_SENIORITY_DT>
                <xsl:value-of select="wd:COMPANY_SENIORITY_DT"/>
            </COMPANY_SENIORITY_DT>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <EXPECTED_RETURN_DT>
                <xsl:value-of select="../wd:Leave_of_Absence_Requests_group/wd:EXPECTED_RETURN_DT"/>
            </EXPECTED_RETURN_DT>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <BUSINESS_TITLE>
                <xsl:value-of select="wd:BUSINESS_TITLE"/>
            </BUSINESS_TITLE>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <REPORTS_TO>
                <xsl:value-of select="wd:REPORTS_TO"/>
            </REPORTS_TO>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <M_PROBATION_END_DT>
                <xsl:choose>
                    <xsl:when test="wd:PROBATION_EXTENDED_END_DATE > wd:M_PROBATION_END_DT">
                        <xsl:value-of select="wd:PROBATION_EXTENDED_END_DATE"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="wd:M_PROBATION_END_DT"/>
                    </xsl:otherwise>
                </xsl:choose>
            </M_PROBATION_END_DT>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <M_APPT_END_DT>
                <xsl:choose>
                    <xsl:when test="wd:M_APPT_END_DT ='6000-01-01-08:00'">
                        <xsl:text></xsl:text>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="wd:M_APPT_END_DT"/>
                    </xsl:otherwise>
                </xsl:choose>
            </M_APPT_END_DT>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <M_LAYOFF_EXP_DT>
                <xsl:value-of select="../wd:M_LAYOFF_EXP_DT"/>
            </M_LAYOFF_EXP_DT>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <M_LAYOFF_NTC_DT>
                <xsl:value-of select="wd:M_LAYOFF_NTC_DT"/>
            </M_LAYOFF_NTC_DT>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <WORK_PHONE>
                <xsl:value-of select="wd:WORK_PHONE"/>
            </WORK_PHONE>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <EMAIL_ADDR>
                <xsl:value-of select="wd:EMAIL_ADDR"/>
            </EMAIL_ADDR>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <DEPTID>
                <xsl:value-of select="wd:DEPTID/wd:ID[@wd:type='Custom_Organization_Reference_ID']"/>
            </DEPTID>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <JOBCODE>
                <xsl:value-of select="substring-before(wd:JOBCODE/wd:ID[@wd:type='Job_Profile_ID'],'_')"/>
            </JOBCODE>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <POSITION_NBR>
                <xsl:value-of select="wd:POSITION_NBR"/>
            </POSITION_NBR>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <EMPL_STATUS>
                <xsl:value-of select="wd:EMPL_STATUS"/>
            </EMPL_STATUS>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <POSITION_ENTRY_DT>
                <xsl:value-of select="../wd:CF_LRV_Position_Restriction_group/wd:POSITION_ENTRY_DT"/>
            </POSITION_ENTRY_DT>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <PAYGROUP>
                <xsl:choose>
                    <xsl:when test="wd:EMPL_RCD = '999' and wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Biweekly'">
                        <xsl:text>P08</xsl:text>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_RCD = '999' and wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Hourly'">
                        <xsl:text>P08</xsl:text>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:text> </xsl:text>
                    </xsl:otherwise>
                </xsl:choose>
                <!--
                    Old vlaue before CRC added the choose statement above 
                <xsl:value-of select="distinct-values(wd:PAYGROUP/wd:ID[@wd:type='Organization_Reference_ID'])" separator="|"/>  
                -->
            </PAYGROUP>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <COMP_FREQUENCY>
                <xsl:choose>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Biweekly'">
                        <xsl:text>B</xsl:text>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Hourly'">
                        <xsl:text>H</xsl:text>
                    </xsl:when>
                </xsl:choose>
                <!--
                    Old vlaue before CRC added the choose statement above 
                <xsl:value-of select="wd:COMP_FREQUENCY"/> 
                -->
            </COMP_FREQUENCY>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <HOLIDAY_SCHEDULE>
                <!-- <xsl:choose>
                    <xsl:when test="contains(wd:JOBCODE,'007205') or contains(wd:JOBCODE,'007012') or contains(wd:JOBCODE,'007022') or contains(wd:JOBCODE,'007013') 
                        or contains(wd:JOBCODE,'007024') or contains(wd:JOBCODE, '007204') or contains(wd:JOBCODE, '007203') 
                        or contains(wd:JOBCODE, '007020') or contains(wd:JOBCODE, '007023') or contains(wd:JOBCODE,'007847')">
                        <xsl:value-of select="distinct-values(wd:HOLIDAY_SCHEDULE/wd:ID[@wd:type='Holiday_Calendar_ID'])" separator="|"/>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Biweekly'">
                    <xsl:text>NONE</xsl:text>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Hourly' and 
                        wd:M_BENEFIT_AUTH/wd:ID[@wd:type='Job_Classification_Reference_ID'] = 'AF1'">
                        <xsl:value-of select="distinct-values(wd:HOLIDAY_SCHEDULE/wd:ID[@wd:type='Holiday_Calendar_ID'])" separator="|"/>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Hourly' and 
                        wd:M_BENEFIT_AUTH/wd:ID[@wd:type='Job_Classification_Reference_ID'] = 'AF5'">
                        <xsl:value-of select="distinct-values(wd:HOLIDAY_SCHEDULE/wd:ID[@wd:type='Holiday_Calendar_ID'])" separator="|"/>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Hourly' and 
                        wd:M_BENEFIT_AUTH/wd:ID[@wd:type='Job_Classification_Reference_ID'] = 'EG1'">
                        <xsl:value-of select="distinct-values(wd:HOLIDAY_SCHEDULE/wd:ID[@wd:type='Holiday_Calendar_ID'])" separator="|"/>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Hourly' and 
                        wd:M_BENEFIT_AUTH/wd:ID[@wd:type='Job_Classification_Reference_ID'] = 'MG1'">
                        <xsl:value-of select="distinct-values(wd:HOLIDAY_SCHEDULE/wd:ID[@wd:type='Holiday_Calendar_ID'])" separator="|"/>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Hourly' and 
                        wd:M_BENEFIT_AUTH/wd:ID[@wd:type='Job_Classification_Reference_ID'] = 'MM1'">
                        <xsl:value-of select="distinct-values(wd:HOLIDAY_SCHEDULE/wd:ID[@wd:type='Holiday_Calendar_ID'])" separator="|"/>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Hourly' and 
                        wd:M_BENEFIT_AUTH/wd:ID[@wd:type='Job_Classification_Reference_ID'] = 'MM3'">
                        <xsl:value-of select="distinct-values(wd:HOLIDAY_SCHEDULE/wd:ID[@wd:type='Holiday_Calendar_ID'])" separator="|"/>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Hourly' and 
                        wd:M_BENEFIT_AUTH/wd:ID[@wd:type='Job_Classification_Reference_ID'] = 'MM4'">
                        <xsl:value-of select="distinct-values(wd:HOLIDAY_SCHEDULE/wd:ID[@wd:type='Holiday_Calendar_ID'])" separator="|"/>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Hourly' and 
                        wd:M_BENEFIT_AUTH/wd:ID[@wd:type='Job_Classification_Reference_ID'] = 'NA3'">
                        <xsl:value-of select="distinct-values(wd:HOLIDAY_SCHEDULE/wd:ID[@wd:type='Holiday_Calendar_ID'])" separator="|"/>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Hourly' and 
                        wd:M_BENEFIT_AUTH/wd:ID[@wd:type='Job_Classification_Reference_ID'] = 'NA4'">
                        <xsl:value-of select="distinct-values(wd:HOLIDAY_SCHEDULE/wd:ID[@wd:type='Holiday_Calendar_ID'])" separator="|"/>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Hourly' and 
                        wd:M_BENEFIT_AUTH/wd:ID[@wd:type='Job_Classification_Reference_ID'] = 'NM1'">
                        <xsl:value-of select="distinct-values(wd:HOLIDAY_SCHEDULE/wd:ID[@wd:type='Holiday_Calendar_ID'])" separator="|"/>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Hourly' and 
                        wd:M_BENEFIT_AUTH/wd:ID[@wd:type='Job_Classification_Reference_ID'] = 'NM3'">
                        <xsl:value-of select="distinct-values(wd:HOLIDAY_SCHEDULE/wd:ID[@wd:type='Holiday_Calendar_ID'])" separator="|"/>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Hourly' and 
                        wd:M_BENEFIT_AUTH/wd:ID[@wd:type='Job_Classification_Reference_ID'] = 'NM4'">
                        <xsl:value-of select="distinct-values(wd:HOLIDAY_SCHEDULE/wd:ID[@wd:type='Holiday_Calendar_ID'])" separator="|"/>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Hourly' and 
                        wd:M_BENEFIT_AUTH/wd:ID[@wd:type='Job_Classification_Reference_ID'] = 'PE1'">
                        <xsl:value-of select="distinct-values(wd:HOLIDAY_SCHEDULE/wd:ID[@wd:type='Holiday_Calendar_ID'])" separator="|"/>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Hourly' and 
                        wd:M_BENEFIT_AUTH/wd:ID[@wd:type='Job_Classification_Reference_ID'] = 'PE5'">
                        <xsl:value-of select="distinct-values(wd:HOLIDAY_SCHEDULE/wd:ID[@wd:type='Holiday_Calendar_ID'])" separator="|"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:text>NONE</xsl:text>
                    </xsl:otherwise>
                </xsl:choose> -->
                <xsl:value-of select="distinct-values(wd:HOLIDAY_SCHEDULE/wd:ID[@wd:type='Holiday_Calendar_ID'])" separator="|"/>
            </HOLIDAY_SCHEDULE>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <SAL_ADMIN_PLAN>
                <xsl:value-of select="wd:SAL_ADMIN_PLAN/wd:ID[@wd:type='Compensation_Grade_ID']"/>
            </SAL_ADMIN_PLAN>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <GRADE>
                <xsl:value-of select="substring-after(wd:GRADE/wd:ID[@wd:type='Compensation_Grade_Profile_ID'],'_')"/>
            </GRADE>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <STEP>
                <xsl:value-of select="wd:STEP"/>
            </STEP>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <ANNL_BENEF_BASE_RT>
                <!-- <xsl:choose>
                    <xsl:when test="wd:ANNL_BENEF_BASE_RT/@wd:Descriptor = '0'">
                        <xsl:text>0</xsl:text>
                    </xsl:when>
                    <xsl:when test="wd:ANNL_BENEF_BASE_RT/@wd:Descriptor = '2088'">
                        <xsl:value-of select="format-number(wd:ANNL_BENEF_BASE_RT/@wd:Descriptor * wd:HOURLY_RATE,'#.00')"/>
                    </xsl:when>
                    <xsl:when test="wd:ANNL_BENEF_BASE_RT/@wd:Descriptor = '24'">
                        <xsl:value-of select="format-number(wd:ANNL_BENEF_BASE_RT/@wd:Descriptor * wd:HOURLY_RATE,'#.00')"/>
                    </xsl:when>
                    <xsl:when test="wd:ANNL_BENEF_BASE_RT/@wd:Descriptor = '30'">
                        <xsl:value-of select="format-number(wd:ANNL_BENEF_BASE_RT/@wd:Descriptor * wd:HOURLY_RATE,'#.00')"/>
                    </xsl:when>
                    <xsl:when test="wd:ANNL_BENEF_BASE_RT/@wd:Descriptor = '32'">
                        <xsl:value-of select="format-number(wd:ANNL_BENEF_BASE_RT/@wd:Descriptor * wd:HOURLY_RATE,'#.00')"/>
                    </xsl:when>
                    <xsl:when test="wd:ANNL_BENEF_BASE_RT/@wd:Descriptor = 'BASEPAY'">
                        <xsl:value-of select="format-number(wd:TOTAL_BASE_PAY,'#.00')"/>
                    </xsl:when>
                </xsl:choose> -->
                <xsl:value-of select="format-number(wd:ANNL_BENEF_BASE_RT,'#.00')"/>
            </ANNL_BENEF_BASE_RT>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <M_EMPLOYMENT_STAT>
                <xsl:value-of select="wd:M_EMPLOYMENT_STAT"/>
            </M_EMPLOYMENT_STAT>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <M_WOC_STEP>
                <xsl:value-of select="wd:M_WOC_STEP"/>
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
            <JOB_ENTRY_DT>
                <xsl:value-of select="wd:JOB_ENTRY_DT"/>
            </JOB_ENTRY_DT>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <M_SPECIAL_PROGRAM>
                <xsl:value-of select="wd:M_SPECIAL_PROGRAM"/>
            </M_SPECIAL_PROGRAM>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <SETID_JOBCODE>
                <xsl:value-of select="substring-after(distinct-values(wd:SETID_JOBCODE/wd:ID[@wd:type='Job_Classification_Reference_ID']),'_')" separator="|"/>
            </SETID_JOBCODE>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <ELIG_CONFIG2>
                <xsl:value-of select="wd:ELIG_CONFIG2/wd:ID[@wd:type='Custom_List__Value_Alias']"/>
            </ELIG_CONFIG2>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <ELIG_CONFIG4>
            	<xsl:value-of select="wd:ELIG_CONFIG4"/>
            	<!-- <xsl:choose>
            		<xsl:when test="exists(wd:ELIG_CONFIG4/wd:ID[@wd:parent_id='SPECIAL_ELIGIBILITY_LIST'])">
            			<xsl:value-of select="wd:ELIG_CONFIG4/wd:ID[@wd:parent_id='SPECIAL_ELIGIBILITY_LIST']"/>
            		</xsl:when>
            		<xsl:otherwise>
            			<xsl:text>CX</xsl:text>
            		</xsl:otherwise>
            	</xsl:choose> -->
            </ELIG_CONFIG4>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <JOB_INDICATOR>
            	<xsl:choose>
            		<xsl:when test="wd:JOB_INDICATOR = 1">
            			<xsl:text>P</xsl:text>
            		</xsl:when>
            		<xsl:otherwise>
            			<xsl:text>S</xsl:text>
            		</xsl:otherwise>
            	</xsl:choose>
            </JOB_INDICATOR>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <OFFICER_CD>
                <xsl:value-of select="wd:OFFICER_CD"/>
            </OFFICER_CD>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <COMPRATE1>
                <xsl:value-of select="wd:COMPRATE1/wd:ID[@wd:type='Pay_Rate_Type_ID']"/>
            </COMPRATE1>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <COMPRATE2>
                <xsl:value-of select="wd:COMPRATE2"/>
            </COMPRATE2>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <ELIG_CONFIG7>
                <xsl:choose>
                    <xsl:when test="wd:ELIG_CONFIG7/wd:ID[@wd:type='Custom_List__Value_Alias'] = 'NOTELIGIBLE'">
                        <xsl:text></xsl:text>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="upper-case(wd:ELIG_CONFIG7/wd:ID[@wd:type='Custom_List__Value_Alias'])"/> 
                    </xsl:otherwise>
                </xsl:choose>
            </ELIG_CONFIG7>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <COMP_RATECD1>
            	<xsl:choose>
            		<xsl:when test="not(exists(wd:COMP_RATECD1))">
            			<xsl:text>ONSTEP</xsl:text>
					</xsl:when>
					<xsl:otherwise>
                		<xsl:value-of select="wd:COMP_RATECD1"/>				
					</xsl:otherwise>
            	</xsl:choose>
            </COMP_RATECD1>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <EMPL_TYPE>
                <xsl:choose>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Hourly'">
                        <xsl:text>H</xsl:text>
                    </xsl:when>
                    <xsl:when test="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID'] =  'Biweekly'">
                        <xsl:text>S</xsl:text>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:text>Unmapped value - fix this in the Position XSLT within INT093</xsl:text>
                    </xsl:otherwise>
                </xsl:choose>
                <!--
                    Old vlaue before CRC added the choose statement above 
                    <xsl:value-of select="wd:EMPL_TYPE/wd:ID[@wd:type='Pay_Rate_Type_ID']"/>
                -->
            </EMPL_TYPE>            
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter> 
            <STD_HOURS>
            	<!-- Making a change to bring in the default working hours into Prism so that we can multiply with either Workday FTE values or FWM Working FTE values -->
            	<xsl:value-of select="format-number(wd:Default_Weekly_Hours, '#.00')"/>
            	<!-- <xsl:choose>
            	    <xsl:when test="wd:Working_FTE_Specified = '1'">
            	        <xsl:value-of select="format-number(wd:Default_Weekly_Hours * wd:M_POSITION_FTE,'#.00')"/>
            		</xsl:when>
            	    <xsl:otherwise>
            	        <xsl:value-of select="format-number(wd:STD_HOURS,'#.00')"/>
            	    </xsl:otherwise>
            	</xsl:choose> -->
            </STD_HOURS>      
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter> 
            <M_LEAVE_AUTH>
                <xsl:value-of select="wd:M_LEAVE_AUTH/wd:ID[@wd:type='Job_Classification_Reference_ID']"/>
            </M_LEAVE_AUTH>    
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter> 
            <EMPL_CLASS>
                <xsl:value-of select="wd:EMPL_CLASS/@wd:Descriptor"/>
            </EMPL_CLASS>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <M_POSITION_FTE>
                <xsl:value-of select="format-number(wd:M_POSITION_FTE * 100,'000')"/>
            </M_POSITION_FTE>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <JOB_FAMILY>
                <xsl:value-of select="wd:Job_Family"/>
            </JOB_FAMILY>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <COST_CENTER>
                <xsl:value-of select="wd:Company"/>
            </COST_CENTER>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <EMPLOYEE_TYPE>
                <xsl:value-of select="wd:Employee_Type"/>
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
                <xsl:value-of select="wd:Job_Profile"/>
            </JOB_PROFILE>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <PAY_END_DATE>
                <xsl:value-of select="format-dateTime($pPEndDate, '[Y]-[M01]-[D01]-[H01]:[m01]')"/>
            </PAY_END_DATE>
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <EMPL_TYPE_TEXT>
            	<xsl:value-of select="wd:EMPL_TYPE_TEXT"/>
            </EMPL_TYPE_TEXT>            
            <Delimiter>
                <xsl:value-of select="$vDelimiter"/>
            </Delimiter>
            <TIME_TYPE>
            	<xsl:value-of select="wd:TIME_TYPE/wd:ID[@wd:type='Position_Time_Type_ID']"/>
            </TIME_TYPE>
            <NewLine>
                <xsl:value-of select="'&#34;'"/>
                <xsl:value-of select="$vNewLine"/>
            </NewLine>
        </xsl:for-each>
        
    </xsl:template>
</xsl:stylesheet>

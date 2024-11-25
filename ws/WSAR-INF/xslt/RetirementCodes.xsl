<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:wd="urn:com.workday.report/bsvc"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:output method="text"/>
    
    <xsl:variable name="vNewLine" select="'&#xD;&#xA;'"/>
    <xsl:variable name="vDelimiter" select="'&#34;,&#34;'"/>
    
    <xsl:template match="wd:Report_Data">
        <HEADER>&#34;WORKER&#34;,&#34;EMPLID&#34;,&#34;POSITION&#34;,&#34;JOB_RECORD_NUMBER_00&#34;,&#34;JOB_RECORD_NUMBER_00_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE&#34;,&#34;JOB_RECORD_NUMBER_00_RETIREMENT_CODE&#34;,&#34;JOB_RECORD_NUMBER_01&#34;,&#34;JOB_RECORD_NUMBER_01_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE&#34;,&#34;JOB_RECORD_NUMBER_01_RETIREMENT_CODE&#34;,&#34;JOB_RECORD_NUMBER_02&#34;,&#34;JOB_RECORD_NUMBER_02_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE&#34;,&#34;JOB_RECORD_NUMBER_02_RETIREMENT_CODE&#34;,&#34;JOB_RECORD_NUMBER_03&#34;,&#34;JOB_RECORD_NUMBER_03_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE&#34;,&#34;JOB_RECORD_NUMBER_03_RETIREMENT_CODE&#34;,&#34;JOB_RECORD_NUMBER_04&#34;,&#34;JOB_RECORD_NUMBER_04_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE&#34;,&#34;JOB_RECORD_NUMBER_04_RETIREMENT_CODE&#34;,&#34;JOB_RECORD_NUMBER_05&#34;,&#34;JOB_RECORD_NUMBER_05_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE&#34;,&#34;JOB_RECORD_NUMBER_05_RETIREMENT_CODE&#34;,&#34;JOB_RECORD_NUMBER_06&#34;,&#34;JOB_RECORD_NUMBER_06_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE&#34;,&#34;JOB_RECORD_NUMBER_06_RETIREMENT_CODE&#34;,&#34;JOB_RECORD_NUMBER_07&#34;,&#34;JOB_RECORD_NUMBER_07_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE&#34;,&#34;JOB_RECORD_NUMBER_07_RETIREMENT_CODE&#34;,&#34;JOB_RECORD_NUMBER_08&#34;,&#34;JOB_RECORD_NUMBER_08_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE&#34;,&#34;JOB_RECORD_NUMBER_08_RETIREMENT_CODE&#34;,&#34;JOB_RECORD_NUMBER_9999&#34;,&#34;JOB_RECORD_NUMBER_9999_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE&#34;,&#34;JOB_RECORD_NUMBER_9999_RETIREMENT_CODE&#34;,&#34;JRN00SUPRETDATE&#34;,&#34;JRN00SUPRETCODE&#34;,&#34;JRN01SUPRETDATE&#34;,&#34;JRN01SUPRETCODE&#34;,&#34;JRN02SUPRETDATE&#34;,&#34;JRN02SUPRETCODE&#34;,&#34;JRN03SUPRETDATE&#34;,&#34;JRN03SUPRETCODE&#34;,&#34;JRN04SUPRETDATE&#34;,&#34;JRN04SUPRETCODE&#34;,&#34;JRN05SUPRETDATE&#34;,&#34;JRN05SUPRETCODE&#34;,&#34;JRN06SUPRETDATE&#34;,&#34;JRN06SUPRETCODE&#34;,&#34;JRN07SUPRETDATE&#34;,&#34;JRN07SUPRETCODE&#34;,&#34;JRN08SUPRETDATE&#34;,&#34;JRN08SUPRETCODE&#34;,&#34;JRN999SUPRETDATE&#34;,&#34;JRN999SUPRETCODE&#34;</HEADER>
        <NewLine><xsl:value-of select="$vNewLine"/></NewLine>   
        <xsl:for-each select="wd:Report_Entry">
            <WORKER>
                <xsl:value-of select="'&#34;'"/>
                <xsl:value-of select="wd:WORKER/wd:ID[@wd:type='WID']"/>
            </WORKER>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <EMPLID>
                <xsl:value-of select="wd:SEMA4_ID/@wd:Descriptor"/>
            </EMPLID>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <POSITION>
                <xsl:value-of select="wd:POSITION_ID"/>
            </POSITION>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN000>
                <xsl:choose>
                    <xsl:when test="exists(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_00_FIELDRETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD)">
                        <xsl:text>000</xsl:text>
                    </xsl:when>
                </xsl:choose>
            </JRN000>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN000EFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_00_FIELDRETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD,'[Y0001]-[M01]-[D01]')"/>
            </JRN000EFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN000RETIREMENTCODE>
                <xsl:choose>
                    <xsl:when test="contains(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_00_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')">
                        <xsl:value-of select="substring-before(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_00_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_00_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList']"/>
                    </xsl:otherwise>
                </xsl:choose>
            </JRN000RETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN001>
                <xsl:choose>
                    <xsl:when test="exists(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_01_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD)">
                        <xsl:text>001</xsl:text>
                    </xsl:when>
                </xsl:choose>
            </JRN001>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN001EFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_01_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD,'[Y0001]-[M01]-[D01]')"/>
            </JRN001EFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN001RETIREMENTCODE>
                <xsl:choose>
                    <xsl:when test="contains(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_01_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')">
                        <xsl:value-of select="substring-before(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_01_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_01_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList']"/>
                    </xsl:otherwise>
                </xsl:choose>
            </JRN001RETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN002>
                <xsl:choose>
                    <xsl:when test="exists(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_02_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD)">
                        <xsl:text>002</xsl:text>
                    </xsl:when>
                </xsl:choose>
            </JRN002>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN002EFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_02_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD,'[Y0001]-[M01]-[D01]')"/>
            </JRN002EFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN002RETIREMENTCODE>
                <xsl:choose>
                    <xsl:when test="contains(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_02_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')">
                        <xsl:value-of select="substring-before(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_02_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_02_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList']"/>
                    </xsl:otherwise>
                </xsl:choose>
            </JRN002RETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN003>
                <xsl:choose>
                    <xsl:when test="exists(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_03_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD)">
                        <xsl:text>003</xsl:text>
                    </xsl:when>
                </xsl:choose>
            </JRN003>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN003EFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_03_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD,'[Y0001]-[M01]-[D01]')"/>
            </JRN003EFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN003RETIREMENTCODE>
                <xsl:choose>
                    <xsl:when test="contains(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_03_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')">
                        <xsl:value-of select="substring-before(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_03_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_03_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList']"/>
                    </xsl:otherwise>
                </xsl:choose>
            </JRN003RETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN004>
                <xsl:choose>
                    <xsl:when test="exists(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_04_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD)">
                        <xsl:text>004</xsl:text>
                    </xsl:when>
                </xsl:choose>
            </JRN004>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN004EFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_04_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD,'[Y0001]-[M01]-[D01]')"/>
            </JRN004EFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN004RETIREMENTCODE>
                <xsl:choose>
                    <xsl:when test="contains(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_04_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')">
                        <xsl:value-of select="substring-before(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_04_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_04_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList']"/>
                    </xsl:otherwise>
                </xsl:choose>
            </JRN004RETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN005>
                <xsl:choose>
                    <xsl:when test="exists(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_05_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD)">
                        <xsl:text>005</xsl:text>
                    </xsl:when>
                </xsl:choose>
            </JRN005>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN005EFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_05_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD,'[Y0001]-[M01]-[D01]')"/>
            </JRN005EFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN005RETIREMENTCODE>
                <xsl:choose>
                    <xsl:when test="contains(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_05_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')">
                        <xsl:value-of select="substring-before(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_05_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_05_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList']"/>
                    </xsl:otherwise>
                </xsl:choose>
            </JRN005RETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN006>
                <xsl:choose>
                    <xsl:when test="exists(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_06_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD)">
                        <xsl:text>006</xsl:text>
                    </xsl:when>
                </xsl:choose>
            </JRN006>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN006EFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_06_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD,'[Y0001]-[M01]-[D01]')"/>
            </JRN006EFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN006RETIREMENTCODE>
                <xsl:choose>
                    <xsl:when test="contains(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_06_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')">
                        <xsl:value-of select="substring-before(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_06_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_06_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList']"/>
                    </xsl:otherwise>
                </xsl:choose>
            </JRN006RETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN007>
                <xsl:choose>
                    <xsl:when test="exists(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_07_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD)">
                        <xsl:text>007</xsl:text>
                    </xsl:when>
                </xsl:choose>
            </JRN007>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN007EFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_07_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD,'[Y0001]-[M01]-[D01]')"/>
            </JRN007EFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN007RETIREMENTCODE>
                <xsl:choose>
                    <xsl:when test="contains(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_07_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')">
                        <xsl:value-of select="substring-before(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_07_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_07_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList']"/>
                    </xsl:otherwise>
                </xsl:choose>
            </JRN007RETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN008>
                <xsl:choose>
                    <xsl:when test="exists(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_08_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD)">
                        <xsl:text>008</xsl:text>
                    </xsl:when>
                </xsl:choose>
            </JRN008>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN008EFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_08_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD,'[Y0001]-[M01]-[D01]')"/>
            </JRN008EFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN008RETIREMENTCODE>
                <xsl:choose>
                    <xsl:when test="contains(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_08_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')">
                        <xsl:value-of select="substring-before(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_08_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_08_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList']"/>
                    </xsl:otherwise>
                </xsl:choose>
            </JRN008RETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN9999>
                <xsl:choose>
                    <xsl:when test="exists(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_9999_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD)">
                        <xsl:text>999</xsl:text>
                    </xsl:when>
                </xsl:choose>
            </JRN9999>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN9999EFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_9999_RETIREMENT_CODE_PLAN_EFFECTIVE_DATE_FIELD,'[Y0001]-[M01]-[D01]')"/>
            </JRN9999EFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN9999RETIREMENTCODE>
                <xsl:choose>
                    <xsl:when test="contains(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_9999_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')">
                        <xsl:value-of select="substring-before(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_9999_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList'],'_')"/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_NUMBER_9999_RETIREMENT_CODE_FIELD/wd:ID[@wd:parent_id='retirementCodeList']"/>
                    </xsl:otherwise>
                </xsl:choose>
            </JRN9999RETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN000SUPEFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_00_SUPPLEMENTAL_RETIREMENT_EFFDT,'[Y0001]-[M01]-[D01]')"/>
            </JRN000SUPEFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN000SUPRETIREMENTCODE>
                <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_00_SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE/wd:ID[@wd:parent_id='SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE_LIST']"/>
            </JRN000SUPRETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN001SUPEFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_01_SUPPLEMENTAL_RETIREMENT_EFFDT,'[Y0001]-[M01]-[D01]')"/>
            </JRN001SUPEFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN001SUPRETIREMENTCODE>
                <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_01_SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE/wd:ID[@wd:parent_id='SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE_LIST']"/>
            </JRN001SUPRETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN002SUPEFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_02_SUPPLEMENTAL_RETIREMENT_EFFDT,'[Y0001]-[M01]-[D01]')"/>
            </JRN002SUPEFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN002SUPRETIREMENTCODE>
                <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_02_SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE/wd:ID[@wd:parent_id='SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE_LIST']"/>
            </JRN002SUPRETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN003SUPEFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_03_SUPPLEMENTAL_RETIREMENT_EFFDT,'[Y0001]-[M01]-[D01]')"/>
            </JRN003SUPEFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN003SUPRETIREMENTCODE>
                <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_03_SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE/wd:ID[@wd:parent_id='SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE_LIST']"/>
            </JRN003SUPRETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN004SUPEFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_04_SUPPLEMENTAL_RETIREMENT_EFFDT,'[Y0001]-[M01]-[D01]')"/>
            </JRN004SUPEFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN004SUPRETIREMENTCODE>
                <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_04_SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE/wd:ID[@wd:parent_id='SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE_LIST']"/>
            </JRN004SUPRETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN005SUPEFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_05_SUPPLEMENTAL_RETIREMENT_EFFDT,'[Y0001]-[M01]-[D01]')"/>
            </JRN005SUPEFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN005SUPRETIREMENTCODE>
                <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_05_SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE/wd:ID[@wd:parent_id='SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE_LIST']"/>
            </JRN005SUPRETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN006SUPEFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_06_SUPPLEMENTAL_RETIREMENT_EFFDT,'[Y0001]-[M01]-[D01]')"/>
            </JRN006SUPEFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN006SUPRETIREMENTCODE>
                <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_06_SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE/wd:ID[@wd:parent_id='SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE_LIST']"/>
            </JRN006SUPRETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN007SUPEFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_07_SUPPLEMENTAL_RETIREMENT_EFFDT,'[Y0001]-[M01]-[D01]')"/>
            </JRN007SUPEFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN007SUPRETIREMENTCODE>
                <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_07_SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE/wd:ID[@wd:parent_id='SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE_LIST']"/>
            </JRN007SUPRETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN008SUPEFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_08_SUPPLEMENTAL_RETIREMENT_EFFDT,'[Y0001]-[M01]-[D01]')"/>
            </JRN008SUPEFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN008SUPRETIREMENTCODE>
                <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_08_SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE/wd:ID[@wd:parent_id='SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE_LIST']"/>
            </JRN008SUPRETIREMENTCODE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN999SUPEFFECTIVEDATE>
                <xsl:value-of select="format-date(wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_999_SUPPLEMENTAL_RETIREMENT_EFFDT,'[Y0001]-[M01]-[D01]')"/>
            </JRN999SUPEFFECTIVEDATE>
            <Delimiter><xsl:value-of select="$vDelimiter"/></Delimiter>
            <JRN999SUPRETIREMENTCODE>
                <xsl:value-of select="wd:Position_Restrictions_Additional_Data_group/wd:JOB_RECORD_999_SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE/wd:ID[@wd:parent_id='SUPPLEMENTAL_RETIREMENT_DEDUCTION_CODE_LIST']"/>
            </JRN999SUPRETIREMENTCODE>
            
            <NewLine>
                <xsl:value-of select="'&#34;'"/>
                <xsl:value-of select="$vNewLine"/>
            </NewLine>
        </xsl:for-each>
        
    </xsl:template>
</xsl:stylesheet>

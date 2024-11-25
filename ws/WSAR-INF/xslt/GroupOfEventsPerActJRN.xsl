<?xml version="1.0" encoding="UTF-8" ?> 

<xsl:stylesheet xmlns:wd="urn:com.workday.report/bsvc"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:map="http://www.w3.org/2005/xpath-functions/map" exclude-result-prefixes="#all"
    version="2.0">
    
    <!--  
    <xsl:mode streamable="no" name="copy" on-no-match="shallow-copy"/>
    <xsl:output method="text" encoding="UTF-8" indent="yes"/>
    -->
    
    <xsl:output method="xml" indent="yes"/>
    
    <xsl:template match="wd:Report_Data">
        <wd:Report_Data>
            <xsl:for-each-group select="wd:Report_Entry[exists(wd:WORKER)]"
                group-by="concat(wd:POSITION_NBR,wd:WORKER,wd:EFFDT,wd:ACTION_REASON,wd:ACTION_COMPLETED)">
                
                <wd:Report_Entry>
                    <xsl:attribute name="validation"><xsl:value-of select="count(current-group())"/></xsl:attribute>
                    <wd:REPORT_ID>
                        <xsl:value-of select="wd:REPORT_ID"/>
                    </wd:REPORT_ID>
                    <wd:POSITION_NBR>
                        <xsl:value-of select="wd:POSITION_NBR"/>
                    </wd:POSITION_NBR>
                    <wd:WORKER>
                        <xsl:value-of select="wd:WORKER/wd:ID[@wd:type = 'WID']"/>
                    </wd:WORKER>
                    <wd:EFFDT>
                        <xsl:value-of
                            select="wd:EFFDT"/>
                    </wd:EFFDT>
                    <wd:ACTION>
                        <xsl:value-of select="wd:ACTION"/>
                    </wd:ACTION>
                    <wd:ACTION_COMPLETED>
                        <xsl:value-of select="wd:ACTION_COMPLETED"/>
                    </wd:ACTION_COMPLETED>
                    <wd:ACTION_DT>
                        <xsl:value-of
                            select="wd:ACTION_DT"/>
                    </wd:ACTION_DT>
                    <wd:ACTION_REASON>
                        <xsl:value-of select="wd:ACTION_REASON"/>
                    </wd:ACTION_REASON>
                    <wd:JRN>
                        <xsl:choose>
                            <xsl:when test="not(wd:Allocation_Details_group[1]/wd:JRN[1])">
                                <xsl:value-of select="wd:DEFAULT_JRN/wd:ID[@wd:type='Custom_Organization_Reference_ID']"/>
                            </xsl:when>
                            <xsl:otherwise>
                                <xsl:value-of select="wd:Allocation_Details_group[1]/wd:JRN[1]"/>
                            </xsl:otherwise>
                        </xsl:choose>
                    </wd:JRN>
                    <wd:Period_Activity_Start_Date>
                        <xsl:value-of select="wd:PERIOD_ACTIVITY_START_DT"/>
                    </wd:Period_Activity_Start_Date>
                    <wd:Period_Activity_End_Date>
                        <xsl:value-of select="wd:PERIOD_ACTIVITY_END_DT"/>
                    </wd:Period_Activity_End_Date>
                </wd:Report_Entry>
                
            </xsl:for-each-group>
            
        </wd:Report_Data>
    </xsl:template>
    
</xsl:stylesheet>

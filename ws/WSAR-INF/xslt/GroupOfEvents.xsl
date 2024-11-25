<?xml version="1.0" encoding="UTF-8" ?> 

<xsl:stylesheet xmlns:wd="urn:com.workday.report/bsvc"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:map="http://www.w3.org/2005/xpath-functions/map" exclude-result-prefixes="#all"
    version="2.0">
    
    <!--  
    <xsl:mode streamable="no" name="copy" on-no-match="shallow-copy"/>
    <xsl:output method="text" encoding="UTF-8" indent="yes"/>
    -->
    
    <xsl:output method="xml" indent="no"/>
    
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
                        <xsl:choose>
                            <xsl:when test="exists(wd:ACTION_REASON) and exists(wd:ACTION_REASON/wd:ID[@wd:type='Event_Classification_Subcategory_ID'])">
                                <xsl:value-of select="substring-before(substring-after(wd:ACTION_REASON/wd:ID[@wd:type='Event_Classification_Subcategory_ID'],'_'),'_')"/>
                            </xsl:when>
                            <xsl:otherwise>
                                <xsl:text/><!-- Left blank on pourpose -->
                            </xsl:otherwise>
                        </xsl:choose>
                    </wd:ACTION>
                    <wd:ACTION_COMPLETED>
                        <xsl:value-of
                            select="wd:ACTION_COMPLETED"/>
                    </wd:ACTION_COMPLETED>
                    <wd:ACTION_DT>
                        <xsl:value-of
                            select="wd:ACTION_DT"/>
                    </wd:ACTION_DT>
                    <wd:ACTION_REASON>
                        <xsl:choose>
                            <xsl:when test="exists(wd:ACTION_REASON) and exists(wd:ACTION_REASON/wd:ID[@wd:type='Event_Classification_Subcategory_ID'])">
                                <xsl:value-of select="substring-after(substring-after(wd:ACTION_REASON/wd:ID[@wd:type='Event_Classification_Subcategory_ID'],'_'),'_')"/>
                            </xsl:when>
                            <xsl:otherwise>
                                <xsl:text/><!-- Left blank on pourpose -->
                            </xsl:otherwise>
                        </xsl:choose>
                    </wd:ACTION_REASON>
                    <wd:JRN>
                        <xsl:value-of select="wd:JRN"/>
                    </wd:JRN>
<!--                    <wd:SEMA4ID>
                        <xsl:value-of select="wd:Worker_group/wd:SEMA4_ID/@wd:Descriptor"/>
                    </wd:SEMA4ID>-->
                    <wd:Period_Activity_Start_Date>
                    	<xsl:value-of select="wd:Period_Activity_Pay_Assignments/wd:Period_Activity_Start_Date"/>
                    </wd:Period_Activity_Start_Date>
                    <wd:Period_Activity_End_Date>
                    	<xsl:value-of select="wd:Period_Activity_Pay_Assignments/wd:Period_Activity_End_Date"/>
                    </wd:Period_Activity_End_Date>
                    <wd:Activity_Type>
                    	<xsl:value-of select="wd:Period_Activity_Pay_Assignments/wd:Activity_Type"/>
                    </wd:Activity_Type>
                </wd:Report_Entry>
                
            </xsl:for-each-group>
            
        </wd:Report_Data>
    </xsl:template>
    
</xsl:stylesheet>

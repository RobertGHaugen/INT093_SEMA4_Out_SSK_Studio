<?xml version="1.0" encoding="UTF-8" ?> 

<xsl:stylesheet xmlns:wd="urn:com.workday.report/bsvc"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:map="http://www.w3.org/2005/xpath-functions/map" exclude-result-prefixes="#all"
    version="2.0">
    
    <!--  
    <xsl:mode streamable="no" name="copy" on-no-match="shallow-copy"/>
    <xsl:output method="text" encoding="UTF-8" indent="yes"/>
    -->
    
    <xsl:output method="xml"/>
    
    <xsl:template match="wd:Report_Data">
        
        <wd:Report_Data>
            
            
            <xsl:for-each-group select="wd:Report_Entry[exists(wd:WORKER)]"
                group-by="concat(wd:Position_for_Probation_Period_group/wd:POSITION_ID,wd:WORKER,wd:EFFECTIVE_DATE,wd:ACTIONandACTIONREASON)">
                
                <wd:Report_Entry>
                    <wd:REPORT_ID>
                        <xsl:value-of select="wd:REPORT_ID"/>
                    </wd:REPORT_ID>
                    <wd:POSITION_NBR>
                        <xsl:value-of select="wd:Position_for_Probation_Period_group/wd:POSITION_ID"/>
                    </wd:POSITION_NBR>
                    <wd:WORKER>
                        <xsl:value-of select="wd:WORKER/wd:ID[@wd:type = 'WID']"/>
                    </wd:WORKER>
                    <wd:EFFDT>
                        <xsl:value-of select="wd:EFFECTIVE_DATE"/>
                    </wd:EFFDT>
                    <wd:ACTION>
                        <xsl:value-of select="substring-before(substring-after(wd:ACTIONandACTIONREASON/wd:ID[@wd:type='Probation_Period_Outcome_ID'],'_'),'_')"/>
                    </wd:ACTION>
                    <wd:ACTION_COMPLETED>
                        <xsl:value-of select="wd:ACTION_DT"/>
                    </wd:ACTION_COMPLETED>
                    <wd:ACTION_DT>
                        <xsl:value-of select="wd:ACTION_DT"/>
                    </wd:ACTION_DT>
                    <wd:ACTION_REASON>
                        <xsl:value-of select="substring-after(substring-after(wd:ACTIONandACTIONREASON/wd:ID[@wd:type='Probation_Period_Outcome_ID'],'_'),'_')"/>
                    </wd:ACTION_REASON>
                    <wd:JRN>
                        <xsl:value-of select="wd:Position_for_Probation_Period_group/wd:JRN"/>
                    </wd:JRN>
                </wd:Report_Entry>
                
            </xsl:for-each-group>
            
        </wd:Report_Data>
    </xsl:template>
    
</xsl:stylesheet>

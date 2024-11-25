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
                group-by="concat(wd:POSITION_NBR, wd:WORKER, wd:EFFDT, wd:ACTION_REASON, wd:ACTION_COMPLETED)">
                
                <wd:Report_Entry>
                    <xsl:attribute name="validation">
                        <xsl:value-of select="count(current-group())"/>
                    </xsl:attribute>
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
                        <xsl:value-of select="wd:EFFDT"/>
                    </wd:EFFDT>
                    <wd:ACTION>
                        <xsl:value-of select="wd:ACTION"/>
                    </wd:ACTION>
                    <wd:ACTION_COMPLETED>
                        <xsl:value-of select="concat(format-date(wd:ACTION_DT, '[Y0001]-[M01]-[D01]'),'T00:00:00.000-07:00')"/>
                    </wd:ACTION_COMPLETED>
                    <wd:ACTION_DT>
                        <xsl:value-of select="concat(format-date(wd:ACTION_DT, '[Y0001]-[M01]-[D01]'),'T00:00:00.000-07:00')"/>
                    </wd:ACTION_DT>
                    <wd:ACTION_REASON>
                        <xsl:value-of select="wd:ACTION_REASON"/>
                    </wd:ACTION_REASON>
                    <wd:JRN>
                        <xsl:value-of select="wd:JRN"/>
                    </wd:JRN>
                </wd:Report_Entry>
                
            </xsl:for-each-group>
            
        </wd:Report_Data>
    </xsl:template>
    
</xsl:stylesheet>

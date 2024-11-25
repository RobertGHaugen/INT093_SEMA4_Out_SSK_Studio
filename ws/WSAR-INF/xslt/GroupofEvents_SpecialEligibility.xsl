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

            <xsl:for-each-group
                select="wd:Report_Entry"
                group-by="concat(wd:POSITION_NBR, wd:WORKER, wd:EFFDT, wd:ACTION_REASON, wd:ACTION_COMPLETED)">


                <wd:Report_Entry>
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
                        <xsl:text>DTA</xsl:text>
                    </wd:ACTION>
                    <wd:ACTION_COMPLETED>
                        <xsl:value-of select="wd:ACTION_COMPLETED"/>
                    </wd:ACTION_COMPLETED>
                    <wd:ACTION_DT>
                        <xsl:value-of select="wd:ACTION_DT"/>
                    </wd:ACTION_DT>
                    <wd:ACTION_REASON>
                        <xsl:value-of select="wd:ACTION_REASON/wd:ID[@wd:type='Custom_List__Value_Alias']"/>
                    </wd:ACTION_REASON>
                    <wd:JRN>
        				<xsl:value-of select="wd:Worker_group/wd:JRN/wd:ID[@wd:type='Custom_Organization_Reference_ID']"/>
        			</wd:JRN>
                    <SEMA4ID>
                        <xsl:value-of select="wd:Worker_group/wd:SEMA4_ID/@wd:Descriptor"/>
                    </SEMA4ID>
                </wd:Report_Entry>

            </xsl:for-each-group>

        </wd:Report_Data>
    </xsl:template>

</xsl:stylesheet>

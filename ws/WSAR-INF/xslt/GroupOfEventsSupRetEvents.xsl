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
    
    <xsl:param name="values" as="xs:string*"
        select="('00', '01', '02', '03', '04', '05', '06', '07', '08')"/>
    
    <xsl:template match="wd:Report_Data">
        <wd:Report_Data>
            <!-- 
                some results coming back might not have the ACTION_REASON populated,
                which is fine as those without ACTION and ACTION_REASON are due to that data being added to the job in the event of a hire,
                those should fall off.
                Those with an ACTION_REASON value are standalone events that we will want to capture.
             -->
            <xsl:apply-templates
                select="wd:Report_Entry[wd:Position_Restrictions_Additional_Data_group/*[contains(name(), 'ACTION_REASON')]]"
            />
        </wd:Report_Data>
    </xsl:template>
    
    <xsl:template match="wd:Report_Entry">
        
        <xsl:variable name="content" select="current()"/><!-- saving current wd:Report_Entry content into variable $content -->
        <xsl:for-each select="$values"><!-- for each value of the param $values that contains simple list of 00, 01, ..., 08 we construct dynamic node names -->
            
            <xsl:variable name="currentValue" select="."/><!-- what is my current value that I am processing, ie: 00 or 01 -->
            <xsl:variable name="nodeName" select="concat('wd:JRN_', $currentValue)"/><!-- build node based on $currentValuem ie: wd:JRN_00 -->
            <xsl:if test="exists($content/wd:Position_Restrictions_Additional_Data_group/*[name() = $nodeName])"><!-- procedd only if the main node of wd:JRN_XX exists -->
                
                <wd:Report_Entry>
                    
                    <wd:REPORT_ID>
                        <xsl:value-of select="$content/wd:REPORT_ID"/>
                    </wd:REPORT_ID>
                    <wd:POSITION_NBR>
                        <xsl:value-of select="$content/wd:POSITION_ID"/>
                    </wd:POSITION_NBR>
                    <wd:WORKER>
                        <xsl:value-of select="$content/wd:WORKER/wd:ID[@wd:type = 'WID']"/>
                    </wd:WORKER>
                    <xsl:variable name="nodeEFFDT" select="concat('wd:JRN_', $currentValue, '_SUPRET_EFFDT')"/><!-- build dynamic node name, ie: wd:JRN_01_SUPRET_EFFDT -->
                    <wd:EFFDT>
                        <xsl:value-of
                            select="$content/wd:Position_Restrictions_Additional_Data_group/*[name() = $nodeEFFDT]"
                        />
                    </wd:EFFDT>
                    <wd:ACTION>
                        <xsl:text>DTA</xsl:text>
                    </wd:ACTION>
                    <wd:ACTION_COMPLETED>
                        <xsl:value-of select="$content/wd:Position_Restrictions_Additional_Data_group/wd:ACTION_DT"/>
                    </wd:ACTION_COMPLETED>
                    <wd:ACTION_DT>
                        <xsl:value-of select="$content/wd:Position_Restrictions_Additional_Data_group/wd:ACTION_DT"/>
                    </wd:ACTION_DT>
                    <xsl:variable name="nodeACTREA"
                        select="concat('wd:JRN_', $currentValue, '_ACTION_REASON')"/><!-- build dynamic node name, ie: wd:JRN_01_ACTION_REASON -->
                    <wd:ACTION_REASON>
                        <xsl:value-of select="$content/wd:Position_Restrictions_Additional_Data_group/*[name() = $nodeACTREA]/wd:ID[@wd:type = 'Custom_List__Value_Alias']"/>
                    </wd:ACTION_REASON>
                    <xsl:variable name="nodeJRN"
                        select="$content/wd:Position_Restrictions_Additional_Data_group/*[name() = $nodeName]/wd:ID[@wd:type = 'Custom_List__Value_Alias']"/>
                    <wd:JRN>
                        <!-- add 0 as a prefix to Job Record Number two last digits of reference id -->
                        <xsl:value-of select="concat('0', substring($nodeJRN,string-length($nodeJRN)-1,string-length($nodeJRN)))"/>
                    </wd:JRN>
                    
                </wd:Report_Entry>
            </xsl:if>
        </xsl:for-each>
    </xsl:template>
    
</xsl:stylesheet>

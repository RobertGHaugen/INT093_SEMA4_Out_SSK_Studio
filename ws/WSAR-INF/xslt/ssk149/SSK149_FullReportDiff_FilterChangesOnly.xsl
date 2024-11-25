<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:xsd="http://www.w3.org/2001/XMLSchema"
    xmlns:wd="urn:com.workday.report/CR_INT_Custom_Report"
    xmlns:diff="urn:com.workday/reportdiff"
    xmlns:this="localhost"
    exclude-result-prefixes="xsd this"
    version="3.0">
    
    <!--
       Changes to be made to this framework / template:
       1. Change the wd namespace in the xsl:stylesheet defintion above to match your integration's custom report
       2. Replace the xsl:copy-of in the wd:Report_Entry template - see further comments below
    -->
    
    <xsl:mode streamable="yes" on-no-match="shallow-skip"/>
    <xsl:mode streamable="no" on-no-match="shallow-skip" name="in-memory"/>
    
    <xsl:output method="xml" indent="no" encoding="UTF-8"/>
    
    <xsl:template match="/">
        <File>
            <xsl:for-each select="wd:Report_Data/wd:Report_Entry/copy-of()">
                <xsl:apply-templates select="." mode="in-memory"/>
            </xsl:for-each>
        </File>        
    </xsl:template>
    
    <xsl:template match="wd:Report_Entry" mode="in-memory">
        <xsl:if test="this:isAdded(.) or this:isRecordRemoved(.) or this:isRecordChanged(.)">
            <!--
                For illustration / example purposes, this transformation simply copies the Report_Entry record.
                The xsl:copy-of should most likely be removed and replaced by the specific transformation needed per the target.
            -->
            <xsl:copy-of select="."/>
        </xsl:if>
    </xsl:template>
    
    <xsl:function name="this:isAdded" as="xsd:boolean">
        <xsl:param name="entry" as="node()"/>
        
        <xsl:sequence select="if (exists($entry/@*:isAdded)) then true() else false()"/>
    </xsl:function>
    
    <xsl:function name="this:isRecordChanged" as="xsd:boolean">
        <xsl:param name="entry" as="node()"/>
        
        <!-- 
            Note the use of the // xpath operator in the logic that follows...
            This syntax is discouraged because of the potential for full document traversals which consume excessive amounts of memory.
            Nevertheless, in this limited and defined context, we understand the scope and bounding of the potential document traversal
            and can be assured of the operation's safety.  It can only search within a single Report_Entry node and no further.
        -->
        <xsl:sequence select="if (exists($entry//*/@*:isAdded) or exists($entry//*/@*:priorValue) or exists($entry//*/@*:priorDescriptor) or exists($entry//*/@*:isDeleted)) then true() else false()"/>
    </xsl:function>
    
    <xsl:function name="this:isRecordRemoved" as="xsd:boolean">
        <xsl:param name="entry" as="node()"/>

        <xsl:sequence select="if (exists($entry/@*:isDeleted)) then true() else false()"/>
    </xsl:function>
</xsl:stylesheet>
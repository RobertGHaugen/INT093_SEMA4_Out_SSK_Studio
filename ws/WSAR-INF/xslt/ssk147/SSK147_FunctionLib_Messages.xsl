<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:ssk="urn:com.workday.custom.ssk.common" 
    exclude-result-prefixes="xs ssk"
    version="3.0">
    
    <xsl:function name="ssk:flexLog">
    	<xsl:param name="log" as="xs:string"/>
    	<xsl:param name="severity" as="xs:string"/>
    	<xsl:param name="values" as="xs:string*"/>
		
		<xsl:message select="concat(
				$log,
				'&lt;ssk:fl&gt;',
				current-dateTime(), 
				'&lt;ssk:fl&gt;',
				$severity, 
				'&lt;ssk:fl&gt;',
				string-join($values, '&lt;ssk:fl&gt;')
			)"/>
    </xsl:function>
</xsl:stylesheet>

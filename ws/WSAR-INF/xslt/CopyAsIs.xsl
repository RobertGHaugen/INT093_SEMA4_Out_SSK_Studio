<?xml version="1.0" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
  xmlns:wd="urn:com.workday.report/bsvc">
  <xsl:output indent="yes" method="xml" encoding="utf-8" omit-xml-declaration="yes"/>

  <!-- Stylesheet to remove all namespaces from docuemnt -->
  <!-- NOTE: this will lead to attribute name clash, if an element contains two attributes with same local name but different namespace prefix -->
  <!-- Nodes that cannot have a namespace are copied as such -->

  <!-- template to copy elements -->

  <xsl:template match="/">
    <xsl:apply-templates />
  </xsl:template>

<xsl:template match="*">
  <xsl:copy-of select="."  />
</xsl:template>
 
</xsl:stylesheet>
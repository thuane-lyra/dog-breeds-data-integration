<?xml version="1.0" encoding="UTF-8" ?>

<!-- New XSLT document created with EditiX XML Editor (http://www.editix.com) at Sat May 16 18:37:47 BST 2026 -->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" indent="yes"/>
	
	<xsl:template match="detalhes">
	<html>
		<body>
		
            <h2> Catálogo de Raças e Fotografias </h2>
            <table border ="1">
                <tr> <th> Nome da Raça </th> <th> Fotografia </th></tr>
                <xsl:apply-templates select="breedDetail"/>
            </table> 
        </body>
    </html>
	</xsl:template>

    <xsl:template match="breedDetail">
        <xsl:variable name="idRaca" select="breedId"/>
        <tr>
            <td><xsl:value-of select="document('racas.xml')/racas/breed[id=$idRaca]/@nome"/></td>
            
            <td><img src="{fotoUrl}" width="150"/></td>
        </tr>
   </xsl:template>

</xsl:stylesheet>



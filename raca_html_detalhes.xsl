<?xml version="1.0" encoding="UTF-8" ?>

<!-- New XSLT document created with EditiX XML Editor (http://www.editix.com) at Sat May 16 19:15:44 BST 2026 -->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" indent="yes"/>
	
	<xsl:template match="detalhes">
	<html>
		<body>
            <h2>Ficha Técnica da Raça</h2>
            <xsl:apply-templates select="breedDetail"/>
        </body>
    </html>
	</xsl:template>

    <xsl:template match="breedDetail">
        
        <xsl:variable name="idRaca" select="breedId"/>
        <h3>Nome: <xsl:value-of select="document('racas.xml')/racas/breed[id=$idRaca]/@nome"/></h3>

        <ul>
            <li><b>ID:</b> <xsl:value-of select="breedId"/></li>
            <li><b>Grupo:</b> <xsl:value-of select="grupo"/></li>
            <li><b>Porte:</b> <xsl:value-of select="porte"/></li>
            <li><b>Origem:</b> <xsl:value-of select="paisOrigem"/></li>
            <li><b>Esperança de vida:</b> <xsl:value-of select="esperancaVida"/> anos</li>
            <li><b>Pelo:</b> <xsl:value-of select="tamanhoPelo"/></li>
            <li><b>Cores:</b> <xsl:value-of select="cores"/></li>
        </ul>

        <xsl:if test="tamanhoDetalhes">
            <h4>Peso e Altura</h4>
            <ul>
                <xsl:if test="tamanhoDetalhes/altura/geral">
                    <li><b>Altura:</b> <xsl:value-of select="tamanhoDetalhes/altura/geral/min"/> - <xsl:value-of select="tamanhoDetalhes/altura/geral/max"/> <xsl:value-of select="tamanhoDetalhes/altura/geral/unidade"/></li>
                </xsl:if>
                
                <xsl:if test="tamanhoDetalhes/peso/macho">
                    <li><b>Peso Macho:</b> <xsl:value-of select="tamanhoDetalhes/peso/macho/min"/> - <xsl:value-of select="tamanhoDetalhes/peso/macho/max"/> kg</li>
                </xsl:if>
                
                <xsl:if test="tamanhoDetalhes/peso/femea">
                    <li><b>Peso Fêmea:</b> <xsl:value-of select="tamanhoDetalhes/peso/femea/min"/> - <xsl:value-of select="tamanhoDetalhes/peso/femea/max"/> kg</li>
                </xsl:if>
            </ul>
        </xsl:if>

   </xsl:template>

</xsl:stylesheet>



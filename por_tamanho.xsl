<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes" encoding="UTF-8"/>
    
    <xsl:key name="porteKey" match="breedDetail" use="porte"/>
    
    <xsl:template match="detalhes">
        <racasPorPorte>
            <xsl:for-each select="breedDetail[count(. | key('porteKey', porte)[1]) = 1]">
                <xsl:sort select="porte"/>
                <xsl:variable name="porteAtual" select="porte"/>
                <grupo porte="{$porteAtual}">
                    <xsl:for-each select="key('porteKey', $porteAtual)">
                        <xsl:sort select="document('racas.xml')/racas/breed[id=current()/breedId]/@nome"/>
                        <raca>
                            <xsl:variable name="idRaca" select="breedId"/>
                            <nome><xsl:value-of select="document('racas.xml')/racas/breed[id=$idRaca]/@nome"/></nome>
                            <grupo><xsl:value-of select="grupo"/></grupo>
                            <esperancaVida><xsl:value-of select="esperancaVida"/></esperancaVida>
                            <paisOrigem><xsl:value-of select="paisOrigem"/></paisOrigem>
                        </raca>
                    </xsl:for-each>
                </grupo>
            </xsl:for-each>
        </racasPorPorte>
    </xsl:template>
</xsl:stylesheet>

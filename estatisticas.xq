(: XQuery - Estatísticas gerais das raças :)
let $detalhes := doc('detalhes.xml')/detalhes
let $total := count($detalhes/breedDetail)
let $mediaVida := avg($detalhes/breedDetail/number(esperancaVida))
return (
  "=== ESTATÍSTICAS DAS RAÇAS ===&#10;&#10;",
  concat("Total de raças: ", $total, "&#10;"),
  concat("Média esperança de vida: ", format-number($mediaVida, "#.0"), " anos&#10;"),
  concat("Maior esperança de vida: ", max($detalhes/breedDetail/number(esperancaVida)), " anos&#10;"),
  concat("Menor esperança de vida: ", min($detalhes/breedDetail/number(esperancaVida)), " anos&#10;"),
  "&#10;--- Contagem por Porte ---&#10;",
  for $porte in distinct-values($detalhes/breedDetail/porte)
  order by $porte
  return concat("  ", $porte, ": ", count($detalhes/breedDetail[porte=$porte]), " raças&#10;"),
  "&#10;--- Contagem por Grupo ---&#10;",
  for $grp in distinct-values($detalhes/breedDetail/grupo)
  order by $grp
  return concat("  ", $grp, ": ", count($detalhes/breedDetail[grupo=$grp]), " raças&#10;"),
  "&#10;--- Países de Origem ---&#10;",
  for $pais in distinct-values($detalhes/breedDetail/paisOrigem)
  order by $pais
  return concat("  ", $pais, ": ", count($detalhes/breedDetail[paisOrigem=$pais]), " raças&#10;")
)

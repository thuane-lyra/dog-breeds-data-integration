(: XQuery - Raças agrupadas por grupo/breed group :)
let $detalhes := doc('detalhes.xml')/detalhes
let $racas := doc('racas.xml')/racas
for $grupo in distinct-values($detalhes/breedDetail/grupo)
order by $grupo
return (
  concat("=== ", upper-case($grupo), " ===&#10;"),
  for $bd in $detalhes/breedDetail[grupo = $grupo]
  let $id := string($bd/breedId)
  let $nome := string($racas/breed[id=$id]/@nome)
  order by $nome
  return concat("  - ", $nome, " (", $bd/porte, ", origem: ", $bd/paisOrigem, ")&#10;"),
  "&#10;"
)

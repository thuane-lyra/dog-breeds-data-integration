(: XQuery - Ranking de raças por esperança de vida (decrescente) :)
let $detalhes := doc('detalhes.xml')/detalhes
let $racas := doc('racas.xml')/racas
return (
  "=== RANKING POR ESPERANÇA DE VIDA ===&#10;&#10;",
  for $bd in $detalhes/breedDetail
  let $id := string($bd/breedId)
  let $nome := string($racas/breed[id=$id]/@nome)
  order by number($bd/esperancaVida) descending
  return concat(
    format-number(position(), "00"), ". ",
    $nome, " - ", $bd/esperancaVida, " anos",
    " (", $bd/porte, ", ", $bd/grupo, ")",
    "&#10;"
  )
)

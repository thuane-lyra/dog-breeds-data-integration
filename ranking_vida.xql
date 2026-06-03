(: XQuery - Ranking de raças por esperança de vida (decrescente) :)
let $detalhes := doc('detalhes.xml')/detalhes
let $racas := doc('racas.xml')/racas
for $bd at $pos in (
  for $b in $detalhes/breedDetail
  order by number($b/esperancaVida) descending
  return $b
)
let $id := string($bd/breedId)
let $nome := string($racas/breed[id=$id]/@nome)
return concat(
  format-number($pos, "00"), ". ",
  $nome, " - ", $bd/esperancaVida, " anos",
  " (", $bd/porte, ", ", $bd/grupo, ")",
  "&#10;"
)
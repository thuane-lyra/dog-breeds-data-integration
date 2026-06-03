package com.mycompany.dogbreeds.app;

import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.Filters;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

public class XPathSearches {

    private static String obtemNomePorId(String breedId, Document docRacas) {
        if (docRacas == null) return "ID " + breedId;
        for (Element breed : docRacas.getRootElement().getChildren("breed")) {
            if (breedId.equals(breed.getChildText("id"))) {
                return breed.getAttributeValue("nome");
            }
        }
        return "ID " + breedId;
    }

    private static String formataDetalhe(Element bd, Document docRacas) {
        String id = bd.getChildText("breedId");
        String nome = obtemNomePorId(id, docRacas);
        StringBuilder sb = new StringBuilder();
        sb.append(nome.toUpperCase()).append("\n");
        sb.append("Grupo: ").append(bd.getChildText("grupo")).append("\n");
        sb.append("Porte: ").append(bd.getChildText("porte")).append("\n");
        sb.append("Cores: ").append(bd.getChildText("cores")).append("\n");
        sb.append("Pais de origem: ").append(bd.getChildText("paisOrigem")).append("\n");
        sb.append("Nivel exercicio: ").append(bd.getChildText("nivelExercicio")).append("\n");
        sb.append("Tamanho pelo:").append(bd.getChildText("tamanhoPelo")).append("\n");
        sb.append("Cuidados pelo:").append(bd.getChildText("cuidadosPelo")).append("\n");
        sb.append("Esperanca vida: ").append(bd.getChildText("esperancaVida")).append(" anos\n");

        Element tamanho = bd.getChild("tamanhoDetalhes");
        if (tamanho != null) {
            Element peso = tamanho.getChild("peso");
            if (peso != null) {
                appendMedida(sb,"Peso macho:", peso.getChild("macho"));
                appendMedida(sb,"Peso femea:", peso.getChild("femea"));
                appendMedida(sb, "Peso geral:", peso.getChild("geral"));
            }
            Element altura = tamanho.getChild("altura");
            if (altura != null) {
                appendMedida(sb,"Altura macho:", altura.getChild("macho"));
                appendMedida(sb,"Altura femea:", altura.getChild("femea"));
                appendMedida(sb,"Altura geral: ", altura.getChild("geral"));
            }
        }
        return sb.toString();
    }

    private static void appendMedida(StringBuilder sb, String label, Element e) {
        if (e != null) {
            sb.append(label)
              .append(e.getChildText("min")).append("-")
              .append(e.getChildText("max")).append(" ")
              .append(e.getChildText("unidade")).append("\n");
        }
    }

    private static String executaXPath(String xpathExpr, Document docDetalhes, Document docRacas, String mensagemVazia) {
        XPathExpression<Element> expr = XPathFactory.instance()
                .compile(xpathExpr, Filters.element());
        List<Element> resultados = expr.evaluate(docDetalhes);

        if (resultados.isEmpty()) return mensagemVazia;

        StringBuilder sb = new StringBuilder();
        sb.append("Encontrada(s) ").append(resultados.size()).append(" raca(s):\n\n");
        for (Element e : resultados) {
            sb.append(formataDetalhe(e, docRacas)).append("\n");
        }
        return sb.toString();
    }

    public static String pesquisarPorNome(String nome, Document docDetalhes, Document docRacas) {
        String breedId = null;
        if (docRacas != null) {
            for (Element breed : docRacas.getRootElement().getChildren("breed")) {
                if (breed.getAttributeValue("nome").equalsIgnoreCase(nome.trim())) {
                    breedId = breed.getChildText("id");
                    break;
                }
            }
        }
        if (breedId == null) return "Raca \"" + nome + "\" nao encontrada no ficheiro racas.xml.";

        String xpath = "//breedDetail[breedId='" + breedId + "']";
        return executaXPath(xpath, docDetalhes, docRacas,
                "Sem detalhes guardados para \"" + nome + "\".");
    }


    public static String pesquisarPorPorte(String porte, Document docDetalhes, Document docRacas) {
        String xpath = "//breedDetail[porte='" + porte + "']";
        return executaXPath(xpath, docDetalhes, docRacas,
                "Nenhuma raca com porte \"" + porte + "\" encontrada.");
    }

    public static String pesquisarPorPeso(double min, double max, Document docDetalhes, Document docRacas) {
        String xpath = "//breedDetail[tamanhoDetalhes/peso/*"
                + "[number(min) >= " + min + " and number(max) <= " + max + "]]";
        return executaXPath(xpath, docDetalhes, docRacas,
                "Nenhuma raca com peso entre " + min + " e " + max + " kg.");
    }


    public static String pesquisarPorCaracteristica(String campo, String valor, Document docDetalhes, Document docRacas) {
        String xpath = "//breedDetail[contains("
                + "translate(" + campo + ",'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')"
                + ",'" + valor.toLowerCase() + "')]";
        return executaXPath(xpath, docDetalhes, docRacas,
                "Nenhuma raca com " + campo + " contendo \"" + valor + "\".");
    }

    public static String pesquisarPorOrigem(String pais, String porte, Document docDetalhes, Document docRacas) {
        String paisLower = pais.toLowerCase();
        String condicaoPais = "contains(translate(paisOrigem,"
                + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')"
                + ",'" + paisLower + "')";

        String xpath;
        String msg;
        if (porte != null && !porte.isBlank()) {
            xpath = "//breedDetail[" + condicaoPais + " and porte='" + porte + "']";
            msg = "Nenhuma raca de porte \"" + porte + "\" com origem em \"" + pais + "\".";
        } else {
            xpath = "//breedDetail[" + condicaoPais + "]";
            msg = "Nenhuma raca com origem em \"" + pais + "\".";
        }
        return executaXPath(xpath, docDetalhes, docRacas, msg);
    }

    public static String pesquisarPorCor(String cor, Document docDetalhes, Document docRacas) {
        String xpath = "//breedDetail[contains("
                + "translate(cores,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')"
                + ",'" + cor.toLowerCase() + "')]";
        return executaXPath(xpath, docDetalhes, docRacas,
                "Nenhuma raca com a cor \"" + cor + "\" encontrada.");
    }


    public static String pesquisarPorGrupo(String grupo, Document docDetalhes, Document docRacas) {
        String xpath = "//breedDetail[contains("
                + "translate(grupo,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')"
                + ",'" + grupo.toLowerCase() + "')]";
        return executaXPath(xpath, docDetalhes, docRacas,
                "Nenhuma raca do grupo \"" + grupo + "\" encontrada.");
    }

    public static String pesquisarPorEsperancaVida(int min, Document docDetalhes, Document docRacas) {
        String xpath = "//breedDetail[number(esperancaVida) >= " + min + "]";
        return executaXPath(xpath, docDetalhes, docRacas,
                "Nenhuma raca com esperanca de vida >= " + min + " anos.");
    }


    public static String pesquisarMaiorEsperancaVida(Document docDetalhes, Document docRacas) {
        String xpath = "//breedDetail[not(number(esperancaVida) < //breedDetail/esperancaVida)]";
        return executaXPath(xpath, docDetalhes, docRacas,
                "Erro ao calcular maior esperanca de vida.");
    }


    public static String pesquisarSemDadosPeso(Document docDetalhes, Document docRacas) {
        String xpath = "//breedDetail[not(tamanhoDetalhes/peso/*)]";
        return executaXPath(xpath, docDetalhes, docRacas,
                "Todas as racas tem dados de peso registados.");
    }


    public static String pesquisarPorAltura(double min, double max,
                                             Document docDetalhes, Document docRacas) {
        String xpath = "//breedDetail[tamanhoDetalhes/altura/*"
                + "[number(min) >= " + min + " and number(max) <= " + max + "]]";
        return executaXPath(xpath, docDetalhes, docRacas,
                "Nenhuma raca com altura entre " + min + " e " + max + " cm.");
    }


    public static String pesquisarCombinado3(String tamanhoPelo, String nivelExercicio,
                                              String paisOrigem,
                                              Document docDetalhes, Document docRacas) {
        String xpath = "//breedDetail["
                + "translate(tamanhoPelo,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')='"
                + tamanhoPelo.toLowerCase() + "'"
                + " and contains(translate(nivelExercicio,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'"
                + nivelExercicio.toLowerCase() + "')"
                + " and contains(translate(paisOrigem,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'"
                + paisOrigem.toLowerCase() + "')]";
        return executaXPath(xpath, docDetalhes, docRacas,
                "Nenhuma raca encontrada com esses 3 criterios.");
    }
}

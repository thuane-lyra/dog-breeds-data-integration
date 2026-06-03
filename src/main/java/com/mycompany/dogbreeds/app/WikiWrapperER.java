package com.mycompany.dogbreeds.app;

import com.mycompany.dogbreeds.model.Medida;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WikiWrapperER {


    private static Medida converteParaMetrico(double min, double max, String unidade) {
        if (unidade.equals("lb")) {
            double minKg = Math.round(min * 0.453592 * 10.0) / 10.0;
            double maxKg = Math.round(max * 0.453592 * 10.0) / 10.0;
            return new Medida(minKg, maxKg, "kg");
        } else { // in
            double minCm = Math.round(min * 2.54 * 10.0) / 10.0;
            double maxCm = Math.round(max * 2.54 * 10.0) / 10.0;
            return new Medida(minCm, maxCm, "cm");
        }
    }

    public static Medida parseMedida(String texto) {
        if (texto == null || texto.isBlank()) return null;
        if (texto.contains("Sem distin") || texto.contains("encontrado")) return null;

        // Normaliza texto
        texto = texto.replace("–", "-").replace("—", "-").replace(" ", " ").trim();
        texto = texto.replaceAll("(?i)kilograms?", "kg");
        texto = texto.replaceAll("(?i)centimetres?|centimeters?", "cm");
        texto = texto.replaceAll("(?i)pounds?", "lb");
        texto = texto.replaceAll("(?i)inches?", "in");
        texto = texto.replaceAll("(?i)\\s+to\\s+", "-");
        texto = texto.replaceAll("[~≈]|(?i)approximately|(?i)about", "").trim();

        Pattern p = Pattern.compile("(\\d+(?:\\.\\d+)?)\\s*-\\s*(\\d+(?:\\.\\d+)?)\\s*(kg|cm)");
        Matcher m = p.matcher(texto);
        if (m.find()) {
            return new Medida(Double.parseDouble(m.group(1)), Double.parseDouble(m.group(2)), m.group(3));
        }

        p = Pattern.compile("(\\d+(?:\\.\\d+)?)\\s*(kg|cm)");
        m = p.matcher(texto);
        if (m.find()) {
            double val = Double.parseDouble(m.group(1));
            return new Medida(val, val, m.group(2));
        }

        p = Pattern.compile("(\\d+(?:\\.\\d+)?)\\s*-\\s*(\\d+(?:\\.\\d+)?)\\s*(lb|in)");
        m = p.matcher(texto);
        if (m.find()) {
            return converteParaMetrico(
                Double.parseDouble(m.group(1)),
                Double.parseDouble(m.group(2)),
                m.group(3)
            );
        }
        p = Pattern.compile("(\\d+(?:\\.\\d+)?)\\s*(lb|in)");
        m = p.matcher(texto);
        if (m.find()) {
            double val = Double.parseDouble(m.group(1));
            return converteParaMetrico(val, val, m.group(2));
        }

        return null;
    }

    public static String obtem_origem(String raca) throws FileNotFoundException, IOException {
        String racaFormatada = raca.replace(" ", "_");
        String link = "https://en.wikipedia.org/wiki/";
        HttpRequestFunctions.httpRequest(link, racaFormatada, "raca.html");
        Scanner ler = new Scanner(new FileInputStream("raca.html"));
        Pattern p1 = Pattern.compile("Origin</th>.*?<[^>]*>([^<]+)<");
        // ER alternativa: para paginas sem infobox, apanha o pais em texto corrido
        Pattern p2 = Pattern.compile("originated in ([A-Z][a-z]+)");
        Matcher m;
        String linha;
        String origemTexto = null;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            m = p1.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1);
            }
            if (origemTexto == null) {
                m = p2.matcher(linha);
                if (m.find()) {
                    origemTexto = m.group(1);
                }
            }
        }
        ler.close();
        return origemTexto != null ? origemTexto : "Origem não encontrada";
    }

    public static String obtem_pesoMacho(String raca) throws FileNotFoundException, IOException {
        String racaFormatada = raca.replace(" ", "_");
        HttpRequestFunctions.httpRequest("https://en.wikipedia.org/wiki/", racaFormatada, "raca.html");
        Scanner ler = new Scanner(new FileInputStream("raca.html"));
        String er = "Weight.*?Males.*?<td[^>]*>\\s*(?:<div[^>]*>)?([^<]+)";
        Pattern p = Pattern.compile(er);
        Matcher m;
        String linha = "";
        while (ler.hasNextLine()) {
            linha = linha + ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1).replace("&nbsp;", " ").replace("&#160;", " ").trim();
            }
        }
        ler.close();
        return "Sem distinção de sexo";
    }

    public static String obtem_pesoFemea(String raca) throws FileNotFoundException, IOException {
        String racaFormatada = raca.replace(" ", "_");
        HttpRequestFunctions.httpRequest("https://en.wikipedia.org/wiki/", racaFormatada, "raca.html");
        Scanner ler = new Scanner(new FileInputStream("raca.html"));
        String er = "Weight.*?Females.*?(?:<td[^>]*>|<li>)\\s*(?:<div[^>]*>)?([^<]+)";
        Pattern p = Pattern.compile(er);
        Matcher m;
        String linha = "";
        while (ler.hasNextLine()) {
            linha = linha + ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1).replace("&nbsp;", " ").replace("&#160;", " ").trim();
            }
        }
        ler.close();
        return "Sem distinção de sexo";
    }

    public static String obtem_alturaMacho(String raca) throws FileNotFoundException, IOException {
        String racaFormatada = raca.replace(" ", "_");
        HttpRequestFunctions.httpRequest("https://en.wikipedia.org/wiki/", racaFormatada, "raca.html");
        Scanner ler = new Scanner(new FileInputStream("raca.html"), "UTF-8");
        String er = "Height</th>(?:(?!</tr>).)*?Males</td>\\s*<td[^>]*>\\s*(?:(<div style[^>]*>))?([^<]+)";
        Pattern p = Pattern.compile(er);
        Matcher m;
        String linha = "";
        while (ler.hasNextLine()) {
            linha = linha + " " + ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(2).replace("&nbsp;", " ").replace("&#160;", " ").replace("–", "-").trim();
            }
        }
        ler.close();
        return "Sem distinção de sexo";
    }

    public static String obtem_alturaFemea(String raca) throws FileNotFoundException, IOException {
        String racaFormatada = raca.replace(" ", "_");
        HttpRequestFunctions.httpRequest("https://en.wikipedia.org/wiki/", racaFormatada, "raca.html");
        Scanner ler = new Scanner(new FileInputStream("raca.html"), "UTF-8");
        String er = "Height</th>(?:(?!</tr>).)*?</tr>\\s*<tr>(?:(?!</tr>).)*?Females</td>\\s*<td[^>]*>\\s*(?:<style[^>]*>.*?</style>)?\\s*(?:<div[^>]*>)?([^<]+)";
        Pattern p = Pattern.compile(er);
        Matcher m;
        String linha = "";
        while (ler.hasNextLine()) {
            linha = linha + " " + ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                String resultado = m.group(1).replace("&nbsp;", " ").replace("&#160;", " ").replace("–", "-").trim();
                ler.close();
                if (resultado.isEmpty()) return "Sem distinção de sexo";
                return resultado;
            }
        }
        ler.close();
        return "Sem distinção de sexo";
    }

    public static String obtem_alturaGeral(String raca) throws FileNotFoundException, IOException {
        String racaFormatada = raca.replace(" ", "_");
        HttpRequestFunctions.httpRequest("https://en.wikipedia.org/wiki/", racaFormatada, "raca.html");
        Scanner ler = new Scanner(new FileInputStream("raca.html"), "UTF-8");
        String er = "Height</th>\\s*<td[^>]*>\\s*([^<]+)<";
        Pattern p = Pattern.compile(er);
        Matcher m;
        String linha = "";
        while (ler.hasNextLine()) {
            linha = linha + " " + ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1).replace("&nbsp;", " ").replace("&#160;", " ").replace("–", "-").trim();
            }
        }
        ler.close();
        return "Não encontrado";
    }

    public static String obtem_cores(String raca) throws FileNotFoundException, IOException {
        String racaFormatada = raca.replace(" ", "_");
        HttpRequestFunctions.httpRequest("https://en.wikipedia.org/wiki/", racaFormatada, "raca.html");
        Scanner ler = new Scanner(new FileInputStream("raca.html"), "UTF-8");
        // Salta tags abertase apanha o primeiro texto
        Pattern p = Pattern.compile("Colou?r</th>\\s*<td[^>]*>(?:\\s*<[^/][^>]*/?>)*\\s*([^<]+)");
        Matcher m;
        String linha = "";
        while (ler.hasNextLine()) {
            linha = linha + ler.nextLine();
            String linhaLimpa = linha.replaceAll("<style[^>]*>.*?</style>", "");
            m = p.matcher(linhaLimpa);
            if (m.find()) {
                String val = m.group(1).replace("&nbsp;", " ").replace("&#160;", " ").trim();
                if (!val.isEmpty()) {
                    ler.close();
                    return val;
                }
            }
        }
        ler.close();
        return "Não encontrado";
    }

    public static String obtem_pesoGeral(String raca) throws FileNotFoundException, IOException {
        String racaFormatada = raca.replace(" ", "_");
        HttpRequestFunctions.httpRequest("https://en.wikipedia.org/wiki/", racaFormatada, "raca.html");
        Scanner ler = new Scanner(new FileInputStream("raca.html"), "UTF-8");
        String er = "Weight</th>\\s*<td[^>]*>\\s*(?:<div[^>]*>)?([^<]+)";
        Pattern p = Pattern.compile(er);
        Matcher m;
        String linha = "";
        while (ler.hasNextLine()) {
            linha = linha + " " + ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1).replace("&nbsp;", " ").replace("&#160;", " ").replace("–", "-").trim();
            }
        }
        ler.close();
        return "Não encontrado";
    }
}

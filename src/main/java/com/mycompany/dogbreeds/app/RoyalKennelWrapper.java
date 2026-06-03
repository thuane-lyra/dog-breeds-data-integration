/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogbreeds.app;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class RoyalKennelWrapper {
    public static ArrayList<String> obtem_racas(String url) throws IOException {
        ArrayList<String> lista = new ArrayList<>();
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements headers = doc.select(".m-breed-card__title");
        for (Element h : headers) {
            lista.add(h.text());
        }
        return lista;
    }

    public static String obtem_grupo(String raca, String url) throws IOException {
       Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements cartoes = doc.select(".m-breed-card");
        
        for (Element cartao : cartoes) {
            String nome_raca = cartao.select(".m-breed-card__title").text();
            if (nome_raca.equals(raca)) {
                return cartao.select(".m-breed-card__category").text();
            }
        }
        return "Sem Grupo";
    }

    public static String obtem_foto(String raca, String url) throws IOException {
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements cartoes = doc.select(".m-breed-card");
        
        for (Element cartao : cartoes) {
            String nome_raca = cartao.select(".m-breed-card__title").text();
            if (nome_raca.equals(raca)) {
                Element img = cartao.selectFirst("img.a-media__image");
                if (img != null) {
                    return img.absUrl("src"); 
                }
            }
        }
        return "Sem foto";
    }

    public static String obtem_tamanho(String raca, String url) throws IOException {
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements cartoes = doc.select(".m-breed-card"); 

        for (Element cartao : cartoes) {
            String nome_raca = cartao.select(".m-breed-card__title").text();
            if (nome_raca.equals(raca)) { 
                Elements itens = cartao.select(".m-breed-summary__item"); 
                for (Element item : itens) {
                    String chave = item.select(".m-breed-summary__key-label").text();
                    if (chave.equals("Size")) { 
                        return item.select(".m-breed-summary__value").text();
                    }
                }
            }
        }
        return "Sem informação";
    }

    public static String obtem_exercicio(String raca, String url) throws IOException {
       Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements cartoes = doc.select(".m-breed-card");

        for (Element cartao : cartoes) {
            String nome_raca = cartao.select(".m-breed-card__title").text();
            if (nome_raca.equals(raca)) { 
                Elements itens = cartao.select(".m-breed-summary__item");
                for (Element item : itens) {
                    String chave = item.select(".m-breed-summary__key-label").text();
                    if (chave.equals("Exercise")) {
                        return item.select(".m-breed-summary__value").text();
                    }
                }
            }
        }
        return "Sem informação";
    }

    public static String obtem_grooming(String raca, String url) throws IOException {
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements cartoes = doc.select(".m-breed-card");
        
        for (Element cartao : cartoes) {
            String nome_raca = cartao.select(".m-breed-card__title").text();
            if (nome_raca.equals(raca)) {
                Elements itens = cartao.select(".m-breed-summary__item");
                for (Element item : itens) {
                    String chave = item.select(".m-breed-summary__key-label").text();
                    if (chave.equals("Grooming")) {
                        return item.select(".m-breed-summary__value").text();
                    }
                }
            }
        }
        return "Sem informação";
    }

    public static String obtem_tamanho_pelo(String raca, String url) throws IOException {
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements cartoes = doc.select(".m-breed-card");
        
        for (Element cartao : cartoes) {
            String nome_raca = cartao.select(".m-breed-card__title").text();
            if (nome_raca.equals(raca)) {
                Elements itens = cartao.select(".m-breed-summary__item");
                for (Element item : itens) {
                    String chave = item.select(".m-breed-summary__key-label").text();
                    if (chave.equals("Coat length")) {
                        return item.select(".m-breed-summary__value").text();
                    }
                }
            }
        }
        return "Sem informação";
    }

    public static int obtem_esperanca_vida(String raca, String url) throws IOException {
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements cartoes = doc.select(".m-breed-card");

        for (Element cartao : cartoes) {
            String nome_raca = cartao.select(".m-breed-card__title").text();
            if (nome_raca.equals(raca)) { 
                Elements itens = cartao.select(".m-breed-summary__item");
                for (Element item : itens) {
                    String chave = item.select(".m-breed-summary__key-label").text();
                    if (chave.equals("Lifespan")) {
                        String valorRaw = item.select(".m-breed-summary__value").text(); 
                        String limpo = valorRaw.replaceAll("[^0-9]", ""); 
                        if(!limpo.isEmpty()){
                            return Integer.parseInt(limpo);
                        }
                    }
                }
            }
        }
        return -1; 
    }

    public static String obtem_link_raca(String raca, String urlPrincipal) throws IOException {
        Document doc = Jsoup.connect(urlPrincipal).maxBodySize(0).get();
        Elements cartoes = doc.select("a.m-breed-card__link"); 
        
        for (Element cartao : cartoes) {
            String nome_raca = cartao.select(".m-breed-card__title").text();
            if(nome_raca.equals(raca)) {
                return cartao.absUrl("href"); 
            }
        }
        return null;
    }

    public static String obtem_tagline(String urlDoCao) throws IOException {
        Document doc = Jsoup.connect(urlDoCao).maxBodySize(0).get();
        Element caixaTexto = doc.selectFirst(".o-breed-header__tagline");
        
        if (caixaTexto != null) {
            return caixaTexto.text();
        }
        return "Sem tagline.";
    }
    
    

    public static String obtem_tamanho_casa(String raca, String url) throws IOException {
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements cartoes = doc.select(".m-breed-card");
        for (Element cartao : cartoes) {
            String nome_raca = cartao.select(".m-breed-card__title").text();
            if (nome_raca.contains(raca)) {
                Elements itens = cartao.select(".m-breed-summary__item");
                for (Element item : itens) {
                    String chave = item.select(".m-breed-summary__key-label").text();
                    if (chave.equals("Size of home")) {
                        return item.select(".m-breed-summary__value").text();
                    }
                }
            }
        }
        return "Sem informação";
    }

    public static String obtem_queda_pelo(String raca, String url) throws IOException {
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements cartoes = doc.select(".m-breed-card");
        for (Element cartao : cartoes) {
            String nome_raca = cartao.select(".m-breed-card__title").text();
            if (nome_raca.contains(raca)) {
                Elements itens = cartao.select(".m-breed-summary__item");
                for (Element item : itens) {
                    String chave = item.select(".m-breed-summary__key-label").text();
                    if (chave.equals("Sheds")) {
                        return item.select(".m-breed-summary__value").text();
                    }
                }
            }
        }
        return "Sem informação";
    }

    public static String obtem_vulneravel(String raca, String url) throws IOException {
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements cartoes = doc.select(".m-breed-card");
        for (Element cartao : cartoes) {
            String nome_raca = cartao.select(".m-breed-card__title").text();
            if (nome_raca.contains(raca)) {
                Elements itens = cartao.select(".m-breed-summary__item");
                for (Element item : itens) {
                    String chave = item.select(".m-breed-summary__key-label").text();
                    if (chave.equals("Vulnerable native breed")) {
                        return item.select(".m-breed-summary__value").text();
                    }
                }
            }
        }
        return "Sem informação";
    }

    public static String obtem_cidade_campo(String raca, String url) throws IOException {
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements cartoes = doc.select(".m-breed-card");
        for (Element cartao : cartoes) {
            String nome_raca = cartao.select(".m-breed-card__title").text();
            if (nome_raca.contains(raca)) {
                Elements itens = cartao.select(".m-breed-summary__item");
                for (Element item : itens) {
                    String chave = item.select(".m-breed-summary__key-label").text();
                    if (chave.equals("Town or country")) {
                        return item.select(".m-breed-summary__value").text();
                    }
                }
            }
        }
        return "Sem informação";
    }

    public static String obtem_tamanho_jardim(String raca, String url) throws IOException {
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements cartoes = doc.select(".m-breed-card");
        for (Element cartao : cartoes) {
            String nome_raca = cartao.select(".m-breed-card__title").text();
            if (nome_raca.contains(raca)) {
                Elements itens = cartao.select(".m-breed-summary__item");
                for (Element item : itens) {
                    String chave = item.select(".m-breed-summary__key-label").text();
                    if (chave.equals("Size of garden")) {
                        return item.select(".m-breed-summary__value").text();
                    }
                }
            }
        }
        return "Sem informação";
    }
}

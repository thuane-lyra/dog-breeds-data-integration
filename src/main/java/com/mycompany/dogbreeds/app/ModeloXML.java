/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogbreeds.app;

import com.mycompany.dogbreeds.model.Breed;
import com.mycompany.dogbreeds.model.BreedDetails;
import com.mycompany.dogbreeds.model.Medida;
import com.mycompany.dogbreeds.model.SizeInfo;
import java.util.List;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author ASUS
 */
public class ModeloXML {
  public static Document adicionaRaca(Breed raca, Document doc) {
        Element raiz;
        if (doc == null) {
            raiz = new Element("racas");
            doc = new Document(raiz);
        } else {
            raiz = doc.getRootElement();
        }
        
        Element pai = new Element("breed");
        Attribute a = new Attribute("nome", raca.getNome());
        pai.setAttribute(a);
        
        Element filho = new Element("id").addContent(raca.getId());
        pai.addContent(filho);
        
        raiz.addContent(pai);
        return doc;
    }

    public static Document adicionaDetalhes(BreedDetails detalhes, Document doc) {
        Element raiz;
        if (doc == null) {
            raiz = new Element("detalhes");
            doc = new Document(raiz);
        } else {
            raiz = doc.getRootElement();
        }
        
        Element pai = new Element("breedDetail");
        
        Element filho = new Element("breedId").addContent(detalhes.getBreedId());
        pai.addContent(filho);
        
        filho = new Element("fotoUrl").addContent(detalhes.getFotoUrl());
        pai.addContent(filho);
        
        filho = new Element("grupo").addContent(detalhes.getGrupo());
        pai.addContent(filho);

        filho = new Element("porte").addContent(detalhes.getPorte());
        pai.addContent(filho);

        filho = new Element("cuidadosPelo").addContent(detalhes.getCuidadosPelo());
        pai.addContent(filho);
        
        filho = new Element("nivelExercicio").addContent(detalhes.getNivelExercicio());
        pai.addContent(filho);
        
        filho = new Element("cores").addContent(detalhes.getCores());
        pai.addContent(filho);
        
        filho = new Element("paisOrigem").addContent(detalhes.getPaisOrigem());
        pai.addContent(filho);
        
        filho = new Element("esperancaVida").addContent(String.valueOf(detalhes.getEsperancaVida()));
        pai.addContent(filho);
        
        filho = new Element("tamanhoPelo").addContent(detalhes.getTamanhoPelo());
        pai.addContent(filho);

        SizeInfo size = detalhes.getTamanhoDetalhes();
        if (size != null) {
            Element paiTamanho = new Element("tamanhoDetalhes");

            Element paiAltura = new Element("altura");
            if (size.getAlturaMacho() != null) {
                paiAltura.addContent(medidaParaXML("macho", size.getAlturaMacho()));
            }
            if (size.getAlturaFemea() != null) {
                paiAltura.addContent(medidaParaXML("femea", size.getAlturaFemea()));
            }
            if (size.getAlturaGeral() != null) {
                paiAltura.addContent(medidaParaXML("geral", size.getAlturaGeral()));
            }
            paiTamanho.addContent(paiAltura);

            Element paiPeso = new Element("peso");
            if (size.getPesoMacho() != null) {
                paiPeso.addContent(medidaParaXML("macho", size.getPesoMacho()));
            }
            if (size.getPesoFemea() != null) {
                paiPeso.addContent(medidaParaXML("femea", size.getPesoFemea()));
            }
            if (size.getPesoGeral() != null) {
                paiPeso.addContent(medidaParaXML("geral", size.getPesoGeral()));
            }
            paiTamanho.addContent(paiPeso);

            pai.addContent(paiTamanho);
        }
        
        raiz.addContent(pai);
        return doc;
    }

    
    public static String removeRaca(String procura, Document doc) {
         Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro não existe");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List<Element> todos = raiz.getChildren("breed");
        boolean found = false;
        String idRemovido = null;
        
        for (int i = 0; i < todos.size(); i++) {
            Element esc = todos.get(i);
            if (esc.getAttributeValue("nome").equalsIgnoreCase(procura)) {
                idRemovido = esc.getChildText("id");
                esc.getParent().removeContent(esc);
                System.out.println("Raça removida com sucesso!");
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Raça " + procura + " não foi encontrada.");
            return null;
        }
        return idRemovido;
    }

    public static Document removeDetalhes(String idProcura, Document doc) {
        if (doc == null || idProcura == null) {
            return doc;
        }
        Element raiz = doc.getRootElement();
        List<Element> todos = raiz.getChildren("breedDetail");
        boolean found = false;
        
        for (int i = 0; i < todos.size(); i++) {
            Element esc = todos.get(i);
            if (esc.getChildText("breedId").equals(idProcura)) {
                esc.getParent().removeContent(esc);
                System.out.println("Detalhes removidos com sucesso!");
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Detalhes não encontrados.");
        }
        return doc;
    }
    
    public static Document alteraGrupo(String idProcura, String novoGrupo, Document doc) {
         Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro não existe");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List <Element> todos = raiz.getChildren("breedDetail");
        boolean found = false;
        
        for (int i = 0; i < todos.size(); i++) {
            Element esc = todos.get(i);
            if (esc.getChildText("breedId").equals(idProcura)) {
                System.out.println("Grupo atual é: " + esc.getChildText("grupo"));
                esc.getChild("grupo").setText(novoGrupo);
                System.out.println("Grupo alterado para: " + novoGrupo);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Detalhes não encontrados para alteração.");
        }
        return doc;
    }
    public static Document alteraCuidadosPelo(String idProcura, String novosCuidados, Document doc) {
        if (doc == null) {
            System.out.println("Ficheiro não existe");
            return null;
        }
        Element raiz = doc.getRootElement();
        List<Element> todos = raiz.getChildren("breedDetail");
        boolean found = false;
        
        for (int i = 0; i < todos.size(); i++) {
            Element esc = todos.get(i);
            if (esc.getChildText("breedId").equals(idProcura)) {
                System.out.println("Cuidados Pelo atual: " + esc.getChildText("cuidadosPelo"));
                esc.getChild("cuidadosPelo").setText(novosCuidados);
                System.out.println("Cuidados Pelo alterado para: " + novosCuidados);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("ID não encontrado.");
        return doc;
    }

    public static Document alteraNivelExercicio(String idProcura, String novoNivel, Document doc) {
        if (doc == null) {
            System.out.println("Ficheiro não existe");
            return null;
        }
        Element raiz = doc.getRootElement();
        List<Element> todos = raiz.getChildren("breedDetail");
        boolean found = false;
        
        for (int i = 0; i < todos.size(); i++) {
            Element esc = todos.get(i);
            if (esc.getChildText("breedId").equals(idProcura)) {
                System.out.println("Nivel Exercicio atual: " + esc.getChildText("nivelExercicio"));
                esc.getChild("nivelExercicio").setText(novoNivel);
                System.out.println("Nivel Exercicio alterado para: " + novoNivel);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("ID não encontrado.");
        return doc;
    }

    public static Document alteraCores(String idProcura, String novasCores, Document doc) {
        if (doc == null) {
            System.out.println("Ficheiro não existe");
            return null;
        }
        Element raiz = doc.getRootElement();
        List<Element> todos = raiz.getChildren("breedDetail");
        boolean found = false;
        
        for (int i = 0; i < todos.size(); i++) {
            Element esc = todos.get(i);
            if (esc.getChildText("breedId").equals(idProcura)) {
                System.out.println("Cores atuais: " + esc.getChildText("cores"));
                esc.getChild("cores").setText(novasCores);
                System.out.println("Cores alteradas para: " + novasCores);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("ID não encontrado.");
        return doc;
    }

    public static Document alteraPaisOrigem(String idProcura, String novoPais, Document doc) {
        if (doc == null) {
            System.out.println("Ficheiro não existe");
            return null;
        }
        Element raiz = doc.getRootElement();
        List<Element> todos = raiz.getChildren("breedDetail");
        boolean found = false;
        
        for (int i = 0; i < todos.size(); i++) {
            Element esc = todos.get(i);
            if (esc.getChildText("breedId").equals(idProcura)) {
                System.out.println("País de Origem atual: " + esc.getChildText("paisOrigem"));
                esc.getChild("paisOrigem").setText(novoPais);
                System.out.println("País de Origem alterado para: " + novoPais);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("ID não encontrado.");
        return doc;
    }

    public static Document alteraEsperancaVida(String idProcura, String novaEsperanca, Document doc) {
        if (doc == null) {
            System.out.println("Ficheiro não existe");
            return null;
        }
        Element raiz = doc.getRootElement();
        List<Element> todos = raiz.getChildren("breedDetail");
        boolean found = false;

        for (int i = 0; i < todos.size(); i++) {
            Element esc = todos.get(i);
            if (esc.getChildText("breedId").equals(idProcura)) {
                System.out.println("Esperança de Vida atual: " + esc.getChildText("esperancaVida"));
                esc.getChild("esperancaVida").setText(novaEsperanca);
                System.out.println("Esperança de Vida alterada para: " + novaEsperanca);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("ID não encontrado.");
        return doc;
    }

    private static Element medidaParaXML(String tag, Medida m) {
        Element e = new Element(tag);
        e.addContent(new Element("min").addContent(String.valueOf(m.getMin())));
        e.addContent(new Element("max").addContent(String.valueOf(m.getMax())));
        e.addContent(new Element("unidade").addContent(m.getUnidade()));
        return e;
    }
}
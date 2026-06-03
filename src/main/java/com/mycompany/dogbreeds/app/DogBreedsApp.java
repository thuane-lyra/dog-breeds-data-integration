/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dogbreeds.app;

import com.mycompany.dogbreeds.model.Breed;
import com.mycompany.dogbreeds.model.BreedDetails;
import com.mycompany.dogbreeds.model.SizeInfo;
import com.mycompany.dogbreeds.model.Medida;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;

public class DogBreedsApp {

  public static void main(String[] args) {
    MainFrame app = new MainFrame();
    app.setVisible(true);
     //populaRacas();
        
    /* try {
          System.out.println("=== A INICIAR REMOÇÃO DO POODLE ===");

          Document docRacas = XMLJDomFunctions.lerDocumentoXML("racas.xml");
          Document docDetalhes = XMLJDomFunctions.lerDocumentoXML("detalhes.xml");

          String idApagado = ModeloXML.removeRaca("Poodle", docRacas);

          if (idApagado != null) { // Se encontrou e apagou...

              docDetalhes = ModeloXML.removeDetalhes(idApagado, docDetalhes);

              XMLJDomFunctions.escreverDocumentoParaFicheiro(docRacas, "racas.xml");
              XMLJDomFunctions.escreverDocumentoParaFicheiro(docDetalhes, "detalhes.xml");
              
              System.out.println("=== POODLE REMOVIDO COM SUCESSO! ===");
          } else {
              System.out.println("O Poodle já não estava no ficheiro.");
          }

      } catch (Exception e) {
          System.out.println("Erro ao aceder aos ficheiros: " + e.getMessage());
      } */
  
      /*
        try {
            String urlPrincipal = "https://www.royalkennelclub.com/search/breeds-a-to-z/";
            String cao = "Rottweiler";

            System.out.println("A iniciar extração de dados para: " + cao + "\n");

            ArrayList<String> todasAsRacas = RoyalKennelWrapper.obtem_racas(urlPrincipal);
            System.out.println("Raças encontradas no site: " + todasAsRacas.size());

            String grupo = RoyalKennelWrapper.obtem_grupo(cao, urlPrincipal);

            String foto = RoyalKennelWrapper.obtem_foto(cao, urlPrincipal);

            String tamanho = RoyalKennelWrapper.obtem_tamanho(cao, urlPrincipal);

            String exercicio = RoyalKennelWrapper.obtem_exercicio(cao, urlPrincipal);

            String grooming = RoyalKennelWrapper.obtem_grooming(cao, urlPrincipal);

            String coatLength = RoyalKennelWrapper.obtem_tamanho_pelo(cao, urlPrincipal);

            int vida = RoyalKennelWrapper.obtem_esperanca_vida(cao, urlPrincipal);

            String linkDoCao = RoyalKennelWrapper.obtem_link_raca(cao, urlPrincipal);

            String tagline = "";
            if (linkDoCao != null) {
                tagline = RoyalKennelWrapper.obtem_tagline(linkDoCao);
            }
            
            
            String tamanhoCasa = RoyalKennelWrapper.obtem_tamanho_casa(cao, urlPrincipal);
            String sheds = RoyalKennelWrapper.obtem_queda_pelo(cao, urlPrincipal);
            String vulneravel = RoyalKennelWrapper.obtem_vulneravel(cao, urlPrincipal);
            String cidadeCampo = RoyalKennelWrapper.obtem_cidade_campo(cao, urlPrincipal);
            String jardim = RoyalKennelWrapper.obtem_tamanho_jardim(cao, urlPrincipal);

            System.out.println("Grupo: " + grupo);
            System.out.println("Foto URL: " + foto);
            System.out.println("Tamanho: " + tamanho);
            System.out.println("Exercício: " + exercicio);
            System.out.println("Cuidados Pêlo (Grooming): " + grooming);
            System.out.println("Tamanho Pêlo (Coat length): " + coatLength);
            System.out.println("Esperança de Vida: " + vida + " anos");
            System.out.println("Link da Raça: " + linkDoCao);
            System.out.println("Tagline: " + tagline);
            System.out.println("Tamanho da Casa: " + tamanhoCasa);
            System.out.println("Queda de Pêlo (Sheds): " + sheds);
            System.out.println("Raça Vulnerável: " + vulneravel);
            System.out.println("Cidade ou Campo: " + cidadeCampo);
            System.out.println("Tamanho do Jardim: " + jardim);
            
            
            
           String origem = WikiWrapperER.obtem_origem(cao);
          //meter cor tbm
            String pesoMacho = WikiWrapperER.obtem_pesoMacho(cao);
            String pesoFemea = WikiWrapperER.obtem_pesoFemea(cao);
            String alturaMacho = WikiWrapperER.obtem_alturaMacho(cao);
            String alturaFemea = WikiWrapperER.obtem_alturaFemea(cao);
            String alturaGeral=WikiWrapperER.obtem_alturaGeral(cao);
            
            System.out.println("País de Origem: " + origem);
            System.out.println("peso macho: "+pesoMacho);
            System.out.println("peso femea: "+pesoFemea);
            System.out.println("altura macho: "+alturaMacho);
            System.out.println("altura femea: "+alturaFemea);
             System.out.println("altura geral: "+alturaGeral);
         

        } catch (IOException e) {
            System.out.println("Erro ao aceder à internet: " + e.getMessage());
        }
    */
  }
public static void populaRacas() {
        String url = "https://www.royalkennelclub.com/search/breeds-a-to-z/";
        String[] racas = {
            "Affenpinscher", "Greyhound", "Rottweiler", "Alaskan Malamute",
            "Chow Chow", "Lhasa Apso", "King Charles Spaniel", "Japanese Spitz",
            "Irish Setter", "Hovawart", "Great Dane", "English Setter",
            "Cavalier King Charles Spaniel", "Bulldog", "Bull Terrier",
            "Boston Terrier", "Bichon Frise", "Bernese Mountain Dog",
            "Bearded Collie", "Basset Hound", "Basenji", "Australian Terrier",
            "Australian Shepherd", "Australian Silky Terrier", "Beagle",
            "Shar Pei", "Schnauzer", "Pug"
        };
        for (String raca : racas) {
            criaEGuardaCao(raca, url);
        }
    }

    public static boolean criaEGuardaCao(String raca, String urlPrincipal) {
        try {
            System.out.println("A processar a raça: " + raca);

            Document docRacas = null;
            Document docDetalhes = null;
            try { docRacas = XMLJDomFunctions.lerDocumentoXML("racas.xml"); } catch (Exception e) {}
            try { docDetalhes = XMLJDomFunctions.lerDocumentoXML("detalhes.xml"); } catch (Exception e) {}

            // Verifica se a raça já existe
            if (docRacas != null) {
                for (Element breed : docRacas.getRootElement().getChildren("breed")) {
                    if (breed.getAttributeValue("nome").equalsIgnoreCase(raca)) {
                        System.out.println("IGNORADO: " + raca + " já existe no ficheiro.");
                        return false;
                    }
                }
            }

            System.out.println("-> A verificar se a raça existe no Royal Kennel Club...");
            String linkVerificacao = RoyalKennelWrapper.obtem_link_raca(raca, urlPrincipal);
            if (linkVerificacao == null) {
                System.out.println("ERRO: Raça '" + raca + "' não encontrada no Royal Kennel Club.");
                return false;
            }

            System.out.println("-> A extrair dados do Royal Kennel Club...");
            String foto = RoyalKennelWrapper.obtem_foto(raca, urlPrincipal);
            String grupo = RoyalKennelWrapper.obtem_grupo(raca, urlPrincipal);
            String porte = RoyalKennelWrapper.obtem_tamanho(raca, urlPrincipal);
            String grooming = RoyalKennelWrapper.obtem_grooming(raca, urlPrincipal);
            String exercicio = RoyalKennelWrapper.obtem_exercicio(raca, urlPrincipal);
            String tamanhoPelo = RoyalKennelWrapper.obtem_tamanho_pelo(raca, urlPrincipal);
            int vida = RoyalKennelWrapper.obtem_esperanca_vida(raca, urlPrincipal);

            System.out.println("-> A extrair dados da Wikipedia...");
            String origem = WikiWrapperER.obtem_origem(raca);
            String cores = WikiWrapperER.obtem_cores(raca);
            String pMachoStr  = WikiWrapperER.obtem_pesoMacho(raca);
            String pFemeaStr  = WikiWrapperER.obtem_pesoFemea(raca);
            String pGeralStr  = WikiWrapperER.obtem_pesoGeral(raca);
            String altMachoStr = WikiWrapperER.obtem_alturaMacho(raca);
            String altFemeaStr = WikiWrapperER.obtem_alturaFemea(raca);
            String altGeralStr = WikiWrapperER.obtem_alturaGeral(raca);

            System.out.println("-> A construir os objetos...");
            String breedId = String.valueOf(obtemProximoId(docRacas));

            Medida pMacho  = WikiWrapperER.parseMedida(pMachoStr);
            Medida pFemea  = WikiWrapperER.parseMedida(pFemeaStr);
            Medida pGeral  = (pMacho == null && pFemea == null) ? WikiWrapperER.parseMedida(pGeralStr) : null;

            Medida altMacho = WikiWrapperER.parseMedida(altMachoStr);
            Medida altFemea = WikiWrapperER.parseMedida(altFemeaStr);
            Medida altGeral = (altMacho == null && altFemea == null) ? WikiWrapperER.parseMedida(altGeralStr) : null;

            SizeInfo tamanhos = new SizeInfo(altGeral, altMacho, altFemea, pGeral, pMacho, pFemea);

            Breed cao = new Breed(breedId, raca);
            BreedDetails detalhes = new BreedDetails(breedId, foto, grupo, porte, tamanhos, grooming, exercicio, cores, origem, vida, tamanhoPelo);

            docRacas = ModeloXML.adicionaRaca(cao, docRacas);
            docDetalhes = ModeloXML.adicionaDetalhes(detalhes, docDetalhes);
            XMLJDomFunctions.escreverDocumentoParaFicheiro(docRacas, "racas.xml");
            XMLJDomFunctions.escreverDocumentoParaFicheiro(docDetalhes, "detalhes.xml");

            System.out.println(raca + " está guardado!");
            return true;

        } catch (Exception e) {
            System.out.println("ERRO ao processar o cão: " + e.getMessage());
            return false;
        }
    }

   
    private static int obtemProximoId(Document docRacas) {
        if (docRacas == null) {
            return 1; 
        }
        
        int maxId = 0;
        java.util.List<org.jdom2.Element> racas = docRacas.getRootElement().getChildren("breed");
        
        for (Element raca : racas) {
            try {
                int idAtual = Integer.parseInt(raca.getChildText("id"));
                if (idAtual > maxId) {
                    maxId = idAtual; 
                }
            } catch (Exception e) {
            }
        }
        return maxId + 1; 
    }

}
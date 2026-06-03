/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dogbreeds.app;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;


/**
 *
 * @author abs
 */
public class HttpRequestFunctions {

    public static void httpRequest(String link, String pesquisa, String outFile) throws IOException {
        URL url;

        if (!pesquisa.isEmpty()) {
            //Create URL, encoded search word
            url = new URL(link + URLEncoder.encode(pesquisa, "UTF-8").replace("+", "_")); //alterar replace se necessário
        } else {
            //Create URL, no search word
            url = new URL(link);
        }
        //System.out.println(url);
        URLConnection ligacao = url.openConnection();

        ligacao.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.6; en-US; rv:1.9.2.16X11; Linux x86_64) Gecko/20110319 Firefox/3.6.16 Chrome/79.0.3945.88 Safari/537.36");

        //Read source File
        Scanner in = new Scanner(new InputStreamReader(ligacao.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String linha;

        while (in.hasNextLine()) {
            linha = in.nextLine();
            sb.append(linha)
                    .append(System.getProperty("line.separator"));
        }
        //Write file
        BufferedWriter out = new BufferedWriter(new FileWriter(outFile));
        out.write(sb.toString());

        out.close();
        in.close();
    }

}

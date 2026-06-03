package com.mycompany.dogbreeds.app;

import net.sf.saxon.s9api.*;
import java.io.*;
import java.nio.file.*;

public class XQueryRunner {
    
    public static String executar(String xqueryFile) {
        try {
            Processor processor = new Processor(false);
            XQueryCompiler compiler = processor.newXQueryCompiler();
            String query = new String(Files.readAllBytes(Paths.get(xqueryFile)), java.nio.charset.StandardCharsets.UTF_8);
            XQueryExecutable exec = compiler.compile(query);
            XQueryEvaluator evaluator = exec.load();
            
            Serializer serializer = processor.newSerializer();
            StringWriter sw = new StringWriter();
            serializer.setOutputWriter(sw);
            serializer.setOutputProperty(Serializer.Property.METHOD, "text");
            evaluator.run(serializer);
            return sw.toString().trim();
        } catch (Exception e) {
            return "Erro ao executar XQuery '" + xqueryFile + "': " + e.getMessage();
        }
    }
    

    public static String executarParaFicheiro(String xqueryFile, String outputFile) {
        try {
            String resultado = executar(xqueryFile);
            Files.write(Paths.get(outputFile), resultado.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            return resultado;
        } catch (Exception e) {
            return "Erro ao guardar output: " + e.getMessage();
        }
    }
}

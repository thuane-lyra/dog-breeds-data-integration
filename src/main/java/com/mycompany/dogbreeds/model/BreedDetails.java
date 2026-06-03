/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogbreeds.model;

/**
 *
 * @author 1663m
 */
public class BreedDetails {
    private String breedId;
    private String fotoUrl;
    private String grupo;
    private String porte;
    private SizeInfo tamanhoDetalhes;
    private String cuidadosPelo;
    private String nivelExercicio;
    private String cores;
    private String paisOrigem;
    private int esperancaVida;
    private String tamanhoPelo;

    public BreedDetails(String breedId, String fotoUrl, String grupo, String porte, SizeInfo tamanhoDetalhes, String cuidadosPelo, String nivelExercicio, String cores, String paisOrigem, int esperancaVida, String tamanhoPelo) {
        this.breedId = breedId;
        this.fotoUrl = fotoUrl;
        this.grupo = grupo;
        this.porte = porte;
        this.tamanhoDetalhes = tamanhoDetalhes;
        this.cuidadosPelo = cuidadosPelo;
        this.nivelExercicio = nivelExercicio;
        this.cores = cores;
        this.paisOrigem = paisOrigem;
        this.esperancaVida = esperancaVida;
        this.tamanhoPelo = tamanhoPelo;
    }

    public String getBreedId() {
        return breedId;
    }

    public void setBreedId(String breedId) {
        this.breedId = breedId;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public SizeInfo getTamanhoDetalhes() {
        return tamanhoDetalhes;
    }

    public void setTamanhoDetalhes(SizeInfo tamanhoDetalhes) {
        this.tamanhoDetalhes = tamanhoDetalhes;
    }

    public String getCuidadosPelo() {
        return cuidadosPelo;
    }

    public void setCuidadosPelo(String cuidadosPelo) {
        this.cuidadosPelo = cuidadosPelo;
    }

    public String getNivelExercicio() {
        return nivelExercicio;
    }

    public void setNivelExercicio(String nivelExercicio) {
        this.nivelExercicio = nivelExercicio;
    }

    public String getCores() {
        return cores;
    }

    public void setCores(String cores) {
        this.cores = cores;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public int getEsperancaVida() {
        return esperancaVida;
    }

    public void setEsperancaVida(int esperancaVida) {
        this.esperancaVida = esperancaVida;
    }

    public String getTamanhoPelo() {
        return tamanhoPelo;
    }

    public void setTamanhoPelo(String tamanhoPelo) {
        this.tamanhoPelo = tamanhoPelo;
    }
    
    
}

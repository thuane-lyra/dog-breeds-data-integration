/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dogbreeds.model;

/**
 *
 * @author 1663m
 */
public class SizeInfo {

    private Medida alturaGeral;
    private Medida alturaMacho;
    private Medida alturaFemea;

    private Medida pesoGeral;
    private Medida pesoMacho;
    private Medida pesoFemea;
        public SizeInfo(Medida alturaGeral, Medida alturaMacho, Medida alturaFemea, Medida pesoGeral, Medida pesoMacho, Medida pesoFemea) {
        this.alturaGeral = alturaGeral;
        this.alturaMacho = alturaMacho;
        this.alturaFemea = alturaFemea;
        this.pesoGeral = pesoGeral;
        this.pesoMacho = pesoMacho;
        this.pesoFemea = pesoFemea;
    }

    public Medida getAlturaGeral() {
        return alturaGeral;
    }

    public void setAlturaGeral(Medida alturaGeral) {
        this.alturaGeral = alturaGeral;
    }

    public Medida getAlturaMacho() {
        return alturaMacho;
    }

    public void setAlturaMacho(Medida alturaMacho) {
        this.alturaMacho = alturaMacho;
    }

    public Medida getAlturaFemea() {
        return alturaFemea;
    }

    public void setAlturaFemea(Medida alturaFemea) {
        this.alturaFemea = alturaFemea;
    }

    public Medida getPesoGeral() {
        return pesoGeral;
    }

    public void setPesoGeral(Medida pesoGeral) {
        this.pesoGeral = pesoGeral;
    }

    public Medida getPesoMacho() {
        return pesoMacho;
    }

    public void setPesoMacho(Medida pesoMacho) {
        this.pesoMacho = pesoMacho;
    }

    public Medida getPesoFemea() {
        return pesoFemea;
    }

    public void setPesoFemea(Medida pesoFemea) {
        this.pesoFemea = pesoFemea;
    }
        
}

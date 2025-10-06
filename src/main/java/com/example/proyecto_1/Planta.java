package com.example.proyecto_1;

//clase planta con sus propiedades y getters
public class Planta {
    private String nombre;
    private String familia;
    private String luzNecesaria;
    private int riego;
    private String ubicacion;

    public Planta(String nombre, String familia, String luzNecesaria, int riego, String ubicacion){
        this.nombre = nombre;
        this.familia = familia;
        this.luzNecesaria = luzNecesaria;
        this.riego = riego;
        this.ubicacion = ubicacion;
    }

    public String getNombre(){
        return nombre;
    }

    public String getFamilia(){
        return familia;
    }

    public String getLuzNecesaria(){
        return luzNecesaria;
    }

    public int getRiego(){
        return riego;
    }

    public String getUbicacion(){
        return ubicacion;
    }
}

package com.orizevtechnologies.historia_de_dota_2.listas;

import java.io.Serializable;

public class lista_relacionados implements Serializable {

    private String nombre_principal;
    private String nombre_secundario;
    private int img_principal;

    public lista_relacionados(String nombre_principal, String nombre_secundario, int img_principal) {
        this.nombre_principal = nombre_principal;
        this.nombre_secundario = nombre_secundario;
        this.img_principal = img_principal;
    }

    public String getNombre_principal() {
        return nombre_principal;
    }

    public String getNombre_secundario() {
        return nombre_secundario;
    }

    public int getImg_principal() {
        return img_principal;
    }
}

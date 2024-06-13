package com.bd2.api.dto;

public class HacerPrediccionDTO {
    
    private String nombreUsuario;
    private int prediccionEquipo1;
    private int prediccionEquipo2;
    private int posicionFormulario;
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getPrediccionEquipo1() {
        return prediccionEquipo1;
    }

    public void setPrediccionEquipo1(int prediccionEquipo1) {
        this.prediccionEquipo1 = prediccionEquipo1;
    }

    public int getPrediccionEquipo2() {
        return prediccionEquipo2;
    }

    public void setPrediccionEquipo2(int prediccionEquipo2) {
        this.prediccionEquipo2 = prediccionEquipo2;
    }

    public int getPosicionFormulario() {
        return posicionFormulario;
    }

    public void setPosicionFormulario(int posicionFormulario) {
        this.posicionFormulario = posicionFormulario;
    }
}

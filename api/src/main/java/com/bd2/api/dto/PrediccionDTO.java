package com.bd2.api.dto;

public class PrediccionDTO {
    
    private int prediccionEquipo1;
    private int prediccionEquipo2;
    private String equipo1;
    private String equipo2;
    private int puntaje;

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

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public int getPuntaje() {
        return puntaje;
    }
    
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}

package com.bd2.api.dto;

import java.sql.Date;
import java.sql.Time;

public class PartidoDTO extends LogicalDelete {

    private int id;
    private String equipo1;
    private String equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private String etapa;
    private Date fecha;
    private Time hora;
    private String estadio;
    private int posicionFormulario;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
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

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Time getHora() {
        return hora;
    }
    
    public void setHora(Time hora) {
        this.hora = hora;
    }
    
    public String getEstadio() {
        return estadio;
    }
    
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }
    
    public int getPosicionFormulario() {
        return posicionFormulario;
    }
    
    public void setPosicionFormulario(int posicionFormulario) {
        this.posicionFormulario = posicionFormulario;
    }
    
    public void borrarPartido() {
        borrar();
    }
    
    public boolean getPartidoBorrado() {
        return getBorrado();
    }
}
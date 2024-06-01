package com.bd2.api.dto;

public abstract class LogicalDelete {
    
    boolean borrado = false;
    
    public boolean getBorrado() {
        return borrado;
    }
    
    public void borrar() {
        borrado = true;
    }
}

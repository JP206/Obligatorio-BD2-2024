package com.bd2.api.dto;

public class LoginDTO {
    
    private String correo;
    private String contrasenia;
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String usuario) {
        this.correo = usuario;
    }
    
    public String getContrasenia() {
        return contrasenia;
    }
    
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}

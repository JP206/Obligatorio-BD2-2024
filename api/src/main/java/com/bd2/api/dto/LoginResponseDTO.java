package com.bd2.api.dto;

public class LoginResponseDTO {
    
    private boolean loginExitoso;
    private boolean esAdmin;
    
    public boolean getLoginExitoso() {
        return loginExitoso;
    }
    
    public void setLoginExitoso(boolean loginExitoso) {
        this.loginExitoso = loginExitoso;
    }
    
    public boolean getEsAdmin() {
        return esAdmin;
    }
    
    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }
}

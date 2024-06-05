package com.bd2.api.dto;

public class AlumnoDTO extends LogicalDelete {
    
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;
    private String campeon;
    private String subcampeon;
    private String carrera;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getContrasenia() {
        return contrasenia;
    }
    
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public void borrarUsuario() {
        borrar();
    }
    
    public boolean getUsuarioBorrado() {
        return getBorrado();
    }
    
    public String getCampeon() {
        return campeon;
    }
    
    public void setCampeon(String campeon) {
        this.campeon = campeon;
    }
    
    public String getSubcampeon() {
        return subcampeon;
    }
    
    public void setSubcampeon(String subcampeon) {
        this.subcampeon = subcampeon;
    }
    
    public String getCarrera() {
        return carrera;
    }
    
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}

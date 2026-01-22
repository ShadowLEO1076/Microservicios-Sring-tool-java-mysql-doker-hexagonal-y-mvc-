package com.glcv.usuario.d_presentacion.dto;

public class UsuarioRequest {
    // Estos son los datos que vienen del JSON
    private String nombre;
    private String email;
    private String password;

    // 1. Constructor Vacío (OBLIGATORIO para que Spring lea el JSON)
    public UsuarioRequest() {
    }

    // 2. Getters y Setters (OBLIGATORIOS para leer y escribir datos)
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }


    public String getEmail() { return email; }
    public void setEmail(String precio) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

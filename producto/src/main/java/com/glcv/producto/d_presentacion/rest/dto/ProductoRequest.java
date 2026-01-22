package com.glcv.producto.d_presentacion.rest.dto;

import java.math.BigDecimal;

public class ProductoRequest {
    // Estos son los datos que vienen del JSON
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;

    // 1. Constructor Vacío (OBLIGATORIO para que Spring lea el JSON)
    public ProductoRequest() {
    }

    // 2. Getters y Setters (OBLIGATORIOS para leer y escribir datos)
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}
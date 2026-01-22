package com.glcv.pedidos.b_dto;

import java.util.List;

public class PedidoRequest {
    private String usuarioId;
    private String nombreCliente;
    private String emailCliente;
    private String direccionEnvio;
    private List<DetalleRequest> productos;

    // --- GETTERS Y SETTERS MANUALES ---
    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public String getEmailCliente() { return emailCliente; }
    public void setEmailCliente(String emailCliente) { this.emailCliente = emailCliente; }

    public String getDireccionEnvio() { return direccionEnvio; }
    public void setDireccionEnvio(String direccionEnvio) { this.direccionEnvio = direccionEnvio; }

    public List<DetalleRequest> getProductos() { return productos; }
    public void setProductos(List<DetalleRequest> productos) { this.productos = productos; }
}
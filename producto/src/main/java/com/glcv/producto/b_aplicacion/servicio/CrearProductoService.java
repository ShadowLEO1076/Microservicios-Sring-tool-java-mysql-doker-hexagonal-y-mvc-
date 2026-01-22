package com.glcv.producto.b_aplicacion.servicio;

import com.glcv.producto.a_dominio.modelos.Producto; // <--- OJO: Debe ser el del dominio
import com.glcv.producto.a_dominio.puertos.in.CrearProductoUseCase;
import com.glcv.producto.a_dominio.puertos.out.ProductoRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CrearProductoService implements CrearProductoUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    // Constructor Manual
    public CrearProductoService(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepositoryPort.guardar(producto);
    }
}
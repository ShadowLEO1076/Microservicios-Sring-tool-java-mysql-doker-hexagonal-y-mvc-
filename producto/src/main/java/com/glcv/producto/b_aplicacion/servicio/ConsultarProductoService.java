package com.glcv.producto.b_aplicacion.servicio;

import com.glcv.producto.a_dominio.modelos.Producto;
import com.glcv.producto.a_dominio.puertos.in.ConsultarProductoUseCase;
import com.glcv.producto.a_dominio.puertos.out.ProductoRepositoryPort;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ConsultarProductoService implements ConsultarProductoUseCase {

    private final ProductoRepositoryPort productoRepositoryPort;

    // --- AGREGAMOS ESTE CONSTRUCTOR MANUALMENTE ---
    public ConsultarProductoService(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }
    // ----------------------------------------------

    @Override
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepositoryPort.buscarPorId(id);
    }
}
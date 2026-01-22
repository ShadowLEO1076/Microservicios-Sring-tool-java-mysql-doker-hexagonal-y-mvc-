
package com.glcv.producto.a_dominio.puertos.in;

import com.glcv.producto.a_dominio.modelos.Producto;

public interface CrearProductoUseCase {
    // Fíjate bien en esta línea
    Producto crearProducto(Producto producto);
}
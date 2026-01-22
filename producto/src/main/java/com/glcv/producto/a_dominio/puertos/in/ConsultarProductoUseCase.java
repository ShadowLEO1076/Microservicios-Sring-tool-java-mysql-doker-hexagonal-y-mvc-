package com.glcv.producto.a_dominio.puertos.in;
import com.glcv.producto.a_dominio.modelos.Producto;
import java.util.Optional;

public interface ConsultarProductoUseCase {
	// Usamos Optional porque puede que el producto no exista
    Optional<Producto> obtenerProductoPorId(Long id);
	

}

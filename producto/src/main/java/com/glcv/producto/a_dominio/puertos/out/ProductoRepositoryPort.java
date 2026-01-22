package com.glcv.producto.a_dominio.puertos.out;
import com.glcv.producto.a_dominio.modelos.Producto;
import java.util.Optional;

public interface ProductoRepositoryPort {
	Producto guardar(Producto producto);
    Optional<Producto> buscarPorId(Long id);

}

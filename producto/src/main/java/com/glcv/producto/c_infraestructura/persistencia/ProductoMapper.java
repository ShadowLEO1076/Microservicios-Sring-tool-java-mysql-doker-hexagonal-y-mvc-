package com.glcv.producto.c_infraestructura.persistencia;

import com.glcv.producto.a_dominio.modelos.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    // Convierte de la Base de Datos -> al Dominio
    public Producto toDomain(ProductoEntity entity) {
        if (entity == null) return null;
        return new Producto(
            entity.getId(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getPrecio(),
            entity.getStock()
        );
    }

    // Convierte del Dominio -> a la Base de Datos
    public ProductoEntity toEntity(Producto domain) {
        if (domain == null) return null;
        return new ProductoEntity(
            domain.getId(),
            domain.getNombre(),
            domain.getDescripcion(),
            domain.getPrecio(),
            domain.getStock()
        );
    }
}
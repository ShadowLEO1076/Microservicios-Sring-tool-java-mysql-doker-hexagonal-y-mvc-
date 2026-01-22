package com.glcv.producto.c_infraestructura.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductoRepository extends JpaRepository<ProductoEntity, Long> {
   
}

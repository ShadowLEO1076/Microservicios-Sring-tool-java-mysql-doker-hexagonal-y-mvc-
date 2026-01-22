package com.glcv.producto.c_infraestructura.persistencia;

import com.glcv.producto.a_dominio.modelos.Producto;
import com.glcv.producto.a_dominio.puertos.out.ProductoRepositoryPort;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class ProductoPersistenceAdapter implements ProductoRepositoryPort {

    private final JpaProductoRepository jpaRepository;
    private final ProductoMapper mapper;

    // --- CONSTRUCTOR MANUAL (Soluciona el error de "blank final field") ---
    public ProductoPersistenceAdapter(JpaProductoRepository jpaRepository, ProductoMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }
    // ----------------------------------------------------------------------

    @Override
    public Producto guardar(Producto producto) {
        ProductoEntity entity = mapper.toEntity(producto);
        ProductoEntity guardado = jpaRepository.save(entity);
        return mapper.toDomain(guardado);
    }

    @Override
    public Optional<Producto> buscarPorId(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }
}
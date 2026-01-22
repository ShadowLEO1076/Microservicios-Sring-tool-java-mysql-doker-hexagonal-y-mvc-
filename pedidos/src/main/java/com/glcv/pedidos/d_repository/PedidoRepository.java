package com.glcv.pedidos.d_repository;

import com.glcv.pedidos.c_model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
}

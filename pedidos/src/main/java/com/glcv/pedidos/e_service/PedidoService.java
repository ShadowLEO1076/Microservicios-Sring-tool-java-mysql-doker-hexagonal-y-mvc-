package com.glcv.pedidos.e_service;

import com.glcv.pedidos.b_dto.DetalleRequest;
import com.glcv.pedidos.b_dto.PedidoRequest;
import com.glcv.pedidos.c_model.DetallePedido;
import com.glcv.pedidos.c_model.Pedido;
import com.glcv.pedidos.d_repository.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Transactional // Si falla algo en el for, se cancela todo (Rollback)
    public Pedido crearPedido(PedidoRequest request) {
        Pedido pedido = new Pedido();
        // Mapeamos los datos del cliente
        pedido.setUsuarioId(request.getUsuarioId());
        pedido.setNombreCliente(request.getNombreCliente());
        pedido.setEmailCliente(request.getEmailCliente());
        pedido.setDireccionEnvio(request.getDireccionEnvio());

        List<DetallePedido> detalles = new ArrayList<>();
        BigDecimal totalGeneral = BigDecimal.ZERO;

        // Recorremos los productos del carrito
        for (DetalleRequest item : request.getProductos()) {
            DetallePedido detalle = new DetallePedido();
            detalle.setProductoId(item.getProductoId());
            detalle.setNombreProducto(item.getNombreProducto());
            detalle.setCantidad(item.getCantidad());
            detalle.setPrecioUnitario(item.getPrecioUnitario());

            //  Cálculo del Subtotal: Precio * Cantidad
            BigDecimal subtotal = item.getPrecioUnitario().multiply(new BigDecimal(item.getCantidad()));
            detalle.setSubtotal(subtotal);
            
            // Vinculación bidireccional (necesaria para JPA)
            detalle.setPedido(pedido);
            
            detalles.add(detalle);
            totalGeneral = totalGeneral.add(subtotal);
        }

        pedido.setDetalles(detalles);
        pedido.setTotal(totalGeneral);

        return pedidoRepository.save(pedido);
    }
    
    // Método extra para listar
    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }
}
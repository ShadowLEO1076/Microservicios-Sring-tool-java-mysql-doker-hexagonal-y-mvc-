package com.glcv.pedidos.a_controller;

import com.glcv.pedidos.b_dto.PedidoRequest;
import com.glcv.pedidos.c_model.Pedido;
import com.glcv.pedidos.e_service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos") // URL base: http://localhost:8081/pedidos
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> crear(@RequestBody PedidoRequest request) {
        Pedido nuevoPedido = pedidoService.crearPedido(request);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        return ResponseEntity.ok(pedidoService.obtenerTodos());
    }
}
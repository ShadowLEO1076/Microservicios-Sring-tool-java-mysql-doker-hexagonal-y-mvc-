package com.glcv.producto.d_presentacion.rest;
import org.springframework.web.bind.annotation.*;
import com.glcv.producto.a_dominio.modelos.Producto;
import com.glcv.producto.a_dominio.puertos.in.ConsultarProductoUseCase;
import com.glcv.producto.a_dominio.puertos.in.CrearProductoUseCase;
import com.glcv.producto.d_presentacion.rest.dto.ProductoRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos") // La URL será: http://localhost:8080/productos
public class ProductoController {

    private final CrearProductoUseCase crearProductoUseCase;
    private final ConsultarProductoUseCase consultarProductoUseCase;

    
    public ProductoController(CrearProductoUseCase crearProductoUseCase, ConsultarProductoUseCase consultarProductoUseCase) {
        this.crearProductoUseCase = crearProductoUseCase;
        this.consultarProductoUseCase = consultarProductoUseCase;
    }

    // POST - Crear Producto
    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody ProductoRequest request) {
        // Convertimos manualmente el Request (JSON) -> al Dominio (Producto)
        Producto productoNuevo = new Producto();
        productoNuevo.setNombre(request.getNombre());
        productoNuevo.setDescripcion(request.getDescripcion());
        productoNuevo.setPrecio(request.getPrecio());
        productoNuevo.setStock(request.getStock());

      
        Producto creado = crearProductoUseCase.crearProducto(productoNuevo);

        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    // GET - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtener(@PathVariable Long id) {
        return consultarProductoUseCase.obtenerProductoPorId(id)
                .map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
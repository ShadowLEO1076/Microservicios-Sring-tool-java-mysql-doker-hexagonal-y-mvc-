package com.glcv.usuario.d_presentacion;



import org.springframework.web.bind.annotation.*;
import com.glcv.usuario.a_dominio.modelo.Usuario;
import com.glcv.usuario.a_dominio.puertos.in.ConsultarUsuarioUseCase;
import com.glcv.usuario.a_dominio.puertos.in.CrearUsuarioUseCase;
import com.glcv.usuario.d_presentacion.dto.UsuarioRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios") // La URL será: http://localhost:8080/productos
public class UsuarioController {

    private final CrearUsuarioUseCase crearUsuarioUseCase;
    private final ConsultarUsuarioUseCase consultarUsuarioUseCase;

    
    public UsuarioController(CrearUsuarioUseCase crearUsuarioUseCase, ConsultarUsuarioUseCase consultarUsuarioUseCase) {
        this.crearUsuarioUseCase = crearUsuarioUseCase;
        this.consultarUsuarioUseCase = consultarUsuarioUseCase;
    }
    // -------------------------------------------------------
    //  AGREGA ESTE MÉTODO PARA QUE EL GET /usuarios FUNCIONE
    // -------------------------------------------------------
    @GetMapping
    public ResponseEntity<String> obtenerTodos() {
        return ResponseEntity.ok("¡HOLA SEMPAY! Si lees esto, el Gateway y el Microservicio funcionan.");
    }

    // POST - Crear 
    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody UsuarioRequest request) {
        
    	Usuario usuarioNuevo = new Usuario();
    	usuarioNuevo.setNombre(request.getNombre());
    	usuarioNuevo.setEmail(request.getEmail());
    	usuarioNuevo.setPassword(request.getPassword());
        

      
        Usuario creado = crearUsuarioUseCase.crearUsuario(usuarioNuevo);

        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }


    // GET - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtener(@PathVariable Long id) {
        return consultarUsuarioUseCase.obtenerUsuarioPorId(id)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
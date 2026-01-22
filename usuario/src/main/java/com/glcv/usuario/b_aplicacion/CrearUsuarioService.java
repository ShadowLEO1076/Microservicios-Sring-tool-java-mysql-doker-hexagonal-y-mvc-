package com.glcv.usuario.b_aplicacion;

import com.glcv.usuario.a_dominio.modelo.Usuario; 
import com.glcv.usuario.a_dominio.puertos.in.CrearUsuarioUseCase;
import com.glcv.usuario.a_dominio.puertos.out.UsuarioRepositorioPort;
import org.springframework.stereotype.Service;

@Service
public class CrearUsuarioService implements CrearUsuarioUseCase {

    private final UsuarioRepositorioPort usuarioRepositoryPort;

    // Constructor Manual
    public CrearUsuarioService(UsuarioRepositorioPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepositoryPort.guardar(usuario);
    }
}
package com.glcv.usuario.a_dominio.puertos.in;


import com.glcv.usuario.a_dominio.modelo.Usuario;

public interface CrearUsuarioUseCase {
    // Fíjate bien en esta línea
    Usuario crearUsuario(Usuario usuario);
}
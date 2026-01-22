package com.glcv.usuario.a_dominio.puertos.in;

import com.glcv.usuario.a_dominio.modelo.Usuario;
import java.util.Optional;

public interface ConsultarUsuarioUseCase {
	// Usamos Optional porque puede que el producto no exista
    Optional<Usuario> obtenerUsuarioPorId(Long id);
	

}

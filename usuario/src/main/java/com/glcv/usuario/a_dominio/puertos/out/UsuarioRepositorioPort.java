package com.glcv.usuario.a_dominio.puertos.out;
import com.glcv.usuario.a_dominio.modelo.Usuario;
import java.util.Optional;

public interface UsuarioRepositorioPort {
	Usuario guardar(Usuario usuario);
    Optional<Usuario> buscarPorId(Long id);

}

package com.glcv.usuario.b_aplicacion;



import com.glcv.usuario.a_dominio.modelo.Usuario;
import com.glcv.usuario.a_dominio.puertos.in.ConsultarUsuarioUseCase;
import com.glcv.usuario.a_dominio.puertos.out.UsuarioRepositorioPort;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ConsultarUsuarioService implements ConsultarUsuarioUseCase {

    private final UsuarioRepositorioPort usuarioRepositoryPort;

    // --- AGREGAMOS ESTE CONSTRUCTOR MANUALMENTE ---
    public ConsultarUsuarioService(UsuarioRepositorioPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }
    // ----------------------------------------------

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepositoryPort.buscarPorId(id);
    }
}
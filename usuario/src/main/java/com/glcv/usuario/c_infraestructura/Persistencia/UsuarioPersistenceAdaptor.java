package com.glcv.usuario.c_infraestructura.Persistencia;




import com.glcv.usuario.a_dominio.modelo.Usuario;
import com.glcv.usuario.a_dominio.puertos.out.UsuarioRepositorioPort;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class UsuarioPersistenceAdaptor implements UsuarioRepositorioPort {

    private final JpaUsuarioRepositorio jpaRepository;
    private final UsuarioMapper mapper;

    // --- CONSTRUCTOR MANUAL (Soluciona el error de "blank final field") ---
    public UsuarioPersistenceAdaptor(JpaUsuarioRepositorio jpaRepository, UsuarioMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }
    // ----------------------------------------------------------------------

    @Override
    public Usuario guardar(Usuario usuario) {
    	UsuarioEntity entity = mapper.toEntity(usuario);
    	UsuarioEntity guardado = jpaRepository.save(entity);
        return mapper.toDomain(guardado);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }
}
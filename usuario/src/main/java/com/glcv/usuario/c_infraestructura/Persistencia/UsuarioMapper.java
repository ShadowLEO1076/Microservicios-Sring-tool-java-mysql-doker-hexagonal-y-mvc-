package com.glcv.usuario.c_infraestructura.Persistencia;

import com.glcv.usuario.a_dominio.modelo.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toDomain(UsuarioEntity entity) {
        if (entity == null) return null;
        return new Usuario(
            entity.getId(),
            entity.getNombre(),
            entity.getEmail(),
            entity.getPassword()
           
        );
    }

    // Convierte del Dominio -> a la Base de Datos
    public UsuarioEntity toEntity(Usuario domain) {
        if (domain == null) return null;
        return new UsuarioEntity(
            domain.getId(),
            domain.getNombre(),
            domain.getEmail(),
            domain.getPassword()

        );
    }
}
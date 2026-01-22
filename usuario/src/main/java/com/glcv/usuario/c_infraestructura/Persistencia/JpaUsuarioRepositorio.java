

package com.glcv.usuario.c_infraestructura.Persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUsuarioRepositorio extends JpaRepository<UsuarioEntity, Long> {
   
}

package com.dev.ruben.apirestayot.repository;

import com.dev.ruben.apirestayot.entity.Comercio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Repositorio de querys para la entidad Comercio
 * @author Rubén
 */
@Repository
public interface ComercioRepository extends JpaRepository<Comercio, Serializable> {
    /**
     * Buscar por id de comercio
     * @param id
     * @return
     */
    public abstract List<Comercio> findById(int id);

    /**
     * Buscar por nombre de comercio
     * @param nombre
     * @return
     */
    public abstract List<Comercio> findByNombre(String nombre);
}

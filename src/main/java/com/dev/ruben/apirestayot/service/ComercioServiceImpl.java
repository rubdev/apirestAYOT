package com.dev.ruben.apirestayot.service;

import com.dev.ruben.apirestayot.converter.ComercioConverter;
import com.dev.ruben.apirestayot.entity.Comercio;
import com.dev.ruben.apirestayot.model.ComercioModel;
import com.dev.ruben.apirestayot.repository.ComercioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio ComercioService
 */
@Service("comercioService")
public class ComercioServiceImpl implements ComercioService {

    @Autowired
    @Qualifier("comercioRepository")
    private ComercioRepository comercioRepository;

    @Autowired
    @Qualifier("comercioConverter")
    private ComercioConverter comercioConverter;


    /**
     * Creación de nuevo Comercio
     * @param comercio
     * @return
     */
    @Override
    public boolean crear(Comercio comercio) {
        try {
            comercioRepository.save(comercio);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Actualización de un Comercio existente
     * @param comercio
     * @return
     */
    @Override
    public boolean actualizar(Comercio comercio) {
        try {
            if (comercio.getId() != 0) {
                // actualizar
            } else {
                // crear
                comercioRepository.save(comercio);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Eliminar Comercio si existe
     * @param nombre
     * @param id
     * @return
     */
    @Override
    public boolean eliminar(String nombre, int id) {
        try {
            List<Comercio> listaComercios = comercioRepository.findByNombreAndId(nombre, id);
            Comercio comercio;
            if (listaComercios.get(0) != null) {
                comercio = listaComercios.get(0);
                comercioRepository.delete(comercio);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Devuelve un listado de Comercios
     * @return
     */
    @Override
    public List<ComercioModel> consultar() {
        return comercioConverter.convertComercio(comercioRepository.findAll());
    }

    /**
     * Devuelve un listado de Comercios filtrados por nombre
     * @return
     */
    @Override
    public List<ComercioModel> consultarPorNombre(String nombre) {
        return comercioConverter.convertComercio(comercioRepository.findByNombre(nombre));
    }
}

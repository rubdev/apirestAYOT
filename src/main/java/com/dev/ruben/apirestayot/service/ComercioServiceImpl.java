package com.dev.ruben.apirestayot.service;

import com.dev.ruben.apirestayot.converter.ComercioConverter;
import com.dev.ruben.apirestayot.entity.Comercio;
import com.dev.ruben.apirestayot.model.ComercioModel;
import com.dev.ruben.apirestayot.repository.ComercioRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio ComercioService
 */
@Service("comercioService")
public class ComercioServiceImpl implements ComercioService {

    private static final Log log = LogFactory.getLog(ComercioConverter.class);

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
        log.info("Se va a crear un nuevo Comercio");
        try {
            comercioRepository.save(comercio);
            return true;
        } catch (Exception e) {
            log.error("Error al crear un Comercio: "+comercio.toString());
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
        log.info("Se va a actualizar un Comercio");
        try {
            if (comercio.getId() != 0) {
                // actualizar
                log.info("El comercio existe, se procede a actualizar: "+comercio.toString());
            } else {
                // crear
                log.info("El comercio no existe, se procede a crear: "+comercio.toString());
                comercioRepository.save(comercio);
            }
            return true;
        } catch (Exception e) {
            log.error("Error al actualizar un Comercio: "+comercio.toString());
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
        log.info("Se va a eliminar un Comercio");
        try {
            List<Comercio> listaComercios = comercioRepository.findByNombreAndId(nombre, id);
            Comercio comercio;
            if (listaComercios.get(0) != null) {
                comercio = listaComercios.get(0);
                comercioRepository.delete(comercio);
            }
            return true;
        } catch (Exception e) {
            log.error("Error al eliminar un Comercio con nombre e id: "+nombre+" - "+id);
            return false;
        }
    }

    /**
     * Devuelve un listado de Comercios
     * @return
     */
    @Override
    public List<ComercioModel> consultar() {
        log.info("Se van a devolver todos los registros de Comercio");
        return comercioConverter.convertComercio(comercioRepository.findAll());
    }

    /**
     * Devuelve un listado de Comercios filtrados por nombre
     * @return
     */
    @Override
    public List<ComercioModel> consultarPorNombre(String nombre) {
        log.info("Se van a devolver los registros de Comercio filtrados por: "+nombre);
        return comercioConverter.convertComercio(comercioRepository.findByNombre(nombre));
    }
}

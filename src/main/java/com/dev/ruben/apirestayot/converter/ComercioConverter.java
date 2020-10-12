package com.dev.ruben.apirestayot.converter;

import com.dev.ruben.apirestayot.entity.Comercio;
import com.dev.ruben.apirestayot.model.ComercioModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("comercioConverter")
public class ComercioConverter {
    private static final Log log = LogFactory.getLog(ComercioConverter.class);
    /**
     * Recibe una lista de entidades Comercio y convierte estas a modelos de Comercio
     * @param comercios
     * @return lista de ComercioModel
     */
    public List<ComercioModel> convertComercio(List<Comercio> comercios) {
        log.info("LLamada a converter");
        List<ComercioModel> listaComerciosModel = new ArrayList<>();
        if (comercios != null && !comercios.isEmpty()) {
            // recorre la lista de comercios y va añadiendo a la de modelos cada elemento
            log.info("Se convierten entidades Comercio a ComercioModel");
            comercios.forEach(comercio -> listaComerciosModel.add(new ComercioModel(comercio)));
        }
        return  listaComerciosModel;
    }
}

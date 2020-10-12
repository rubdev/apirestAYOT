package com.dev.ruben.apirestayot.service;

import com.dev.ruben.apirestayot.entity.Comercio;
import com.dev.ruben.apirestayot.model.ComercioModel;

import java.util.List;

/**
 * Interfaz para el servicio encargado de gestionar peticiones de la entidad Comercio
 * @author Rubén
 */
public interface ComercioService {
    public boolean crear(Comercio comercio);
    public boolean actualizar(Comercio comercio);
    public boolean eliminar(String nombre, int id);
    public List<ComercioModel> consultar();
    public List<ComercioModel> consultarPorNombre(String nombre);
}

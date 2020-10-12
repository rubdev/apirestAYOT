package com.dev.ruben.apirestayot.controller;

import com.dev.ruben.apirestayot.entity.Comercio;
import com.dev.ruben.apirestayot.model.ComercioModel;
import com.dev.ruben.apirestayot.service.ComercioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador encargado de la gestión de Comercio en la api rest
 * @author Rubén
 */
@RestController
@RequestMapping("/comercio")
public class ComercioController {

    @Autowired
    @Qualifier("comercioService")
    ComercioServiceImpl comercioService;

    /**
     * Método encargado de llamar al servicio y hacer la llamada a guardar nuevo Comercio
     * @param comercio
     * @return
     */
    @PostMapping("/nuevo")
    public boolean nuevoComercio(@RequestBody @Validated Comercio comercio) {
        return comercioService.crear(comercio);
    }

    /**
     * Método encargado de llamar al servicio y hacer la llamada para modificar un Comercio
     * @param comercio
     * @return
     */
    @PutMapping("/modificar")
    public boolean modificarComercio(@RequestBody @Validated Comercio comercio) {
        return comercioService.actualizar(comercio);
    }

    /**
     * Método encargado de llamar al servicio y hacer la llamada para eliminar un Comercio
     * @param id
     * @param nombre
     * @return
     */
    @DeleteMapping("/eliminar/{id}/{nombre}")
    public boolean borrarComercio(@PathVariable("id") int id,
                                  @PathVariable("nombre") String nombre) {
        return comercioService.eliminar(nombre, id);
    }

    /**
     * Método encargado de llamar al servicio para obtener todos los registros de Comercio
     * @return
     */
    @GetMapping("obtenerTodos")
    public List<ComercioModel> obtenerTodosComercios() {
        return comercioService.consultar();
    }

}

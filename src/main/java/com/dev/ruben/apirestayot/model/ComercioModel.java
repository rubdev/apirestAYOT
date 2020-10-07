package com.dev.ruben.apirestayot.model;

import com.dev.ruben.apirestayot.entity.Comercio;

import java.util.Objects;

public class ComercioModel {

    private int id;
    private String nombre;
    private String descripcion;
    private String direccion;
    private String telefono;

    /**
     * Default constructor
     */
    public ComercioModel(){ }

    /**
     * Full constructor
     * @param id
     * @param nombre
     * @param descripcion
     * @param direccion
     * @param telefono
     */
    public ComercioModel(int id, String nombre, String descripcion, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * Constructor por entidad comercio
     * @param comercio
     */
    public ComercioModel(Comercio comercio) {
        this.id = comercio.getId();
        this.nombre = comercio.getNombre();
        this.descripcion = comercio.getDescripcion();
        this.direccion = comercio.getDireccion();
        this.telefono = comercio.getTelefono();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Equals method
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComercioModel that = (ComercioModel) o;
        return id == that.id &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(direccion, that.direccion) &&
                Objects.equals(telefono, that.telefono);
    }

    /**
     * hashCode method
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, direccion, telefono);
    }

    /**
     * toString method
     * @return
     */
    @Override
    public String toString() {
        return "ComercioModel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}

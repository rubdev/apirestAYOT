package com.dev.ruben.apirestayot.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Entidad de la tabla comercio
 * @author Rubén
 */
@Table(name = "comercio")
@Entity
public class Comercio implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", length = 10)
    private int id;
    @Column(name = "NOMBRE", length = 50)
    private String nombre;
    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;
    @Column(name = "DIRECCION", length = 50)
    private String direccion;
    @Column(name = "TELEFONO", length = 9)
    private String telefono;

    /**
     * Default constructor
     */
    public Comercio() {}

    /**
     * Full constructor
     * @param id
     * @param nombre
     * @param descripcion
     * @param direccion
     * @param telefono
     */
    public Comercio(int id, String nombre, String descripcion, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * Getters y setters
     */

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
     * equals method
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comercio comercio = (Comercio) o;
        return id == comercio.id &&
                Objects.equals(nombre, comercio.nombre) &&
                Objects.equals(descripcion, comercio.descripcion) &&
                Objects.equals(direccion, comercio.direccion) &&
                Objects.equals(telefono, comercio.telefono);
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
        return "Comercio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}

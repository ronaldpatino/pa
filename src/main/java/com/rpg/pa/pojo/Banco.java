package com.rpg.pa.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Banco implements Serializable {

    private String nombre;

    public Banco() {
    }

    public Banco(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banco banco = (Banco) o;
        return nombre.equals(banco.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString(){
        return this.nombre;
    }
}

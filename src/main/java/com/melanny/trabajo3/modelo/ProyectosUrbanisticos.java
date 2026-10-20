package com.melanny.trabajo3.modelo;

import java.util.ArrayDeque;
import java.util.Deque;

public class ProyectosUrbanisticos {

    private int id;
    private String nombre;
    private String ciudad;
    private double presupuesto;
    private EnumConstruccion tipo;
    private Categoria categoria;
    private Deque<Construccion> construcciones = new ArrayDeque<>();

    public ProyectosUrbanisticos() {
    }

    public ProyectosUrbanisticos(int id, String nombre, String ciudad, double presupuesto,
                                 EnumConstruccion tipo, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.presupuesto = presupuesto;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public void agregarConstruccion(Construccion construccion) {
        construcciones.addLast(construccion);
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public EnumConstruccion getTipo() {
        return tipo;
    }

    public void setTipo(EnumConstruccion tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Deque<Construccion> getConstrucciones() {
        return construcciones;
    }

    public void setConstrucciones(Deque<Construccion> construcciones) {
        this.construcciones = construcciones;
    }
}

package com.melanny.trabajo3.modelo;

import java.util.Stack;
import java.util.function.Function;

public class Construccion {

    private int id;
    private String nombre;
    private String direccion;
    private double areaMetros;
    private double costo;
    private EnumConstruccion tipo;
    private Categoria categoria;

    // Cuenta cuantos obreros trabajaron cada dia de la obra
    private Stack<Integer> conteo = new Stack<>();

    public Construccion() {
    }

    public Construccion(int id, String nombre, String direccion, double areaMetros,
                        double costo, EnumConstruccion tipo, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.areaMetros = areaMetros;
        this.costo = costo;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public void agregarConteo(int obreros) {
        conteo.push(obreros);
    }

    // Recibe la funcion del punto 4 y muestra el total de obreros del objeto
    public int verTotales(Function<Construccion, Integer> funcion) {
        int total = funcion.apply(this);
        System.out.println("Total de obreros de " + nombre + ": " + total);
        return total;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getAreaMetros() {
        return areaMetros;
    }

    public void setAreaMetros(double areaMetros) {
        this.areaMetros = areaMetros;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
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

    public Stack<Integer> getConteo() {
        return conteo;
    }

    public void setConteo(Stack<Integer> conteo) {
        this.conteo = conteo;
    }

    @Override
    public String toString() {
        return "Construccion{id=" + id + ", nombre='" + nombre + "', tipo=" + tipo
                + ", categoria=" + categoria + ", conteo=" + conteo + "}";
    }
}

package com.melanny.trabajo3.repositories;

import java.util.Stack;

import org.springframework.stereotype.Repository;

import com.melanny.trabajo3.modelo.Categoria;
import com.melanny.trabajo3.modelo.Construccion;
import com.melanny.trabajo3.modelo.EnumConstruccion;
import com.melanny.trabajo3.modelo.ProyectosUrbanisticos;

@Repository
public class ConstruccionRepository {

    private final Stack<Construccion> pilaConstrucciones = new Stack<>();
    private final ProyectosUrbanisticos proyecto;

    public ConstruccionRepository() {
        // Los 5 objetos llevan el mismo tipo y la misma categoria
        Construccion c1 = new Construccion(1, "Casa Los Almendros", "Calle 50 #45-12",
                120.5, 185000000, EnumConstruccion.CASA, Categoria.RESIDENCIAL);
        Construccion c2 = new Construccion(2, "Casa Vista Hermosa", "Carrera 48 #30-21",
                95.0, 140000000, EnumConstruccion.CASA, Categoria.RESIDENCIAL);
        Construccion c3 = new Construccion(3, "Casa El Mirador", "Calle 36 #52-08",
                160.0, 250000000, EnumConstruccion.CASA, Categoria.RESIDENCIAL);
        Construccion c4 = new Construccion(4, "Casa Los Cerezos", "Diagonal 55 #40-15",
                80.0, 118000000, EnumConstruccion.CASA, Categoria.RESIDENCIAL);
        Construccion c5 = new Construccion(5, "Casa La Pradera", "Carrera 60 #38-44",
                140.0, 205000000, EnumConstruccion.CASA, Categoria.RESIDENCIAL);

        // Obreros que trabajaron cada dia (datos del Stack conteo)
        c1.agregarConteo(4);
        c1.agregarConteo(6);
        c1.agregarConteo(5);

        c2.agregarConteo(3);
        c2.agregarConteo(3);

        c3.agregarConteo(8);
        c3.agregarConteo(10);
        c3.agregarConteo(7);
        c3.agregarConteo(9);

        c4.agregarConteo(2);

        c5.agregarConteo(5);
        c5.agregarConteo(6);
        c5.agregarConteo(6);
        c5.agregarConteo(4);
        c5.agregarConteo(5);

        pilaConstrucciones.push(c1);
        pilaConstrucciones.push(c2);
        pilaConstrucciones.push(c3);
        pilaConstrucciones.push(c4);
        pilaConstrucciones.push(c5);

        proyecto = new ProyectosUrbanisticos(1, "Ciudadela Bello Horizonte", "Bello, Antioquia",
                1500000000, EnumConstruccion.CASA, Categoria.RESIDENCIAL);

        proyecto.agregarConstruccion(c1);
        proyecto.agregarConstruccion(c2);
        proyecto.agregarConstruccion(c3);
        proyecto.agregarConstruccion(c4);
        proyecto.agregarConstruccion(c5);
    }

    public Stack<Construccion> getPilaConstrucciones() {
        return pilaConstrucciones;
    }

    public ProyectosUrbanisticos getProyecto() {
        return proyecto;
    }
}

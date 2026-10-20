package com.melanny.trabajo3.controlador;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.melanny.trabajo3.modelo.Construccion;
import com.melanny.trabajo3.modelo.EnumConstruccion;
import com.melanny.trabajo3.modelo.ProyectosUrbanisticos;
import com.melanny.trabajo3.repositories.ConstruccionRepository;

@Controller
public class ConstruccionController {

    @Autowired
    private ConstruccionRepository repositorio;

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    // PUNTO 1: los 5 objetos, el Stack y el proyecto con su Deque
    @GetMapping("/punto1")
    public String punto1(Model model) {
        model.addAttribute("pila", repositorio.getPilaConstrucciones());
        model.addAttribute("proyecto", repositorio.getProyecto());
        return "punto1";
    }

    // PUNTO 2: ListIterator sobre el Stack e Iterator sobre el Deque
    @GetMapping("/punto2")
    public String punto2(Model model) {
        Stack<Construccion> pila = repositorio.getPilaConstrucciones();
        List<Construccion> recorridoPila = new ArrayList<>();

        ListIterator<Construccion> listIterator = pila.listIterator();
        while (listIterator.hasNext()) {
            recorridoPila.add(listIterator.next());
        }

        Deque<Construccion> deque = repositorio.getProyecto().getConstrucciones();
        List<Construccion> recorridoDeque = new ArrayList<>();

        Iterator<Construccion> iterator = deque.iterator();
        while (iterator.hasNext()) {
            recorridoDeque.add(iterator.next());
        }

        model.addAttribute("recorridoPila", recorridoPila);
        model.addAttribute("recorridoDeque", recorridoDeque);
        model.addAttribute("proyecto", repositorio.getProyecto());
        return "punto2";
    }

    // PUNTO 3: programacion funcional sobre el Deque, filtrando por un enum
    @GetMapping("/punto3")
    public String punto3(Model model) {
        // Stack convertido a Deque
        Deque<Construccion> dequeDesdePila = new ArrayDeque<>(repositorio.getPilaConstrucciones());

        ProyectosUrbanisticos proyecto = repositorio.getProyecto();
        EnumConstruccion tipoBuscado = EnumConstruccion.CASA;

        List<Construccion> filtradas = proyecto.getConstrucciones()
                .stream()
                .filter(c -> c.getTipo() == tipoBuscado)
                .toList();

        // Tambien se imprimen en consola con forEach
        filtradas.forEach(c -> System.out.println(c));

        model.addAttribute("tipoBuscado", tipoBuscado);
        model.addAttribute("filtradas", filtradas);
        model.addAttribute("tamanoDeque", dequeDesdePila.size());
        model.addAttribute("proyecto", proyecto);
        return "punto3";
    }

    // PUNTO 4: Function<T,R> que suma los datos del Stack conteo
    @GetMapping("/punto4")
    public String punto4(Model model) {
        Function<Construccion, Integer> sumarConteo = construccion -> {
            int suma = 0;
            for (int dato : construccion.getConteo()) {
                suma += dato;
            }
            return suma;
        };

        List<Construccion> construcciones = repositorio.getPilaConstrucciones();
        List<Integer> totales = new ArrayList<>();
        for (Construccion c : construcciones) {
            totales.add(sumarConteo.apply(c));
        }

        model.addAttribute("construcciones", construcciones);
        model.addAttribute("totales", totales);
        return "punto4";
    }

    // PUNTO 5: un objeto llama a verTotales pasandole la funcion del punto 4
    @GetMapping("/punto5")
    public String punto5(Model model) {
        Function<Construccion, Integer> sumarConteo = construccion -> {
            int suma = 0;
            for (int dato : construccion.getConteo()) {
                suma += dato;
            }
            return suma;
        };

        Construccion elegida = repositorio.getPilaConstrucciones().firstElement();
        int total = elegida.verTotales(sumarConteo);

        model.addAttribute("construccion", elegida);
        model.addAttribute("total", total);
        return "punto5";
    }
}

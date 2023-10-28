package org.bedu.java.jse.basico.modelo;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class ListaTareas implements Serializable {
    private String nombre;
    private final LocalDate fechadeCreacion;
    private final List<Tarea> tareas = new ArrayList<>();
    public ListaTareas(String nombre) {
        this.nombre = nombre;
        fechadeCreacion = LocalDate.now();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void agregaTarea(Tarea tarea) {
        tareas.add(tarea);
    }
    public Tarea eliminaTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            return tareas.remove(indice);
        } else {
            System.out.println("La tarea indicada no se encuentra en la lista.");
            return null;
        }
    }
    public List<Tarea> getTareas() {
        return tareas;
    }
    public int numeroTareas() {
        return tareas.size();
    }
    public void muestraTareas() {
        for (int i = 0; i < tareas.size(); i++) {
            Tarea tarea = tareas.get(i);
            String realizado = tarea.isRealizado() ? "█" : " ";
            String fechadeRealizacion = tarea.isRealizado() ? tarea.getFechadeRealizacion().toString() : "";
            System.out.println((i + 1) + " - " + tarea.getNombre() + "[" + realizado + "] " + fechadeRealizacion);
        }
    }
    public LocalDate getFechadeCreacion() {
        return fechadeCreacion;
    }
}
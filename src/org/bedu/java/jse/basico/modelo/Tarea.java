package org.bedu.java.jse.basico.modelo;
import java.io.Serializable;
import java.time.LocalDate;
public class Tarea implements Serializable {
    private String nombre;
    private final LocalDate fechadeCreacion;
    private LocalDate fechadeExpiracion;
    private boolean realizado;
    private LocalDate fechadeRealizacion;
    public Tarea(String nombre, LocalDate fechadeRealizacion) {
        this.nombre = nombre;
        this.fechadeRealizacion = fechadeRealizacion;
        this.realizado = false;
        this.fechadeCreacion = LocalDate.now();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalDate getFechadeCreacion() {
        return fechadeCreacion;
    }
    public LocalDate getFechadeExpiracion() {
        return fechadeExpiracion;
    }
    public void setFechadeExpiracion(LocalDate fechadeExpiracion) {
        this.fechadeExpiracion = fechadeExpiracion;
    }
    public boolean isRealizado() {
        return realizado;
    }
    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }
    public LocalDate getFechadeRealizacion() {
        return fechadeRealizacion;
    }
    public void setFechadeRealizacion(LocalDate fechadeRealizacion) {
        this.fechadeRealizacion = fechadeRealizacion;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return nombre.equals(tarea.nombre);
    }
    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
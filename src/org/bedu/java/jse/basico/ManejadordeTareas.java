package org.bedu.java.jse.basico;
import org.bedu.java.jse.basico.modelo.ListaTareas;
import org.bedu.java.jse.basico.modelo.Tarea;
import java.time.LocalDate;
public class ManejadordeTareas {
    private final Lector lector = new Lector();
    public Tarea nuevaTarea(){
        System.out.println("Nueva Tarea");
        System.out.println("Ingresa la información de la nueva tarea: ");
        System.out.print("Nombre: ");
        String nombredelaTarea = lector.leerCadena();
        LocalDate fechadeRealizacion = LocalDate.now();  // Obtener la fecha actual
        return new Tarea(nombredelaTarea, fechadeRealizacion);  // Proporcionar ambos argumentos al constructor de Tarea
    }
    public Tarea eliminarTarea(ListaTareas listaTareas){
        System.out.println("Eliminar tarea");
        System.out.println("Indica el índice de la tarea que quieres eliminar: ");
        byte indice = lector.leerOpcion();
        if (indice > listaTareas.numeroTareas()){
            System.out.println("La tarea que indicaste no existe.");
            return null;
        }
        return listaTareas.eliminaTarea(indice - 1);
    }
    public Tarea marcarTareaFinalizada(ListaTareas listaTareas) {
        System.out.println("Finalizar tarea");
        System.out.println("Indica el índice de la tarea a marcar");
        byte indice = lector.leerOpcion();
        if (indice > listaTareas.numeroTareas()) {
            System.out.println("La tarea indicada no existe.");
            return null;
        }
        Tarea tarea = listaTareas.getTareas().get(indice - 1);
        tarea.setFechadeRealizacion(LocalDate.now());
        tarea.setRealizado(true);
        return tarea;
    }
}
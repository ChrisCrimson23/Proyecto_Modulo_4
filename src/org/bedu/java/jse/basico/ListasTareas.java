package org.bedu.java.jse.basico;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.bedu.java.jse.basico.modelo.ListaTareas;
import org.bedu.java.jse.basico.modelo.Tarea;
import org.bedu.java.jse.basico.ManejadordeTareas;
public class ListasTareas {
    private Menu menu = new Menu();
    private ManejadordeTareas tareas = new ManejadordeTareas();
    private Lector lector = new Lector();
    private List<ListaTareas> listasTareas = new ArrayList<>();
    private static final String NOMBRE_ARCHIVO = System.getProperty("user.home") + "/.tareas";
    public void crearNuevaLista() {
        System.out.println("Crear nueva lista de tareas");
        System.out.print("Ingresa el nombre de la lista de tareas: ");
        String nombreLista = lector.leerCadena();
        ListaTareas nuevaLista = new ListaTareas(nombreLista);
        listasTareas.add(nuevaLista);
        System.out.println("Lista de tareas creada con éxito: " + nombreLista);
    }
    public void verListaTareas() {
        System.out.println("Ver listas de tareas.");
        if (!validaExistenciaLista()) {
            return;
        }
        for (int i = 0; i < listasTareas.size(); i++) {
            System.out.printf("%d - %s%n", (i + 1), listasTareas.get(i).getNombre());
        }
    }
    public void verTareasDeLista() {
        System.out.println("Ver tareas de lista.");
        byte indice = validaIndice();
        if (indice == 0) {
            return;
        }
        ListaTareas lista = listasTareas.get(indice - 1);
        if (lista.numeroTareas() == 0) {
            System.out.println("Aún no hay tareas en la lista.");
        } else {
            lista.muestraTareas();
        }
    }
    public void actualizarListaDeTareas() {
        System.out.println("Actualizar lista de tareas.");
        byte indice = validaIndice();
        if (indice == 0) {
            return;
        }
        ListaTareas listaActual = listasTareas.get(indice - 1);
        byte opcionSeleccionada;
        do {
            menu.muestradeOpcionesdeTareas();
            opcionSeleccionada = lector.leerOpcion();
            switch (opcionSeleccionada) {
                case 1:
                    Tarea nuevaTarea = tareas.nuevaTarea();
                    listaActual.agregaTarea(nuevaTarea);
                    break;
                case 2:
                    Tarea tarea1 = tareas.eliminarTarea(listaActual);
                    if (tarea1 != null) {
                        System.out.printf("Se eliminó la tarea: %s%n", tarea1.getNombre());
                    } else {
                        System.out.println("No se puede eliminar la tarea.");
                    }
                    break;
                case 3:
                    Tarea tarea2 = tareas.marcarTareaFinalizada(listaActual);
                    if (tarea2 != null) {
                        System.out.printf("La tarea %s se completó el %2$te de %2$tB de %2$tY%n", tarea2.getNombre(), tarea2.getFechadeCreacion());
                    } else {
                        System.out.println("La tarea no puede ser marcada como terminada.");
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción no reconocida.");
            }
        } while (opcionSeleccionada != 4);
    }
    public void eliminarListaDeTareas() {
        System.out.println("Eliminar lista de tareas.");
        byte indice = validaIndice();
        if (indice == 0) {
            return;
        }
        ListaTareas listaEliminada = listasTareas.remove(indice - 1);
        System.out.printf("Se eliminó la lista de tareas: %s%n", listaEliminada.getNombre());
    }
    public void cargaTareas() throws Exception {
        if (new File(NOMBRE_ARCHIVO).exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO));
            listasTareas = (List<ListaTareas>) ois.readObject();
            ois.close();
        }
    }
    public void guardarTareas() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO));
        oos.writeObject(listasTareas);
        oos.close();
    }
    private boolean validaExistenciaLista() {
        if (listasTareas.isEmpty()) {
            System.out.println("Aún no se ha creado ninguna lista de tareas.");
            return false;
        }
        return true;
    }
    private byte validaIndice() {
        byte indice = 0;
        if (!validaExistenciaLista()) {
            return indice;
        }
        System.out.println("Indique el índice de la lista de tareas.");
        indice = lector.leerOpcion();
        if (indice > listasTareas.size() || indice < 1) {
            System.out.println("No existen listas de tareas en el índice seleccionado.");
            indice = 0;
        }
        return indice;
    }
}
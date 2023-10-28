package org.bedu.java.jse.basico;

public class TareasMain {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Lector lector = new Lector();
        ListasTareas lista = new ListasTareas();
        byte opcionSeleccionada = 0;
        do {
            menu.muestradeOpciones();
            opcionSeleccionada = lector.leerOpcion();
            System.out.printf("%n%nLa opción seleccionada es: %d%n", opcionSeleccionada);
            switch (opcionSeleccionada) {
                case 1:
                    lista.crearNuevaLista();
                    break;
                case 2:
                    lista.verListaTareas();
                    break;
                case 3:
                    lista.verTareasDeLista();
                    break;
                case 4:
                    lista.actualizarListaDeTareas();
                    break;
                case 5:
                    lista.eliminarListaDeTareas();
                    break;
                case 6:
                    try {
                        lista.guardarTareas();
                        System.out.println("Guardando y saliendo de la aplicación.");
                    } catch (Exception e) {
                        System.out.println("Error al guardar las tareas: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Opción desconocida.");
            }
        } while (opcionSeleccionada != 6);
    }
}

package org.bedu.java.jse.basico;
import java.util.Scanner;
public class Lector {
    private Scanner scanner = new Scanner(System.in);
    public byte leerOpcion(){
        System.out.println("Opción: ");
        return scanner.nextByte();
        }
    public String leerCadena() {
        System.out.print("Cadena: ");
        scanner.nextLine();
        return scanner.nextLine().trim();
    }
}

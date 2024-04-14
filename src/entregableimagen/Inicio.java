/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//NICOLA  BODNAR YUZYFISHYN 
//DAYLTO BRAVO TINTE
package entregableimagen;

//import static entregableimagen.PGMFileDouble.sc;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author daylto
 */
public class Inicio {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        PGMFileDouble pgm = null;
        String opcion = "";
        String nombreFichero = "";
        boolean cargaCorrecta = false;
        do {
            System.out.println("Introduce el nombre y ruta del fichero: ");
            nombreFichero = sc.nextLine();
            try {
                pgm = new PGMFileDouble(nombreFichero);
                cargaCorrecta = true;
            } catch (NumberFormatException e) {
                System.out.println("Formato del fichero incorrecto");
            } catch (Exception e) {
                System.out.println("Se ha producido un error inesperado al abrir el fichero");
            }
        } while (!cargaCorrecta);
        menu(pgm);
    }
    public static void menu(PGMFileDouble pgm) throws IOException {
        String opcion;
        do {
            System.out.println("-------------------------");
            opciones();
            System.out.println("-------------------------\nEscoje una opcion: ");
            opcion = sc.nextLine();
            if (!opcion.equalsIgnoreCase("S")) {
                if (opcion.equals("1")) {
                    pgm.filtroGirarIzquierda();
                } else if (opcion.equals("2")) {
                    pgm.filtroGirarDerecha();
                } else if (opcion.equals("3")) {
                    pgm.filtroFlipHorizontal();
                } else if (opcion.equals("4")) {
                    pgm.filtroFlipVertical();
                } else if (opcion.equals("5")) {
                    pgm.filtroObtenerNegativo();
                } else if (opcion.equals("7")) {
                    pgm.imprimir();
                } else if (opcion.equalsIgnoreCase("G")) {
                    System.out.println("Escriba ruta y nombre del nuevo fichero: ");
                    System.out.println("Ejemplo --> home/usr/Escritorio/nombreFichero O ./nombreFichero");
                    String nombreArch = sc.nextLine();
                    pgm.guardarFichero(nombreArch);
                }
            }

        } while (!opcion.equalsIgnoreCase("S"));
    }

    public static void opciones() {
        System.out.println(
                "1. Para aplicar filtro girar izquierda." + "\n"
                + "2. Para aplicar filtro girar derecha." + "\n"
                + "3. Para aplicar filtro flip horizontal." + "\n"
                + "4. Para aplicar filtro flip vertical." + "\n"
                + "5. Para aplicar filtro obtener negativo." + "\n"
                + "7. Para imprimir" + "\n"
                + "G. Para guardar fichero." + "\n"
                + "S. Para salir.");
    }

}

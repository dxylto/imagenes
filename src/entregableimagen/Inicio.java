/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//NICOLA  BODNAR YUZYFISHYN 
//DAYLTO BRAVO TINTE
package entregableimagen;
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
        do{
            System.out.println("Introduce el nombre y ruta del fichero: ");
            nombreFichero = sc.nextLine();
            try{
                pgm = new PGMFileDouble(nombreFichero);
                cargaCorrecta = true;
            } 
            catch (NumberFormatException e) {
                System.out.println("Formato del fichero incorrecto");
            }            
            catch (Exception e) {
                System.out.println("Se ha producido un error inesperado al abrir el fichero");
            }
        }while(!cargaCorrecta); 
            
        menu(pgm);
    }
    public static void menu(PGMFileDouble pgm) throws IOException { //arreglar menu
        String opcion;
        do {
            opciones();
            System.out.println("-------------------------\nEscoje una opcion: ");
            opcion = sc.nextLine();
            if (!opcion.equalsIgnoreCase("S")) {
                if (opcion.equals("1")) {
                    pgm.girarIzquierda();
                } else if (opcion.equals("2")) {
                    pgm.girarDerecha();
                } else if (opcion.equals("3")) {
                    pgm.girarHorizontal();
                } else if (opcion.equals("4")) {
                    pgm.girarVertical();
                } else if (opcion.equals("5")) {
                    pgm.filtroNegativo();
                } 
                else if (opcion.equals("7")){
                    pgm.imprimir();
                }
                else if (opcion.equalsIgnoreCase("G")) {
                    pgm.guardarFichero();
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
                + "6. Para aplicar filtro obtener filtro caja." + "\n"
                + "7. Para imprimir"+"\n"
                + "G. Para guardar fichero. Por favor, introduce el nombre del fichero donde quieres guardar la imagen." + "\n"
                + "S. Para salir.");
    }

    

    
}

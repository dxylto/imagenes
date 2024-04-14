/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entregableimagen;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daylto
 */
public class EntregableImagen {
    private String ruta;
    private int alto;
    private int ancho;
    private double blancoAbs;
    private double [][] pixeles;    
    static Scanner sc = new Scanner(System.in);
    public EntregableImagen(String ruta) {
        

        Scanner scFile = null;

        File f = new File(ruta);
        try{
            scFile = new Scanner(f);
            System.out.println("antes del p2");
            String numero = scFile.nextLine();
            if (!numero.equals("P2")) {
                throw new IOException("No es un archivo PGM válido.");
            }
            String lineaImg = scFile.nextLine();
            String arr[] =  scFile.nextLine().split(" ");         
            System.out.println(arr[0]);
            System.out.println(arr[1]);
            int num = Integer.parseInt(arr[0]);
            this.ancho =  num;           
            this.alto = Integer.parseInt(arr[1]);
            System.out.println("3");
            this.blancoAbs = Double.parseDouble(scFile.nextLine());
            System.out.println("antes del while");
            String [] pixel;
            String linea;
            double pasar [] = new double[this.alto*this.ancho];
            this.pixeles = new double[this.alto][this.ancho];
            int j = 0;
            System.out.println("antes del while");
            for (int i = 0; i < this.alto; i++) {
                for (int k = 0; k < this.ancho; k++) {
                    this.pixeles[i][j] = scFile.nextInt();
                }
            }
        }catch(IOException e){
                System.out.println("error");
        }
        finally {
            if (scFile != null) scFile.close();            
           }
    }
    public void filtroCaja() {

    }
    public void girarIzquierda()  { //ARREGLAR
        int tmp;
        tmp = this.ancho;
        this.ancho = this.alto; //PREGUNTAR ESTO MAÑANA A RIESGO
        this.alto = tmp;
        double[][] imagenIzq = new double[this.alto][this.ancho]; // ancho, alto y pixeles los saco de las variables que tenemos en el la clase PGMFileDouble.java
        for (int i = 0; i < this.alto; i++) {       
            for (int j = 0; j < this.ancho; j++) {
               imagenIzq[i][j] =  this.pixeles[this.alto - j ][i]; // con esto hacemos que la imagen gire a la izquierda, en el caso de girar a la derecha lo haremos al reves. ya lo veremos
            }
        }
        this.pixeles = new double[this.alto][this.ancho];
        this.pixeles = imagenIzq; 
    }
    public void girarDerecha() { //ARREGLAR
        int tmp;
        tmp = this.ancho;
        this.ancho = this.alto;
        this.alto = tmp;
        double[][] imagenDrch = new double[this.alto][this.ancho];         
        for (int i = 0; i < this.alto; i++) {
            for (int j = 0; j < this.ancho; j++) {    
               imagenDrch[this.alto - i - 1][j] = this.pixeles[i][j]; 
            }
        }
        this.pixeles = new double[this.alto][this.ancho];
        this.pixeles = imagenDrch; // esto si queremos girar la imagen original ( creo que no)
    }

    

    public void girarHorizontal()  {
        double horizontal[][] = new double[this.alto][this.ancho];       
        for (int i = 0; i < this.pixeles.length; i++) {
            for (int j = this.pixeles.length; j > 0; j--) {
                horizontal[i][j] = this.pixeles[i][j];
            }
        }
        //this.pixeles = new double[this.alto][this.ancho];
        this.pixeles = horizontal;
    }

    public void girarVertical() {
        double[][] vertical = new double[this.alto][this.ancho];
        
        int k = 0, n = 0;
        for (int i = this.pixeles.length; i >0; i--) {
            n = 0;
            for (int j = this.pixeles.length; j > 0; j--) {
                vertical[k][n] = this.pixeles[i][j];
                n++;
            }
            k++;
        }
        //this.pixeles = new double[this.alto][this.ancho];
        this.pixeles = vertical;
    }

    public void filtroNegativo() {          
         for (int i = 0; i < this.pixeles.length; i++) {
             for (int j = 0; j < this.pixeles.length; j++) {
                this.pixeles[i][j] = this.blancoAbs -pixeles[i][j];
             }
        }          
    }
    public void guardarFichero() {
        System.out.println("Escriba ruta y nombre del nuevo fichero: ");
        System.out.println("Ejemplo --> home/usr/Escritorio/nombreFichero O ./nombreFichero");
        String nombreArch = sc.nextLine();
        int num;
       FileWriter wt = null;

        try{
            wt = new FileWriter(nombreArch);
            for (int i = 0; i < pixeles.length ; i++) {
                for (int j = 0; j < pixeles.length; j++) {                   
                    wt.write((int) pixeles[i][j]);
                }
            }
            
        }catch(IOException e){
            System.out.println("error");
        }
    }
    public void imprimir(){
        for (int i = 0; i < this.alto; i++) {
            for (int j = 0; j < this.ancho; j++) {
                System.out.print(pixeles[i][j]+" ");
            }
            System.out.println();
        }
    }
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public double getBlancoAbs() {
        return blancoAbs;
    }

    public void setBlancoAbs(double blancoAbs) {
        this.blancoAbs = blancoAbs;
    }

    public double[][] getPixeles() {
        return pixeles;
    }

    public void setPixeles(double[][] pixeles) {
        this.pixeles = pixeles;
    }
      
}

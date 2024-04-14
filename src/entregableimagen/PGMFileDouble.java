/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregableimagen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author daylto
 */
public class PGMFileDouble {
   private String ruta;
    private int alto;
    private int ancho;
    private double blancoAbs;
    private double [][] pixeles; 
    private String lineaImg;
    static Scanner sc = new Scanner(System.in);
    public PGMFileDouble(String ruta) {
        Scanner scFile = null;
        File f;
        
        try {
            scFile = new Scanner(f = new File(ruta));
            String numero = scFile.nextLine();
            if (!numero.equals("P2")) {
                throw new IOException("No es un archivo PGM válido.");
            }
            this.lineaImg = scFile.nextLine();
            this.ancho = scFile.nextInt();
            this.alto = scFile.nextInt();
            this.blancoAbs = scFile.nextInt();
            this.pixeles = new double[this.alto][this.ancho];
            for (int i = 0; i < this.alto; i++) {
                for (int j = 0; j < this.ancho; j++) {
                    this.pixeles[i][j] = scFile.nextInt();
                }
            }
//            for (int i = 0; i < alto; i++) {
//                for (int j = 0; j < ancho; j++) {
//                    System.out.print(pixeles[i][j]+ " ");
//                }
//                System.out.println();
//            }
        while(scFile.hasNextLine()){
         String  linea = scFile.nextLine();         
        }
        }catch(IOException e){
            System.out.println("error");
        }finally{
                if(scFile != null) scFile.close();

        }       
    }
    
    public void filtroCaja() {

    }
    public void girarIzquierda()  { //ARREGLADO
        
        double[][] imagenIzq = new double[this.ancho][this.alto]; // ancho, alto y pixeles los saco de las variables que tenemos en el la clase PGMFileDouble.java
        for (int i = 0; i < this.ancho; i++) {       
            for (int j = 0; j < this.alto; j++) {
               imagenIzq[i][j] =  this.pixeles[j][this.ancho - i -1]; // con esto hacemos que la imagen gire a la izquierda, en el caso de girar a la derecha lo haremos al reves. ya lo veremos
            }
        }
        
        int tmp = this.ancho;
        this.ancho = this.alto; 
        this.alto = tmp;
       // this.pixeles = new double[this.alto][this.ancho];
        this.pixeles = imagenIzq; 
    }
    public void girarDerecha() { //ARREGLADO
        
        double[][] imagenDrch = new double[this.ancho][this.alto];         
        for (int i = 0; i < this.ancho; i++) {
            for (int j = 0; j < this.alto; j++) {    
               imagenDrch[i][j] = this.pixeles[this.alto - j - 1][i]; 
            }
        } 
        int tmp = this.ancho;
        this.ancho = this.alto;
        this.alto = tmp;
       // this.pixeles = new double[this.alto][this.ancho];
        this.pixeles = imagenDrch; // esto si queremos girar la imagen original ( creo que no)
    }

    

    public void girarHorizontal()  {
        double horizontal[][] = new double[this.alto][this.ancho];  
        int k;
        for (int i = 0; i < this.alto; i++) {
            k = 0;
            for (int j = this.ancho -1; j > 0; j--) {
                horizontal[i][k] = this.pixeles[i][j];
                k++;
            }
        }
        //this.pixeles = new double[this.alto][this.ancho];
        this.pixeles = horizontal;
    }

    public void girarVertical() {
        double[][] vertical = new double[this.alto][this.ancho];
        
        int k = 0, n = 0;
        for (int i = this.alto -1; i > 0; i--) {
            n = 0;
            for (int j = this.ancho -1; j > 0; j--) {
                vertical[k][n] = this.pixeles[i][j];
                n++;
            }
            k++;
        }
        //this.pixeles = new double[this.alto][this.ancho];
        this.pixeles = vertical;
    }

    public void filtroNegativo() {   //PREGUNTAR A JAIME        
        for (int i = 0; i < alto; i++) {
             for (int j = 0; j < ancho; j++) {
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
            for (int i = 0; i < alto ; i++) {
                for (int j = 0; j < ancho; j++) {                   
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
                System.out.print(this.pixeles[i][j]+" ");
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

    public String getLineaImg() {
        return lineaImg;
    }

    public void setLineaImg(String lineaImg) {
        this.lineaImg = lineaImg;
    }
    
}
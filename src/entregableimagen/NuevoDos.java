/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregableimagen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author daylto
 */
public class NuevoDos {
    private String ruta;
    private int alto;
    private int ancho;
    private double blancoAbs;
    private double [][] pixeles;    
    static Scanner sc = new Scanner(System.in);
    public void NuevoDos(String ruta) {
        ruta = "/home/daylto/Escritorio/img/imagen.pgm";
        try(BufferedReader rd = new BufferedReader(new FileReader(ruta))){
        String numero = rd.readLine();
        if (!numero.equals("P2")) {
                throw new IOException("No es un archivo PGM válido.");
            }
        String linea = rd.readLine();
        String dimensiones = rd.readLine();
        String arr [] = dimensiones.split(" ");
        this.ancho = Integer.parseInt(arr[0]);
        this.alto = Integer.parseInt(arr[1]);
        int it = 0;
        this.blancoAbs = Integer.parseInt(rd.readLine());  
        //String linea;      
        double [] pixel = new double[ancho*alto];
        this.pixeles = new double[this.alto][this.ancho];
        while((linea = rd.readLine()) != null){
              arr = linea.split(" ");
              for (int i = 0; i < arr.length; i++) {
                if(!arr[i].isEmpty()){
                double valor = Double.parseDouble(arr[i]);               
                pixel[it] = valor;
                }
              //  System.out.println(pixel[contador]);                
            }
        }
        rd.close();
        it = 0;
            for (int i = 0; i < this.pixeles.length; i++) {
                for (int j = 0; j < this.pixeles.length; j++) {
                    this.pixeles[i][j] = pixel[it];
                }
            }
        }catch(IOException e){
            System.out.println("error");
           
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

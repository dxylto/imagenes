/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregableimagen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author daylto
 */
public class guardar {
    public static void main(String[] args) {
        Scanner scFile = null;
        File f ;
        
        try {
            scFile = new Scanner(f = new File("/home/daylto/Escritorio/img/imagen.pgm"));
            String numero = scFile.nextLine();
            if (!numero.equals("P2")) {
                throw new IOException("No es un archivo PGM válido.");
            }
            String lineaImg = scFile.nextLine();
            int ancho = scFile.nextInt();
            int alto = scFile.nextInt();
            double blancoAbs = scFile.nextInt();
            double[][] pixeles = new double[alto][ancho];
            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                    pixeles[i][j] = scFile.nextInt();
                }
            }
            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                    System.out.print(pixeles[i][j]+ "");
                }
                System.out.println();
            }
        while(scFile.hasNextLine()){
         String  linea = scFile.nextLine();         
        }
        }catch(IOException e){
            System.out.println("error");
        }finally{
                if(scFile != null) scFile.close();

        }
        
        
    }
}

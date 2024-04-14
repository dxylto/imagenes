/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregableimagen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author daylto
 */
public class nuevo {
    public static void main(String[] args) throws IOException {
        String fichero = "/home/daylto/Escritorio/img/imagen.pgm";
        Scanner scFile = null;
        File f = new File(fichero);
        try{
            scFile = new Scanner(f);
            int i = 0;
            String linea[];
            double[]arr = new double[24*7];
            String numero = scFile.nextLine();
            if (!numero.equals("P2")) {
                throw new IOException("No es un archivo PGM válido.");
            }
            String segunLin = scFile.nextLine();
            while(scFile.hasNextLine()){
                linea = scFile.nextLine().split(" ");
                for (int j = 0; j < linea.length; j++) {
                   arr[i] = Double.parseDouble(linea[j]);
                }
                i++;
            }
            for (int j = 0; j < arr.length; j++) {
                System.out.println(arr[j]);
            }
        }catch(FileNotFoundException e){
            System.out.println("error");
            e.printStackTrace();
        }
    }
}
/*    public  PGMFileDouble(String ruta) {
        //ruta = "/home/daylto/Escritorio/img/imagen.pgm";
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
        double valor;
        double [] pixel = new double[this.ancho*this.alto];
        this.pixeles = new double[this.alto][this.ancho];
        while((linea = rd.readLine()) != null){
              arr = linea.split(" ");
              for (int i = 0; i < arr.length; i++) {
                if(!arr[i].isEmpty()){
                    valor = Double.parseDouble(arr[i]);               
                    pixel[it] = valor;
                    it++;
                }
                System.out.println(pixel[it]);                
            }
        }
            System.out.println("-------------------------------------------------------");
        rd.close();
       int n = 0;
            for (int i = 0; i < (pixel.length/this.ancho) ; i++) {
                for (int j = 0; j < (pixel.length/this.alto); j++) {
                    
                    valor = pixel[it];
                    System.out.print("valor ---> "+valor+"  pixel ---> "+pixel[it]);
                    this.pixeles[i][j] = valor;
                    it++;
                }
                System.out.println();
            }
        }catch(IOException e){
            System.out.println("error");          
        }
}*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aeropuerto;

import Control.ControlVuelo;
import java.util.Scanner;

/**
 *
 * @author User1
 */
public class Aeropuerto {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectorConsola = new Scanner(System.in);
        System.out.print("Ciudad origen:");
        String origen= lectorConsola.next();
		
        System.out.print("Ciudad destino:");
        String destino= lectorConsola.next();

        ControlVuelo controlVuelo=new ControlVuelo();
        String vuelos=controlVuelo.infoVuelos(origen,destino).toString();
        System.out.println(vuelos);    

        

    }
    
}
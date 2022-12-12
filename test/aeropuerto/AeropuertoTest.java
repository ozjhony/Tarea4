/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package aeropuerto;

import Control.ControlVuelo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AeropuertoTest {

    
    //Test existe origen-destino
    @Test
    public void testTrue() {
        String origen = "Manizales";
        String destino = "Medellin";

        String resultado = "[{estado=Rutas, info=Se encontraron las siguientes rutas}, {precio=95000.0, duracion=1.5, origen=Manizales, destino=Medellin, escala=no}]";
        ControlVuelo controlVuelo = new ControlVuelo();
        String vuelos = controlVuelo.infoVuelos(origen, destino).toString();
        assertTrue(resultado.equals(vuelos));
    }
    
     //Test no existe origen-destino
    @Test
    public void testFalse() {
        String origen = "Ms";
        String destino = "Md";

        String resultado = "[{estado=Sin origen/destino, info=El origen o destino no existen}]";
        ControlVuelo controlVuelo = new ControlVuelo();
        String vuelos = controlVuelo.infoVuelos(origen, destino).toString();
        assertTrue(resultado.equals(vuelos));
    }
    
   
}

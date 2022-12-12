/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author User1
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Clase que tiene un metodo para leer un JSON y usar los datos en otras clases
 */
public class LectorJson {

    public LectorJson() {
    }

    /**
     * Metodo que se encarga de procesar el JSON de vuelos de una ruta
     * especifica y lo convierte en una lista de vuelos
     *
     * @param ruta del Json
     * @return una lista de vuelos
     */
    public List<Vuelo> lecturaJSONvuelos(String ruta) {
        //Se crea una instancia de JSONParser
        JSONParser jsonParser = new JSONParser();

        //Se crea una lista de vuelos
        List<Vuelo> listaVuelos = new ArrayList();

        try {
            //Se abre un archivo en una ubicacion definida
            FileReader reader = new FileReader(ruta);

            //Se lee el archivo JSON
            Object obj = jsonParser.parse(reader);

            //Se genera un JSON interno
            JSONArray JSONVuelos = (JSONArray) obj;

            //Se itera sobre cada diccionario
            for (Object vuelo : JSONVuelos) {
                listaVuelos.add(parseVuelo((JSONObject) vuelo));
            }

        } catch (FileNotFoundException ex) {
            System.out.println("La ruta del JSON de los vuelos es incorrecta");
            return new ArrayList();
        } catch (IOException | ParseException ex) {
            System.out.println("Hubo un error a la hora de procesar el JSON");
            return new ArrayList();
        }

        return listaVuelos;
    }

    /**
     * Metodo que recibe un objeto JSON y lo procesa por parametros
     * @param un objeto JSON con datos de vuelo
     * @return un objeto de tipo Vuelo
     */
    private Vuelo parseVuelo(JSONObject vuelo) {
        //Se selecciona cada diccionario del JSON

        //Se obtienen los datos de una parte del JSON
        String origen = (String) vuelo.get("origen");
        String destino = (String) vuelo.get("destino");
        Double duracion = (Double) vuelo.get("duracion");
        Double precio = (Double) vuelo.get("precio");

        //Se crea el objeto de vuelo
        return new Vuelo(origen, destino, duracion, precio);
    }

}


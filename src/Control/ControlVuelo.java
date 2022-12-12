/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author User1
 */
import Clases.LectorJson;
import Clases.Vuelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ControlVuelo {

    public LectorJson lector;
    public List<Vuelo> listaVuelos;

    public ControlVuelo() {
        this.lector = new LectorJson();
        this.listaVuelos = lector.lecturaJSONvuelos("src\\datos\\vuelos.json");

    }

    /**
     * Muestra las rutas
     * @param String origen
     * @param String destino
     * @return
     */
    private List<List<Vuelo>> encuentraRutas(String origen, String destino) {

        List<Vuelo> visitados = new ArrayList<>();
        List<List<Vuelo>> caminos = new ArrayList<List<Vuelo>>();

        return this.encuentraRutasDFT(origen, destino, visitados, caminos);
    }

    /**
     * Busca las rutas recursivamente por DFT
     * @param String origen
     * @param String destino
     * @param Lista visitados
     * @param Lista vacia
     * @return
     */
    private List<List<Vuelo>> encuentraRutasDFT(String origen, String destino, List<Vuelo> visitados, List<List<Vuelo>> caminos) {

        if (origen.equals(destino)) {
            caminos.add(new ArrayList<Vuelo>(visitados));

            return caminos;
        }

        for (Vuelo vuelo : this.listaVuelos) {
            if (vuelo.getOrigen().equals(origen) && !visitados.contains(vuelo)) {
                visitados.add(vuelo);
                caminos = encuentraRutasDFT(vuelo.getDestino(), destino, visitados, caminos);
                visitados.remove(vuelo);
            }
        }
        return caminos;
    }

    /**
     * Devuelve un hashmap con la infomacion
     * @param String origen
     * @param String destino
     * @return
     */
    public List<Map> infoVuelos(String origen, String destino) {

        List<Map> informacion = new ArrayList();
        Map<String, String> info = new HashMap<>();

        if (this.listaVuelos.size() == 0) {
            info.put("estado", "Sin vuelos");
            info.put("info", "No hay vuelos");
            informacion.add(info);
            return informacion;
        }
        else if ((this.existe_origen(origen) == false) || (this.existe_destino(destino) == false)) {
            info.put("estado", "Sin origen/destino");
            info.put("info", "El origen o destino no existen");
            informacion.add(info);
            return informacion;
        }

        List<List<Vuelo>> caminos = encuentraRutas(origen, destino);

    if (caminos.size() == 0) {
            info.put("estado", "Sin rutas");
            info.put("info", "No se encontraron rutas que cumplan con los criterios");
            informacion.add(info);
            return informacion;
        } //Si el origen y el destino existen pero no se encuentra una ruta se retorna con la info
        else {
            info.put("estado", "Rutas");
            info.put("info", "Se encontraron las siguientes rutas");
            informacion.add(info);

            for (List<Vuelo> vuelos : caminos) {
                Map<String, String> ruta = new HashMap<String, String>();
                ruta.put("origen", origen);
                ruta.put("destino", destino);
                ruta.put("duracion", Double.toString(this.duracionVuelos(vuelos)));
                ruta.put("precio", Double.toString(this.precioVuelos(vuelos)));
                ruta.put("escala", this.tieneEscala(vuelos));

                informacion.add(ruta);
            }

        }
        return informacion;
    }

    /**
     * Devuelve si existe origen
     * @param String origen
     * @return
     */
    private boolean existe_origen(String origen) {
        for (Vuelo vuelo : this.listaVuelos) {

            if (vuelo.getOrigen().equals(origen)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Devuelve si existe destino
     * @param String destino
     * @return
     */
    private boolean existe_destino(String destino) {
        for (Vuelo vuelo : this.listaVuelos) {

            if (vuelo.getDestino().equals(destino)) {
                return true;
            }
        }
        return false;

    }

    /**
     * Suma el precio de todos los vuelos
     * @param List vuelos
     * @return
     */
    private double precioVuelos(List<Vuelo> vuelos) {
        double precio = 0;
        for (Vuelo vuelo : vuelos) {
            precio = precio + vuelo.getPrecio();
        }
        return precio;
    }

    /**
     * Suma la duracion de todos los vuelos
     * @param List vuelos
     * @return
     */
    private double duracionVuelos(List<Vuelo> vuelos) {
        double duracion = 0;
        for (Vuelo vuelo : vuelos) {
            duracion = duracion + vuelo.getDuracion();
        }
        return duracion;

    }

    /**
     * Devuelve si tiene escala
     * @param List vuelos
     * @return
     */
    private String tieneEscala(List<Vuelo> vuelos) {
        if (vuelos.size() > 1) {
            return "si";
        } else {
            return "no";        
        }

    }

}

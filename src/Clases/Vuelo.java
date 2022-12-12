/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author User1
 */
 public class Vuelo {

        private String origen;
        private String destino;
        private double duracion;
        private double precio;  

        public Vuelo(String origen, String destino, double duracion, double precio) {
            this.origen = origen;
            this.destino = destino;
            this.duracion = duracion;
            this.precio = precio;
        }


        public double getPrecio() {
            return precio;
        }


        public String getDestino() {
            return destino;
        }


        public String getOrigen() {
            return origen;
        }


        public Double getDuracion() {
            return duracion;
        }

    }

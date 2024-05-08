package com.vicksanchez.screenmatch.calculos;

import com.vicksanchez.screenmatch.modelos.Pelicula;

public class CalculadoraDeTiempo {

    private int tiempoTotal;

    public void incluye(Pelicula pelicula) {
        tiempoTotal += pelicula.getDuracionEnMinutos();
    }
}

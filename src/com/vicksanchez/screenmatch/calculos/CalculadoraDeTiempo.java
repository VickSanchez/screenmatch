package com.vicksanchez.screenmatch.calculos;

import com.vicksanchez.screenmatch.modelos.Pelicula;
import com.vicksanchez.screenmatch.modelos.Serie;
import com.vicksanchez.screenmatch.modelos.Titulo;

public class CalculadoraDeTiempo {

    private int tiempoTotal;

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void incluye(Titulo titulo) {
        this.tiempoTotal += titulo.getDuracionEnMinutos();
    }

}

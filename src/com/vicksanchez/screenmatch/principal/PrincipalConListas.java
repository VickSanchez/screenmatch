package com.vicksanchez.screenmatch.principal;

import com.vicksanchez.screenmatch.modelos.Pelicula;
import com.vicksanchez.screenmatch.modelos.Serie;
import com.vicksanchez.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalConListas {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Matrix",2000 );
        miPelicula.evalua(9);
        Pelicula otraPelicula = new Pelicula("Avatar", 2023);
        otraPelicula.evalua(6);
        Pelicula peliculaDeBruno = new Pelicula("El señor de los anillos", 2001);
        peliculaDeBruno.evalua(10);
        Serie casaDragon = new Serie("La Casa del Dragón", 2022);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaDeBruno);
        lista.add(casaDragon);

        for (Titulo item: lista){
            System.out.println(item);
            // Verifica si el elemento del array es de tipo Pelicula y crea una variable de referencia llamada itemPelicula
            if (item instanceof Pelicula itemPelicula && itemPelicula.getClasificacion() > 2){
                System.out.println(itemPelicula.getClasificacion());
            }
        }

        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Penelope");
        listaDeArtistas.add("Tom Cruise");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Ricardo Darin");

        System.out.println("Lista de Artistas No Ordenada: " + listaDeArtistas);
        // Utilidad Collections contiene metodos para manipular listas
        Collections.sort(listaDeArtistas);
        System.out.println("Lista de Artistas Ordenada: " + listaDeArtistas);

        System.out.println("Lista de Titulos No Ordenada: " + lista);
        Collections.sort(lista);
        System.out.println("Lista de Titulos Ordenada por Nombre: " + lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista de Titulos Ordenada por Fecha de Lanzamientp: " + lista);





    }
}

package com.vicksanchez.screenmatch.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vicksanchez.screenmatch.excepciones.ErrorEnConversionDuracionException;
import com.vicksanchez.screenmatch.modelos.Pelicula;
import com.vicksanchez.screenmatch.modelos.Titulo;
import com.vicksanchez.screenmatch.modelos.TituloOmdb;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        while(true){
            System.out.println("Escriba el nombre de la pelicula a buscar");
            String busqueda = lectura.nextLine();

            if (busqueda.equalsIgnoreCase("salir")){
                break;
            }

            String uri = "https://www.omdbapi.com/?t="+ busqueda.replace(" ", "+") + "&apikey=daa92f88";
            System.out.println("URI: " + uri);
            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(uri))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                System.out.println(response.body());

                TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(miTituloOmdb);

                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("Titulo Convertido: " + miTitulo);

                titulos.add(miTitulo);
            }catch(NumberFormatException e) {
                System.out.println("Ocurrió un error");
                System.out.println(e.getMessage());
            }catch(IllegalArgumentException e) {
                System.out.println("Ocurrió un error");
                System.out.println(e.getMessage());
            }catch (ErrorEnConversionDuracionException e){
                System.out.println(e.getMessage());
            }catch(Exception e){
                System.out.println("Ocurrio un error inesperado");
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);

        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();
        System.out.println("Finalizó la ejecición del programa");
    }
}

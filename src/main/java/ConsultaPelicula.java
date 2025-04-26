import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPelicula {
    public Pelicula buscaPelicula(int numeroPelicula) {
        URI direccion = URI.create("https://swapi.py4e.com/api/films/" + numeroPelicula + "/?format=json");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Pelicula.class);
        } catch (Exception e) {
            System.out.println("No se encontró la película");
            return null;
        }
    }
}

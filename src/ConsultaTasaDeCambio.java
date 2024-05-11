import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaTasaDeCambio {


    public Moneda buscaMoneda(String base_code) throws IOException, InterruptedException{
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/51e47a094093cfee2a89372c/latest/"
                    + base_code);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();


            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);




    }
}


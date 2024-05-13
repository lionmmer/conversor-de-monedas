import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ConsultaTasaDeCambio {
    public Moneda buscaMoneda(String base_code) throws IOException, InterruptedException {
        String apiKey = "51e47a094093cfee2a89372c";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"
                + base_code);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verificar si la solicitud fue exitosa (código de estado 200)
        if (response.statusCode() == 200) {
            // Procesar la respuesta JSON
            Gson gson = new Gson();
            Map<String, Object> responseData = gson.fromJson(response.body(), Map.class);

            // Obtener las tasas de conversión del JSON
            Map<String, Double> conversionRatesMap = (Map<String, Double>) responseData.get("conversion_rates");

            // Crear el objeto ConversionRates
            ConversionRates conversionRates = new ConversionRates(conversionRatesMap);

            // Crear y devolver el objeto Moneda
            return new Moneda(base_code, conversionRates);
        } else {
            throw new IOException("Error al realizar la consulta. Código de estado: " + response.statusCode());
        }
    }
}









import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    public static void generarArchivo(Moneda moneda, String filePath) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(moneda);
        try (FileWriter writer = new FileWriter("conversion.json")) {
            writer.write(json);
        }
    }
}

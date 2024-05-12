import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    public void generarArchivo(Moneda moneda, String filePath) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(moneda);
        try (FileWriter writer = new FileWriter("moneda.json")) {
            writer.write(json);
        }
    }
}

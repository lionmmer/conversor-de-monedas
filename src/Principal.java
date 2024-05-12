import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        String baseCode = "USD";

        ConsultaTasaDeCambio consulta = new ConsultaTasaDeCambio();
        GeneradorDeArchivo generador = new GeneradorDeArchivo();

        System.out.println("¿Desea buscar la tasa de cambio para una moneda diferente? (si/no)");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("Ingrese el código de la moneda base:");
            baseCode = scanner.nextLine();
        }

        try {
            // Realizar la consulta a la API
            Moneda moneda = consulta.buscaMoneda(baseCode);

            // Mostrar la información de la moneda en la consola
            System.out.println("Resultado de la consulta:");
            System.out.println("Base: " + moneda.getBase_code());
            System.out.println("Tasas de conversión:");
            moneda.getConversion_rates().getRates().forEach((codigo, tasa) -> {
                System.out.println(codigo + ": " + tasa);
            });

            // Generar el archivo JSON
            generador.generarArchivo(moneda, "tasa_de_cambio.json");
            System.out.println("Se ha generado el archivo 'tasa_de_cambio.json' correctamente.");

        } catch (IOException | InterruptedException e) {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }

        scanner.close();
    }
}



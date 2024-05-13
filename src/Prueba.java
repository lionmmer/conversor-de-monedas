import java.io.IOException;
import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


            System.out.println("""
                Estos son los códigos de algunas monedas:\s
                BRL\tBrazilian Real
                MXN\tMexican Peso
                USD\tUnited States Dollar
                Para consultar todos los códigos de monedas, siga el enlace: https://www.exchangerate-api.com/docs/supported-currencies""");

            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            ConsultaTasaDeCambio consulta = new ConsultaTasaDeCambio();

            System.out.println("Ahora puede ingresar la cantidad a convertir:");
            double cantidad = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Ingrese el tipo de moneda (ej. USD, EUR, etc.):");
            String monedaBase = scanner.nextLine();
            System.out.println("Ingrese el tipo de moneda al que desea convertir:");
            String monedaObjetivo = scanner.nextLine();

            try {
                Moneda moneda = consulta.buscaMoneda(monedaBase);

                double tasaConversion = moneda.getConversion_rates().getRates().get(monedaObjetivo);

                double cantidadConvertida = cantidad * tasaConversion;

                System.out.println("Cantidad convertida de " + monedaBase + " a " + monedaObjetivo + ": " + cantidadConvertida);

                // Generar el archivo JSON

                Moneda resultadoConversion = new Moneda(cantidad, monedaBase, cantidadConvertida, monedaObjetivo);

                // Generar el archivo JSON
                GeneradorDeArchivo.generarArchivo(resultadoConversion, "C:\\Users\\siste\\OneDrive\\Escritorio\\Data Scientist\\Oracle One\\Desafíos");
                System.out.println("Se ha generado el archivo 'moneda.json' correctamente.");
            } catch (IOException | InterruptedException e) {
                System.err.println("Error al realizar la consulta: " + e.getMessage());
            }

            scanner.close();
        }
    }



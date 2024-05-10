import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaTasaDeCambio consulta = new ConsultaTasaDeCambio();
        System.out.println("Ingrese la cantidad a convertir en el siguiente formato cantidad código base. Deberán estar separados por espacio:");
        String line = lectura.nextLine();

        // Dividiendo la línea en dos valores usando espacio como delimitador
        String[] valores = line.split(" ");

        if (valores.length >= 2) {
             String valor1 = valores[0];
             String valor2 = valores[1];
        } else {
            System.out.println("Ingrese al menos dos valores separados por espacio");
        }

        lectura.close();
        



    }
}

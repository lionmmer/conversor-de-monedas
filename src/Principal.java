import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        ConsultaTasaDeCambio consulta = new ConsultaTasaDeCambio();
        System.out.println("Ingrese la cantidad a convertir: ");

        String line = lectura.nextLine();
        Moneda moneda = consulta.buscaMoneda("USD");
        System.out.println(moneda);

    }
}

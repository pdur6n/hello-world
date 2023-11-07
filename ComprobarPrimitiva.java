
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ComprobarPrimitiva {
    public static void main(String[] args) {
        int rangoMinimo = 1;
        int rangoMaximo = 49;
        int numerosASeleccionar = 6;

        Random random = new Random();
        int[] boleto = generarBoletoAleatorio(rangoMinimo, rangoMaximo, numerosASeleccionar, random);

        System.out.println("Boleto de la Primitiva generado:");
        mostrarBoleto(boleto);

        Scanner scanner = new Scanner(System.in);
        int[] numerosGanadores = new int[numerosASeleccionar];

        for (int i = 0; i < numerosASeleccionar; i++) {
            System.out.println("Ingrese el número ganador " + (i + 1) + ":");
            numerosGanadores[i] = scanner.nextInt();
        }

        Arrays.sort(boleto);
        Arrays.sort(numerosGanadores);

        System.out.println("Números ganadores:");
        mostrarBoleto(numerosGanadores);

        int aciertos = contarAciertos(boleto, numerosGanadores);
        if (aciertos == 6) {
            System.out.println("¡Has acertado los 6 números principales! ¡Felicidades!");
        } else {
            System.out.println("Número de aciertos: " + aciertos);
        }
    }

    private static int[] generarBoletoAleatorio(int min, int max, int cantidad, Random random) {
        int[] boleto = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            int numero;
            do {
                numero = random.nextInt(max - min + 1) + min;
            } while (Arrays.binarySearch(boleto, numero) >= 0);
            boleto[i] = numero;
        }
        return boleto;
    }

    private static void mostrarBoleto(int[] boleto) {
        System.out.print("Números: ");
        for (int i = 0; i < boleto.length; i++) {
            System.out.print(boleto[i]);
            if (i < boleto.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private static int contarAciertos(int[] boleto, int[] numerosGanadores) {
        int aciertos = 0;
        for (int numero : boleto) {
            if (Arrays.binarySearch(numerosGanadores, numero) >= 0) {
                aciertos++;
            }
        }
        return aciertos;
    }
}
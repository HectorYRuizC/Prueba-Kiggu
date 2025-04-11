package org.example;

import java.util.Arrays;

public class Frecuencias_Maximas {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 3, 3, 2, 1, 1, 1, 6, 4, 4, 6, 5, 5, 7, 4, 4, 5, 4, 7, 7, 7, 7, 7};

      
        Arrays.sort(numbers);
        System.out.println("Arreglo ordenado: " + Arrays.toString(numbers));

        int[][] resultados = obtenerDosNumerosMasFrecuentes(numbers);

       
        System.out.println("\nPrimer Número más frecuente: " + resultados[0][0]);
        System.out.println("Repetido: " + resultados[0][1] + " veces");

        System.out.println("\nSegundo Número más frecuente: " + resultados[1][0]);
        System.out.println("Repetido: " + resultados[1][1] + " veces");
    }

    public static int[][] obtenerDosNumerosMasFrecuentes(int[] numbers) {
        int contador = 0;
        int numeroActual = numbers[0];

        int numeroMasFrecuente = 0;
        int maxFrecuencia = 0;

        int segundonumeroMasFrecuente = 0;
        int segundomaxFrecuencia = 0;

        for (int num : numbers) {
            if (num == numeroActual) {
                contador++;
            } else {
                if (contador > maxFrecuencia) {
                    segundonumeroMasFrecuente = numeroMasFrecuente;
                    segundomaxFrecuencia = maxFrecuencia;
                    numeroMasFrecuente = numeroActual;
                    maxFrecuencia = contador;
                } else if (contador > segundomaxFrecuencia && numeroActual != numeroMasFrecuente) {
                    segundonumeroMasFrecuente = numeroActual;
                    segundomaxFrecuencia = contador;
                }

                numeroActual = num;
                contador = 1;
            }
        }

        if (contador > maxFrecuencia) {
            segundonumeroMasFrecuente = numeroMasFrecuente;
            segundomaxFrecuencia = maxFrecuencia;
            numeroMasFrecuente = numeroActual;
            maxFrecuencia = contador;
        } else if (contador > segundomaxFrecuencia && numeroActual != numeroMasFrecuente) {
            segundonumeroMasFrecuente = numeroActual;
            segundomaxFrecuencia = contador;
        }

        return new int[][]{
                {numeroMasFrecuente, maxFrecuencia},
                {segundonumeroMasFrecuente, segundomaxFrecuencia}
        };
    }
}

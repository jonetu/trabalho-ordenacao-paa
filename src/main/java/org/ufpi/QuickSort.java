package org.ufpi;

import java.util.Arrays;

public class QuickSort {
    private static int iterCount = 0;

    public static void main(String[] args) {
        Integer[] numeros = {12, 11, 13, 5, 6, 7, 1, 3};
        System.out.println("iteracoes " + NewquickSort(numeros, 0, numeros.length-1));
    }

    public static int quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            // pi é o índice da particion
            int pi = partition(arr, low, high);
            iterCount++;
            // Recursivamente ordenar elementos antes e depois
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        
        return iterCount;
    }

    private static int partition(Integer[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index do menor elemento
        for (int j = low; j < high; j++) {
            // Se o elemento atual é menor ou igual ao pivot
            if (arr[j] <= pivot) {
                i++;
                // Troca
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static int NewquickSort(Integer[] vetor, int inicio, int fim) {
        if(fim > inicio) {
            
          //Chamada da rotina que ira dividir o vetor em 3 partes.
          int indexPivo = dividir(vetor, inicio, fim);
          iterCount++;
          /* Chamada recursiva para redivisao do vetor de elementos menores
            que o pivô. */
            NewquickSort(vetor, inicio, indexPivo - 1);
          /* Chamada recursiva para redivisao do vetor de elementos maiores
            que o pivô. */
            NewquickSort(vetor, indexPivo + 1, fim);
        }
        return iterCount;
      }


    private static int dividir(Integer[] vetor, int inicio, int fim) {
        int pivo, pontEsq, pontDir = fim;
        pontEsq = inicio + 1;
        pivo = vetor[inicio];
    
        while(pontEsq <= pontDir) {
          /* Vai correr o vetor ate que ultrapasse o outro ponteiro
            ou ate que o elemento em questão seja menor que o pivô. */
          while(pontEsq <= pontDir && vetor[pontEsq] <= pivo) {
            pontEsq++;
          }
    
          /* Vai correr o vetor ate que ultrapasse o outro ponteiro
            que o elemento em questão seja maior que o pivô. */
          while(pontDir >= pontEsq && vetor[pontDir] > pivo) {
            pontDir--;
          }
    
          /* Caso os ponteiros ainda nao tenham se cruzado, significa que valores
            menores e maiores que o pivô foram localizados em ambos os lados.
            Trocar estes elementos de lado. */
          if(pontEsq < pontDir) {
            trocar(vetor, pontDir, pontEsq);
            pontEsq++;
            pontDir--;
          }
        }
    
        trocar(vetor, inicio, pontDir);
        return pontDir;
      }
      private static void trocar(Integer[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
      }
}

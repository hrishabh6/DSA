package arrays;

import java.util.Scanner;

public class Sorting_1  {

    static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minimum = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minimum]){
                    minimum = j;
                }
            }
            int temp = arr[minimum];
            arr[minimum] = arr[i];
            arr[i] = temp;
        }

    }

    static void bubbleSort(int[] arr){
        for (int i = arr.length - 1; i > 0; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization
        }
    }

    static void insertionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j-1] > arr[j]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of array : ");
        int input = sc.nextInt();

        int[] arr = new int[input];

        for (int i = 0; i < input; i++) {
            System.out.print("Enter the " + (i+1) + " Element : ");
            arr[i] = sc.nextInt();
        }

//        selectionSort(arr);
//        bubbleSort(arr);
        insertionSort(arr);

        for (int j : arr) {
            System.out.print(j + " ");
        }


    }
}

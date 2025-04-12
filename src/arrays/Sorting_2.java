package arrays;

import recurrsion.Reccursions;

import java.util.Scanner;

public class Sorting_2 {

    static void merge(int[] arr, int low, int high, int mid) {
        int[] newArr = new int[high - low + 1];
        int i = 0;
        int left = low;
        int right = mid + 1;

        while ((left <= mid) && (right <= high)) {
            if (arr[left] > arr[right]) {
                newArr[i++] = arr[right++];
            } else {
                newArr[i++] = arr[left++];
            }
        }

        while (left <= mid) {
            newArr[i++] = arr[left++];
        }

        while (right <= high) {
            newArr[i++] = arr[right++];
        }

        for (int j = 0; j < newArr.length; j++) {
            arr[low + j] = newArr[j];
        }
    }


    static void mergeSort(int[] arr, int low, int high){
        if (low >= high) return;
        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, high, mid);
    }

    static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length-1);
    }

    //Quick Sort
    static void quickSort(int[] arr, int low, int high){
        if (low < high){
            int pIndex = index(arr, low, high);
            quickSort(arr, low, pIndex);
            quickSort(arr, pIndex+1, high);
        }
    }

    static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    static int index(int[] arr, int low, int high){
        int i = low;
        int pivot = arr[low];
        int j = high;
        while(i < j){
            while(arr[i] <= pivot && i <= high-1) {
                i++;
            }
            while(arr[j] > pivot && j >= low+1){
                j--;
            }
            if (i < j) Reccursions.swap(arr, i, j);

        }
        Reccursions.swap(arr, low, j);
        return j;
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

//        mergeSort(arr);
        quickSort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}

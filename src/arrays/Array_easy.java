package arrays;

import recurrsion.Reccursions;

import java.util.Scanner;

public class Array_easy {
    //largest element in an array
    static int largestElement(int[] arr){
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) largest = arr[i];
        }
        return largest;
    }

    static int secondLargest(int[] arr){
        if (arr.length == 1) return arr[0];
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > largest) {
                secondLargest = largest;
                largest = j;
            } else if (j > secondLargest && j != largest) {
                secondLargest = j;
            }
        }
        return secondLargest;
    }

    static int secondSmallest(int [] arr){
        if (arr.length == 1) return arr[0];
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int j : arr) {
            if (j < smallest) {
                secondSmallest = smallest;
                smallest = j;
            } else if (j < secondSmallest && j != smallest) {
                secondSmallest = j;
            }
        }
        return secondSmallest;
    }

    static int uniqueElements(int [] arr){
        int startingIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[startingIndex] != arr[i]){
                arr[startingIndex + 1] = arr[i];
                startingIndex++;
            }
        }
        return startingIndex + 1;
    }

    static void rotateArray(int [] arr){
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length -1] = temp;
    }

    static void reverseArray(int[] arr, int from, int to) {
        int left = from, right = to;
        while (left < right) {
            // Swap elements at left and right
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }


    static void rotateByD(int[] arr,  int n){
        int numberOfRotations = n%arr.length;
        reverseArray(arr, 0, numberOfRotations - 1);
        reverseArray(arr, numberOfRotations, arr.length - 1);
        reverseArray(arr, 0, arr.length - 1);
    }

    static void shiftAllZeroes(int[] arr){
        int currentNonZeroIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                arr[currentNonZeroIndex++] = arr[i];
            };

        }
        while (currentNonZeroIndex < arr.length) {
            arr[currentNonZeroIndex++] = 0;
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

//        System.out.println("The largest element is : " + largestElement(arr));
//        System.out.println("The Second largest element is : " + secondLargest(arr));
//        System.out.println("The Second Smallest element is : " + secondSmallest(arr));
//        System.out.println(uniqueElements(arr));
//        rotateArray(arr);
//        rotateByD(arr, 5);
        shiftAllZeroes(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}

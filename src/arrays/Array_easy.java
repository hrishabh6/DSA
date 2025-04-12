package arrays;

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
        for (int i = 0; i < arr.length; i++) {
            
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

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}

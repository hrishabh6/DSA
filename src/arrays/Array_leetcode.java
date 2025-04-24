package arrays;

import java.util.Scanner;

public class Array_leetcode {

    static boolean rotatedAndSorted(int[] arr){
        int n = arr.length - 1;
        int currentPtr = 1;
        for (int i = 1; i < n * 2; i++) {

            if( arr[i % n] >= arr[(i-1) % n ] ){
                currentPtr++;
            } else if (arr[i%n] < arr[(i%n) - 1]){
                currentPtr = 1;
            }
            if (currentPtr == n){
                return true;
            }
        }
        return false;
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

        System.out.println(rotatedAndSorted(arr));
    }
}

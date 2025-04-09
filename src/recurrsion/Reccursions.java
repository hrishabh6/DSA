package recurrsion;

import java.sql.Array;

public class Reccursions {
    //Infinite recursive function cause stckoverflow error
    public static void recursiveMethod(int count) {
        // No base case → infinite recursion
        count++;
        System.out.println(count);

        recursiveMethod(count);
    }

    static void printName(int i, int n){
        if (i > n){
            return;
        }
        System.out.println("Hrishabh Joshi is my name");
        printName(i+1, n);
    }
    //Overloading the function because java don't have default argument support
    static void printName(int n){
        printName(1, n);
    }


    //Printing in reverse order using recursions
    //Striver homework to solve from 1 to n without using i-1
    static void reversePrinting(int i,int n){
        if (i > n) return;
        reversePrinting(i+1, n);
        System.out.println(i);
    }

    //sum of first n natural numbers using functional recursions
    static int sum(int n){
        if (n == 0) return 0;
        return n + sum(n-1);
    }

    //striver homework 2
    //Factorial of n
    static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial cannot be of a negative number");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    //Reversing an array using recursion
    //helper swap function
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int[] reverseArray(int i, int[] arr, int n){
        if (i > n/2) return arr;
        swap(arr, i, n-i-1);
        return reverseArray(i+1,arr, n);
    }

    //check for a palindrome string
    static boolean checkPalindrome(int i, String str){
        int len = str.length();
        if (i > len/2) return true;

        if (str.charAt(i) != str.charAt(len - i - 1) ) return false;

        return checkPalindrome(i+1, str);

    }
    static boolean checkPalindrome(String str){
        return checkPalindrome(0, str);
    }

    static int fibonacci(int n){
        if (n<= 1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
//        recursiveMethod(1);
//        printName(3);
//        reversePrinting(1,5);
//        System.out.println(sum(10));
//        System.out.println(factorial(-1));
//        System.out.println();
//        System.out.println();
//        int[] arr = {1,2,3,4,5};
//        reverseArray(0, arr, 5);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//        System.out.println(checkPalindrome("Madam"));
//        System.out.println(fibonacci(5));
    }   
}

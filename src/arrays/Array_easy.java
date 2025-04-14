package arrays;

import recurrsion.Reccursions;

import java.util.*;

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

    static int linearSearch(int[] arr, int n){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) return i;
        }
        return -1;
    }

    static int[] union(int[] arr1, int[] arr2) {
        int size = Math.min(arr1.length, arr2.length);
        int i = 0;
        int[] newArr = new int[arr1.length + arr2.length];
        int arr1ptr = 0, arr2ptr = 0;
        while(arr1ptr < arr1.length && arr2ptr < arr2.length){
            if (arr1[arr1ptr] == arr2[arr2ptr]) {
                newArr[i] = arr1[arr1ptr];
                i++;
                arr1ptr++;
                arr2ptr++;
            } else if(arr1[arr1ptr] < arr2[arr2ptr]){
                newArr[i] = arr1[arr1ptr];
                i++;
                arr1ptr++;
            } else if (arr1[arr1ptr] > arr2[arr2ptr]) {
                newArr[i] = arr2[arr2ptr];
                i++;
                arr2ptr++;
            }
        }
        while(arr1ptr < arr1.length){
            if (arr1ptr == 0 || arr1[arr1ptr] != arr1[arr1ptr - 1])
            {
                newArr[i] = arr1[arr1ptr];
                System.out.println("First While executed");
                arr1ptr++;
                i++;
            } else {
                arr1ptr++;
            }
        }
        while(arr2ptr < arr2.length){
            if (arr2ptr == 0 || arr2[arr2ptr] != arr2[arr2ptr - 1])
            {
                newArr[i] = arr2[arr2ptr];
                System.out.println("Second While executed");
                arr2ptr++;
                i++;
            } else {
                arr2ptr++;
            }
        }
        return Arrays.copyOf(newArr, i);
    }

    static List<Integer> intersection(int[] arr1, int[] arr2){
        int ptr1 = 0, ptr2 = 0, i = 0;
        List<Integer> result = new ArrayList<>();
        while(ptr1 < arr1.length && ptr2 < arr2.length){
            if (arr1[ptr1] == arr2[ptr2]){
                result.add(arr1[ptr1]);
                ptr1++;
                ptr2++;
            } else if (arr1[ptr1] < arr2[ptr2]) {
                ptr1++;
            } else {
                ptr2++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of array : ");
        int input = sc.nextInt();

        int[] arr = new int[input];
        int[] arr2 = new int[7];

        for (int i = 0; i < input; i++) {
            System.out.print("Enter the " + (i+1) + " Element : ");
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < 7; i++) {
            System.out.print("Enter the " + (i+1) + " Element for second array : ");
            arr2[i] = sc.nextInt();
        }

//        System.out.println("The largest element is : " + largestElement(arr));
//        System.out.println("The Second largest element is : " + secondLargest(arr));
//        System.out.println("The Second Smallest element is : " + secondSmallest(arr));
//        System.out.println(uniqueElements(arr));
//        rotateArray(arr);
//        rotateByD(arr, 5);
//        shiftAllZeroes(arr);
//        System.out.println(linearSearch(arr, 10));
//        int[] newArray = union(arr, arr2);
        List<Integer> result = intersection(arr, arr2);



        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int j : result) {
            System.out.print(j + " ");
        }
    }
}

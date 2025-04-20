package arrays;

import recurrsion.Reccursions;

import java.util.HashMap;
import java.util.Scanner;

public class Array_med {
    static boolean twoSum(int[] arr, int n){
        HashMap<Integer, Integer> tempHashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int requiredNumber = n - arr[i];
            if (tempHashMap.containsKey(requiredNumber)) {
                return true;  // Found the pair
            }
            tempHashMap.put(arr[i], i);  // Store the current number
        }
        return false;  // No pair found
    }
    
    //Deutch National Flag algorithm
    static void sortZeroOneTwosArray(int[] arr){
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high){
            if (arr[mid] == 0){
                Reccursions.swap(arr, mid, low);
                mid++;
                low++;
            } else if (arr[mid] == 1){
                mid++;
            } else if (arr[mid] == 2) {
                Reccursions.swap(arr, mid, high);
                high--;
            }
        }
    }

    //Moores voting algorithm
    static int majorityElement(int[] arr){
        int element = Integer.MIN_VALUE;
        int counter = 0;
        for (int j : arr) {
            if (counter == 0) {
                counter = 1;
                element = j;
            } else if (j == element) {
                counter++;
            } else {
                counter--;
            }
        }
        int counter2 = 0;
        for (int j : arr) {
            if (j == element) counter2++;
        }
        if (counter2 > (arr.length)/2) return element;
        return -1;
    }

    //kadane's algo for finding maximum subarray sum
    static int maximumSubarraySum(int[] arr){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum > max){
                max = sum;
            }

            if (sum < 0){
                sum = 0;
            }
        }
        if (max < 0) max = 0;
        return max;
    }

    static int buySellStocks(int[] arr) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : arr) {
            if (price < minPrice) {
                minPrice = price; // update the minimum price seen so far
            } else {
                int profit = price - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of array : ");
        int input = sc.nextInt();

        int[] arr = new int[input];
//        int[] arr2 = new int[7];

        for (int i = 0; i < input; i++) {
            System.out.print("Enter the " + (i+1) + " Element : ");
            arr[i] = sc.nextInt();
        }
//        for (int i = 0; i < 7; i++) {
//            System.out.print("Enter the " + (i+1) + " Element for second array : ");
//            arr2[i] = sc.nextInt();
//        }

//        System.out.println(twoSum(arr, 5));
//        sortZeroOneTwosArray(arr);
//        System.out.println(majorityElement(arr));
        System.out.println(buySellStocks(arr));

        for (int j : arr) {
            System.out.print(j + " ");
        }
//        System.out.println();
//        for (int j : result) {
//            System.out.print(j + " ");
//        }
    }
}

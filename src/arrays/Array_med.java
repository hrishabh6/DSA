package arrays;

import recurrsion.Reccursions;

import java.util.*;

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

    static int[] rearrangeArray(int[] arr){
        int posIndex = 0, negIndex = 1;
        int[] arr2 = new int[arr.length];
        for (int j : arr) {
            if (j > 0) {
                arr2[posIndex] = j;
                posIndex += 2;
            } else {
                arr2[negIndex] = j;
                negIndex += 2;
            }
        }
        return arr2;
    }

    //Second variety of rearranging array
    static int[] rearrange(int[] arr){
        ArrayList <Integer> posArray = null, negArray = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 ) posArray.add(arr[i]);
            else negArray.add(arr[i]);
        }
        if (posArray.size() > negArray.size()){
            for (int i = 0; i < negArray.size(); i++) {
                arr[i*2] = posArray.get(i);
                arr[i*2+1] = posArray.get(i);
            }
            int index = negArray.size() * 2;
            for (int i = negArray.size(); i < posArray.size(); i++) {
                arr[index] = posArray.get(i);
            }
        }
        else {
            for (int i = 0; i < posArray.size(); i++) {
                arr[i*2] = posArray.get(i);
                arr[i*2+1] = posArray.get(i);
            }
            int index = posArray.size() * 2;
            for (int i = posArray.size(); i < negArray.size(); i++) {
                arr[index] = negArray.get(i);
            }
        }
        return arr;
    }
    
    public void nextPermutation(int[] arr){
        int index = -1;
        for (int i = arr.length - 2 ; i >= 0; i--) {
            if (arr[i] < arr[i+1]){
                index = i;
                break;
            }
        }
        if (index == -1) {
            // If no pivot found, reverse the whole array (it's the last permutation)
            Array_easy.reverseArray(arr, 0, arr.length - 1);
            return;
        }
        for (int i = arr.length - 1; i > index ; i--) {
            if (arr[i] > arr[index]){
                Reccursions.swap(arr, i, index);
                break;
            }
        }
        Array_easy.reverseArray(arr, index + 1, arr.length -1);
    }

     static ArrayList<Integer> leader(int[] arr){
        int maximum = Integer.MIN_VALUE;
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > maximum){
                maximum = arr[i];
                answer.add(arr[i]);
            }
        }
            Collections.reverse(answer);
            return answer;
    }

    static int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int longest = 0;

        for (int num : arr) {
            // Only start if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak);
            }
        }

        return longest;
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
//        System.out.println(buySellStocks(arr));
        ArrayList<Integer> list = leader(arr);

        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int j : list) {
            System.out.print(j + " ");
        }
    }
}

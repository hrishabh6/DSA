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
    
    //Dutch National Flag algorithm
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

    //kadane's algo for finding maximum sub array sum
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
    
    static void zeroMatrix(int[][] arr){
        int col0 = 1;
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0){
                    arr[i][0] = 0;
                    if (j != 0) arr[0][j] = 0;
                    else col0 = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0){
                    arr[i][j] = 0;
                }
            }
        }
        if (arr[0][0] == 0){
            for (int i = 0; i < n; i++) {
                arr[0][i] = 0;

            }
        }if (col0 == 0){
            for (int i = 0; i < m; i++) {
                arr[i][0] = 0;
            }
        }
    }

    static void rotateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        List<Integer> answer = new ArrayList<>();
        int top = 0, bottom = n-1;
        int left = 0, right = m-1;
        while(top <= bottom && left <= right){
            //print for right
            for (int i = left; i <= right; i++) {
                answer.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i < bottom ; i++) {
                answer.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom){
                for (int i = right; i > left ; i--) {
                    answer.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right){
                for (int i = bottom; i > top ; i--) {
                    answer.add(matrix[i][left]);
                }
                left++;
            }

        }
        return answer;
    }

    static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> answer = new HashMap<>();
        int count = 0, sum = 0;
        answer.put(0, 1); // This is important to handle the case where sum directly equals k

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // Check if there is a subarray sum that equals sum - k
            if (answer.containsKey(sum - k)) {
                count += answer.get(sum - k);
            }

            // Update the map with the current sum's frequency
            answer.put(sum, answer.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Edge case: if numRows is 0, return an empty list
        if (numRows == 0) {
            return triangle;
        }

        // The first row is always [1]
        triangle.add(new ArrayList<>());
        triangle.getFirst().add(1);

        // Generate each row
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            // First element is always 1
            row.add(1);

            // Add middle elements
            for (int j = 1; j < i; j++) {
                int sum = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                row.add(sum);
            }

            // Last element is always 1
            row.add(1);

            // Add the row to the triangle
            triangle.add(row);
        }

        return triangle;
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

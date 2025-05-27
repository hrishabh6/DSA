package arrays;

import java.util.*;

public class Array_hard {

    //majority element which appear n/3 time in array
    static List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (cnt1 == 0 && nums[i] != ele2){
                cnt1 = 1;
                ele1 = nums[i];
            } else if (cnt2 == 0 && nums[i] != ele1){
                cnt2 = 1;
                ele2 = nums[i];
            } else if (ele1 != nums[i]){
                cnt1--;
            }
            else if (ele2 != nums[i]){
                cnt2--;
            } else{
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> answer = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele1) cnt1++;
            if (nums[i] == ele2) cnt2++;
        }
        int minValue = nums.length/3 + 1;
        if (cnt1 >= minValue) answer.add(ele1);
        if (cnt2 >= minValue) answer.add(ele2);
        return answer;
    }

    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // Skip duplicate 'i'

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    answer.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    // Skip duplicates for j and k
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return answer;
    }

    static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < nums.length; j++) {
                if (j != i+1 && nums[j] == nums[j-1]) continue;;
                int k = j+1;
                int l = nums.length - 1;
                while (k < l){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target){
                        answer.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else if (sum > target){
                        l--;
                    }

                }
            }
        }
        return answer;
    }
    //Largest subarray with 0 sum
    static int maxLen(int arr[]) {
        int maximum = 0;
        int sum = 0;
        HashMap <Integer, Integer> store = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0){
                maximum = i+1;
            } else {
                if (store.get(sum) != null){
                    maximum = Math.max(maximum, i-store.get(sum));
                } else {
                    store.put(sum, i);
                }
            }
        }
        return maximum;
    }

    static long subarrayXor(int arr[], int k) {
        HashMap <Integer, Integer> temp = new HashMap<>();
        temp.put(0, 1);
        long count = 0;
        int xor = 0;
        for (int j : arr) {
            xor ^= j;
            count += temp.getOrDefault(xor ^ k, 0);
            temp.put(xor, temp.getOrDefault(xor, 0) + 1);
        }

        return count;

    }

    static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort intervals based on starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (current[1] >= next[0]) {

                current[1] = Math.max(current[1], next[1]);
            } else {
                merged.add(current);
                current = next;
            }
        }

        merged.add(current);

        return merged.toArray(new int[merged.size()][]);
    }

    static List<Integer> findMissingRepeating(int[] arr){
        int n = arr.length;
        long SN = ((long) n *(n+1))/2;
        long S2N = (n * (n+1) * (2L *n+1))/2;
        long S1 = 0, S2 = 0;
        for (int j : arr) {
            S1 += j;
            S2 += (long) j * j;
        }
        long val1 = S1 - SN;
        long val2 = S2 - S2N;
        val2 = val2/val1; //x+y;
        long x = (val1+val2)/2;
        long y = x - val1;
        List<Integer> answer = new ArrayList<>();
        answer.add((int) x);
        answer.add((int) y);
        return answer;
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

//

        for (int j : arr) {
            System.out.print(j + " ");
        }
//        System.out.println();
//        for (int j : list) {
//            System.out.print(j + " ");
//        }
    }
}

package ArraysQ.Medium;

import java.util.HashMap;

public class LongestSubarrayWithSumKth {
    //brute approach
    public static int longestSubarrayWithSumK(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int curSum = 0;
            for (int j = i; j < arr.length; j++) {
                curSum += arr[j];
                if (curSum == k) {
                    max = Math.max(max, j - i + 1);
                }
            }

        }
        return max;
    }

    //better approach . this better when array contain negative element
    public static int longestSubarrayWithSumKII(int[] arr, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = i + 1;
            }
            int rem = sum - k;
            if (mp.containsKey(rem)) {
                maxLen = Math.max(maxLen, i - mp.get(rem) );
            }
            if (!mp.containsKey(sum)) {
                mp.put(sum, i);
            }
        }
        return maxLen;
    }

    // this is bette for array contain 0
    public static int longestSubarrayWithSumKIII(int[] arr, int k){
        int left=0;
        int sum=arr[0];
        int maxLen=0;
        int right=0;
        int n=arr.length;
        while (right<n){
            while (left<=right && sum>k){
                sum-=arr[left];
                left++;
            }
            if(sum==k){
                maxLen=Math.max(maxLen,right-left+1);
            }
            right++;
            if(right<n)sum+=arr[right];
        }
        return maxLen;
    }

    public static void main(String[] args) {
//        int[] arr = {4, -1, 2, 1, -5, 4, 3};
//        int[] arr = {2,0,0,3};
        int[] arr = {1,2,3,1,1,1,1,3,3};
        int k = 6;
        int i = longestSubarrayWithSumK(arr, k);
        System.out.println(i);
        int i1 = longestSubarrayWithSumKII(arr, k);
        System.out.println(i1);
        int i2 = longestSubarrayWithSumKIII(arr, k);
        System.out.println(i2);

    }
}

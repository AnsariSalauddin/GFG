package ArraysQ.Medium;

import java.util.HashMap;

public class CountSubArraySumEqualtoK {
    //brute force
    public static int countSubarraySumEqualToK(int[] arr, int kth){
        int count=0;
        for (int i=0; i<arr.length; i++){
            for (int j=i; j<arr.length; j++){
                int sum=0;
                for (int k=i; k<=j;k++){
                    sum=sum+arr[k];
                }
                if(sum==kth){
                    count++;
                }
            }
        }
        return count;
    }
    //better approach
    public static int countSubarraySumEqualToKII(int[] arr, int kth){
        int count=0;

        for (int i=0; i<arr.length; i++){
            int sum=0;
            for (int j=i; j<arr.length; j++){

                sum+=arr[j];
                if(sum==kth){
                    count++;
                }
            }
        }
        return count;
    }

    //optimal appraoch
    public static int countSubarraySumEqualToKIII(int[] arr, int kth){
        int count=0;
        int sum=0;
        HashMap<Integer, Integer> preSum=new HashMap<>();
        preSum.put(0,1);
        for (int j : arr) {
            sum += j;
            int pre=sum - kth;
            if (preSum.containsKey(pre)) {
                count = count + preSum.get(pre) ;
            }
           preSum.put(sum,preSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;
        int arr1[] = {9, 4, 20, 3, 10, 5};
        int k1 = 33;
//        int i = countSubarraySumEqualToK(arr1, k1);
//        System.out.println(i);
        int i1 = countSubarraySumEqualToKII(arr, k);
        System.out.println(i1);
        int i2 = countSubarraySumEqualToKII(arr1, k1);
        System.out.println(i2);
        int i3 = countSubarraySumEqualToKIII(arr, k);
        System.out.println(i3);
        int i4 = countSubarraySumEqualToKIII(arr1, k1);
        System.out.println(i4);
    }
}

package ArraysQ.Medium;

public class MaximumSubArraySum {
    //better approach
    public static int maximumSubarraySum(int[] arr){
        int maxSum=0;
        for (int i=0; i<arr.length; i++){
            int sum=0;
            for (int j=i; j<arr.length; j++){
                sum+=arr[j];
                maxSum=Math.max(maxSum,sum);
            }
        }
        return maxSum;
    }
//kadane alog
    public static int maxSubArray(int[] arr) {
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int x : arr){
            curSum += x;
            maxSum = Math.max(maxSum, curSum);

            if(curSum < 0){
                curSum = 0;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr={-2,-3,4,-1,-2,1,5,-3};
        int i = maximumSubarraySum(arr);
        System.out.println(i);
    }
}

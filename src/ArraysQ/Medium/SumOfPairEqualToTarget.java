package ArraysQ.Medium;

public class SumOfPairEqualToTarget {
    //step1:- Brute force
    public static boolean sumOfPairEqualToTarget(int[] arr, int k){
        for (int i=0; i<arr.length-1; i++){
            for (int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==k){
                    return true;
                }
            }
        }
        return false;
    }
    //approach2
    public static boolean sumOfPairEqualToTarget11(int[] arr, int k){
        int left=0;
        int right=arr.length-1;
        while (left<right){
            if(arr[left]+arr[right]==k){
                return true;
            }else if(arr[left]+arr[right]>k){
                right--;
            }else {
                left++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {10, 20, 35, 50};
        int target =70;
        boolean b = sumOfPairEqualToTarget(arr, target);
        System.out.println(b);
        boolean b1 = sumOfPairEqualToTarget11(arr, target);
        System.out.println(b1);
    }
}

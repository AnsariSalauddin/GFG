package ArraysQ.Medium;

import java.util.Arrays;
import java.util.HashMap;

public class TowSum {
    //brute approach
    public static int[] twoSumI(int[] arr, int tg){
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                if(i==j)continue;
                if(arr[i]+arr[j]==tg){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    //better approach
    public static int[] twoSumII(int[] arr, int tg){
        HashMap<Integer, Integer> mp=new HashMap<>();
        for (int i=0; i<arr.length;i++){
            if(mp.containsKey(tg-arr[i])){
                return new int[]{mp.get(tg-arr[i]),i};
            }
            mp.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }
    //optimal approach
    public static int[] twoSumIII(int[] arr, int tg){
        int left=0;
        int right=arr.length-1;
        int sum=0;
        while (left<right){
            sum=arr[left]+arr[right];
            if(sum==tg){
                return new int[]{left,right};
            } else if (sum<tg) {
                left++;
            }else {
                right--;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] arr={2,6,5,8,11};
        int[] ints = twoSumII(arr, 14);
        System.out.println(Arrays.toString(ints));
        int[] ints1 = twoSumI(arr, 14);
        System.out.println(Arrays.toString(ints1));
        int[] ints2 = twoSumIII(arr, 14);
        System.out.println(Arrays.toString(ints2));
    }
}

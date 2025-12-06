package ArraysQ.Striver.BS;

import java.util.Map;

public class FindMinimumElementRotatedArray {

    //approach -1
    public static int findTheMinimumElementFromRotatedArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + high ) / 2;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return arr[low];
    }
    //approach-2
    public static int findTheMinimumElementFromRotatedArrayII(int[] arr){
        int low=0;
        int high=arr.length-1;
        int ans=Integer.MAX_VALUE;

        while (low<=high){
            int mid=(low+high)/2;
            if(arr[low]<=arr[high]){
                ans=Math.min(ans,arr[low]);
                break;
            }
            if(arr[low]<=arr[mid]){
               ans= Math.min(ans,arr[low]);
               low=mid+1;
            }else {
                ans=Math.min(ans,arr[mid]);
                high=mid-1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int min = findTheMinimumElementFromRotatedArray(arr);
        System.out.println(min);
        int  min1 = findTheMinimumElementFromRotatedArrayII(arr);
        System.out.println(min1);

    }
}

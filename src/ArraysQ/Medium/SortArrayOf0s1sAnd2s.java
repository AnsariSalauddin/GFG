package ArraysQ.Medium;

import java.util.Arrays;

public class SortArrayOf0s1sAnd2s {
    //better approach
    public static void sortArrayOf0s1sand2s(int[] arr) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zero++;
            } else if (arr[i] == 1) {
                one++;
            } else if (arr[i] == 2) {
                two++;
            }
        }
        int idx = 0;
        while (zero > 0) {
            arr[idx++] = 0;
            zero--;
        }
        while (one > 0) {
            arr[idx++] = 1;
            one--;
        }
        while (two > 0) {
            arr[idx++] = 2;
            two--;
        }
    }
    //optimal:-detach notion flag algorithm
    public static void sortArrayOf0s1sand2sII(int[] arr){
        int low=0;
        int mid=0;
        int high=arr.length-1;
        while (mid<=high){
            if(arr[mid]==0){
                swap(arr,low,mid);
                low++;
                mid++;
            }else if(arr[mid]==1){
                mid++;
            }else if(arr[mid]==2){
                swap(arr,mid, high);
                high--;
            }
        }
    }
    public static void swap(int[] arr, int left, int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;

    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 1, 0, 2, 0, 0, 2, 1, 2};
//        sortArrayOf0s1sand2s(arr);
//        System.out.println(Arrays.toString(arr));
        sortArrayOf0s1sand2sII(arr);
        System.out.println(Arrays.toString(arr));
    }
}

package ArraysQ.Medium;

import java.util.ArrayList;

public class MediumOfTwoSortedArray {
    //brute force approach
    public static int mediumOfTwoSortedArray(int[] arr, int[] arr1){
        int[] res=new int[arr.length+arr1.length];
        int i=0;
        int j=0;
        int k=0;
        while (i<arr.length && j<arr1.length){
            if(arr[i]<=arr1[j]){
                res[k++]=arr[i++];

            } else if (arr[i]>arr1[j]) {
                res[k++]=arr1[j++];
            }
        }
        while (i<arr.length){
            res[k++]=arr[i++];
        }
        while (j<arr1.length){
            res[k++]=arr1[j++];
        }
        int length = res.length;
        if (length % 2 == 1) {
            return res[length / 2];
        } else {
            return (res[length / 2] + res[(length / 2) - 1]) / 2;
        }
    }

    //better approach
    public static int mediumOfTwoSortedArrayII(int[] arr1, int[] arr2){
        return 1;
    }
    public static void main(String[] args) {
        int[] arr={1,3,4,7,10,12};
        int[] arr1={2,3,6,15};
        int i = mediumOfTwoSortedArray(arr, arr1);
        System.out.println(i);
    }
}

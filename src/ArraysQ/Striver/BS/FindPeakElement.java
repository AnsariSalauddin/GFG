package ArraysQ.Striver.BS;

import java.util.ArrayList;
import java.util.Arrays;

public class FindPeakElement {
    //brute force
    public static ArrayList<Integer> findPeakElement(int[] arr){
        ArrayList<Integer> peakEl=new ArrayList<>();
        int n=arr.length;
        if(n==1){
            return new ArrayList<>();
        }
        for (int i=0; i<n; i++){
            if(i==0){
                if(arr[i]>arr[i+1]){
                    peakEl.add(arr[i]);
                }
            }else if (i==n-1){
                if(arr[i]>arr[i-1]){
                    peakEl.add(arr[i]);
                }
            }else {
                if(arr[i]>arr[i+1] && arr[i]>arr[i-1]){
                    peakEl.add(arr[i]);
                }
            }
        }
        return peakEl;
    }
    //peakElement using binary search
    public static int findPeakElementII(int[]arr){
        int n=arr.length;
        int low=0;
        int end=n-1;
        while (low<end){
            int mid=(low+end)/2;
            if (arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
                return mid;
            }
            if(arr[mid]>arr[mid+1]){

            }
        }
        return -1;
    }
    public static void main(String[] args) {

        int[] arr={1, 2, 4, 5, 7, 8, 3};
        ArrayList<Integer> peakElement = findPeakElement(arr);
        System.out.println(peakElement.toString());
    }
}

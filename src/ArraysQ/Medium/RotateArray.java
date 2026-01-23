package ArraysQ.Medium;

import java.util.Arrays;

public class RotateArray {
    public static void rotateOneElementByLeft(int[] arr){
        int temp=arr[0];
        for (int i=1; i<arr.length;i++){
            arr[i-1]=arr[i];
        }
        arr[arr.length-1]=temp;
    }

    public static void rotateKthElment(int[] arr, int n, int d){
        d=d%n;
        int[] temp=new int[d];
        for (int i=0; i<d; i++){
            temp[i]=arr[i];
        }
        for (int i=d;i<n;i++){
            arr[i-d]=arr[i];
        }
        for (int i=n-d;i<n; i++){
            arr[i]=temp[i-(n-d)];
        }
    }

    //Optimal approach
    public static void rotatedArray(int[] arr, int d){
        d=d%arr.length;
        swap(arr,0,d-1);
        swap(arr,d,arr.length-1);
        swap(arr,0,arr.length-1);

    }
    public static void swap(int[] arr, int left, int right){
        while (left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
//        rotateOneElementByLeft(arr);
//        rotateKthElment(arr,arr.length,2);
        rotatedArray(arr,2);
        Arrays.stream(arr).forEach(System.out::println);

    }
}

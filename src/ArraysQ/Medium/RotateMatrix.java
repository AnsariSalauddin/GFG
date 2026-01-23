package ArraysQ.Medium;

import java.util.Arrays;

public class RotateMatrix {
    //brute force
    public static void rotateMatrix(int[][] arr){
        int[][] temp=new int[arr.length][arr[0].length];
        for (int i=0;i<arr.length; i++){
            for (int j=0; j<arr[0].length;j++){
                temp[j][arr.length-1-i]=arr[i][j];
            }
        }
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                arr[i][j]=temp[i][j];
            }
        }
    }


    public static void rotateMatrixII(int[][] arr){
        for (int i=0;i<arr.length-1; i++){
            for (int j=i+1; j<arr[0].length;j++){
                int temp=arr[j][i];
                arr[j][i]=arr[i][j];
                arr[i][j]=temp;
            }
        }

        for (int i=0;i<arr.length;i++){
            int start=0;
            int end=arr[i].length-1;
            while (start<end){
                int temp=arr[i][start];
                arr[i][start]=arr[i][end];
                arr[i][end]=temp;
                start++;
                end--;
            }
        }

    }
    public static void main(String[] args) {
        int[][] arr={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotateMatrixII(arr);
        for (int i=0; i<arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}

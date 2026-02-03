package ArraysQ.Medium;

import java.util.Arrays;

public class SetMatrixZero {
    //brute force
    public static void setMatrixZero(int[][] arr){

        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length;j++){
                if(arr[i][j]==0){
                    markRow(i,arr);
                    markCol(j,arr);
                }
            }
        }

        for (int i=0;i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                if(arr[i][j]==-1){
                    arr[i][j]=0;
                }
            }
        }
    }
    public static void markRow(int i,int[][]arr){
        for (int j=0; j<arr.length;j++){
            if(arr[i][j]!=0){
                arr[i][j]=-1;
            }
        }
    }
    public static void markCol(int j,int[][]arr){
        for (int i=0; i<arr.length;i++){
            if(arr[i][j]!=0){
                arr[i][j]=-1;
            }
        }
    }
    // end here

    //better solution
    public static void setMatrixZeroII(int[][] arr){
        int[] row=new int[arr.length];
        int[] col=new int[arr[0].length];
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length;j++){
                if(arr[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length;j++){
                if(row[i]==1 || col[j]==1){
                    arr[i][j]=0;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] arr={
                {1,1,1,1},
                {1,0,0,1},
                {1,1,0,1},
                {1,1,1,1}
        };
        setMatrixZeroII(arr);
        for (int i=0; i<arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));
    }
}

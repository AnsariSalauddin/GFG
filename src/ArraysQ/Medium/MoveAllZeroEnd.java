package ArraysQ.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveAllZeroEnd {
    //brute force time complexity o(2n)
    public static void  moveAllZeroEnd(int[] arr){
        List<Integer> res=new ArrayList<>();
        for (int i=0; i<arr.length;i++){
            if(arr[i]!=0){
                res.add(arr[i]);
            }
        }
        for (int j=0; j<res.size();j++){
            arr[j]=res.get(j);
        }
        for (int k=res.size(); k<arr.length;k++){
            arr[k]=0;
        }
    }
    //better approach
    public static void moveAllZeroEndII(int[] arr){
        int idx=0;
        for (int j=0; j<arr.length; j++){
            if(arr[j]!=0){
                arr[idx++]=arr[j];
            }
        }
        while (idx<arr.length){
            arr[idx++]=0;
        }
    }
    //optimal approach
    public static void moveAllZeroIII(int[] arr){
        int j=-1;
        for (int i=0;i<arr.length;i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1)return;
        for (int i=j+1; i<arr.length; i++){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={1,0,3,0,0,4,6,0,9,2,1};
//        moveAllZeroEnd(arr);
        moveAllZeroIII(arr);
        Arrays.stream(arr).forEach(System.out::print);

    }
}

package ArraysQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeadersInArrays {
    //brute force
    public static ArrayList<Integer> leaderInArray(int[] arr){
        ArrayList<Integer> res=new ArrayList<>();
        boolean leader=false;
        for (int i=0; i<arr.length; i++){
            leader=true;
            for (int j=i+1; j<arr.length; j++){
                if(arr[j]>arr[i]){
                    leader=false;
                    break;
                }
            }
            if(leader){
                res.add(arr[i]);
            }
        }
        return res;
    }
    //optimal approach
    public static ArrayList<Integer> leaderInArray2(int[] arr){
        int max=Integer.MIN_VALUE;
        int n=arr.length-1;
        ArrayList<Integer> res=new ArrayList<>();
        for (int i=n; i>=0; i--){
            if(arr[i]>max){
                res.add(arr[i]);
            }
           max =Math.max(arr[i],max);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr={10,22,12,3,0,6};
        ArrayList<Integer> arrayList = leaderInArray(arr);
        System.out.println(arrayList.toString());
        ArrayList<Integer> arrayList1 = leaderInArray2(arr);
        System.out.println(arrayList1.reversed());

    }
}

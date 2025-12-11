package ArraysQ.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class ReArrangeElementBySign {
    //brute force
    public static void rearrangeElementBySign(int[] arr){
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();
        for (int i:arr){
            if(i>0){
                pos.add(i);
            }else if(i<0){
                neg.add(i);
            }
        }
        for (int i=0; i<arr.length/2; i++){
            arr[2*i]=pos.get(i);
            arr[2*i+1]=neg.get(i);
        }
    }
    //optimal solution
    public static void  reArrangeElementBySignII(int[] arr){
        int n=arr.length;
        int postIdx=0;
        int negIdx=1;
        int[] ans=new int[n];
        for (int i=0; i<n; i++){
            if(arr[i]<0){
                ans[negIdx]=arr[i];
                negIdx=negIdx+2;
            }else {
                ans[postIdx]=arr[i];
                postIdx=postIdx+2;
            }
        }
        for (int i=0; i<arr.length; i++){
            arr[i]=ans[i];
        }
    }
    //approach- when negative and postive element are not equal to size
    public static void reArrangeElementBySignIII(int[] arr){
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();

        for (int i=0; i<arr.length; i++){
            if(arr[i]<0){
                neg.add(arr[i]);
            }else if(arr[i]>0){
                pos.add(arr[i]);
            }
        }
        if(pos.size()>neg.size()){

            for (int i=0; i<neg.size(); i++){
                arr[2*i]=pos.get(i);
                arr[2*i+1]=neg.get(i);
            }
            int index=neg.size()*2;
            for (int i=neg.size(); i<pos.size(); i++){
                arr[index++]=pos.get(i);
            }
        }else {
            for (int i=0; i<pos.size(); i++){
                arr[2*i]=pos.get(i);
                arr[2*i+1]=neg.get(i);
            }
            int index=pos.size()*2;
            for (int i=pos.size(); i<neg.size(); i++){
                arr[index++]=neg.get(i);
            }
        }

    }
    public static void main(String[] args) {
        int[] arr={3,1,2,-5,-2,-4,4,5};
//        rearrangeElementBySign(arr);
//        System.out.println(Arrays.toString(arr));
//        int[]arr={1,2,-3,-5};
        reArrangeElementBySignII(arr);
        System.out.println(Arrays.toString(arr));
//        reArrangeElementBySignIII(arr);
//        System.out.println(Arrays.toString(arr));
    }
}

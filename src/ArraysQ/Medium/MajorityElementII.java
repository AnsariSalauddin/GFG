package ArraysQ.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class MajorityElementII {
    // Majority Element II - Elements occurring more than ⌊n/3⌋ times

    //brute force
    public static ArrayList<Integer> majorityElement(int[] arr){
        ArrayList<Integer> res=new ArrayList<>();
        for (int i=0; i<arr.length; i++){
            int cnt=0;
            for (int j=i; j<arr.length; j++){
                if(arr[i]==arr[j]){
                    cnt++;
                }
            }
            if(cnt>(arr.length)/3){
                if(res.size()==0 || arr[i]!=res.get(0)){
                    res.add(arr[i]);
                }
            }
            if(res.size()==2){
                if(res.get(0)>res.get(1)){
                    Collections.swap(res,0,1);
                }
                break;
            }
        }
        return res;
    }

    //better approach
    public static ArrayList<Integer> majorityElementII(int[] arr){
        HashMap<Integer,Integer> hm=new HashMap<>();
        ArrayList<Integer> res=new ArrayList<>();
        for (int i:arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
            if(hm.get(i)>(arr.length)/3){
                res.add(i);
            }
            if(res.size()==2){
                if(res.get(0)>res.get(1)){
                    Collections.swap(res,0,1);
                }
                break;
            }
        }
        return res;
    }

    //optimal approach
    public static ArrayList<Integer> majorityElementIII(int[] arr){
        int cnt1=0;
        int el1=-1;
        int cnt2=0;
        int el2=-1;
        for (int i:arr){
            if(cnt1==0 && i!=el2){
                el1=i;
                cnt1++;
            } else if (cnt2==0 && i!=el1) {
                el2=i;
                cnt2++;
            } else if (el1==i) {
                cnt1++;
            } else if (el2==i) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        cnt1=0; cnt2=0;
        for (int i:arr){
            if(el1==i)cnt1++;
            if (el2==i)cnt2++;
        }
        int min=((arr.length)/3)+1;
        if(cnt1>=min) res.add(el1);
        if(cnt2>=min)res.add(el2);
        if(res.get(0)> res.get(1)){
            Collections.swap(res,0,1);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 1, 3, 2, 1, 1};
        ArrayList<Integer> arrayList = majorityElement(arr);
        System.out.println(arrayList.toString());
        ArrayList<Integer> arrayList1 = majorityElementII(arr);
        System.out.println(arrayList1.toString());
        ArrayList<Integer> arrayList2 = majorityElementIII(arr);
        System.out.println(arrayList2.toString());
    }
}

package ArraysQ.Medium;

import java.util.HashMap;

public class MajorityElementInArray {
    //brute approach
    public static int majorityElement(int[] arr){
        for (int i=0; i<arr.length; i++){
            int count=0;
            for (int j=0; j<arr.length; j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>arr.length/2){
                return arr[i];
            }
        }
        return -1;
    }

    //better approach
    public static int majorityElementII(int[] arr){
        HashMap<Integer, Integer> mp=new HashMap<>();
        for (int i=0; i<arr.length; i++){
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
            if(mp.get(arr[i])>arr.length/2){
                return arr[i];
            }
        }
        return -1;
    }
    //optimal solution
    public static int majorityElementIII(int[] arr){
        int count=0;
        int ele=-1;
        for (int in:arr){
            if(count==0){
                count=1;
                ele=in;
            }else if (in==ele){
                count++;
            }else {
                count--;
            }
        }
        int cnt=0;
        for (int in:arr){
            if(in==ele){
                cnt++;
            }
        }
        if(cnt>arr.length/2){
            return ele;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={2,2,3,3,1,2,2};
        int i = majorityElement(arr);
        System.out.println(i);
        int i1 = majorityElementII(arr);
        System.out.println(i1);
        int i2 = majorityElementIII(arr);
        System.out.println(i2);
    }
}

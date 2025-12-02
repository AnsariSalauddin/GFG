package ArraysQ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveElement {
    public static int longestConsecutiveElement(int[] arr){
        int longest=0;
        for (int i=0; i<arr.length;i++){
            int cur=arr[i];
            int count=1;
            while (linearSearch(arr,cur+1)==true){
                cur=cur+1;
                count++;
            }
            longest=Math.max(count,longest);
        }
        return longest;
    }
    public static boolean linearSearch(int[] arr, int cur){
        int i=0;
        while (i<arr.length){
            if(arr[i]==cur){
                return true;
            }
            i++;
        }
        return false;
    }
    //better approach
    public static int longestConsecutiveElementII(int[] arr){
        int count=0;
        int longest=1;
        int lastSmallest=Integer.MIN_VALUE;
        Arrays.sort(arr);
        for (int i=0; i<arr.length; i++){
            if(arr[i]-1==lastSmallest){
                count++;
                lastSmallest=arr[i];
            }else if (arr[i]!=lastSmallest){
                //
                count=1;
                lastSmallest=arr[i];
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    //optimal solution
    public static int longestConsecutiveElementIII(int[] arr){
        HashSet<Integer> hs=new HashSet<>();
        for (int i:arr){
            hs.add(i);
        }
        int longest=1;
        for (int j:hs){
            if(!hs.contains(j-1)){
                int cnt=1;
                int x=j;
                while (hs.contains(x+1)){
                    x=x+1;
                    cnt++;
                }
                longest=Math.max(longest,cnt);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] arr={102,4,100,1,101,3,2,1};
        int i = longestConsecutiveElement(arr);
        int i1 = longestConsecutiveElementII(arr);
        System.out.println(i1);
        System.out.println(i);
        int i2 = longestConsecutiveElementIII(arr);
        System.out.println(i2);
    }
}

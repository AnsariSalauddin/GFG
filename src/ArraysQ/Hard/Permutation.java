package ArraysQ.Hard;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static ArrayList<ArrayList<Integer>> permutation(int[] arr,int idx, ArrayList<ArrayList<Integer>> ds){
        if(arr.length==idx){
            ArrayList<Integer> temp=new ArrayList<>();
            for (int x:arr){
                temp.add(x);
            }
            ds.add(temp);
            return ds;
        }
        for (int i=idx; i<arr.length; i++){
            int temp1=arr[idx];
            arr[idx]=arr[i];
            arr[i]=temp1;
            permutation(arr,idx+1,ds);
            int temp2=arr[idx];
            arr[idx]=arr[i];
            arr[i]=temp2;
        }
        return ds;
    }


    private static void backtrack(int[] nums, boolean[] used,
                                  List<Integer> temp, List<List<Integer>> res) {

        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                temp.add(nums[i]);
                backtrack(nums, used, temp, res);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), res);
        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = permutation(new int[]{1, 2, 3}, 0, new ArrayList<ArrayList<Integer>>());
        System.out.println(arrayLists.toString());

        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println(permute.toString());
    }
}

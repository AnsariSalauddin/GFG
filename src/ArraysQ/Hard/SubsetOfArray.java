package ArraysQ.Hard;

import java.util.ArrayList;

public class SubsetOfArray {
    //print subset
    public static void printAllSubset(int[] arr, ArrayList<Integer> ds, int i) {
        if (i == arr.length) {
            System.out.println(ds.toString());
            return;

        }
        ds.add(arr[i]);
        printAllSubset(arr, ds, i + 1);
        ds.removeLast();
        printAllSubset(arr, ds, i + 1);
    }
    //return list as all subset

    public static ArrayList<ArrayList<Integer>> printAllSubsetII(int[] arr, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> res, int i) {
        if (i == arr.length) {
            res.add(new ArrayList<>(ds));
            return res;
        }
        ds.add(arr[i]);
        printAllSubsetII(arr, ds, res, i + 1);
        ds.removeLast();
        printAllSubsetII(arr, ds, res, i + 1);
        return res;
    }

    //when array contain duplicate values
    public static ArrayList<ArrayList<Integer>> printAllSubsetI2(int[] arr, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> res, int i) {
        if (i == arr.length) {
            res.add(new ArrayList<>(ds));
            return res;
        }
        ds.add(arr[i]);
        printAllSubsetI2(arr, ds, res, i + 1) ;
        ds.removeLast();
        int idx=i+1;
        while (idx<arr.length && arr[idx]==arr[i]){
            idx++;
        }
        printAllSubsetI2(arr, ds, res, idx );
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        printAllSubset(arr, new ArrayList<>(), 0);
        ArrayList<ArrayList<Integer>> arrayLists = printAllSubsetI2(arr, new ArrayList<>(), new ArrayList<ArrayList<Integer>>(), 0);
        System.out.println(arrayLists.toString());
    }
}

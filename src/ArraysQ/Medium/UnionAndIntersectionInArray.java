package ArraysQ.Medium;

import java.util.ArrayList;
import java.util.HashSet;

public class UnionAndIntersectionInArray {
    //brute force
    public static int[] unionOfTwoArray(int[] arr1, int[] arr2) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            hs.add(arr2[i]);
        }
        int[] res = new int[hs.size()];
        int idx = 0;
        for (int i : hs) {
            res[idx++] = i;
        }
        return res;
    }

    //optimal solution
    public static ArrayList<Integer> unionOfTwoArrayII(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if (!res.contains(arr1[i])) {
                    res.add(arr1[i]);
                }
                i++;
            } else {
                if (!res.contains(arr2[j])) {
                    res.add(arr2[j]);
                }
                j++;
            }

        }
        while (i < n1) {
            if (!res.contains(arr1[i])) {
                res.add(arr1[i]);
            }
            i++;
        }
        while (j < n2) {
            if (!res.contains(arr2[j])) {
                res.add(arr2[j]);
            }
            j++;
        }
        return res;
    }

    //brute force approach solution
    public static ArrayList<Integer> intersectionOfTwoArray(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] visit = new int[n2];
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (arr1[i] == arr2[j] && visit[j] == 0) {
                    res.add(arr1[i]);
                    visit[j] = 1;
                    break;
                }
                if (arr2[j] > arr1[i]) break;
            }
        }
        return res;
    }

    //optimal solution
    public static ArrayList<Integer> intersectionOfTwoArrayII(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            } else {
                if (!res.contains(arr1[i])) {
                    res.add(arr1[i]);
                }
                i++;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] arr1 = {1, 2, 3, 3, 5};
//        int[] arr2 = {2, 3, 3, 5, 6, 6, 7};
        int[] arr1 = {3, 4, 2, 2, 4};
        int[] arr2 = {3, 2, 2, 7};
//        int[] ints = unionOfTwoArray(arr1, arr2);
//        Arrays.stream(ints).forEach(System.out::print);
        ArrayList<Integer> arrayList = unionOfTwoArrayII(arr1, arr2);
        arrayList.forEach(System.out::print);
        ArrayList<Integer> arrayList1 = intersectionOfTwoArrayII(arr1, arr2);
        System.out.println();
        arrayList1.forEach(System.out::print);
    }
}

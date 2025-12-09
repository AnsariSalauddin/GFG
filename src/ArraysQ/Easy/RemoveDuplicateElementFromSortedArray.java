package ArraysQ.Easy;

public class RemoveDuplicateElementFromSortedArray {
    public static int removeDuplicateFromSortedArray(int[] arr){
        int n=arr.length;
        int idx=1;
        for (int i=1; i<arr.length; i++){
            if(arr[i]!=arr[i-1]){
                arr[idx++]=arr[i];
            }
        }
        return idx;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int idx= removeDuplicateFromSortedArray(arr);

        for (int i=0; i<idx;i++){
            System.out.println(arr[i]);
        }
    }
}

package ArraysQ.Striver.BS;

public class FindFirstAndLastOccurrence {
    public static int firstOccurrence(int[] arr, int k){
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        while (start<end){
            int mid=(start+end)/2;
            if(arr[mid]==k){
                ans=mid;
                end=mid-1;
            }else if (arr[mid]>k){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        return ans;
    }
    public static int lastOccurrence(int[] arr, int k){
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        while (low<high){
            int mid=(low+high)/2;
            if(arr[mid]==k){
                ans=mid;
                low=mid+1;
            } else if (arr[mid]>k) {
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
    int[] arr={1,2,8,8,8,8,9,10};
        int i = firstOccurrence(arr, 3);
        System.out.println(i);
        int i1 = lastOccurrence(arr, 8);
        System.out.println(i1);

    }
}

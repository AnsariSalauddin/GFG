package ArraysQ.Striver.BS;

public class SearchElementInRotatedArray {
    //this for only unique element
    public static int searchElementInRotateArray(int[] arr, int k){
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==k)return mid;

            if(arr[low]<=arr[mid]){
                if(arr[low]<=k && k<=arr[mid]){
                    high=mid-1;
                }else {
                    low=mid+1;
                }
            }else {
                if(arr[mid]<=k && k<=arr[high]){
                    low=mid+1;
                }else {
                    high=high-1;
                }
            }
        }
        return -1;
    }
    // array contain duplicate element--
    public static int searchElementInRotateArrayII(int[] arr, int k){
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==k)return mid;

            if(arr[mid]==arr[low] && arr[mid]==arr[high]){
                low=low+1;
                high=high-1;
                continue;
            }

            if(arr[low]<=arr[mid]){
                if(arr[low]<=k && k<=arr[mid]){
                    high=mid-1;
                }else {
                    low=mid+1;
                }
            }else {
                if(arr[mid]<=k && k<=arr[high]){
                    low=mid+1;
                }else {
                    high=high-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
    int[] arr={7,8,9,1,2,3,4,5,6};
    int[] arr1={3,1,2,3,3,3,5};
        int i = searchElementInRotateArrayII(arr1, 1);
        System.out.println(i);
    }
}

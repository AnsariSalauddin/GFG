package ArraysQ.Striver.BS;

public class FindHowManyTimeArrayRotated {
    public static int findHowManyTimeArrayRotated(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int findTheMinimumElementFromRotatedArrayII(int[] arr){
        int low=0;
        int high=arr.length-1;
        int ans=Integer.MAX_VALUE;
        int index=-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(arr[low]<=arr[high]){
                if(arr[low]<ans){
                    index=low;
                    ans=arr[low];
                }
                break;
            }
            if(arr[low]<=arr[mid]){
                if(arr[low]<ans){
                    index=low;
                    ans=arr[low];
                }
                low=mid+1;
            }else {
                if(arr[mid]<ans){
                    index=mid;
                    ans=arr[low];
                }
                high=mid-1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        int t = findHowManyTimeArrayRotated(arr);
        System.out.println(t);
        int kk = findTheMinimumElementFromRotatedArrayII(arr);
        System.out.println(kk);
    }
}

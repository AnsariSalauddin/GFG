package ArraysQ.Striver.BS;

public class SingleElementInArrayUsingBS {
    //brute force
    public static int singleElementI(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i] != arr[i + 1]) return arr[i];
            } else if (i == arr.length - 1) {
                if (arr[arr.length - 1] != arr[arr.length - 2]) return arr[i];
            } else {
                if (arr[i] != arr[i + 1] && arr[i] != arr[i - 1]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    //optimal solution
    public static int singleElementII(int[] arr){
        int n=arr.length-1;
        if(n==0)return arr[0];
        if(arr[0]!=arr[1])return arr[0];
        if (arr[n]!=arr[n-1])return arr[n];
        int left=1;
        int right=n-1;

        while (left<right){
            int mid=(left+right)/2;
            if(arr[mid]!=arr[mid+1] && arr[mid]!=arr[mid-1]){
                return arr[mid];
            }else if((mid%2==1 &&arr[mid-1]==arr[mid]) || (mid%2==0 && arr[mid]==arr[mid+1]) ){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,3,4,5,5};
        int i = singleElementI(arr);
        System.out.println(i);
        int i1 = singleElementII(arr);
        System.out.println(i1);

    }
}

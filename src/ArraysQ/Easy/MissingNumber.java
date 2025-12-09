package ArraysQ.Easy;

public class MissingNumber {
    //brute approach solution
    public static int missingNumber(int[] arr){
        for (int i=1; i<=arr.length+1; i++){
            int flag=0;
            for (int j=0; j<arr.length;j++){
                if(arr[j]==i){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                return i;
            }
        }
        return -1;
    }
    //better Solution
    public static int missingNumberII(int[] arr){
        int[] hash=new int[arr.length+1];
        for (int i=0; i<arr.length; i++){
            hash[arr[i]]++;
        }
        for (int i=1; i<hash.length; i++){
            if(hash[i]==0){
                return i;
            }
        }
        return -1;
    }
    //better approach
    public static int missingNumberIII(int[]arr){
        int n=arr.length;
        int actSum=(n*(n+1))/2;
        int sum=0;
        for (int i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        return actSum-sum;
    }

    //better approach
    public static int missingNumberIV(int[] arr,int N){
        int xor1=0;
        int xor2=0;
        for (int i=0; i<arr.length; i++){
            xor1=xor1^arr[i];
            xor2=xor2^(i+1);
        }
        xor1 = xor1 ^ N;
        return xor1^xor2;
    }
    public static void main(String[] args) {
        int[] arr={1,2,4,5,6};
        int i = missingNumber(arr);
        System.out.println(i);
//        int i1 = missingNumberII(arr);
//        System.out.println(i1);
//        int i2 = missingNumberIII(arr);
//        System.out.println(i2);
//        int i = missingNumberIV(arr, 6);
//        System.out.println("final--"+ i);

    }
}

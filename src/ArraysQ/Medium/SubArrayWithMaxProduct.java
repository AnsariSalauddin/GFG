package ArraysQ.Medium;

public class SubArrayWithMaxProduct {
    //optimal approach
    public static int subArrayWithMaxProduct(int[] arr){
        int pre=1;
        int suf=1;
        int res=Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++){
            if(pre==0)pre=1;
            if(suf==0)suf=1;
            pre=pre*arr[i];
            suf=suf*arr[arr.length-1-i];
            res=Math.max(res, Math.max(pre,suf));
        }
        return res;
    }
    //brute force
    public static int maxProductII(int[] arr){
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        for (int i=0; i<n;i++){
            int product=1;
            for (int j=i; j<n;j++){
                product*=arr[j];
                max=Math.max(max,product);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr={-2, 6, -3, -10, 0, 2};
        int i = subArrayWithMaxProduct(arr);
//        System.out.println(i);
        int i1 = maxProductII(new int[]{2,-3,4});
        System.out.println(i1);
    }
}

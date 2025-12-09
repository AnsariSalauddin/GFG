package ArraysQ.Easy;

public class MaximumConsecutive1s {
    public static int maximumConsecutive_1s(int[] arr){
        int max=0;
        int count=0;
        for (int i:arr){
            if(i==1){
                count++;
               max= Math.max(count,max);
            }else {
                count=0;

            }
        }
        return max;
    }

    //second for maximum consective 1 eg.{1,1,1,1,1}
    public static void main(String[] args) {
        int max[]={1,1,0,1,1,1,1,1,0,1,1,0};
        System.out.println(maximumConsecutive_1s(max));

    }
}

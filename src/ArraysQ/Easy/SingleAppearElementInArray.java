package ArraysQ.Easy;

public class SingleAppearElementInArray {
    //brute force
    public static int singleAppeareElmenetInArray(int[] arr){
        int num=0;
        for (int i=0; i<arr.length; i++){
            num=arr[i];
            int count=0;
            for (int j=0; j<arr.length; j++){
                if(num==arr[j]){
                    count++;
                }
            }
            if(count==1)return num;
        }
        return -1;
    }
    //we can use hashing
    /* code here*/

    // we can use Map data structure
    /* code here*/

    //optimal solution using xor
    public static int singleAppearElementInArrayII(int[] arr){
        int xor=0;
        for (int i=0; i<arr.length; i++){
            xor=xor^arr[i];
        }
        return xor;
    }
    public static void main(String[] args) {
        int[] arr={1,2,2,3,3,1,5,6,6,7,7};
        int i = singleAppeareElmenetInArray(arr);
        System.out.println(i);
        int i1 = singleAppearElementInArrayII(arr);
        System.out.println(i1);
    }
}

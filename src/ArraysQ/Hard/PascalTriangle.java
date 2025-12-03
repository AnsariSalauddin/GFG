package ArraysQ.Hard;

import java.util.ArrayList;

public class PascalTriangle {
    //when calculate the n th row and nth col element from pascal
    public static int giveNthRowNthCoulumElement(int row, int col){
        int res=1;
        for (int i=0;i<col-1; i++){
            res=res*(row-1);
            res=res/(i+1);
        }
        return res;
    }
    //print the all element of nth row -> First Approach
    public static ArrayList<Integer> allElementOfNthRowFromPascalI(int row){
        ArrayList<Integer> res=new ArrayList<>();
        for (int i=1; i<=row;i++){
            int i1 = giveNthRowNthCoulumElement(row , i );
            res.add(i1);
        }
        return res;
    }
    //print the all element of nth row -> Second Approach
    public static ArrayList<Integer>  allElementOfNthRowFromPascalII(int row){
        ArrayList<Integer> res=new ArrayList<>();
        int ans=1;
        res.add(ans);
        for (int i=1; i<row; i++){
            ans=ans*(row-i);
            ans=ans/i;
            res.add(ans);
        }
        return res;
    }

    //print all pascal
    public static void pascal(int row){
        for (int i=1; i<=row; i++){
            int ans=1;
            System.out.print(ans+" ");
            for (int j=1; j<i; j++){
                ans=ans*(i-j);
                ans=ans/j;
                System.out.print(ans+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int i = giveNthRowNthCoulumElement(4, 1);
        System.out.println(i);
        ArrayList<Integer> arrayList = allElementOfNthRowFromPascalI(1);
        System.out.println(arrayList.toString());
        ArrayList<Integer> arrayList1 = allElementOfNthRowFromPascalII(1);
        System.out.println(arrayList1.toString());
        pascal(4);
    }
}

package StringQ.GFG.Easy;

public class checkIfStringIsIsogramOrNot {
    static boolean isIsogram(String data) {
       boolean[] seen=new boolean[26];
       for (char ch:data.toCharArray()){
           int idx=ch-'a';
           if(seen[idx]){
               return false;
           }
           seen[idx]=true;
       }
       return true;
    }
    public static void main(String[] args) {
      String  s = "machine";
        boolean isogram = isIsogram(s);
        System.out.println(isogram);

    }
}

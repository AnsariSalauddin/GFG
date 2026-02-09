package StringQ.GFG.Easy;

public class CheckTwoStringAlmostEquivalent {
    public static boolean checkTwoStringEquivalent(String str1,String str2){
        int[] count=new int[26];
        for (int i=0; i<str1.length(); i++){
            count[str1.charAt(i)-'a']++;
            count[str2.charAt(i)-'a']--;
        }
        for (int j=0; j<26;j++){
            if(Math.abs(count[j])>3){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}

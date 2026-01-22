package StringQ.Striver;
//Reverse a string preserving space positions

public class ReverseStringPreserveSpacePosition {
    public static String reverseString(String str){
        char[] charArray = str.toCharArray();
        char[] result=new char[charArray.length];
        for (int i=0; i<charArray.length; i++){
            if(charArray[i]==' '){
                result[i]=' ';
            }
        }
        int j=charArray.length-1;
        for (int i=0; i<charArray.length; i++){
            if(charArray[i]!=' '){
                if(result[j]==' '){
                    j--;
                }
                result[j]=charArray[i];
                j--;
            }
        }
        return  String.valueOf(result);
    }

    public static String reverseStringPreserveSpace(String str){
        int left=0;
        int right=str.length()-1;
        char[] charArray = str.toCharArray();
        while (left<right){
            if(charArray[left]==' '){
                left++;
                continue;
            } else if (charArray[right]==' ') {
                right--;
                continue;
            }else {
                char temp=charArray[left];
                charArray[left]=charArray[right];
                charArray[right]=temp;
                left++;
                right--;
            }
        }
        return String.valueOf(charArray);
    }
    public static void main(String[] args) {
        String s = "internship at geeks for geeks";
        String s1 = reverseString(s);
        System.out.println(s1);
        String s2 = reverseStringPreserveSpace(s);
        System.out.println(s2);
    }
}

package StringQ.Striver;

public class AddString {
    public static String addString(String str1, String str2){
        StringBuilder sb=new StringBuilder();
        int i=str1.length()-1;
        int j=str2.length()-1;
        int carry=0;

        while (i>=0 || j>=0 || carry!=0){
            int digit1=i>=0?str1.charAt(i)-'0':0;
            int digit2=j>=0?str2.charAt(j)-'0':0;
            int sum=digit2+digit1+carry;
            carry=sum/10;
            sb.append(sum%10);
            i--;
            j--;
        }

        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String str="223";
        String str1="911";
        String s = addString(str1, str);
        System.out.printf(s);
    }
}

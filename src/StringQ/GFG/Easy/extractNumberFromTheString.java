package StringQ.GFG.Easy;

public class extractNumberFromTheString {
    public static long extractNumber(String sentence) {
        // code here
        String[] s = sentence.split(" ");
        Long max=0l;
        for (String st:s){
            if (st.matches("\\d+")) {
                long val = Long.parseLong(st);
                if (val > max) {
                    max =val;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
       String sentence="This is alpha 5057 and 97";
        long l = extractNumber(sentence);
        System.out.println(l);
    }
}

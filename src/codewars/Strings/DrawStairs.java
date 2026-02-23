package codewars.Strings;

public class DrawStairs {
    public String drawStairs(int n){
        StringBuilder sb=new StringBuilder();
        for (int i=0; i<n; i++){
            sb.append(" ".repeat(i)).append("I");
            if(i<n-1){
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        DrawStairs d=new DrawStairs();
        String s = d.drawStairs(7);
        System.out.println(s);
    }
}

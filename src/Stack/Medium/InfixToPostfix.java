package Stack.Medium;

import java.util.Stack;

public class InfixToPostfix {
    public static int priority(char ch){
       int val=switch (ch){
            case '^'->3;
            case '*','/'->2;
            case '+','-'->1;
           default -> -1;
        };
       return val;
    }
    public static String infixToPostfix(String str){
        String ans="";

        Stack<Character> st=new Stack<>();
        for (int i=0; i<str.length(); i++){
            char cur=str.charAt(i);
            if((cur>='A' && cur<='Z') || (cur>='a' && cur<='z') ||(cur>='0' &&cur<='9')){
                ans+=cur;
            }else if(cur=='('){
                st.push(cur);
            }else if(cur==')'){
                while (!st.isEmpty() && st.peek()!='('){
                    ans+=st.pop();
                }
                st.pop();
            }else {
                while (!st.isEmpty() && priority(cur)<=priority(st.peek())){
                    ans+=st.pop();
                }
                st.push(cur);
            }

        }
        while (!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
//        String str="A+B*C-D/E";
//        String str="(A+B)*(C-D)^E";
        String str="(5+3)*(8-2)/4";
        String s = infixToPostfix(str);
        System.out.println(s);

    }
}

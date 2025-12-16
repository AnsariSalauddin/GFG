package Stack.Easy;

import java.util.Stack;

public class CheckValidParenthesis {
    public static boolean checkValidParenthesis(String string){
        Stack<Character> st=new Stack<>();
        for (int i=0;i<string.length(); i++){
            char cur=string.charAt(i);
            if(cur=='(' || cur=='{' || cur=='['){
                st.push(cur);
            }else {
                if(st.isEmpty())return false;
                char pop=st.pop();
                if(cur==')' && pop!='(')return false;
                if(cur=='}' && pop!='{')return false;
                if(cur==']' && pop!='[')return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str="()[{(})]";
        boolean b = checkValidParenthesis(str);
        System.out.println(b);

    }
}

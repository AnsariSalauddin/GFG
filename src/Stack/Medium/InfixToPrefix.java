package Stack.Medium;
import java.util.Stack;

public class InfixToPrefix  {

    // function to return precedence
    static int precedence(char c) {
        if (c == '^') return 3;
        else if (c == '*' || c == '/') return 2;
        else if (c == '+' || c == '-') return 1;
        else return -1;
    }

    static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    // check if operator is right-associative
    static boolean isRightAssociative(char c) {
        return (c == '^');
    }

    // function to convert infix to prefix using reverse-trick
    static String infixToPrefix(String s) {
        // reverse string
        StringBuilder sb = new StringBuilder(s).reverse();
        char[] arr = sb.toString().toCharArray();

        // swap ( and )
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') arr[i] = ')';
            else if (arr[i] == ')') arr[i] = '(';
        }

        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();

        // infix to postfix on reversed string
        for (char c : arr) {
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            else if (c == '(') {
                st.push(c);
            }
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result.append(st.pop());
                }
                if (!st.isEmpty()) st.pop();
            }
            else if (isOperator(c)) {
                while (!st.isEmpty() && st.peek() != '(' &&
                        (precedence(st.peek()) > precedence(c) ||
                                (precedence(st.peek()) == precedence(c) && isRightAssociative(c)))) {
                    result.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "a*(b+c)/d";
        System.out.println(infixToPrefix(s));
    }
}
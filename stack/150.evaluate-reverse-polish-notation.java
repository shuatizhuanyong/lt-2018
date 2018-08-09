import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0 ; i < tokens.length ; i++) {
            String t = tokens[i];
            if (isNumber(t)) {
                st.push(Integer.parseInt(t));
                continue;
            }
            int n2 = st.pop();
            int n1 = st.pop();
            st.push(cal(n1, n2, t.charAt(0)));
        }
        return st.peek();
    }
    int cal (int n1, int n2, char sign) {
        if (sign == '/') return n1 / n2;
        if (sign == '*') return n1 * n2;
        if (sign == '+') return n1 + n2;
        return n1 - n2;
    }
    boolean isNumber(String str) {
        try {
            return str.equals(Integer.parseInt(str) + "");
        } catch(Exception e) {
            return false;
        }
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        int res = -1; 
        res = so.evalRPN(new String[]{"4", "13", "5", "/", "+"});
        System.out.println(res);
    }
}

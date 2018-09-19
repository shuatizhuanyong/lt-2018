import java.util.*;
class Solution {
    public int calPoints(String[] ops) {
        if (ops == null ||  ops.length == 0) return 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0 ; i < ops.length ; i++) {
            String cur = ops[i];
            if (cur.equals("D")) {
                if(!st.isEmpty()) {
                    st.push(st.peek() * 2);
                }
            } else if (cur.equals("C")) {
                if(!st.isEmpty()) {
                    st.pop();
                }
            } else if (cur.equals("+")) {
                if (st.size() >= 2) {
                    int n0 = st.pop();
                    int sum = st.peek() + n0;
                    st.push(n0);
                    st.push(sum);
                }
            } else {
                int num = Integer.valueOf(cur);
                st.push(num);
            }
        }
        int res = 0;
        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int res = -1; 
        res = so.calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
        System.out.println(res);
    }
}

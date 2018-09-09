import java.util.*;
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.replaceAll(" ", "");
        s = s + " ";
        char[] chs = s.toCharArray();
        //System.out.println(Arrays.toString(chs));
        char sign = '+';
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int cur = 0;
        
        while (i < chs.length) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                while (i < chs.length && chs[i] >= '0' && chs[i] <= '9') {
                    //System.out.println(chs[i]);
                    cur = cur * 10 + (chs[i] - '0');
                    i++;
                }
            } else {
                if (sign == '+') {
                    st.push(cur);
                } else if (sign == '-') {
                    st.push(0 - cur);
                } else if (sign == '*') {
                    st.push(cur * st.pop());

                } else if (sign == '/') {
                    st.push(st.pop() / cur);
                }
                sign = chs[i];
                cur = 0;
                i++;
            }
        }
        //System.out.println(st);
        while (!st.isEmpty()) {
            cur += st.pop();
        }
        return cur;

    }
    public static void main (String[] args) {
        Solution so = new Solution();
        int rs = 0 ;
        rs = so.calculate("1+2*3");
        System.out.println(rs);
        rs = so.calculate("1-2*3");
        System.out.println(rs);

    }
}

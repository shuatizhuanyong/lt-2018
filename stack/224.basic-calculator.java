import java.util.*;
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.replaceAll(" ", "");
        char[] chs = s.toCharArray();
        int i = 0;
        char op = '+';
       
        Stack<Integer> st = new Stack<>();
        while (i < chs.length) { 
//            System.out.println(chs[i]);
            if (Character.isDigit(chs[i])) {
                int cur = 0;
                while (i < chs.length && Character.isDigit(chs[i])) {
                    cur = cur * 10 + (chs[i] - '0');
                    i++;
                }
                if (op == '+') {
                    st.push(cur);
                } else {
                    st.push(0 - cur);
                }
            } else if (chs[i] == '+' || chs[i] == '-') {
                op = chs[i];
                i++;
            } else if (chs[i] == '('){
                int j = i;
                int cnt = 0;
                while (j < chs.length) {
                    if (chs[j] == '(') cnt++;
                    if (chs[j] == ')') cnt--;
                    if (cnt == 0) break;
                    j++;
                }
                int num = calculate(s.substring(i + 1, j));
                i = j + 1;
                if (op == '+') {
                    st.push(num);
                } else {
                    st.push(0 - num);
                }
            }
        }
        int res = 0;
        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }
    public static void main (String args[]) {
        Solution so = new Solution();
        int res = 0;
        res = so.calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(res);
    }
}
class Solution0 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.replaceAll(" ", "");
        char[] chs = s.toCharArray();
        int i = 0;
        char op = '+';
        int num = 0;
        Stack<Integer> st = new Stack<>();
        while (i < chs.length) {
            if (Character.isDigit(chs[i])) {
                while (i < chs.length && Character.isDigit(chs[i])) {
                    num = num * 10 + (chs[i] - '0');
                    i++;
                }
            } else if (chs[i] == '(') {
                int j = i;
                int cnt = 0;
                while (j < chs.length) {
                    if (chs[j] == '(') cnt++;
                    if (chs[j] == ')') cnt--;
                    if (cnt == 0) break;
                    j++;
                }
                num = calculate(s.substring(i + 1, j));
                i = j + 1;
            }
            if (i >= chs.length || chs[i] == '+' || chs[i] == '-')  {
                if (op == '+') {
                    st.push(num);
                } else {
                    st.push(0 - num);
                }
                if (i >= chs.length) break;
                op = chs[i];
                num = 0;
                i++;
            }
        }
        int res = 0;
        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }
}

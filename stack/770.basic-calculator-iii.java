import java.util.*;
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.replaceAll(" ", "");
        char[] chs = s.toCharArray();
        int i = 0, res = 0;
        char op = '+';
        Stack<Integer> st = new Stack<>();
        while (i < chs.length) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                int cur = 0;
                while (i < chs.length && chs[i] >= '0' && chs[i] <= '9') {
                    cur = cur * 10 + (chs[i] - '0');
                    i++;
                }
                st.push(calculateWithSign(cur, op, st));
            } else if (chs[i] == '+' || chs[i] == '-' || chs[i] == '/' || chs[i] == '*') {
                op = chs[i];
                i++;
            }else if (chs[i] == '(') {
                int j = i;
                int cnt = 0;
                while (j < chs.length) {
                    if (chs[j] == '(') cnt++;
                    if (chs[j] == ')') cnt--;
                    if (cnt == 0) break;
                    j++;
                }
                int num = calculate(s.substring(i + 1, j));
                st.push(calculateWithSign(num, op, st));
                i = j + 1;
            }
        }
        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }
    int calculateWithSign(int cur, char op, Stack<Integer> st) {
        if (op == '+') {
            return cur;
        } else if (op == '-') {
            return 0 - cur;
        } else if (op == '/') {
            return st.pop() / cur;
        } else {
            return st.pop() * cur;
        }
    }
    public static void main (String args[]) {
        Solution so = new Solution();
        int res  = 0 ;
        res = so.calculate("2*(5+5*2)/3+(6/2+8)");
        System.out.println(res);
    }
}

import java.util.*;
class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;
        Stack<String> strs = new Stack<>();
        Stack<Integer> times = new Stack<>();
        String cur = "";
        int d = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (c == '[') {
                times.push(d);
                d = 0;
            } else if (c == ']') {
                int t = times.pop();
                if (cur.equals("")) cur = strs.pop();
                //System.out.println("cur:"+ cur + ", time:" + t + ", size:" + strs.size());
                
                cur = timeString(cur, t);
                if (!strs.isEmpty()) {
                    String top = strs.pop();
                    //System.out.println(top);
                    cur = top + cur;
                }
                strs.push(cur);
                cur = "";

            }else {
                if (Character.isLetter(c)) {
                    cur += c;
                    if (d > 0) {
                        times.push(d);
                        d = 0;
                    }
                } else {
                    d = d * 10 + (int)(c - '0');
                    if (!cur.equals(""))  {
                        strs.push(cur);
                        cur = "";
                    }
                }
            }
        }
        while (!strs.isEmpty()) {
            sb.insert(0, strs.pop());
        }
        
        //System.out.println(times.size());
        //System.out.println(strs.peek());
        return sb.toString() + cur;
    }
    public static void main(String args[]) {
        Solution0 so = new Solution0();
        String res ;
       // res = so.decodeString("3[a]2[bc]");
       // System.out.println(res);
        res = so.decodeString("2[2[a]]");
        System.out.println(res);
        res = so.decodeString("2[2[a]2[b]]");
        System.out.println(res);
        res = so.decodeString("2[a3[b]]");
        System.out.println(res);
        res = so.decodeString("2[a3[b]cd3[e]]");
        System.out.println(res);


    }
    String timeString(String s, int times) {
        StringBuilder sb = new StringBuilder();
        while (times-- > 0) {
            sb.append(s);
        }
        return sb.toString();
    }

}

class Solution0 {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;
        Stack<String>  st = new Stack<>();
        String cur = null;
        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (c == '[') {
                st.push(cur);
                cur = null;
            } else if (c == ']') {
                //System.out.println(st);
                while (!st.isEmpty() && !isNumber(st.peek())) {
                 if (cur == null) cur = "";   
                 cur = st.pop() + cur;
                }
                //if (cur == null) cur = st.pop();
                int times = Integer.valueOf(st.pop());
                st.push(repeatString(cur, times));
                cur = null;
            } else {
                if (cur == null) {
                    cur = "" + c;
                    continue;
                }
                if (isNumber(cur) ^ Character.isDigit(c)) {
                    st.push(cur);
                    cur = "" + c;
                } else {
                    cur = cur + c;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        if (cur != null) sb.append(cur);
        return sb.toString();
    }
    String repeatString(String str, int t) {
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(str);
        }
        return sb.toString();
    }
    boolean isNumber (String str) {
        for (int i = 0 ; i < str.length() ; i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return str.length() > 0;
    }
}

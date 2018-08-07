class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;
        char[] chs = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0 ; i < chs.length ; i++) {
            char ch = chs[i];
            if (isLeft(ch)) {
                st.push(ch);
            } else {
                if (st.isEmpty()) return false;
                char left = st.pop();
                if (!isPair(left, ch)) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    boolean isPair(char left, char right) {
        return (left == '(' && right == ')') ||
            (left == '{' && right == '}') ||
            (left == '[' && right == ']');
    }
    boolean isLeft(char c) {
        return c == '(' || c == '[' || c == '{';
    }
}

// Worst Problem in lj, how to gather all requirements
class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        char[] chs = s.toCharArray();
        int start = 0;
        while (start < chs.length) {
            if (chs[start] == ' ') {
                start++;
            } else break;
        }
        if (start == chs.length) return false;
        boolean isNeg = false, hasPoint = false;
        if (chs[start] == '+' || chs[start] == '-') {
            isNeg = (chs[start] == '-');
            start++;
        }
        if (start < chs.length && chs[start] == '.') {
            hasPoint = true;
            start++;
        }
        boolean hasNumber = false, hasENumber = false;
        boolean hasE = false;
        while (start < chs.length) {
            char c = chs[start];
            if (c == 'e') {
                if(!hasNumber || hasE) return false;
                hasE = true;
            } else if (c == '.') {
                if (hasPoint || hasE) return false;
                hasPoint = true;
            //    start++;
            } else if(c == '-' || c == '+') {
                if(!hasE || (hasE && chs[start - 1]!= 'e')) {
                    return false;
                }   
            } else if (!Character.isDigit(c)){
                break;
            } else {
                if (!hasE)  hasNumber = true;
                else hasENumber = true;
            }
            start++;
        }
        while (start < chs.length) {
            //System.out.println("start at [start]" + (chs[start]));
            if (chs[start] == ' ') {
                start++;
            } else return false;
        }
        if (hasE) {
            return hasNumber && hasENumber;
        }
        return hasNumber;
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        boolean r = false;
        r = so.isNumber("ab");
        System.out.println(r);
        r = so.isNumber("-.4");
        System.out.println(r);
        r = so.isNumber("-.4e2.2");
        System.out.println(r);
        r = so.isNumber("-.4e22");
        System.out.println(r);
        r = so.isNumber("-.4.e22");
        System.out.println(r);
        //not cover the following cases
        r = so.isNumber(".");
        System.out.println(r);
        r = so.isNumber(".4e");
        System.out.println(r);
        r = so.isNumber("4k");
        System.out.println(r);
        r = so.isNumber("-.3e+1");
        System.out.println(r);
        r = so.isNumber("-.3e2+1");
        System.out.println(r);
    }
}

//[tags] two-pointers
class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= numRows || numRows < 2) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0 ; i < numRows ; i++) sbs[i] = new StringBuilder();
        int dir = 0, j = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            sbs[j].append(c);
            if (dir == 0) {
                j++;
            } else j--;
            if (j == -1) {
                j = 1;
                dir = 0;
            }  else if (j == numRows) {
                j = numRows - 2;
                dir = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder subsb : sbs) {
            sb.append(subsb.toString());
        }
        return sb.toString();
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        String rs = null;
        rs = so.convert("PAYPALISHIRING", 3);
        System.out.println(rs);

    }
}

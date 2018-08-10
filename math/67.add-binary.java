class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        int carry = 0, i = 0;
        a = reverse(a);
        b = reverse(b);
        StringBuilder sb = new StringBuilder();
        while (i < a.length() || i < b.length()) {
            int digit = (i >= a.length() ? 0 : (int)(a.charAt(i) - '0')) +
                (i >= b.length() ? 0 : (int)(b.charAt(i) - '0')) + carry;
            carry = digit / 2;
            digit = digit % 2;
            sb.insert(0, digit);
            i++;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
    String reverse(String a) {
        StringBuilder sb = new StringBuilder(a);
        return sb.reverse().toString();
    }
}

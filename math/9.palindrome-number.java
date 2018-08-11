class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int origin = x, rev = 0;
        while (x != 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev == origin;
        
    }
    public static void main (String args[]) {
        System.out.println(Integer.MAX_VALUE + 1 == Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE - 1 == Integer.MAX_VALUE);
    }
}

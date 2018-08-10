class Solution {
    String[] RS = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    int[] DS = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num < DS[i]) {
                i++;
                continue;
            }
            num -= DS[i];
            sb.append(RS[i]);
        }
        return sb.toString();
    }
}

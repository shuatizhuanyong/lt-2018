public class Solution {
    public String reverseWords(String s) {
        String[] substrs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for( int i = substrs.length - 1 ; i >= 0 ; i--) {
            if (substrs[i].length() > 0 ) {
                sb.append(substrs[i] + " ");
            }
        }
        if (sb.length() > 0) return sb.toString().substring(0 ,sb.length() - 1);
        return "";
    }

}

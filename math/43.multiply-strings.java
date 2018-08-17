import java.util.*;
class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null ||num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "0";
        }
        int [] arr = new int[num1.length() + num2.length()];
        char[] chn1 = num1.toCharArray();
        char[] chn2 = num2.toCharArray();
        reverse(chn1);
        reverse(chn2);
        //int carry = 0;
        for (int i = 0 ; i < chn1.length ; i++ ) {
            for (int j = 0 ; j < chn2.length ; j++) {
                int mu = (chn2[j] - '0') * (chn1[i] - '0');
                int sum = arr[i + j] + mu;
                arr[i + j] = sum % 10;
                arr[i + j + 1] += sum / 10;
            }
        }
       // if (carry > 0) {
       //     arr[arr.length - 1] = carry;
       // }
        StringBuilder sb = new StringBuilder();
        int end = arr.length - 1;
        while (end >= 0) {
            if( arr[end] != 0) break;
            end--;
        }
        while(end >= 0) {
            sb.append(arr[end--]);
        }
        return sb.length() > 0 ? sb.toString(): "0";
    }
    void reverse(char[] a) {
        int i = 0, j = a.length - 1;
        while (i < j) {
            char t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
    }
    public static void main (String[] args) {
        Solution so = new Solution();

        String res;
        res  = so.multiply("2", "8");
        System.out.println(res);
        res  = so.multiply("1234", "321");
        System.out.println(res);
    }
}

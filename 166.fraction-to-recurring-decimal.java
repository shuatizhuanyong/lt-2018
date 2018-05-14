import java.util.*;
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) throw new RuntimeException("Denminator should not be zero");
        StringBuilder sb = new StringBuilder();
        if (( numerator > 0 ) ^ ( denominator > 0 )) {
            sb.append('-');
        }
        long digit = Math.abs((long)numerator / (long)denominator);
        long carry = Math.abs((long)numerator % (long)denominator);
        if (digit != 0) {
            sb.append(digit);
        } else {
            sb.append('0');
        }

        if (carry == 0) {
            return sb.toString();
        }
        sb.append('.');
        StringBuilder fracs = new StringBuilder();
        while (carry < denominator / 10) {
            carry *= 10;
            fracs.append('0');
        }
        Map<Long, Integer> map = new HashMap<>();
        while (carry != 0) {
            while (carry < denominator) {
                carry *= 10;
            }
            //System.out.println("carry = " + carry + " ,d=" +(carry / denominator) + ", fracs:" + fracs );
            long d = carry / denominator;
            carry = carry % denominator; 
            if (map.containsKey(d)){
                fracs.insert(map.get(d), "(");
                fracs.append(")");
                break;
            } else {
                map.put(d, fracs.length());
                fracs.append(d);
            }
        }
        return sb.append(fracs).toString();
    }
    public static void main (String args[]) {
        Solution so = new Solution();
        //String res = so.fractionToDecimal(1, 3);
        //System.out.println(res); res = so.fractionToDecimal(1, 72);
        System.out.println(so.fractionToDecimal(1, 3));
        System.out.println(so.fractionToDecimal(1, 72));
        System.out.println(so.fractionToDecimal(3, 729));
    }
}

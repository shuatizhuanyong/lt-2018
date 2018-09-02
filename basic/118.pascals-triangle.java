import java.util.*;
class Solution { public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rs = new ArrayList<>();
        if (numRows == 0) return rs;
        rs.add(Arrays.asList(1));
        if (numRows == 1) return rs;
        for (int i = 2 ; i <= numRows ; i++) {
            List<Integer> row  = new ArrayList<>();
            row.add(1);
            List<Integer> last = rs.get(rs.size() - 1);
            for (int j = 1 ; j < last.size() ; j++) {
                row.add(last.get(j - 1) + last.get(j));
            }
            row.add(1);
            rs.add(row);
        }
        return rs;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        List<List<Integer>> rs = null;
        rs = so.generate(5);
        System.out.println(rs);

    }
}

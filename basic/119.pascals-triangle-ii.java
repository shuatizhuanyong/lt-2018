// extra space complexity: O(n) -- n is row
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rs = new ArrayList<>();
        if (rowIndex < 0) return rs;
        rs.add(1);
        for (int i = 1 ; i <= rowIndex ; i++) {
            List<Integer> tmp = new ArrayList<>(rs);
            rs = new ArrayList<>();
            rs.add(1);
            for (int j = 1 ; j < tmp.size() ; j++) {
                rs.add(tmp.get(j - 1) + tmp.get(j));
            }
            rs.add(1);
        }
        return rs;
    }
}


// constant space complexity
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rs = new ArrayList<>();
        if (rowIndex < 0) return rs;
        rs.add(1);
        for (int i = 1 ; i <= rowIndex ; i++) {
            rs.add(1);
            for (int j = rs.size() - 2 ; j > 0 ; j--) {
                rs.set(j, rs.get(j) + rs.get(j - 1));
            }
        }
        return rs;
    }
}

class Solution {
    Map<Integer, Integer> mapping = new HashMap<>();

    private void initMapping() {
        mapping.put(0, 0);
        mapping.put(1, 1);
       // mapping.put(2, 5);
       // mapping.put(5, 2);
        mapping.put(6, 9);
        mapping.put(8, 8);
        mapping.put(9, 6);
    }
    public boolean isStrobogrammatic(String num) {
        initMapping();
        int i = 0, j = num.length() - 1;
        while (i <= j) {
            int left = Integer.parseInt(num.substring(i, i + 1));
            int right = Integer.parseInt(num.substring(j, j + 1));
            if (mapping.get(left) != null && mapping.get(right) != null && mapping.get(left) == right && mapping.get(right) == left) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}

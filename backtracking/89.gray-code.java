class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        List<String> res = new ArrayList<>();

        if (n < 1) return Arrays.asList(0);
        res.add("0");
        res.add("1");
        for (int i = 1 ; i < n ; i++) {
            List<String> tmplist = new ArrayList<>();
            for (int j = 0 ; j < res.size(); j++) {
                tmplist.add("0" + res.get(j));
            }
            for (int j = res.size() - 1 ; j >= 0; j--) {
                tmplist.add("1" + res.get(j));
            }
            res = tmplist;
        }
        for (int i = 0 ; i < res.size() ; i++) {
            String s = res.get(i);
            int num = 0;
            int j = 0;

            while (j < s.length()) {
                if (s.charAt(j) != '0') break;
                j++;
            }
            while (j < s.length()) {
                num = num * 2 + (s.charAt(j) == '1' ? 1: 0);
            }
            list.add(num);
        }
        return list;
    }
}

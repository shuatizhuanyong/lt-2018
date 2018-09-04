import java.util.*;
/*
 * [tags] union-find
 * */
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) return res;
        //Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> mailIndex = new HashMap<>();
        //Set<String>[] sets = new Set<String>[accounts.size()];

        int[] uf = new int[accounts.size()];
        for (int i = 0 ; i < uf.length ; i++) uf[i] = i;

        for (int i = 0 ; i < accounts.size(); i++) {
            List<String> ac = accounts.get(i);
            int index = -1;
            for (int j = 1; j < ac.size() ; j++) {
                String email = ac.get(j);
                if (!mailIndex.containsKey(email)) {
                    mailIndex.put(email, i);
                    continue;
                }
                index = mailIndex.get(email);
                union(uf, i, index);
            }
        }
        List<Integer>[] indexGroup = new List[accounts.size()];
        for (int i = 0 ; i < uf.length ; i++) {
            int rootIndex = find(uf, i);
            if (indexGroup[rootIndex] == null)  {
                indexGroup[rootIndex] = new ArrayList<Integer>();
            }
            indexGroup[rootIndex].add(i);
        }
        //System.out.println(Arrays.toString(indexGroup));
        for (List<Integer> ins : indexGroup ) {
            if (ins == null) continue;
            //System.out.println(ins);
            Set<String> r = new HashSet<>();
            for (int i = 0 ; i < ins.size() ; i++) {
                List<String> alist = accounts.get(ins.get(i));
                for (int j = 1 ; j < alist.size() ; j++) {
                    r.add(alist.get(j));
                }
            }
            List<String> list = new ArrayList<>(r);
            Collections.sort(list);
            list.add(0, accounts.get(ins.get(0)).get(0));
            //System.out.println(list);
            res.add(list);
        }
        return res;
    }
    
    int find(int[] uf, int i) {
        while (uf[i] != i) {
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        return i;
    }
    void union(int[] uf, int i , int j) {
        int ri = find(uf, i);
        int rj = find(uf, j);
        if (ri != rj) {
            uf[ri] = rj;
        }
    }
    public static void main (String[] args) {
        Solution so = new Solution();

        List<List<String>> res = null;
        res = so.accountsMerge(Arrays.asList( Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                    Arrays.asList("John", "johnnybravo@mail.com"),
                    Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                    Arrays.asList("Mary", "mary@mail.com")));
        System.out.println(res);
    }
}

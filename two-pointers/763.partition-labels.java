import java.util.*;
/*
 * [tags]: hashtable
 * */
class Solution {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) return new ArrayList<Integer>();
        List<Integer> rs = new ArrayList<>();
        //int[][] intervals = new int[26][2];
        Map<Character, Interval> map = new HashMap<>();
       // for (int i = 0 ; i < 26 ; i++) {
       //     intervals[i][0] = -1;
       //     intervals[i][1] = -1;
       // }
        char[] chs = S.toCharArray();
        for (int i = 0 ; i < chs.length; i++) {
            char c = chs[i];
            if (!map.containsKey(c)) {
                map.put(c, new Interval(c));
            }
            if (map.get(c).start == -1) {
                map.get(c).start = i;
            }
            map.get(c).end = i;
        }
        List<Interval> intervals = new ArrayList<>(map.values());
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i0, Interval i1) {
                return i0.start - i1.start;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1 ; i < intervals.size() ; i++) {
            Interval cur = intervals.get(i);
            if (end < cur.start) {
                rs.add(end - start + 1);
                start = cur.start;
                end = cur.end;
            } else {
                end = Math.max(end, cur.end); 
            }
        }
        rs.add(end - start + 1);
        return rs;
    }

    public static void main (String[] args) {
        Solution0 so = new Solution0();
        List<Integer> rs = so.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(rs);
    }
    class Interval{
        public Interval(char c){
            this.c = c;
        }
        char c = ' ';
        int start = -1, end = -1;
    }
}
class Solution0 {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) return new ArrayList<Integer>();
        List<Integer> rs = new ArrayList<>();
        int[] indexs = new int[26];
        Arrays.fill(indexs, -1);
        char [] chs = S.toCharArray();
        for (int i = 0 ; i < chs.length ; i++) {
            indexs[chs[i] - 'a'] = i;
        }
        int last = indexs[chs[0] - 'a'];
        int start = 0;
        for (int i = 0 ; i < chs.length ; i++) {
            if (i > last) {
                rs.add(last - start + 1);
                start = i;
                last = indexs[chs[i] - 'a'];
            } else {
                last = Math.max(last, indexs[chs[i] - 'a']);
            }
        }
        rs.add(last - start + 1);
        return rs;
    }
}
        //int[][] intervals = new int[26][2];

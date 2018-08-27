import java.util.*;
class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0)  return new ArrayList<int[]>();
        List<int[]> res = new ArrayList<>();
        List<int[]> heis = new ArrayList<>();
        for(int[]bd: buildings) {
            heis.add(new int[]{bd[0], -bd[2]});
            heis.add(new int[]{bd[1], bd[2]});
        }
        Collections.sort(heis, new Comparator<int[]>() {
            public int compare(int[] h1, int[] h2) {
                if(h1[0] != h2[0]) return h1[0] - h2[0];
                return h1[1] - h2[1];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer b1, Integer b2) {
                return b2 - b1;
            }
        });
        pq.offer(0);
        int pre = 0;
        for (int[] h: heis) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (cur != pre) {
                res.add(new int[]{h[0], cur});
                pre = cur;
            }
        }
        return res;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        List<int[]> line = null;
        line = so.getSkyline(new int[][]{ { 2,9,10 },{ 3,7,15 },{ 5,12,12 },{ 15,20,10 },{ 19,24,8 } });
        for (int[] l : line) {
            System.out.println(Arrays.toString(l));
        }
    }
}

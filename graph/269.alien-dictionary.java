import java.util.*;
class Solution {
    public String alienOrder(String[] words) {
        if (words.length == 0) return "";
        Set<Character>[] graph = new Set[128];
        int[] indegrees = new int[128];
        Arrays.fill(indegrees, -1);

        for (int i = 0 ; i < words.length ; i++) {
            char[] chs = words[i].toCharArray();
            for (int j = 0 ; j < chs.length ; j++) {
                if (indegrees[chs[j]] == -1) indegrees[chs[j]] = 0;
                if (graph[chs[j]] == null) graph[chs[j]] = new HashSet<Character>();
            }
        }
        char[] pre = words[0].toCharArray();
        for (int i = 1 ; i < words.length ; i++) {
            char[] cur = words[i].toCharArray();
            for (int j = 0 ; j < Math.min(pre.length, cur.length) ;j++) {
                char pchar = pre[j];
                char cchar = cur[j];

                if (graph[cchar] == null) {
                    graph[cchar] = new HashSet<Character>();
                }
                if (pchar == cchar) continue;
                if (graph[cchar] != null && graph[cchar].contains(pchar)) return "";

                if(graph[pchar].add(cchar)){
                    indegrees[cchar]++;
                }
                break;
            }
            pre = cur;
        }
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();

        int total = 0;
        for (int i = 0 ; i < 128 ; i++) {
            if (indegrees[i] == 0) {
                q.offer((char)i);
            }
            if(indegrees[i] >= 0) total++;
        }
        //Set<Character> visited = new HashSet<>();
        while (!q.isEmpty()) {
            char ch = q.poll();
            sb.append(ch);
            for (char nxt : graph[ch]) {
                indegrees[nxt]--;
                if (indegrees[nxt] == 0) {
                    q.offer(nxt);
                }
            }
        }
        return sb.length() == total? sb.toString(): "";
    }

    public static void main (String args[]) {
        Solution so = new Solution();
        String res = null;
        res = so.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"});
        System.out.println(res);
        res = so.alienOrder(new String[]{"ab","adc"});
        System.out.println(res);
        res = so.alienOrder(new String[]{"ac","ab","b"});
        System.out.println(res);
        res = so.alienOrder(new String[]{"bsusz","rhn","gfbrwec","kuw","qvpxbexnhx","gnp","laxutz","qzxccww"});
        System.out.println(res);
    }
}

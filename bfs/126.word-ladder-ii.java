import java.util.*;
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        return null;
    }

    void dfs(Map<String, Set<String>> map, String cur, String end, List<String> path, List<List<String>> res, Map<String, Integer> steps) {}
    public static void main(String args[]) {
        Solution0 so = new Solution0();
        List<List<String>> res = null;
        res = so.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(res);
       // res = so.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log"));
       // System.out.println(res);
       // res = so.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log"));
       // System.out.println(res);

       // res = so.findLadders("hot", "dog", Arrays.asList("hot","dot","dog"));
       // System.out.println(res);
       // res = so.findLadders("hot", "hot", Arrays.asList("hot","dot","dog"));
       // System.out.println(res);
        //res = so.findLadders("red", "tax", Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));
        //System.out.println(res);

    }



}


class Solution0 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return new ArrayList<List<String>>();
        words.add(beginWord);
        List<List<String>> res = new ArrayList<>();
        if (endWord.equals(beginWord)) {
            res.add(Arrays.asList(beginWord, endWord));
            return res;
        }
        

        Map<String, Node> graph = createGraph(words);
        Queue<Node> q = new LinkedList<>();
        Node begin = graph.get(beginWord);
        begin.level = 1;
        q.offer(begin);
        boolean found = false;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node node = q.poll();
                if (node.val.equals(endWord)) {
                    found = true;
                    break;
                }
                for (Node nxt: node.neighbors) {
                    if (nxt.level > 0) continue;
                    nxt.level = node.level + 1;
                    q.offer(nxt);
                }
            }
            if (found) break;
        }
        if (!found) return res;
        System.out.println(graph);
        List<String> list = new ArrayList<String>();
        list.add(beginWord);
        searchSolutions(res, list, beginWord, endWord, graph);
        return res;
    }
    void searchSolutions(List<List<String>> res, List<String> list, String cur, String end, Map<String, Node> graph) {
        //list.add(cur);
        if (cur.equals(end)) {
            //list.add(end);
            res.add(new ArrayList<String>(list));
            return;
        }
        Node node = graph.get(cur);
        for (Node nxt: node.neighbors) {
            if (nxt.level == node.level + 1) {
                list.add(nxt.val);
                searchSolutions(res, list, nxt.val, end, graph);
                list.remove(list.size() - 1);
            }
        }
    }
    Map<String, Node> createGraph(Set<String> dict) {
        Map<String, Node> graph = new HashMap<>();
        for (String s : dict) {
            graph.put(s, new Node(s));
        }
        for (String s : dict) {
            char[] chs = s.toCharArray();
            for (int i = 0 ; i < chs.length ; i++) {
                char oc = chs[i];
                for (char c = 'a' ; c <= 'z'; c++) {
                    if (c == oc) continue;
                    chs[i] = c;
                    String tmp = new String(chs);
                    if (dict.contains(tmp)) {
                        graph.get(s).neighbors.add(graph.get(tmp));
                    }
                }
                chs[i] = oc;
            }
        }
        return graph;
    }
    class Node {
        String val;
        Set<Node> neighbors = new HashSet<>();
        public Node(String val) {
            this.val = val;
        }
        public String toString() {
            List<String> neivalues = new ArrayList<>();
            for (Node nxt: neighbors) {
                neivalues.add(nxt.val);
            }
            return "[neighbors:" + neivalues + ", levels:" + this.level + "]" ;
        }
        int level = 0;
    }
}

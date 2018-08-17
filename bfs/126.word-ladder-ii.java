import java.util.*;
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return new ArrayList<List<String>>();
        Queue<String> q = new LinkedList<>();

        Map<String, Set<String>> levels = new HashMap<>();
        levels.put(beginWord, new HashSet<String>());
        q.offer(beginWord);
        words.remove(beginWord);
        boolean isFound = false;
        int step = 0;
        while (!q.isEmpty()) {
            if (isFound) break;
            int size = q.size();
            for (int j = 0 ; j < size; j++) {
                String cur = q.poll();
                if (cur.equals(endWord)) break;
                char[] chs = cur.toCharArray();
                for (int i = 0; i < chs.length ; i++) {
                    char ori = chs[i];
                    for (char c = 'a' ; c <= 'z'; c++) {
                        if (ori == c) continue;
                        chs[i] = c;
                        String temp = new String(chs);
                        if (words.contains(temp)) {
                            if (temp.equals(endWord)) {
                                isFound = true;
                            } else {
                //                words.remove(temp);
                            }
                            levels.get(cur).add(temp);
                            q.offer(temp);
                            if (!levels.containsKey(temp)) {
                                levels.put(temp, new HashSet<String>());
                            }
                        }
                    }
                    chs[i] = ori;
                }
            }
            step++;
        }
        List<List<String>> res = new ArrayList<>();       
        if (!isFound) return res;
        System.out.println(levels);
       // System.out.println(isFound);

        List<String> path = new ArrayList<String>();
        path.add(beginWord);
        dfs(levels, beginWord, endWord, path , res, step);
        return res;
    }

    void dfs(Map<String, Set<String>> map, String cur, String end, List<String> path, List<List<String>> res, int leftStep) {
        if (cur.equals(end)) {
            List<String> p = new ArrayList<String>(path);
            res.add(p);
            return;
        }
        if (leftStep == 0) return;
        Set<String> nxts = map.get(cur);
        for (String w: nxts) {
                path.add(w);
                dfs(map, w, end, path, res, leftStep - 1);
                path.remove(path.size() - 1);

        }
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        List<List<String>> res = null;
        res = so.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
       System.out.println(res);
        res = so.findLadders("hot", "dog", Arrays.asList("hot","dot","dog"));
        System.out.println(res);
        res = so.findLadders("red", "tax", Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));
        System.out.println(res);

    }

    

}

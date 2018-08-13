class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        int step = 1;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0 ; j < size; j++) {
                String cur = q.poll();
                if (cur.equals(endWord)) return step;
                char[] chs = cur.toCharArray();
                for (int i = 0; i < chs.length ; i++) {
                    char ori = chs[i];
                    for (char c = 'a' ; c <= 'z'; c++) {
                        if (ori == c) continue;
                        chs[i] = c;
                        String temp = new String(chs);
                        if (words.contains(temp)) {
                   //         if (temp.equals(endWord)) return step;
                            words.remove(temp);
                            q.offer(temp);
                        }
                    }
                    chs[i] = ori;
                }
            }
            step++;
        }
        return 0;
    }
}

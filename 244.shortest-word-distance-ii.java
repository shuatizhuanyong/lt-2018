class WordDistance {
    Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {
        for (int i = 0 ; i < words.length ; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new LinkedList<Integer>());
            }
            map.get(words[i]).add(i);
        }
    }

    Map<String, Integer> cache = new HashMap<>();
    
    public int shortest(String word1, String word2) {
        int com = word1.compareTo(word2);
        if (com < 0) return shortest(word2, word1);
        if (word1.equals(word2)) return 0;
        if (cache.get(word1+ "#" + word2) != null) return cache.get(word1+ "#" + word2);

        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int shortest = Math.abs(l1.get(0) - l2.get(0));
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            int index1 = l1.get(i);
            int index2 = l2.get(j);
            if (Math.abs(index2 - index1) < shortest) {
                shortest = Math.abs(index2 - index1);
            }
            if (index1 < index2) i++;
            else j++;
        }
        cache.put(word1+ "#" + word2, shortest);
        return shortest;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */

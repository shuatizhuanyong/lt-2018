class WordDictionary {

    TrieNode root = null;
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0) return;
        char[] chs = word.toCharArray();
        TrieNode p = root;
        for (int i = 0 ; i < chs.length ; i++) {
            char c = chs[i];
            if (p.children[c - 'a'] == null)  {
                p.children[c - 'a'] = new TrieNode();
            }
            p = p.children[c - 'a'];
        }
        p.isWord = true;
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        char[] chs = word.toCharArray();
        return search(chs, 0, root);
    }
    boolean search(char[] chs, int index, TrieNode node) {
        if (index == chs.length && node.isWord) return true;
        if (index == chs.length) return false;
        char c = chs[index];
        if (c != '.') {
            if (node.children[c - 'a'] == null) return false;
            return search(chs, index + 1, node.children[c - 'a']);
        }
        for (char i = 'a' ; i <= 'z'; i++) {
            if (node.children[i - 'a'] == null) continue;
            if (search(chs, index + 1, node.children[i - 'a'])) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

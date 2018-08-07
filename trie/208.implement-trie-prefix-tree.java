class Trie {
    TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public Trie() {
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null) return;
        TrieNode p = root;
        for (int i = 0 ; i < word.length() ; i++) {
            char ch = word.charAt(i);
            if (p.children[ch - 'a'] == null) {
                p.children[ch - 'a'] = new TrieNode();
            }
            p = p.children[ch - 'a'];
        }
        p.end = true; 
    }

    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null) return false;
        TrieNode p = root;
        for (int i = 0 ; i < word.length() ; i++) {
            char ch = word.charAt(i);
            p = p.children[ch - 'a'];
            if (p == null) return false;
        }
        return p.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        TrieNode p = root;
        for (int i = 0 ; i < prefix.length() ; i++) {
            char ch = prefix.charAt(i);
            p = p.children[ch - 'a'];
            if (p == null) return false;
        }
        return true;
    }
    class TrieNode {
        boolean end = false;
        TrieNode[] children = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

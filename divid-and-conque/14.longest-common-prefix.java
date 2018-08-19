/**
 *
 * [tags]: trie, array
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        for (String s : strs) {
            if (s == null || s.length() == 0) return "";
            insert(s);
        }
        return commonPrefix();
    }
    void insert(String s) {
        if (s == null) return;
        char[] chs = s.toCharArray();
        TrieNode p = root;
        for (int i = 0 ; i < chs.length ; i++) {
            char c = chs[i];
            if (p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new TrieNode();
            }
            p = p.children[c - 'a'];
        }
        p.isEnd = true;
    }
    String commonPrefix() {
        TrieNode p = root;
        StringBuilder sb = new StringBuilder();
        while(p != null) {
            TrieNode cld = null;
            
            boolean hasChild = false;
            int index = -1;
            for (int i = 0 ; i < p.children.length ; i++) {
                if (p.children[i] != null && cld != null) {
                    hasChild = true;
                    break;
                };
                if (p.children[i] != null) {
                    cld = p.children[i];
                    index = i;
                }
            }
            if (index == -1 || hasChild) {
                break;
            }
            sb.append((char)('a' + index));
            if (cld.isEnd) {
                break;
            }
            p = cld;
        }
        return sb.toString();
    }

    TrieNode root = new TrieNode();
    class TrieNode {
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        String pre;
        pre = so.longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(pre);
    }
}

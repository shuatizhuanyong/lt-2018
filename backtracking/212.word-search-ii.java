class Solution {
    TrieNode root = new TrieNode();
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0 || words == null || words.length == 0){
            return res;
        }
        int m = board.length, n = board[0].length;
        buildTrieTree(words);
        boolean[][] visited = new boolean[m][n];
        Set<String> unRes = new HashSet<>();
        for (int i = 0 ; i < m ; i++ ) {
            for (int j = 0 ; j < n; j++) {
                char bc = board[i][j];
                if (root.children[bc - 'a'] != null) {
                    searchWords(board, root, i, j, visited, unRes);
                }
            }
        }
        return new ArrayList<String>(unRes);
    }
    public void searchWords(char[][] board, TrieNode node, int i, int j, boolean[][] visited, Set<String> res) {
        if (node.end == true) {
            res.add(node.word);
        }
        int m = board.length, n = board[0].length;
        if (i >= m || i < 0 || j >= n || j < 0 ) {
            return;
        }
        if (visited[i][j]) return;
        if (node.children[board[i][j] - 'a'] == null) {
            return;
        }
        visited[i][j] = true;
        //int[][] ds = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        searchWords(board, node.children[board[i][j] - 'a'], i + 1, j, visited, res);
        searchWords(board, node.children[board[i][j] - 'a'], i - 1, j, visited, res);
        searchWords(board, node.children[board[i][j] - 'a'], i, j + 1, visited, res);
        searchWords(board, node.children[board[i][j] - 'a'], i, j - 1, visited, res);

        visited[i][j] = false;
    }
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean end = false;
        String word = null;
    }
    void buildTrieTree(String[] words) {
        for (String w: words) {
            insert(w);
        }
    }
    void insert(String w){
        if (w == null || w.length() == 0) return;
        TrieNode p = root;
        char[] chs = w.toCharArray();
        for (int i = 0 ; i < chs.length ; i++) {
            char c = chs[i];
            if (p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new TrieNode(); 
            }
            p = p.children[c - 'a'];
        }
        p.word = w;
        p.end = true;
    }

}

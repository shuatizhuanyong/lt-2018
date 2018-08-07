class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word == null) return false;
        if (word.length() == 0) return true;
        int m = board.length, n = board[0].length;
        boolean[] visited = new boolean[m * n];
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean exist = search(board, word, i, j, 0, visited);
                    if (exist) {
                        return true;
                    }
                }

            }
        }
        return false;
    }
    boolean search(char[][] board, String word, int i, int j , int index, boolean[] visited) {
        if (index >= word.length()) return true;
        int m = board.length, n = board[0].length;
        if (i >= m || i < 0 || j >= n || j < 0 ) return false;
        if (board[i][j] != word.charAt(index)) return false;
        if (visited[i * n + j]) return false;
        visited[i * n + j] = true;
        boolean r = search(board, word, i + 1, j, index + 1, visited) ||
            search(board,  word,i - 1, j, index + 1, visited) ||
            search(board, word, i , j + 1, index + 1, visited) ||
            search(board, word, i , j - 1, index + 1, visited);
        if (r) return true;
        visited[n * i + j] = false;
        return false;
    }
      

}

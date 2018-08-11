//[tags] dfs, uf
class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)  return;
        int m = board.length, n = board[0].length;
        for (int i = 0 ; i < m; i++) {
            char co = board[i][0];
            if (co == 'O') {
                markOs(board, i, 0); 
            }
            co = board[i][n - 1];
            if (co == 'O') {
                markOs(board, i, n - 1); 
            }
        }

        for (int i = 0 ; i < n; i++) {
            char co = board[0][i];
            if (co == 'O') {
                markOs(board, 0, i); 
            }
            co = board[m - 1][i];
            if (co == 'O') {
                markOs(board, m - 1, i); 
            }
        }
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (board[i][j] == 'Y') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        } 
        
    }
    void markOs(char[][] board, int i, int j ) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j>= n ) return;
        if (board[i][j] != 'O') return;
        board[i][j] = 'Y';
        markOs(board, i + 1, j);
        markOs(board, i - 1, j);
        markOs(board, i, j + 1);
        markOs(board, i, j - 1);
    }
}

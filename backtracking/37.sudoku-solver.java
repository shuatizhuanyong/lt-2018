class Solution {
    public void solveSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9 ) return;
        solve(board);
    }
    boolean solve(char[][] board) {
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                if (board[i][j] != '.') continue;
                for (char c = '1' ; c <= '9' ; c++) {
                    if (check(board, i, j, c)) {
                        board[i][j] = c;
                        if (solve(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    boolean check(char[][] board, int i, int j, char c) {
        for (int x = 0 ; x < 9 ; x++) {
            if (board[i][x] == c || board[x][j] == c) {
                return false;
            }
        }
        int rowStart = (i / 3) * 3;
        int colStart = (j / 3) * 3;
        for (int x = rowStart ; x < rowStart + 3; x++) {
            for (int y = colStart ; y < colStart + 3; y++) {
                if (board[x][y] == c) return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        //char[][] board = char[][] { { '5','3','.','.','7','.','.','.','.' },{ '6','.','.','1','9','5','.','.','.' },{ '.','9','8','.','.','.','.','6','.' },{ '8','.','.','.','6','.','.','.','3' },{ '4','.','.','8','.','3','.','.','1' },{ '7','.','.','.','2','.','.','.','6' },{ '.','6','.','.','.','.','2','8','.' },{ '.','.','.','4','1','9','.','.','5' },{ '.','.','.','.','8','.','.','7','9' } };
        so.solveSudoku(null);
    }
}


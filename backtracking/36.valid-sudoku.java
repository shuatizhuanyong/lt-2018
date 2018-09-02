/*
 * [tags]: hash-table
 * */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> blocks = new HashMap<>();
        for (int i = 0 ; i < 9 ; i++)  {
            rows.put(i, new HashSet<Character>());
            cols.put(i, new HashSet<Character>());
            blocks.put(( i / 3 ) + "_" + (i % 3), new HashSet<Character>());
        }
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                if (board[i][j] == '.') continue;
                if (!rows.get(i).add(board[i][j])) {
                    return false;
                }
                if (!cols.get(j).add(board[i][j])) {
                    return false;
                }
                String bkey = ( i / 3 ) + "_" + ( j / 3 );
                if (!blocks.get(bkey).add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main (String[] args) {
        Solution so = new Solution();
        so.isValidSudoku();

    }
}

class Solution0 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0 ; i < 9 ; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> blocks = new HashSet<>();
            for (int j = 0 ; j < 9 ; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if (board[j][i] != '.' && !cols.add(board[j][i])) return false;
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                int iIndex = rowIndex + ( j / 3 );
                int jIndex = colIndex + ( j % 3 );
                if (board[iIndex][jIndex] != '.' && !blocks.add(board[iIndex][jIndex])) return false;
            }
        }
        return true;
    }
}

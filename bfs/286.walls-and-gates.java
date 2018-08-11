class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n; j++) {
                if (rooms[i][j] == 0) {
                    markneigbors(rooms, i + 1, j, 1);
                    markneigbors(rooms, i - 1, j, 1);
                    markneigbors(rooms, i, j + 1, 1);
                    markneigbors(rooms, i, j - 1, 1);
                }
            }
        }
    }
    void markneigbors(int[][] rooms, int i, int j, int val) {
        int m = rooms.length, n = rooms[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (rooms[i][j] <= val) return;
        //if (visited[i][j]) return;
        //visited[i][j] = true;
        rooms[i][j] = val;
        markneigbors(rooms, i + 1, j, val + 1);
        markneigbors(rooms, i - 1, j, val + 1);
        markneigbors(rooms, i, j + 1, val + 1);
        markneigbors(rooms, i, j - 1, val + 1);
        //visited[i][j] = false;
    }
}

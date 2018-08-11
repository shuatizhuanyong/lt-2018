import java.util.*;
class Solution {
    int[][] dirs = new int[][]{{0 ,1}, {0 ,-1}, {1, 0}, {-1, 0} };
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        if (maze.length == 0 || maze[0].length == 0 || start.length != 2 || dest.length != 2) return false;
        int m = maze.length, n = maze[0].length;
        for (int[] d: dirs) {
            if (hasPath(maze, start[0], start[1], dest, d, new boolean[m][n][4])) return true;
        }
        return false;
    }
    int getDirIndex(int[] d) {
        for (int i = 0 ; i < dirs.length ; i++) {
            if (dirs[i][0] == d[0] && dirs[i][1] == d[1]) return i;
        }
        return -1;
    }
    boolean hasPath(int[][] maze, int i, int j, int[] dest, int[] dir, boolean[][][] visited) {
        int m = maze.length, n = maze[0].length;
        if (i >= m || i < 0 || j < 0 || j >= n) return false;
        if (visited[i][j][getDirIndex(dir)]) return false;
        int[] nxt = new int[]{i + dir[0], j + dir[1]};
        if (i == dest[0] && j == dest[1]) {
            if (hasWall(nxt[0], nxt[1], maze)) return true;
        }
        visited[i][j][getDirIndex(dir)] = true;
        if (hasWall(nxt[0], nxt[1], maze)) {
            for (int[] d: dirs) { 
                if (d[0] == dir[0] && d[1] == dir[1]) {
                    continue;
                }
                if (hasPath(maze, i + d[0], j + d[1], dest, d, visited)) return true;
            }
        } else {
            if (hasPath(maze, i + dir[0], j + dir[j], dest, dir, visited)) return true;
        }
        visited[i][j][getDirIndex(dir)] = false;
        return false;
    }
    boolean hasWall(int i, int j, int[][] maze) {
        int m = maze.length, n = maze[0].length;
        if (i < 0 || i <= m || j < 0 || j <= n) return true;
        return maze[i][j] == 1;
    }
    public static void main(String args[]) {
        Solution0 so = new Solution0();
        boolean res ;
        res = so.hasPath(new int[][]{ 
            { 0,0,1,0,0 },
            { 0,0,0,0,0 },
            { 0,0,0,1,0 },
            { 1,1,0,1,1 },
            { 0,0,0,0,0 }
        }, 
        new int[] {0, 4}, 
        new int[]{4, 4} );
        System.out.println(res);
    }

}
class Solution0 {
    int[][] dirs = new int[][]{{0 ,1}, {0 ,-1}, {1, 0}, {-1, 0} };
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        if (maze.length == 0 || maze[0].length == 0 || start.length != 2 || dest.length != 2) return false;
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            
            int[] pos = q.poll();
            //System.out.println(Arrays.toString(pos));
            if (pos[0] == dest[0] && pos[1] == dest[1]) return true;
            //if (visited[pos[0]][pos[1]]) continue;
            for (int[] d : dirs) {
                int x = pos[0];
                int y = pos[1];
                while (true) {
                    int rx = x + d[0], cy = y + d[1];
                    if (rx >= 0 && rx < m && cy >= 0 && cy < n && maze[rx][cy] == 0) {
                        x = rx;
                        y = cy;
                    } else {
                        break;
                    }
                }

                if (x != pos[0] || y != pos[1] ) {
                    if (!visited[x][y])
                        q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}

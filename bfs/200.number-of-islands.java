import java.util.*;
/*
 * [tags]: union find
 * */
//union find
class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        if (grid.length == 0 || grid[0].length == 0)  return 0;
        int m = grid.length, n = grid[0].length;
        UF uf = new UF(m * n + 1);
        for (int i = 0 ; i < m; i++) {
            for (int j = 0 ; j < n; j++) {
                if (grid[i][j] == '0') {
                    uf.union(i * n + j, m * n);
                    continue;
                } 
                for (int[] d: dirs) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                        uf.union(i * n + j, x * n + y);
                    }
                }
            }
        }
        return uf.group() - 1;
    }
    class UF {
        int[] nums;
        public UF(int n ) {
            nums = new int[n];
            for (int i = 0 ; i < nums.length ; i++) {
                nums[i] = i;
            }
        }
        void union(int p, int q) {
            int pr = find(p);
            int qr = find(q);
            if (pr != qr) {
                nums[pr] = qr;
            }
        }
        int find(int p) {
            while (nums[p] != p) {
                nums[p] = nums[nums[p]];
                p = nums[p];
            }
            return p;
        }
        int group() {
            Set<Integer> set = new HashSet<>();
            for (int i = 0 ; i < nums.length ; i++) {
                int ri = find(i);
                set.add(ri);
            }
            return set.size();
        }
    }
    public static void main (String[] args) {
        Solution0 so = new Solution0();
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{ '0','0','0','1','0' }};
        so.numIslands(grid);
        for (char[] chs: grid) {
            System.out.println(new String(chs));
        }
    }

}


//BFS
class Solution0 {
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int count = 0;
        if (grid.length == 0 || grid[0].length == 0)  return 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0 ; i < m; i++) {
            for (int j = 0 ; j < n; j++) {
                if (grid[i][j] == '1') {
                    System.out.println("i:" + i +" , j:" + j);
                    findLand(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    void findLand(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0|| j >= n || grid[i][j] != '1') return;
        grid[i][j] = '2';
        for (int[] d: dirs) {
            int x = i + d[0];
            int y = j + d[1];
            findLand(grid, x, y);
        }
    }
}

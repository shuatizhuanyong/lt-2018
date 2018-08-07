import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return false;
        Set<Integer>[] adjList = new Set[numCourses];
        int[] indegrees = new int[numCourses];
        for (int i = 0 ; i < numCourses; i++) {
            adjList[i] = new HashSet<Integer>();
            //inDegreeList[i] = new HashSet<Integer>();
        }
        for (int i = 0 ; i < prerequisites.length ; i++) {
            int node = prerequisites[i][0], inNode = prerequisites[i][1];
            if(adjList[inNode].add(node)) {
                indegrees[node]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0 ; i < indegrees.length ; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }
        if (q.isEmpty()) return false;
        while (!q.isEmpty()) {
            int node = q.poll();
            Set<Integer> nxts = adjList[node];
            for (Integer n: nxts) {
                indegrees[n]--;
                if (indegrees[n] == 0){
                    q.offer(n);
                }
            }
        }
        for (int inNum : indegrees) {
            if (inNum > 0) return false;
        }
        return true;
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        boolean res = false;
        res = so.canFinish(2, new int[][]{ {1,0 } });
        System.out.println(res);
        res = so.canFinish(2, new int[][]{ {1, 0}, {0, 1} });
        System.out.println(res);
    }
}

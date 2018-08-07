class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[0];
        Set<Integer>[] nxts = new Set[numCourses];
        for (int i = 0 ; i < numCourses ; i++) nxts[i] = new HashSet<Integer>();
        int[] inDegrees = new int[numCourses];
        for (int i = 0 ; i < prerequisites.length; i++) {
            int node = prerequisites[i][1];
            int nxt = prerequisites[i][0];
            if (nxts[node].add(nxt)) {
                inDegrees[nxt]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[] order = new int[numCourses];
        int index = 0;
        for (int i = 0 ; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                q.offer(i);
                order[index++] = i;
                
            }
        }
        
        if (q.isEmpty()) return new int[0];
        while (!q.isEmpty()) {
            int node = q.poll();
            order[index++] = node;
            Set<Integer> nxtSet = nxts[node];
            for (int n: nxtSet) {
                inDegrees[n]--;
                if (inDegrees[n] == 0) {
                    q.offer(n);
                }
            }
            numCourses--;
        }
        return numCourses == 0 ? order: new int[0];

    }
}

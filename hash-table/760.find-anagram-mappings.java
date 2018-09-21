class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        if (A == null || A.length == 0 ) return new int[0];
        Map<Integer, List<Integer>> mapb = new HashMap<>();
        for (int i = 0 ; i < B.length ; i++) {
            if (!mapb.containsKey(B[i])) {
                mapb.put(B[i], new ArrayList<Integer>());
            }
            mapb.get(B[i]).add(i);
        }
        int[] res = new int[B.length];
        for (int i = 0 ; i < A.length ; i++) {
            List<Integer> iList = mapb.get(A[i]);
            int indexB = iList.get(iList.size() - 1);
            iList.remove(iList.size() - 1);
            res[i] = indexB;
        }
        return res;
    }
}

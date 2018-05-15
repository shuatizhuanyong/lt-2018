class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0 ; i < nums.length ; i++) {
            int n = nums[i];
            if (q.size() > k) {
                int head = q.poll();
                set.remove(head);
            }
            if (!set.add(n)) {
                return true;
            }
            q.offer(n);
        }
        return false;
    }
}

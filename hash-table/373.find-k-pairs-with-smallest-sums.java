class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return list;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2) {
                return arr2[0] + arr2[1] - arr1[0] - arr1[1];
            }
        });
        for (int i = 0 ; i < Math.min(k, nums1.length); i++) {
            for (int j = 0 ; j < Math.min(k, nums2.length); j++) {
                pq.offer(new int[]{nums1[i], nums2[j]});
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        while (!pq.isEmpty()) {
            list.add(0, pq.poll());
        }
        return list;
    }
}
class Solution0 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return list;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] + arr1[1] - (arr2[0] + arr2[1]);
            }
        });
        for (int i = 0 ; i < Math.min(nums1.length, k) ; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (!pq.isEmpty() && list.size() < k) {
            int[] cur = pq.poll();
            list.add(new int[]{cur[0], cur[1]});
            if (cur[2] + 1 < nums2.length) {
                pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
            }
        }
        return list;
    }
}

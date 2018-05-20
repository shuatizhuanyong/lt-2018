class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int n1 : nums1) set.add(n1);

        for (int n2: nums2) {
            if (set.remove(n2)) {
                res.add(n2);
            }
        }
        int[] arr = new int[res.size()];
        for(int i = 0 ; i < res.size(); i++){
            arr[i] = res.get(i);
        }
        return arr;

    }
}

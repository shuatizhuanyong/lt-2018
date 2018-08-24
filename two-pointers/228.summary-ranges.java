class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        int start = 0, i = 1;
        while (i < nums.length) {
            if (nums[i] != nums[i - 1] + 1) {
                list.add(getRange(nums, start, i - 1));
                start = i;
            }
            i++;
        }
        list.add(getRange(nums, start, nums.length - 1));
        return list;
    }
    String getRange(int[] nums, int start , int end) {
        StringBuilder sb = new StringBuilder();
        sb.append(nums[start]);
        if (start == end) {
            return sb.toString();
        }
        return sb.append("->").append(nums[end]).toString();
    }
}

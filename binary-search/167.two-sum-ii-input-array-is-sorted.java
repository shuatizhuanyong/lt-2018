// actua
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < numbers.length ; i++) {
            if(map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i + 1};
            }
            map.put(numbers[i], i + 1);
        }
        return new int[]{-1, -1};
        
    }
}


class Solution0 {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{-1, -1};

    }
}


class Solution {
    public int trap(int[] height) {
        if (height.length < 3) return 0;

        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1 ; i < height.length ; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int total = 0;
        int rightMax = height[height.length - 1];
        for (int i = height.length - 2; i >= 0 ; i--) {
            rightMax = Math.max(height[i], rightMax);
            total += (Math.min(rightMax, leftMax[i]) - height[i]);
        }
        return total;
    }
}

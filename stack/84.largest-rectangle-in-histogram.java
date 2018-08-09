//TODO
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length < 1) return 0;

        int maxArea = 0;
        for (int i = 0 ; i < heights.length ; i++) {
            int minHei = heights[i];
            for (int j = i ; j < heights.length ; j++) {
                minHei = Math.min(minHei, heights[j]);
                maxArea = Math.max(maxArea, minHei * (j - i + 1));
            }
        }
        return maxArea;
    }
}

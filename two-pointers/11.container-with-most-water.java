import java.util.Stack;
class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for (int i = 0 ; i < height.length ; i++) {
            int h = height[i];
            if (st.isEmpty()) {
                st.push(i);
                continue;
            }
            int peek = height[st.peek()];
            int area = Math.min(peek, h) * (i - st.peek());
            if (h <= peek) {
                maxArea = Math.max(maxArea, area);
                continue;
            }
            st.pop();
            while (!st.isEmpty() && area > maxArea) {
                maxArea = area;
                peek = height[st.peek()];
                area = peek * (i - st.peek());
                st.pop();
            }
            st.push(i);
        }
        return maxArea;
    }
    public static void main (String args[]) {
        Solution0 so = new Solution0();
        int res = -1;
        res = so.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(res);
        res = so.maxArea(new int[]{1,2,3,4,5,4,3,2,1});
        System.out.println(res);
    }
}


class Solution0 {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}

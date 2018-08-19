/*
 * [tag] two-pointers
 * */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[] minLeft = new int[prices.length];
        int maxProfit = 0;
        for (int i = 0 ; i < prices.length ; i++) {
            if (i == 0) {
                minLeft[0] = prices[0];
            } else {
                minLeft[i] = Math.min(prices[i], minLeft[i - 1]);
            }
            maxProfit = Math.max(maxProfit, prices[i] - minLeft[i]);
        }
        return maxProfit;
    }
}

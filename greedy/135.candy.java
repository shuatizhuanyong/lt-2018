class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1 ; i < ratings.length ; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = 1 + candies[i - 1];
            }
        }
        int total = candies[ratings.length - 1];
        for (int i = ratings.length - 2 ; i >= 0 ; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(1 + candies[i + 1], candies[i]);
            }
            total += candies[i];
        }
        return total;
    }
    
}

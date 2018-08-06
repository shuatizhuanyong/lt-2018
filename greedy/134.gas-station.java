class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length || gas.length == 0) return -1;
        int totalLeft = 0, resultId = -1, maxDiff = 0;
        for (int i = 0 ; i < gas.length ; i++) {
            totalLeft += (gas[i] - cost[i]);
            if (maxDiff < totalLeft) {
                maxDiff = totalLeft;
                resultId = i;
            }
            //if (totalLeft < 0) resultId = i;
        }
        return totalLeft < 0 ? -1 : resultId;
    }

    public static void main(String args[]) {
        Solution0 so = new Solution0();
        int res = 0;
        res = so.canCompleteCircuit(new int[] {}, new int[]{});
        System.out.println(res);
        res = so.canCompleteCircuit(new int[] {0, 0 , 3, 5}, new int[]{2, 3, 1, 1});
        System.out.println(res);
        res = so.canCompleteCircuit(new int[] {0, 0 , 0, 5}, new int[]{2, 3, 1, 1});
        System.out.println(res);
        res = so.canCompleteCircuit(new int[] {3, 2, 1, 1}, new int[]{2, 3, 1, 1});
        System.out.println(res);
        res = so.canCompleteCircuit(new int[] {7,1,0,11,4}, new int[]{5,9,1,2,5});
        System.out.println(res);
        res = so.canCompleteCircuit(new int[] {1, 2, 3, 4, 5}, new int[]{3,4,5,1,2});
        System.out.println(res);
    }
}

class Solution0 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0, total = 0, acc = 0;
        for (int i = 0 ; i < gas.length ; i++) {
            total += (gas[i] - cost[i]);
            if (acc < 0) {
                acc = 0;
                index = i;
            }
            acc += (gas[i] - cost[i]);
        }
        return total < 0 ? -1 : index;
    }
}

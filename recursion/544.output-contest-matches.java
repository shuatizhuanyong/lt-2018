import java.util.*;
class Solution {
    public String findContestMatch(int n) {
        if (n < 2) return "";
        //int t = n;
        int[] arr = new int[n];
        int i = 1, j = n, k = 0;
        int turn = 0;
        while (k < n) {
            if (turn == 0) {
                arr[k] = i++;
            } else {
                arr[k] = j--;
            }
            k++;
            turn = ~turn;
        }

        String res = findContestMatch(arr, 0, arr.length - 1);
        return res;
    }
    String findContestMatch(int[] arr, int start, int end) {
        if (end <= start) return "";
        if (end == start + 1) {
            return "(" + arr[start] + "," + arr[end] +")";
        }
        int len = (end - start) + 1;
        return "(" + findContestMatch(arr, start, start + (len / 2) - 1 ) + "," + findContestMatch(arr, end - (len / 2) + 1, end ) + ")";
    }
    public static void main (String args[]) {
        Solution0 so = new Solution0();
        String res;
        res = so.findContestMatch(4);
        System.out.println(res);
        res = so.findContestMatch(8);
        System.out.println(res);
        res = so.findContestMatch(32);
        System.out.println(res);
    }
}


class Solution0 {
    public String findContestMatch(int n) {
        if (n < 2) return "";
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            list.add((i + 1) + "");
        }
        int step = 1;
        while (step < n) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0 ; i < list.size() / 2 ; i++) {
                tmp.add("(" + list.get(i) + "," + list.get(list.size() - 1 - i) + ")");
            }
            list = new ArrayList<>(tmp);
            //if (list.size() == 1) break;
            step *= 2;
        }
        return list.get(0);
    }
}


class Solution1 {
    public String findContestMatch(int n) {
        if (n < 2) return "";

    }
}


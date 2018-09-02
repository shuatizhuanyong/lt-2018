/**
 *
 * not completed
 * [tags] treemap
 */
class MyCalendarTwo {
    List<int[]> cals = new ArrayList<>();
    List<int[]> dous = new ArrayList<>();
    public MyCalendarTwo() {}
    
    public boolean book(int start, int end) {
        int[] curInt =new int[]{start, end};
        if (canBook(curInt, cals)) {
            cals.add(curInt);
            return true;
        }
        if (canBook(curInt, dous)) {
            dous.add(curInt);
            return true;
        }
        return false;
    }

    boolean canBook(int[] interval, List<int[]> list) {
        for (int[] c: list) {
            if (c[0] < interval[1] && interval[0] < c[1])  {
                return false;
            }
        }
        return true;
    }

}

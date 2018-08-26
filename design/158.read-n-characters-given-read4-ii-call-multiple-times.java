/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     */
    int preIndex = 0;
    int preSize = 0;
    char[] preBuf = new char[4];
    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            if (preIndex < preSize) {
                buf[index++] = preBuf[preIndex++];
                continue;
            }
            preSize = read4(preBuf);
            preIndex = 0;
            if (preSize == 0) break;
        }
        return index;
    }
}

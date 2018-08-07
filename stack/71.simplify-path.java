import java.util.*;
class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return "/";
        LinkedList<String> files = new LinkedList<>();
        int i = 0;
        String cur = "";
        path = path + "/";
        while (i < path.length()) {
            char ch = path.charAt(i);
            if (ch == '/') {
                if (cur.length() > 0) {
                    if (cur.equals(".")) {
                        cur = "";
                    } else if (cur.equals("..")) {
                        if(files.size() > 0) files.pop();
                    } else {
                        files.push(cur);
                    }
                    cur = "";
                }
            } else {
                cur += ch;
            }
            i++;
        }
        StringBuilder res = new StringBuilder();
        while(!files.isEmpty()) {
            String f = files.pop();
            res.insert(0, "/" + f);
        }
        return res.length() == 0 ? "/" : res.toString();
    }
    public static void main(String args[]) {
        Solution so = new Solution();
        String res = "";
        res = so.simplifyPath("/home/../home/../aa/..");
        System.out.println(res);
        res = so.simplifyPath("/home/./home/./aa/..");
        System.out.println(res);
        res = so.simplifyPath("//./home//aa/..");
        System.out.println(res);
    
    }
}

# notice:
1. total, map, start these 3 vars need to maintain together in
  1.1 in side of 1st loop:
```java
            Map<String, Integer> map = new HashMap<>(template);
            total = 0;
            int j = i, start = i;
```

1.2 current substring is not dictionary 
```
                    map = new HashMap(template);
                    j += wlen;
                    start = j;
                    total = 0;
```
1.3 current substring is in dict but too more, window map keep going
```
                while (map.get(sb) <= 0) {
                    String begin = s.substring(start, start + wlen);
                    //   System.out.println(begin + ", " +map.get(begin) + ", " + start + ", " + map + ", sb=" + sb);
                    map.put(begin, map.get(begin) + 1);
                    start += wlen;
                    total--;
                }
```
1.4  total === words.length : when find out a result, the window need to keep sliding forward
```
                    String begin = s.substring(start, start + wlen);
                    map.put(begin, map.get(begin) + 1);
                    start += wlen;
                    total--;

```

2. to prevent duplicated traverse:
   2.1 outer loop while (i < wlen) 
   2.2 inner loop while (j <= s.length() - wlen)  // note =

3. silding window template:
from https://leetcode.com/problems/minimum-window-substring/discuss/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems
```
// input: string s or  string[] words
int[] map = new int[128]; 
// or Map<String, Integer> map = new HashMap<>();

int len = s.length() 
// or int len = words.length;

int counter = 0;
int start = 0, end = 0;
for() { /* initialize the hash map here */ }
while (end < len) {
}


```
```
int findSubstring(string s){
        vector<int> map(128,0);
        int counter; // check whether the substring is valid
        int begin=0, end=0; //two pointers, one point to tail and one  head
        int d; //the length of substring

        for() { /* initialize the hash map here */ }

        while(end<s.size()){

            if(map[s[end++]]-- ?){  /* modify counter here */ }

            while(/* counter condition */){ 
                 
                 /* update d here if finding minimum*/

                //increase begin to make it invalid/valid again
                
                if(map[s[begin++]]++ ?){ /*modify counter here*/ }
            }  

            /* update d here if finding maximum*/
        }
        return d;
  }
```


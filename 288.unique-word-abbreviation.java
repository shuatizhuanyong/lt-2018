import java.util.*;
class ValidWordAbbr {

    Map<String, Set<String>> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for (String str: dictionary) {
            String abbr = toAbbr(str);
            if (!map.containsKey(abbr)) {
                map.put(abbr, new HashSet<String>());
            }
            map.get(abbr).add(str);
        }
    }
    
    private String toAbbr (String str) {
        StringBuilder sb = new StringBuilder();
        if (str.length() <= 2) {
            sb.append(str);
        } else {
            sb.append(str.charAt(0));
            sb.append(str.length() - 2);
            sb.append(str.charAt(str.length() - 1));
        }
        return sb.toString();
    }

    public boolean isUnique(String word) {
        String abbr = toAbbr(word);
        if (!map.containsKey(abbr) )  return true;
        if (map.get(abbr).size() == 1 && map.get(abbr).iterator().next().equals(word)) return true;
        return false;
    }
    public static void main (String args[]){
        ValidWordAbbr vwa = new ValidWordAbbr(new String[]{"deer", "door", "cake", "card" });
        System.out.println(vwa.isUnique("dear"));
        System.out.println(vwa.isUnique("cart"));
        
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        Map<String, Integer> dnas = new HashMap<>();
        for (int i = 0 ; i <= s.length() - 10; i++) {
            String dna = s.substring(i, i + 10);
            dnas.put(dna, dnas.getOrDefault(dna, 0) + 1);
            if (dnas.get(dna) == 2) {
                res.add(dna);
            }

        }
        return res;
    }
}

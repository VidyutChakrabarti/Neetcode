class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        
        for (String s : strs) {
            int[] a = new int[26];
            for (char c : s.toCharArray()) {
                a[c - 'a']++;
            }
            String key = Arrays.toString(a);
            m.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(m.values());
    }
}

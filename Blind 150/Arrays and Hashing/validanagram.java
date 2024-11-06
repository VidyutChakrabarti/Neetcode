class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for (char c : s.toCharArray()) {
        m1.put(c, m1.getOrDefault(c, 0)+1);
        }
        for (char c : t.toCharArray()) {
        m2.put(c, m2.getOrDefault(c, 0)+1);
        }
        return m1.equals(m2);
    }
}

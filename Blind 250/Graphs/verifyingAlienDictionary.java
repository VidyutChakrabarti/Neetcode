public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderIndex = new int[26];
        for (int i = 0; i < order.length(); i++)
            orderIndex[order.charAt(i) - 'a'] = i;
        
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int j = 0;
            
            for (; j < w1.length(); j++) {
                if (j == w2.length()) return false;
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (orderIndex[w1.charAt(j) - 'a'] > orderIndex[w2.charAt(j) - 'a']) {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }
}
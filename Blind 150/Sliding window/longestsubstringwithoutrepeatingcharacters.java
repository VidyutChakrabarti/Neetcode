public class Solution {
    public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> m = new HashMap<>();
    int l = 0; 
    int res = 0;
    for(int r = 0; r<s.length(); r++){
        char c = s.charAt(r);
        if(m.containsKey(c)){
            l = Math.max(m.get(c)+1, l);
        }
        m.put(c, r);
        res = Math.max(res, r-l+1);
    }
    return res;
    }}
class Solution {
    public int characterReplacement(String s, int k) {
        HashSet<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            charSet.add(c);
        }
        int ml = 0;
        int n = s.length();
        for(char mf: charSet){
        int l = 0;
        int curf = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) != mf){
               curf+=1;
            }
            while(curf>k){
                if(s.charAt(l)!=mf){
                    curf--;
                }
                l++;
            }
            ml = Math.max(i-l+1,ml);
        }
    }
        return ml;
    }
}

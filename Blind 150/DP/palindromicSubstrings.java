class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = n;
        //for counting odd palindromes
        for(int i = 0; i<n; i++){
            int l = i-1;
            int r = i+1;
            while(l>=0 && r<n){
                if(s.charAt(l) == s.charAt(r)){
                    ans++;
                    l-=1;
                    r+=1;
                }else{
                    break;
                }
            }
        }

        for(int i = 0; i<n-1; i++){
            int l = i;
            int r = i+1;
            while(l>=0 && r<n){
                if(s.charAt(l) == s.charAt(r)){
                    ans++;
                    l-=1;
                    r+=1;
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}



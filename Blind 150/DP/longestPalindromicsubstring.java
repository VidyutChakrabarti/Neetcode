class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxl = 1;
        String ans = Character.toString(s.charAt(0));
        //for counting odd palindromes
        for(int i = 0; i<n; i++){
            int l = i-1;
            int r = i+1;
            int len = 1; 
            while(l>=0 && r<n){
                if(s.charAt(l) == s.charAt(r)){
                    len+=2;
                    if(len>maxl){
                        maxl = len;
                        ans = s.substring(l, r+1);
                    }
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
            int len = 0;
            while(l>=0 && r<n){
                if(s.charAt(l) == s.charAt(r)){
                    len+=2;
                    if(len>maxl){
                        maxl = len;
                        ans = s.substring(l, r+1);
                    }
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
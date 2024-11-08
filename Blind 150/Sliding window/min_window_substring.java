class Solution {
    public boolean check(HashMap<Character, Integer> m, HashMap<Character,Integer> hm){
        for(char ch: m.keySet()){
            if(m.get(ch)>hm.getOrDefault(ch,0)){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> m = new HashMap<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        int n = s.length(); 
        int ml = t.length();
        if(ml>n){
            return "";
        }
        for(int i = 0;i<ml; i++){
            char c = t.charAt(i);
            m.put(c, m.getOrDefault(c, 0)+1);
        }
        int l = 0;
        int minl = Integer.MAX_VALUE;
        String ans = "";
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            if(m.containsKey(c)){
                hm.put(c, hm.getOrDefault(c, 0)+1);
                char lc = s.charAt(l);
                while(l<=i && (!m.containsKey(lc) || 
                m.get(lc) <= hm.get(lc)-1 
                )){
                    
                    if(m.containsKey(lc)){
                        hm.put(lc, hm.getOrDefault(lc, 0)-1);
                    }
                    l++;
                    lc = s.charAt(l);
                }
                //System.out.println(hm);
                if(check(m,hm)){
                if(i-l+1<minl){
                    minl = i-l+1;
                    ans = s.substring(l, i+1);
                }
                }
            }
            
        }
        //System.out.println(minl);
        return ans;
    }
}

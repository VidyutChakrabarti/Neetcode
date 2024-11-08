class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> m = new HashMap<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        int ws = s1.length();
        int n = s2.length();

        if(n<ws){
            return false;
        }

        for(int i = 0; i<ws ; i++){
            m.put(s1.charAt(i), m.getOrDefault(s1.charAt(i), 0)+1);
            hm.put(s2.charAt(i), hm.getOrDefault(s2.charAt(i), 0)+1);
        }
        if(n==ws){
            if(m.equals(hm)){
                return true;
            }else{
                return false;
            }
        }
        if(hm.equals(m)){
                return true;
            }
        int l = 0;
        for(int i = ws; i<n; i++){
            char to_be_removed = s2.charAt(l);
            char to_be_added = s2.charAt(i);
            
            // System.out.println(to_be_added);
            // System.out.println(to_be_removed);
            if(hm.get(to_be_removed)-1 ==0){
                hm.remove(to_be_removed);
            }else{
                hm.put(to_be_removed, hm.get(to_be_removed) - 1);
            }
            hm.put(to_be_added, hm.getOrDefault(to_be_added, 0)+1);
            // System.out.println(hm);
            if(hm.equals(m)){
                return true;
            }
            l++;
        }
        return false;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        int ms = 0;
        for(int n: nums){
            if(!s.contains(n-1)){
                int cs = 1;
                int curr = n+1;
                while(s.contains(curr)){
                    cs+=1;
                    curr+=1;
                }
                ms = Math.max(cs, ms);
            }
        }
        return ms;
    }
}

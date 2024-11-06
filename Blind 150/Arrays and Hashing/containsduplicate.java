class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> m = new HashSet<>();
        boolean ans = false;
        for(int n: nums){
            if(m.contains(n)){
                ans = true;
                break;
            }else{
                m.add(n);
            }
        }
        return ans;
    }
}
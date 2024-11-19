class Solution {
    public boolean canPartition(int[] nums) {
        int s = 0;
        int l = 0;
        for(int n: nums){
            s+=n;
            l++;
        }

        if(s%2 == 1){
            return false;
        }
        int target = s/2;

        HashSet<Integer> ps = new HashSet<>();
        ps.add(0);

        for(int i = l-1;i>=0;i--){
            if(ps.contains(target)) return true;
            HashSet<Integer> newps = new HashSet<>();
            for(int sums: ps){
                newps.add(sums+nums[i]);
                newps.add(sums);
            }
            ps = newps;
        }
        return false;
    }
}

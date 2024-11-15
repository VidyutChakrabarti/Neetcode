class Solution {
    int target;
    void harness(List<List<Integer>> ans,List<Integer> l, int[] nums, int sum, int i){
    if(sum==target){
        ans.add(new ArrayList<>(l)); 
        return;
    }
    if(i>=nums.length || sum>target){
        return;
    }
    l.add(nums[i]);
    harness(ans, l, nums, sum+nums[i], i+1);
    l.remove(l.size() - 1);
    int q = 1;
    while(i+q<nums.length && nums[i]==nums[i+q]){
        q++;
    }
    harness(ans, l, nums, sum, i+q);
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        this.target = target;
        List<Integer> l = new ArrayList<>();
        Arrays.sort(candidates);
        harness(ans, l, candidates, 0, 0);
        return ans;
    }
}

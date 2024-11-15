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
    harness(ans, l, nums, sum+nums[i], i);
    l.remove(l.size() - 1);
    harness(ans, l, nums, sum, i+1);
    }
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        this.target = target;
        List<Integer> l = new ArrayList<>();
        harness(ans, l, nums, 0, 0);
        return ans;
    }
}

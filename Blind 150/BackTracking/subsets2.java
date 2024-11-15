class Solution {
    List<List<Integer>> ans;
    void harness(int[] nums, List<Integer> l, int i, int n){
        if(i >= n) {
            ans.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[i]);
        harness(nums, l, i+1, n);
        //System.out.println(i+" "+l);
        l.remove(l.size()-1);
        int q = 1;
    while(i+q<nums.length && nums[i]==nums[i+q]){
        q++;
    }
        harness(nums, l, i+q, n);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        harness(nums, l, 0, n);
        return ans;
    }
}


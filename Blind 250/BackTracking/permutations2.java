public class Solution {
    private Map<Integer, Integer> count;
    private List<List<Integer>> res;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        count = new HashMap<>();
        List<Integer> perm = new ArrayList<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        dfs(nums, perm);
        return res;
    }

    private void dfs(int[] nums, List<Integer> perm) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int num : count.keySet()) {
            if (count.get(num) > 0) {
                perm.add(num);
                count.put(num, count.get(num) - 1);
                dfs(nums, perm);
                count.put(num, count.get(num) + 1);
                perm.remove(perm.size() - 1);
            }
        }
    }
}
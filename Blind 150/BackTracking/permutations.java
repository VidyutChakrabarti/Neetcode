class Solution {
    void dfs(List<List<Integer>> ans, List<Integer> curr, int[] nums, boolean[] visited) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            curr.add(nums[i]);

            dfs(ans, curr, nums, visited);

            // Backtrack
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(ans, new ArrayList<>(), nums, visited);
        return ans;
    }
}

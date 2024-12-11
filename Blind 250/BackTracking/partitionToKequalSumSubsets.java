//backtracking pruning

public class Solution {
    private boolean[] used;
    private int target;
    private int n;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;

        this.target = sum / k;
        this.n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = tmp;
        }
        used = new boolean[n];
        return backtrack(nums, k, 0, 0);
    }

    private boolean backtrack(int[] nums, int k, int currentSum, int start) {
        if (k == 0) return true;
        if (currentSum == target) return backtrack(nums, k - 1, 0, 0);

        for (int i = start; i < n; i++) {
            if (used[i] || currentSum + nums[i] > target) continue;
            used[i] = true;
            if (backtrack(nums, k, currentSum + nums[i], i + 1)) return true;
            used[i] = false;
            if (currentSum == 0) {  // Pruning
                return false;
            }
        }
        return false;
    }
}
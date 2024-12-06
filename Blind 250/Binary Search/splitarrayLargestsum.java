public class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0, res = 0;
        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }
        res = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canSplit(nums, k, mid)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private boolean canSplit(int[] nums, int k, int largest) {
        int subarray = 1, curSum = 0;
        for (int num : nums) {
            curSum += num;
            if (curSum > largest) {
                subarray++;
                if (subarray > k) return false;
                curSum = num;
            }
        }
        return true;
    }
}
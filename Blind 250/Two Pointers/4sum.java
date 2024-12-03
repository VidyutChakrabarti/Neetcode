// Two Pointers: O(n^3) time, O(1) space

public class Solution {
    private List<List<Integer>> res;
    private List<Integer> quad;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        quad = new ArrayList<>();
        kSum(nums, 4, 0, target);
        return res;
    }

    private void kSum(int[] nums, int k, int start, long target) {
        if (k == 2) {
            int l = start, r = nums.length - 1;
            while (l < r) {
                long sum = nums[l] + nums[r];
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    res.add(new ArrayList<>(quad));
                    res.get(res.size() - 1).add(nums[l]);
                    res.get(res.size() - 1).add(nums[r]);
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }
            }
            return;
        }

        for (int i = start; i < nums.length - k + 1; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            quad.add(nums[i]);
            kSum(nums, k - 1, i + 1, target - nums[i]);
            quad.remove(quad.size() - 1);
        }
    }
}

/*

HashMap: 

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.get(nums[i]) - 1);
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) - 1);
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                for (int k = j + 1; k < nums.length; k++) {
                    count.put(nums[k], count.get(nums[k]) - 1);
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;

                    long fourth = target - (nums[i] + nums[j] + 0L + nums[k]);
                    if (fourth > Integer.MAX_VALUE || fourth < Integer.MIN_VALUE) {
                        continue;
                    }
                    if (count.getOrDefault((int) fourth, 0) > 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], (int) fourth));
                    }
                }

                for (int k = j + 1; k < nums.length; k++) {
                    count.put(nums[k], count.get(nums[k]) + 1);
                }
            }

            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) + 1);
            }
        }

        return res;
    }
}

*/
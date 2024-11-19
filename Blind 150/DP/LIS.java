public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                    //a break cannot be here because there can be multiple sequences for each num
                    // like 5,8,10 and 3,4,8,10 in 1, 5, 3, 4, 8, 7, 10. 
                }
            }
        }
        return Arrays.stream(LIS).max().getAsInt();
    }
}
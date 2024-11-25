public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xorr = n;  
        for (int i = 0; i < n; i++) {
            xorr ^= i ^ nums[i];
        }
        return xorr;
    }
}

/*
Sorting: 

public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }
}

HASHsET:

public class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
        
            if (!numSet.contains(i)) {
                return i;

            }
        }
        return -1;
    }
}

**/
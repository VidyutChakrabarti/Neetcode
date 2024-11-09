class Solution {
    public int findMin(int n, int[] nums) {
        int l = 0;
        int r = n - 1;
        while(l<r){
            int m = (l+r) / 2;
            if(nums[m]<nums[r]){
                r = m;
            }else{
                l = m + 1; 
            }
        }
        return l;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int m = findMin(n, nums);
        int l, r;
        if(nums[m]<=target && nums[n-1]>=target){
            l = m;
            r = n-1;
        }else{
            l= 0;
            r = m;
        }
        // System.out.println(l);
        // System.out.println(r);
        while(l<=r){
            int mid = (l + r) / 2;
            // System.out.println(mid);
            if(nums[mid]>target){
                r = mid - 1;
            }else if(nums[mid] == target){
                return mid; 
            }else{
                l = mid+1;
            }
        }
        return -1;
    }
}

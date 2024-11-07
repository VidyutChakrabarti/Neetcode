class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length -1;
        int[] ans = new int[2]; 
        while(l<r){
            int s = numbers[l]+numbers[r];
            if(s>target){
                r--;
            }else if(s<target){
                l++;
            }
            else{
                ans[0] = l+1;
                ans[1] = r+1;
                return ans;
            }
        }
        return ans;

    }
}

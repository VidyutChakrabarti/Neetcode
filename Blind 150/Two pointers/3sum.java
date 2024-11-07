class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<Integer> nu = new HashSet<>();
        for(int k: nums){
            nu.add(k);
        }
        List<Integer> num = new ArrayList<>(nu);
        Collections.sort(num);
        int n = num.size();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 2; i<n; i++){
            int l = 0;
            int r = i-1;
            int t = -num.get(i); 
            while(l<r){
                if(num.get(l)+num.get(r)<t){
                    l++;
                }else if(num.get(l)+num.get(r)>t){
                    r--;
                }else{
                    ans.add(List.of(num.get(l), num.get(r), -t));
                    l++;
                    r--;
                }
            }
        }
        return ans;
    }
}

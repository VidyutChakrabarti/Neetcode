class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> mh = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );
    ArrayList<Integer> ans = new ArrayList<>();

    int n = nums.length;
    for(int i = 0; i< k; i++){
        mh.add(new int[]{nums[i], i});
    }

    ans.add(mh.peek()[0]);

    for(int i = k; i<n; i++){
        mh.add(new int[]{nums[i],i});
        while(mh.peek()[1]<=i-k){
            int a = mh.poll()[0];
        }
        ans.add(mh.peek()[0]);
    }
    int[] arr = ans.stream().mapToInt(f -> f).toArray();
    return arr;
    }
}

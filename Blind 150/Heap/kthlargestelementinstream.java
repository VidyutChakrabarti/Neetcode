class KthLargest {
    int k;
    int[] nums;
    PriorityQueue<Integer> pq = new PriorityQueue<>(); 

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        for(int n: nums){
            this.pq.offer(n);
        }
    }
    
    public int add(int val) {
        this.pq.add(val);
        while(pq.size()>this.k){
            this.pq.poll();
        }
        return pq.peek(); 
    }
}

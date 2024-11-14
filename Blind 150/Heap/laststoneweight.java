class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int s: stones){
            pq.offer(s);
        }
        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            if(x!=y){
                pq.offer(Math.abs(x-y));
            }
        }
        //System.out.println(pq);
        if(pq.size() == 1){return pq.poll();}
        return 0;
    }
}

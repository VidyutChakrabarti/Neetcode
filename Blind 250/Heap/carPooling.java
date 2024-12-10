public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // [end, numPassengers]
        int curPass = 0;
        
        for (int[] trip : trips) {
            int numPass = trip[0], start = trip[1], end = trip[2];
            
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= start) {
                curPass -= minHeap.poll()[1];
            }
            
            curPass += numPass;
            if (curPass > capacity) {
                return false;
            }
            
            minHeap.offer(new int[]{end, numPass});
        }
        
        return true;
    }
}
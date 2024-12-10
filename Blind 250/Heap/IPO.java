// two heaps optimal

public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> minCapital = new PriorityQueue<>((a, b) -> capital[a] - capital[b]);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a, b) -> profits[b] - profits[a]);

        for (int i = 0; i < capital.length; i++) {
            minCapital.offer(i);
        }

        for (int i = 0; i < k; i++) {
            while (!minCapital.isEmpty() && capital[minCapital.peek()] <= w) {
                maxProfit.offer(minCapital.poll());
            }
            if (maxProfit.isEmpty()) {
                break;
            }
            w += profits[maxProfit.poll()];
        }

        return w;
    }
}

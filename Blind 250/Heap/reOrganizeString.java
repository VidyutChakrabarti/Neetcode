public class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{freq[i], i});
            }
        }

        StringBuilder res = new StringBuilder();
        int[] prev = null;
        while (!maxHeap.isEmpty() || prev != null) {
            if (prev != null && maxHeap.isEmpty()) {
                return "";
            }

            int[] curr = maxHeap.poll();
            res.append((char) (curr[1] + 'a'));
            curr[0]--;

            if (prev != null) {
                maxHeap.offer(prev);
                prev = null;
            }

            if (curr[0] > 0) {
                prev = curr;
            }
        }

        return res.toString();
    }
}
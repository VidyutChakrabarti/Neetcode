//HEAP BASED SOLUTION

public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        Map<Integer, Integer> count = new HashMap<>();
        for (int n : hand)
            count.put(n, 1 + count.getOrDefault(n, 0));

        PriorityQueue<Integer> minH = new PriorityQueue<>(count.keySet());
        while (!minH.isEmpty()) {
            int first = minH.peek();
            for (int i = first; i < first + groupSize; i++) {
                if (!count.containsKey(i))
                    return false;
                count.put(i, count.get(i) - 1);
                if (count.get(i) == 0) {
                    if (i != minH.peek())
                        return false;
                    minH.poll();
                }
            }
        }
        return true;
    }
}


/*
ORDERED MAP: 

public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> count = new TreeMap<>();
        for (int num : hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> q = new LinkedList<>();
        int lastNum = -1, openGroups = 0;

        for (int num : count.keySet()) {
            if ((openGroups > 0 && num > lastNum + 1) || 
                 openGroups > count.get(num)) {
                return false;
            }

            q.add(count.get(num) - openGroups);
            lastNum = num;
            openGroups = count.get(num);

            if (q.size() == groupSize) {
                openGroups -= q.poll();
            }
        }
        return openGroups == 0;
    }
}

*/
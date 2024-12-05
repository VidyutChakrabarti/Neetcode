// using heap O(log n) time, O(logn) space

public class FreqStack {
    private PriorityQueue<int[]> heap;
    private Map<Integer, Integer> cnt;
    private int index;

    public FreqStack() {
        heap = new PriorityQueue<>((a, b) -> 
            a[0] != b[0] ? Integer.compare(b[0], a[0]) : Integer.compare(b[1], a[1])
        );
        cnt = new HashMap<>();
        index = 0;
    }

    public void push(int val) {
        cnt.put(val, cnt.getOrDefault(val, 0) + 1);
        heap.offer(new int[]{cnt.get(val), index++, val});
    }

    public int pop() {
        int[] top = heap.poll();
        int val = top[2];
        cnt.put(val, cnt.get(val) - 1);
        return val;
    }
}


/*

Hashmap O(1) time, O(1) space

class FreqStack {
    private Map<Integer, Integer> cnt;
    private Map<Integer, Stack<Integer>> stacks;
    private int maxCnt;

    public FreqStack() {
        cnt = new HashMap<>();
        stacks = new HashMap<>();
        maxCnt = 0;
    }

    public void push(int val) {
        int valCnt = cnt.getOrDefault(val, 0) + 1;
        cnt.put(val, valCnt);
        if (valCnt > maxCnt) {
            maxCnt = valCnt;
            stacks.putIfAbsent(valCnt, new Stack<>());
        }
        stacks.get(valCnt).push(val);
    }

    public int pop() {
        int res = stacks.get(maxCnt).pop();
        cnt.put(res, cnt.get(res) - 1);
        if (stacks.get(maxCnt).isEmpty()) {
            maxCnt--;
        }
        return res;
    }
}

*/
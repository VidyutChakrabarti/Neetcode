public class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> res = new HashMap<>();
        int i = 0;
        for (int q : Arrays.stream(queries).sorted().toArray()) {
            while (i < intervals.length && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                minHeap.offer(new int[]{r - l + 1, r});
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }
            res.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }
        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = res.get(queries[j]);
        }
        return result;
    }
}

/*

SEGMENT TREE: 

class SegmentTree {
    int n;
    int[] tree;
    int[] lazy;

    SegmentTree(int N) {
        this.n = N;
        tree = new int[4 * N];
        lazy = new int[4 * N];
        Arrays.fill(tree, Integer.MAX_VALUE);
        Arrays.fill(lazy, Integer.MAX_VALUE);
    }

    void propagate(int treeidx, int lo, int hi) {
        if (lazy[treeidx] != Integer.MAX_VALUE) {
            tree[treeidx] = Math.min(tree[treeidx], lazy[treeidx]);
            if (lo != hi) {
                lazy[2 * treeidx + 1] = Math.min(lazy[2 * treeidx + 1], lazy[treeidx]);
                lazy[2 * treeidx + 2] = Math.min(lazy[2 * treeidx + 2], lazy[treeidx]);
            }
            lazy[treeidx] = Integer.MAX_VALUE;
        }
    }

    void update(int treeidx, int lo, int hi, int left, int right, int val) {
        propagate(treeidx, lo, hi);
        if (lo > right || hi < left) return;
        if (lo >= left && hi <= right) {
            lazy[treeidx] = Math.min(lazy[treeidx], val);
            propagate(treeidx, lo, hi);
            return;
        }
        int mid = (lo + hi) / 2;
        update(2 * treeidx + 1, lo, mid, left, right, val);
        update(2 * treeidx + 2, mid + 1, hi, left, right, val);
        tree[treeidx] = Math.min(tree[2 * treeidx + 1], tree[2 * treeidx + 2]);
    }

    int query(int treeidx, int lo, int hi, int idx) {
        propagate(treeidx, lo, hi);
        if (lo == hi) return tree[treeidx];
        int mid = (lo + hi) / 2;
        if (idx <= mid) return query(2 * treeidx + 1, lo, mid, idx);
        else return query(2 * treeidx + 2, mid + 1, hi, idx);
    }

    void update(int left, int right, int val) {
        update(0, 0, n - 1, left, right, val);
    }

    int query(int idx) {
        return query(0, 0, n - 1, idx);
    }
}

public class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        List<Integer> points = new ArrayList<>();
        for (int[] interval : intervals) {
            points.add(interval[0]);
            points.add(interval[1]);
        }
        for (int q : queries) {
            points.add(q);
        }
        points = new ArrayList<>(new HashSet<>(points));
        Collections.sort(points);

        // Compress the points to indices
        Map<Integer, Integer> compress = new HashMap<>();
        for (int i = 0; i < points.size(); i++) {
            compress.put(points.get(i), i);
        }

        // Create the segment tree
        SegmentTree segTree = new SegmentTree(points.size());

        // Update the segment tree with intervals
        for (int[] interval : intervals) {
            int start = compress.get(interval[0]);
            int end = compress.get(interval[1]);
            int length = interval[1] - interval[0] + 1;
            segTree.update(start, end, length);
        }

        // Query the segment tree for each query
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = compress.get(queries[i]);
            int res = segTree.query(idx);
            ans[i] = (res == Integer.MAX_VALUE) ? -1 : res;
        }

        return ans;
    }
}

*/
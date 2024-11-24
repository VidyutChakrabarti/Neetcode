//HashMap set 1

public class CountSquares {
    private Map<List<Integer>, Integer> ptsCount;
    private List<List<Integer>> pts;

    public CountSquares() {
        ptsCount = new HashMap<>();
        pts = new ArrayList<>();
    }

    public void add(int[] point) {
        List<Integer> p = Arrays.asList(point[0], point[1]);
        ptsCount.put(p, ptsCount.getOrDefault(p, 0) + 1);
        pts.add(p);
    }

    public int count(int[] point) {
        int res = 0;
        int px = point[0], py = point[1];
        for (List<Integer> pt : pts) {
            int x = pt.get(0), y = pt.get(1);
            if (Math.abs(py - y) != Math.abs(px - x) || x == px || y == py) {
                continue;
            }
            res += ptsCount.getOrDefault(Arrays.asList(x, py), 0) * 
                   ptsCount.getOrDefault(Arrays.asList(px, y), 0);
        }
        return res;
    }
}


/*

HASHMAP 2:


public class CountSquares {
    private Map<Integer, Map<Integer, Integer>> ptsCount;

    public CountSquares() {
        ptsCount = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        ptsCount.putIfAbsent(x, new HashMap<>());
        ptsCount.get(x).put(y, ptsCount.get(x).getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0, x1 = point[0], y1 = point[1];

        if (!ptsCount.containsKey(x1)) return res;

        for (int y2 : ptsCount.get(x1).keySet()) {
            int side = y2 - y1;
            if (side == 0) continue;

            int x3 = x1 + side, x4 = x1 - side;
            res += ptsCount.get(x1).get(y2) *
                   ptsCount.getOrDefault(x3, new HashMap<>()).getOrDefault(y1, 0) *
                   ptsCount.getOrDefault(x3, new HashMap<>()).getOrDefault(y2, 0);

            res += ptsCount.get(x1).get(y2) *
                   ptsCount.getOrDefault(x4, new HashMap<>()).getOrDefault(y1, 0) *
                   ptsCount.getOrDefault(x4, new HashMap<>()).getOrDefault(y2, 0);
        }

        return res;
    }
}

*/
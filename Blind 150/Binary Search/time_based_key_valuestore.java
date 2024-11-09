class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    int bins(int n, List<Integer> ls, int ts) {
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int mide = ls.get(mid);
            if (mide > ts) {
                r = mid - 1;
            } else if (mide == ts) {
                return mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        TreeMap<Integer, String> innerMap = map.get(key);
        if (innerMap.isEmpty()) return "";

        List<Integer> ls = new ArrayList<>(innerMap.keySet());
        int idx = bins(ls.size(), ls, timestamp);
        if (idx == -1) return "";

        int tsAtIdx = ls.get(idx);
        return innerMap.get(tsAtIdx);
    }
}

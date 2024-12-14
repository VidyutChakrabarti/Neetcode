class UnionFind {
    private final Map<String, String> parent;
    private final Map<String, Double> weight;

    public UnionFind() {
        parent = new HashMap<>();
        weight = new HashMap<>();
    }

    public void add(String x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            weight.put(x, 1.0);
        }
    }

    public String find(String x) {
        if (!x.equals(parent.get(x))) {
            String origParent = parent.get(x);
            parent.put(x, find(origParent));
            weight.put(x, weight.get(x) * weight.get(origParent));
        }
        return parent.get(x);
    }

    public void union(String x, String y, double value) {
        add(x);
        add(y);
        String rootX = find(x);
        String rootY = find(y);

        if (!rootX.equals(rootY)) {
            parent.put(rootX, rootY);
            weight.put(rootX, value * weight.get(y) / weight.get(x));
        }
    }

    public double getRatio(String x, String y) {
        if (!parent.containsKey(x) || !parent.containsKey(y) || !find(x).equals(find(y))) {
            return -1.0;
        }
        return weight.get(x) / weight.get(y);
    }
}

public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind uf = new UnionFind();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            uf.union(a, b, values[i]);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);
            result[i] = uf.getRatio(a, b);
        }

        return result;
    }
}
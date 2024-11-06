class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i<n; i++){
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> topk = m.entrySet()
            .stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .limit(k)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        int[] arr = topk.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
}

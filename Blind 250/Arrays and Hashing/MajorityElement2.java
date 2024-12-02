// BOOYRE-MOORE VOTING ALGORITHM HASHMAP

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);

            if (count.size() > 2) {
                Map<Integer, Integer> newCount = new HashMap<>();
                for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                    if (entry.getValue() > 1) {
                        newCount.put(entry.getKey(), entry.getValue() - 1);
                    }
                }
                count = newCount;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int key : count.keySet()) {
            int frequency = 0;
            for (int num : nums) {
                if (num == key) frequency++;
            }
            if (frequency > nums.length / 3) {
                res.add(key);
            }
        }

        return res;
    }
}

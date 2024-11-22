class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int gs = 0;
        int cs = 0;
        for(int i = 0; i<n; i++){
            gs+= gas[i];
            cs+= cost[i];
        }
        if(gs<cs){return -1;}

        int res = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            total += (gas[i] - cost[i]);
            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }

        return res;
    }
}



/*

two pointers: 

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = n - 1, end = 0;
        int tank = gas[start] - cost[start];
        while (start > end) {
            if (tank < 0) {
                start--;
                tank += gas[start] - cost[start];
            } else {
                tank += gas[end] - cost[end];
                end++;
            }
        }
        return tank >= 0 ? start : -1;
    }
}

*/
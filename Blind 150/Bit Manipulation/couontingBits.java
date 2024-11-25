public class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int num = 1; num <= n; num++) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    res[num]++;
                }
            }
        }       
        return res;
    }
}


/*
bitm manipulation-2 

public class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num != 0) {
                res[i]++;
                num &= (num - 1);
            }
        }
        return res;
    }
}

*/s
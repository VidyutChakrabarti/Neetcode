public class Solution {
    public int reverseBits(int n) {
        int ret = n;
        ret = ret >>> 16 | ret << 16;
        ret = (ret & 0xff00ff00) >>> 8 | (ret & 0x00ff00ff) << 8;
        ret = (ret & 0xf0f0f0f0) >>> 4 | (ret & 0x0f0f0f0f) << 4;
        ret = (ret & 0xcccccccc) >>> 2 | (ret & 0x33333333) << 2;
        ret = (ret & 0xaaaaaaaa) >>> 1 | (ret & 0x55555555) << 1;
        return ret;
    }
}


// brute force: 

public class Solution {
    public int reverseBits(int n) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                binary.append("1");
            } else {
                binary.append("0");
            }
        }
        
        int res = 0;
        String reversedBinary = binary.reverse().toString();
        for (int i = 0; i < 32; i++) {
            if (reversedBinary.charAt(i) == '1') {
                res |= (1 << i);
            }
        }
        
        return res;
    }
}


// brute foree: 

public class Solution {
    public int reverseBits(int n) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                binary.append("1");
            } else {
                binary.append("0");
            }
        }
        
        int res = 0;
        String reversedBinary = binary.reverse().toString();
        for (int i = 0; i < 32; i++) {
            if (reversedBinary.charAt(i) == '1') {
                res |= (1 << i);
            }
        }
        
        return res;
    }
}
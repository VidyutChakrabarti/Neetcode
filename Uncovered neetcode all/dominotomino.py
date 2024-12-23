
nums = [1, 2, 5]
mod = 1e9+7

for _ in range(997):
    nums.append((nums[-1] * 2 + nums[-3]) % mod)

class Solution(object):
    def numTilings(self, n):

        return int(nums[n-1])
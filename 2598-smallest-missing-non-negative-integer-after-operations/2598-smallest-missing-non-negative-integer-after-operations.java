class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();

        // Step 1: Count occurrences by modulo value
        for (int num : nums) {
            int mod = ((num % value) + value) % value; // ensure non-negative
            count.put(mod, count.getOrDefault(mod, 0) + 1);
        }

        // Step 2: Find the smallest non-negative integer (MEX)
        int mex = 0;
        while (true) {
            int mod = mex % value;
            if (count.getOrDefault(mod, 0) > 0) {
                count.put(mod, count.get(mod) - 1);
                mex++;
            } else {
                break;
            }
        }

        return mex;
    }
}

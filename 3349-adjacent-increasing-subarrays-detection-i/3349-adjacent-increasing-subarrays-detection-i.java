class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int count = 1;  // length of current increasing streak

        // Store lengths of all strictly increasing subarrays
        int[] inc = new int[n];
        inc[0] = 1;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 1;
            }
        }

        // Now, check if there are two adjacent increasing subarrays of length k
        for (int i = k - 1; i + k < n; i++) {
            // If subarray ending at i has length >= k
            // and next subarray ending at i + k has length >= k
            if (inc[i] >= k && inc[i + k] >= k) {
                return true;
            }
        }

        return false;
    }
}

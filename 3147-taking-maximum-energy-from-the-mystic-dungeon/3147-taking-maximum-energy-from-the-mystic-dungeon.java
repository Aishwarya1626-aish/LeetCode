class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n]; // dp[i] stores max energy starting at i and jumping by k
        int maxEnergy = Integer.MIN_VALUE;

        // Start from the end and move backward
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = energy[i];
            if (i + k < n) {
                dp[i] += dp[i + k];
            }
            maxEnergy = Math.max(maxEnergy, dp[i]);
        }

        return maxEnergy;
    }
}

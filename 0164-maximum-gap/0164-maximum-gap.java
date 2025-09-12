class Solution 
{
    public int maximumGap(int[] nums) 
    {       
        if (nums == null || nums.length < 2) 
           return 0;

        int n = nums.length;
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;

        // Find min and max
        for (int num : nums) 
        {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        if (minVal == maxVal) 
            return 0; // all numbers are same

        // Bucket size and count
        int bucketSize = Math.max(1, (maxVal - minVal) / (n - 1));
        int bucketCount = (maxVal - minVal) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] bucketUsed = new boolean[bucketCount];

        // Initialize buckets
        for (int i = 0; i < bucketCount; i++) 
        {
            bucketMin[i] = Integer.MAX_VALUE;
            bucketMax[i] = Integer.MIN_VALUE;
        }

        // Distribute numbers into buckets
        for (int num : nums) 
        {
            int idx = (num - minVal) / bucketSize;
            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
            bucketUsed[idx] = true;
        }

        // Scan buckets to find max gap
        int maxGap = 0;
        int prev = minVal;

        for (int i = 0; i < bucketCount; i++) 
        {
            if (!bucketUsed[i]) continue;
            maxGap = Math.max(maxGap, bucketMin[i] - prev);
            prev = bucketMax[i];
        }

        return maxGap;
    }
}

class Solution
{
    
    public  static int maxArea(int[] height) {
        // Initialize two pointers: 'left' at the beginning and 'right' at the end.
        int left = 0;
        int right = height.length - 1;

        // Initialize maxArea to store the maximum area found so far.
        int maxArea = 0;

        // The correct syntax for the while loop condition
        while (left < right) {
            
            // 1. Calculate the current height of the container.
            // The height is limited by the shorter of the two lines.
            int currentHeight = Math.min(height[left], height[right]);

            // 2. Calculate the width of the container.
            // The width is the distance between the two pointers.
            int width = right - left;

            // 3. Calculate the area and update maxArea if the current area is larger.
            int currentArea = currentHeight * width;
            maxArea = Math.max(maxArea, currentArea);

            // 4. Move the pointer of the shorter line inward.
            // This is the core optimization: moving the shorter pointer is the 
            // only way to potentially increase the height, which is necessary
            // to offset the decreasing width.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}









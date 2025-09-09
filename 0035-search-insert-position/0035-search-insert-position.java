class Solution 
{
    public int searchInsert(int[] nums, int target) 
    {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
            {
                 // target found
                return mid;  
            }
            else if (nums[mid] < target) 
            {
                 // search in right half
                left = mid + 1; 
            } else 
            {
                // search in left half
                right = mid - 1; 
            }
        }

        // if not found, left will be the insert position
        return left;
    }
}

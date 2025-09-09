class Solution 
{
    public int removeElement(int[] nums, int val) 
    {
        //pointer for next position of non-val element

        int num = 0; 

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
            {
                // copy non-val element
                nums[num] = nums[i]; // copy non-val element
                num++;
            }
        }

        // length of array without val
        return num; 
    }
}


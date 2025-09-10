class Solution {
    public int[] plusOne(int[] digits)
     {
        int n = digits.length;
        
        // Traverse from last digit
        for (int i = n - 1; i >= 0; i--) 
        {
            if (digits[i] < 9) 
            {
                 // just add 1 if it's not 9
                digits[i]++;  
                return digits;
            }
            // if digit is 9, make it 0 and continue loop
            digits[i] = 0;  
        }
        
        // If all digits were 9 (e.g., 999 -> 1000)
        int[] result = new int[n + 1];
        // rest will be 0 by default
        result[0] = 1; 
        return result;
    }
}

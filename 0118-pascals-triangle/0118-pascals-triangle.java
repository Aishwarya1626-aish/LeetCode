class Solution 
{
    public List<List<Integer>> generate(int numRows) 
    {
        // 2D array to hold values
        int[][] arr = new int[numRows][numRows]; 
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++)
        {
            // first element = 1
            arr[i][0] = 1;
             // last element = 1
            arr[i][i] = 1;          
            for (int j = 1; j < i; j++)
            {
                // sum of two above
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j]; 
            }
            
            // Convert current row to List<Integer>
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++)
            {
                row.add(arr[i][j]);
            }
            result.add(row);
        }
        
        return result;
    }
}

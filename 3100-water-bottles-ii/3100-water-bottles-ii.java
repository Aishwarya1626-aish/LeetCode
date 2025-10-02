class Solution {
    
    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        // 'totalDrunk' is the result we want to return.
        int totalDrunk = 0;
        
        // 'emptyBottles' tracks the empty bottles available for exchange.
        int emptyBottles = 0;

        // Loop continues as long as there are full bottles to drink or enough empty bottles for an exchange.
        while (numBottles > 0 || emptyBottles >= numExchange) {
            
            // --- Phase 1: Drink ---
            // Drink all available full bottles.
            totalDrunk += numBottles;
            emptyBottles += numBottles;
            numBottles = 0; // All full bottles are now drunk.
            
            // --- Phase 2: Exchange ---
            // Check if we can make an exchange with the current rate.
            if (emptyBottles >= numExchange) {
                // Perform the exchange: get 1 new full bottle.
                numBottles = 1; 
                
                // Use up the required number of empty bottles.
                emptyBottles -= numExchange;
                
                // Increase the exchange rate for the next trade.
                numExchange++;
            }
        }
        
        return totalDrunk;
    }
}
class Solution {
    
    public static int numWaterBottles(int numBottles, int numExchange) {
        // 'totalDrunk' is the result we want to return. It starts with the initial bottles.
        int totalDrunk = numBottles;
        
        // 'emptyBottles' tracks the empty bottles available for exchange.
        // After drinking the initial bottles, they all become empty.
        int emptyBottles = numBottles;

        // The loop continues as long as we have enough empty bottles for at least one exchange.
        while (emptyBottles >= numExchange) {
            
            // 1. Calculate the number of new full bottles we can get from the exchange.
            int newFullBottles = emptyBottles / numExchange;

            // 2. Calculate the number of empty bottles remaining after the exchange.
            // These are the empty bottles we couldn't exchange.
            int remainingEmpty = emptyBottles % numExchange;

            // 3. Update the total bottles drunk.
            // We drink all the newly acquired full bottles.
            totalDrunk += newFullBottles;

            // 4. Update the empty bottle count for the next iteration.
            // The empty bottles for the next round come from two sources:
            // a) The bottles that were remaining and couldn't be exchanged.
            // b) The new full bottles we just drank (which are now empty).
            emptyBottles = remainingEmpty + newFullBottles;
        }

        return totalDrunk;
    }
}
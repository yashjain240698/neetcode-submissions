class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, len = gas.length;
        for(int i = 0 ; i < len ; i++){
            totalCost += cost[i];
            totalGas += gas[i];
        }

        if(totalGas < totalCost){
            return -1;
        }

        int k = 0, ans = 0;
        for(int i = 0 ; i < len ; i++){
            k += gas[i] - cost[i];
            if(k < 0){
                ans = i+1;
                k = 0;
            }
        }
        return ans;
    }
}

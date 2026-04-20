class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i=0;i<n;i++){
            if(gas[i]>=cost[i]){
                int j = i+1==n?0:i+1;
                int curGas=gas[i]-cost[i];
                while(j!=i){
                    curGas =curGas+gas[j]-cost[j];
                    if(curGas<0){
                        break;
                    }
                    j = j+1==n?0:j+1;
                }
                if(i==j){
                    return i;
                }
            }
        }
        return -1;
    }
}

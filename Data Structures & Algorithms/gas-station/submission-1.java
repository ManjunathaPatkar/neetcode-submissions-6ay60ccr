class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tank=0,index=0,total=0;
        for(int i=0;i<n;i++){
            total =total+gas[i]-cost[i];
            tank =tank+gas[i]-cost[i];
            if(tank<0){
                tank=0;
                index=i+1;
            }
        }
        return total>=0?index:-1;
    }
}

class Solution {
    HashMap<Integer,Integer> hm;
    public int minCostClimbingStairs(int[] cost) {
        hm = new HashMap<>();
        helper(cost,0);
        // helper(cost,1);
        return Math.min(hm.get(0),hm.get(1));
    }
    private int helper(int[] cost, int i){
        if(i>=cost.length){
            return 0;
        }
        if(hm.containsKey(i)){
            return hm.get(i);
        }
        int first =  helper(cost, i+1);
        int second =  helper(cost, i+2);
        int res = Math.min(first,second)+cost[i];
        hm.put(i,res);
        return res;
    }


}

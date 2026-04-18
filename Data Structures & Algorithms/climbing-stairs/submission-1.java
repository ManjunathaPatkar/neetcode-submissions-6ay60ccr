class Solution {
    HashMap<Integer,Integer> hm;
    public int climbStairs(int n) {
       hm = new HashMap<>();
       hm.put(0,0);
       hm.put(1,1);
       hm.put(2,2);
       return helper(n);
    }

    private int helper(int n){
        if(hm.containsKey(n)){
            return hm.get(n);
        }
        int res= helper(n-1)+helper(n-2);
        hm.put(n,res);
        return res;
    }
}

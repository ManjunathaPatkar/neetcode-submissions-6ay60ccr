class Solution {
    HashMap<Integer,Integer> hm;
    int max;
    public int rob(int[] nums) {
        hm = new HashMap<>();
        max = Integer.MIN_VALUE;
        helper(nums,0);
        return max;
    }
    private int helper(int[] nums, int i){
        if(i>=nums.length){
            return 0;
        }
        if(hm.containsKey(i)){
            return hm.get(i);
        }
        int with = nums[i]+helper(nums,i+2);
        int without = helper(nums,i+1);
        int curMax = Math.max(with,without);
        max= Math.max(max,curMax);
        hm.put(i,curMax);
        return curMax;
    }
}

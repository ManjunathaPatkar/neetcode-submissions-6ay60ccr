class Solution {
    HashMap<Integer,Integer> hm;
    int max;
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        hm = new HashMap<>();
        max = Integer.MIN_VALUE;
        int a =helper(nums,0,nums.length-2);
        hm = new HashMap<>();
        max = Integer.MIN_VALUE;
        int b=helper(nums,1,nums.length-1);
        return Math.max(a,b);
    }
    private int helper(int[] nums, int i, int end){
        if(i>end){
            return 0;
        }
        if(hm.containsKey(i)){
            return hm.get(i);
        }
        int with = nums[i]+helper(nums,i+2,end);
        int without = helper(nums,i+1,end);
        int curMax = Math.max(with,without);
        max= Math.max(max,curMax);
        hm.put(i,curMax);
        return curMax;
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(res,cur,nums,0,0,target);
        return res;
    }
    private void helper(
        List<List<Integer>> res,List<Integer> cur,int[] nums, int i, int sum ,int target
    ){
        if(i==nums.length || sum>target){
            return;
        }
        if(sum==target){
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        helper(res,cur,nums,i,sum+nums[i],target);
        cur.remove(cur.size()-1);
        helper(res,cur,nums,i+1,sum,target);
    }
}

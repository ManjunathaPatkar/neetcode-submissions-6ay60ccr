class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
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
        if(sum+nums[i]>target){
            return;
        }
        for(int ind =i;ind<nums.length;ind++){
            if(nums[ind]+sum>target){
                return;
            }
            cur.add(nums[ind]);
            helper(res,cur,nums,ind,sum+nums[ind],target);
            cur.remove(cur.size()-1);
        }
    }
}

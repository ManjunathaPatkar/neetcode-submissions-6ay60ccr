class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res,cur,candidates,0,0,target);
        return res;
    }

    private void helper(
        List<List<Integer>> res,List<Integer> cur,int[] nums,
        int i, int sum, int target){
            if(sum==target){
                res.add(new ArrayList<>(cur));
                return;
            }
            if(i==nums.length){
                return;
            }
            for(int ind =i;ind<nums.length;ind++){
                if(ind>i && nums[ind]==nums[ind-1]){
                    continue;
                }
                if(sum+nums[ind]>target){
                    return;
                }
                cur.add(nums[ind]);
                helper(res,cur,nums,ind+1,sum+nums[ind],target);
                cur.remove(cur.size()-1);
            }
        }
    
}

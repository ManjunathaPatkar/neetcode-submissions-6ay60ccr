class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> cur= new ArrayList<>();
        Arrays.sort(nums);
        helper(res,cur,nums,0);
        return res;
    }
    private void helper(
        List<List<Integer>> res,List<Integer> cur,
        int[] nums, int i
    ){
        res.add(new ArrayList<>(cur));
        if(i==nums.length){
            return;
        }
        for(int ind =i;ind<nums.length;ind++){
            if(ind>i && nums[ind]==nums[ind-1]){
                continue;
            }
            cur.add(nums[ind]);
            helper(res,cur,nums,ind+1);
            cur.remove(cur.size()-1);
        }
    }
}

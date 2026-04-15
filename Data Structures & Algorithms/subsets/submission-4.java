class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(cur,res,nums,0);
        return res;
    }
    private void helper(
        List<Integer> cur, List<List<Integer>> res,int[] nums, int i){        
            res.add(new ArrayList<>(cur));
            for(int ind =i;ind<nums.length;ind++){
                cur.add(nums[ind]);
                helper(cur,res,nums,ind+1);
                cur.remove(cur.size()-1);
            }
        }
}


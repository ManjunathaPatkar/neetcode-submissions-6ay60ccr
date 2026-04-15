class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> cur =new ArrayList<>();
        helper(res, cur, nums, 0, new HashSet<>());
        return res;
    }

    private void helper(
         List<List<Integer>> res, List<Integer> cur, int[] nums, int i,
         HashSet<Integer> hs
    ){
        if(cur.size()==nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int ind =0;ind<nums.length;ind++){
            if(hs.contains(nums[ind])){
                continue;
            }
            hs.add(nums[ind]);
            cur.add(nums[ind]);
            helper(res,cur,nums,ind+1,hs);
            hs.remove(cur.get(cur.size()-1));
            cur.remove(cur.size()-1);
        }
    }
}


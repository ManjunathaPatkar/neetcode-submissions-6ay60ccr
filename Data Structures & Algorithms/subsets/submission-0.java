class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        res.add(cur);
        helper(cur,res,nums,0);
        return res;
    }
    private void helper(
        List<Integer> cur, List<List<Integer>> res,int[] nums, int i){
            if(i==nums.length){
                return;
            }          
            cur.add(nums[i]);
            System.out.println();
            res.add(new ArrayList<>(cur));
            helper(cur,res,nums,i+1);
            cur.remove(cur.size()-1);
            helper(cur,res,nums,i+1);
        }
}


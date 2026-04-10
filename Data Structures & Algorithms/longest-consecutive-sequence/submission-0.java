class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }
        int lcs = 0;
        for(Integer num : numSet){
            int lcsc = 1;
            int i = num;
            while (numSet.contains(i+1)){
                lcsc ++;
                i++;
            }
            if(lcsc>lcs){
                lcs = lcsc;
            }
        }
        return lcs;
    }
}

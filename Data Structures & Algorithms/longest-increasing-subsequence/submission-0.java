class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> seq = new ArrayList<>();
        for(int num:nums){
            int i=0,j=seq.size();
            while(i<j){
                int m = (i+j)/2;
                if(seq.get(m)<num){
                    i=m+1;
                }
                else{
                    j=m;
                }
            }
            if(i==seq.size()){
                seq.add(num);
            }
            else{
                seq.set(i,num);
            }
        }
        return seq.size();
    }
}

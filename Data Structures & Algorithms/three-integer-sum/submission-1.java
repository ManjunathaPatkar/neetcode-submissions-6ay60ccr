class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length,j,k;
        for (int i=0; i<n; i++){
            j=i+1;
            k=n-1;
            while(j<k){
                if(nums[j]+nums[k]+nums[i]==0){
                    res.add(List.of(nums[i],nums[j],nums[k]));
                    while(j+1<n && nums[j]== nums[j+1]){
                        j++;
                    }
                    while(k-1>=0 && nums[k]== nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }
                else if(nums[j]+nums[k]+nums[i]>0){
                    k--;
                }
                else{
                    j++;
                }
            }
             while(i+1<n && nums[i]== nums[i+1]){
                i++;
            }
        }
        return res;
    }
}

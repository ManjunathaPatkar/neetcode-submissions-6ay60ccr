class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length, j, k, mid;
        for(int i=0; i< numbers.length; i++){
            int toFind = target- numbers[i];
            j=i+1;
            k= n-1;
            while(j<=k){
                mid = (j+k)/2;
                if(numbers[mid]==toFind){
                    return new int[]{i+1,mid+1};
                }
                else if(numbers[mid] > toFind){
                    k = mid-1;
                }
                else{
                    j = mid+1;
                }
            }
        }
        return new int[]{-1,-1};
    }
}

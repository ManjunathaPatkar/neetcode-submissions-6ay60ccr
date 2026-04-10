class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int j = numbers.length-1, i=0;
        while(i<j){
            if(numbers[i]+numbers[j] == target){
                return new int[]{i+1,j+1};
            }
            else if(numbers[i]+numbers[j] > target){
                j--;
            }
            else{
                i++;
            }
        }
        return new int[]{-1,-1};
    }
}

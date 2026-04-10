class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0, curArea;
        int i=0, j=heights.length-1;
        while(i<j){
            curArea = Math.min(heights[i],heights[j])*(j-i);
            if(curArea>maxArea){
                maxArea = curArea;
            }
            if(heights[i]>heights[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return maxArea;
    }
}

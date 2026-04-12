class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea =0, n = heights.length;
        for(int i=0;i<=n;i++){
            int curHeight = i==n ? 0 :heights[i];
            while(!stack.isEmpty() && heights[stack.peek()]> curHeight){
                int l =heights[stack.pop()], w = stack.isEmpty()? i:i-stack.peek()-1;
                maxArea = Math.max(maxArea,l*w);
            }
            stack.push(i);
        }
        return maxArea;

    }
}
//          0,1,2,3,4,5
// heights=[7,1,7,2,2,4]

// [1]
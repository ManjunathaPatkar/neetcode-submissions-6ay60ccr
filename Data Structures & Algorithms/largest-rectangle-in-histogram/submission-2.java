class Solution {
    public int largestRectangleArea(int[] heights) {
      int n = heights.length;
        int smallleft[] = new int[n];
        int smallright[] = new int[n];
        Stack<Integer> s = new Stack<>();
       

        for(int i=0;i<heights.length;i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i] ){
                s.pop();
            }
            if(s.isEmpty()){
                smallleft[i] = -1;
            }
            else{
                smallleft[i] = s.peek();
            }

            s.push(i);
        }

        s = new Stack<>();
        for(int i=heights.length-1; i>=0; i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i] ){
                s.pop();
            }
            if(s.isEmpty()){
                smallright[i] = heights.length;
            }
            else{
                smallright[i] = s.peek();
            }

            s.push(i);
        }
        int largeRectangle = 0;
        for(int i=0; i<heights.length; i++){
            int height = heights[i];
            int width = smallright[i] -smallleft[i]-1;
            int currRectangle = height * width;
            largeRectangle = Math.max(currRectangle, largeRectangle);
        }

        return largeRectangle;

    }
}
//O(n)
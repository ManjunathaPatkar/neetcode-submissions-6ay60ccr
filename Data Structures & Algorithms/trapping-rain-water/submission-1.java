class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        for(int i=1; i<n; i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i-1]);
        }
        int[] rightMax = new int[n];
        for(int i=n-2; i>=0; i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i+1]);
        }
        int res=0;
        for(int i=0; i<n; i++){
            int minHeight = Math.min(leftMax[i],rightMax[i]);
            if(height[i]<minHeight){
                res=res+minHeight-height[i];
            }
        }
        return res;
    }
}

// [0,2,0,3,1,0,1,3,2,1]
// [0,0,2,2,3,3,3,3,3,3]
// [3,3,3,3,3,3,3,2,1,0]


// [0,1,0,2,1,0,1,3,2,1,2,1]
// [0,0,1,1,2,2,2,2,3,3,3,3]
// [3,3,3,3,3,3,3,2,2,2,1,0]

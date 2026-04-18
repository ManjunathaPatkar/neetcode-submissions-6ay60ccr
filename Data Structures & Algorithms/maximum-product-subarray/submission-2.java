class Solution {
    public int maxProduct(int[] nums) {
        int minMul =1, maxMul=1, max =Integer.MIN_VALUE;
        for(int num:nums){
            int minCur = minMul * num;
            int maxCur = maxMul * num;
            minMul = Math.min(num, Math.min(minCur,maxCur));
            maxMul = Math.max(num, Math.max(minCur,maxCur));
            max= Math.max(max,maxMul);
            System.out.println(num+" "+minCur+" "+maxCur+" "+max);
        }
        return max;
    }
}

// [2,-5,-2, -4, 3]

// 2. -10 -2 -80 -240
// 2. -5  20  8   24
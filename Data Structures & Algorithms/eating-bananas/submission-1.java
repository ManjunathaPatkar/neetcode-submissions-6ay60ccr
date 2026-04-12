class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = -1;
        for(int pile:piles){
            max=Math.max(max,pile);
        }
        int i=1,j=max, min =Integer.MAX_VALUE;
        while(i<=j){
            int m = (i+j)/2;
            int timeReq = helper(piles, m);
            if(timeReq<=h){
                min = Math.min(min,m);
                j=m-1;
            }else{
                i=m+1;
            }

        }
        return min;
    }

    private int helper(int[] piles, int k){
        int count=0;
        for(int pile:piles){
            count+=  (Math.ceil ((double)pile/k));
        }
        return count;
    }
}


// [1,4,3,2] = 4.  9


// [1,2,3,4]

// 2


// [25,10,23,4]

// [4,10,23,24]
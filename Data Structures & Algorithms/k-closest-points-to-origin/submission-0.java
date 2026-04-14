class Solution {
    class Point{
        int x;
        int y;
        double k;
        Point(int x,int y,double k){
            this.x=x;
            this.y=y;
            this.k=k;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
       PriorityQueue<Point> pq = 
       new PriorityQueue<>((a, b) -> Double.compare(a.k, b.k));
        for(int[] point:points){
            pq.offer(new Point(point[0],point[1],helper(point[0],point[1])));
        }
        int[][] res= new int[k][2];
        int i=0;
        while(k!=0){
            Point p =pq.poll();
            res[i] = new int[]{p.x,p.y};
            i++;
            k--;
        }
        return res;
    }
    private double helper(int x1, int y1){
        int x = x1*x1;
        int y = y1*y1;
        return Math.sqrt(x+y); 
    }
}

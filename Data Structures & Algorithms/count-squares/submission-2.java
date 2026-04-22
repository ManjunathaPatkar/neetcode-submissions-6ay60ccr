class CountSquares {
    int[][] square;
    List<int[]> points;
    public CountSquares() {
        square = new int[1001][1001];
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        square[point[0]][point[1]]=square[point[0]][point[1]]+1;
        points.add(point);
    }
    
    public int count(int[] point) {
        int x1=point[0],y1=point[1];
        int res=0;
        for(int[] p:points){
            int x2=p[0],y2=p[1];
            if(Math.abs(x1-x2)==0 || (Math.abs(x1-y1)!=Math.abs(x2-y2))){
                continue;
            }
            res=res+square[x1][y2]*square[x2][y1];
        }
        return res;
    }
}

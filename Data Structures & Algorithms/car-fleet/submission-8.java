class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length ==1 ){
            return 1;
        }
        List<double[]> map =new ArrayList<>();
        for(int i=0;i<position.length;i++){
            double leftToCover = target-position[i];
            map.add(
                new double[]{position[i], 
            (double)leftToCover/speed[i]});
        }
        int count =0;
        double prev = 0;
        Collections.sort(map, (a, b) -> Double.compare(b[0], a[0]));
        for(int i =0; i< map.size(); i++){
           if(prev < map.get(i)[1]){
                count++;
                prev = map.get(i)[1];
            }
        }
        return count;
    }
}

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
            TreeMap<Integer,Integer> tm = new TreeMap<>();
            for(int num:hand){
                tm.put(num,tm.getOrDefault(num,0)+1);
            }
            while(!tm.isEmpty()){
                int firstKey = tm.firstKey();
                for(int i=0;i<groupSize;i++){
                    int a=firstKey+i;
                    if(!tm.containsKey(a)){
                        return false;
                    }
                    tm.put(a,tm.get(a)-1);
                    if(tm.get(a)==0){
                        tm.remove(a);
                    }
                }
            }
            return tm.isEmpty();
    }
}

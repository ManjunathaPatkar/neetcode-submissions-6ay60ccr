class TimeMap {
    public Map<String,TreeMap<Integer,String>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(hm.containsKey(key)){
            hm.get(key).put(timestamp, value);
        }
        else{
            TreeMap<Integer,String> tp= new TreeMap<>();
            tp.put(timestamp,value);
            hm.put(key,tp);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)){
            return "";
        }
        if(hm.get(key).floorKey(timestamp)==null){
            return "";
        }
        return hm.get(key).getOrDefault(hm.get(key).floorKey(timestamp),"");
    }
}

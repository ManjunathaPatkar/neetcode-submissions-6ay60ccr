class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] numCount = new int[26];
        HashMap<String,List<String>> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            Arrays.fill(numCount,0);
            for(char c: str.toCharArray()){
                numCount[c-'a']++;
            }
            sb = new StringBuilder();
            for(int num: numCount){
                sb.append(num);
                sb.append(':');
            }
            String key=sb.toString();
            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(str);
        }
        return new ArrayList<>(hm.values());
    }
}

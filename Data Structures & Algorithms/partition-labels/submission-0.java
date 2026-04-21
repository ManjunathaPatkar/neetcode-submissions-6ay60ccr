class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> lastIndex = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            lastIndex.put(c,i);
        }
        List<Integer> res = new ArrayList<>();
        int j=0,start=0;
        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            if(i>j){
                res.add(j-start+1);
                start=j+1;
                j++;
            }
            j=Math.max(lastIndex.get(c),j);
        }
        res.add(j-start+1);
        return res;
    }
}

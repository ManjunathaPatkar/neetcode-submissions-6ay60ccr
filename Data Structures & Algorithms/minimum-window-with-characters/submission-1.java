class Solution {
    public String minWindow(String s, String t) {
        Set<Character> hs = new HashSet<>();
        Map<Character,Integer> hm = new HashMap<>();
        for(char c: t.toCharArray()){
            hs.add(c);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        int uniqueCount = hs.size(), currentCount=0;
        int i =0, j=0, minLen=s.length();
        String res = "";
        while(i<s.length()){
            char c =s.charAt(i);
             hm.put(c,hm.getOrDefault(c,0)-1);
             if(hm.get(c)==0){
                currentCount++;
                if(currentCount == uniqueCount){
                    while(j<=i && hm.get(s.charAt(j))!=0){
                         hm.put(s.charAt(j),hm.get(s.charAt(j))+1);
                         j++;
                    }
                    if(i-j+1<=minLen){
                        res=s.substring(j,i+1);
                        minLen = res.length();
                    }
                    hm.put(s.charAt(j),hm.get(s.charAt(j))+1);
                    j++;
                    currentCount--;
                }
             }
             i++;
        }
        return res;
    }
}
// 0 1 2 3 4 5 6 7 8 9.   X Y Z
// O U Z O D Y X A Z V
//             i
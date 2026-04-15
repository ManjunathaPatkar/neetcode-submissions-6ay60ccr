class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res,s,0,new ArrayList<>());
        return res;
    }

    private void helper(
        List<List<String>> res, String s, int start, List<String> cur
    ){
        if(start==s.length()){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int end = start; end<s.length();end++){
            if(isPal(s,start,end)){
                cur.add(s.substring(start,end+1));
                helper(res,s,end+1,cur);
                cur.remove(cur.size()-1);
            }
        }
    }

    private boolean isPal(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        helper(res,0,0,n,new StringBuilder());
        return res;
    }
    private void helper(
        List<String> res, int open,int close,int n,StringBuilder sb
    ){
        if(sb.length()==n*2){
            res.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append("(");
            helper(res,open+1,close,n,sb);
            sb.setLength(sb.length()-1);
        }
        if(open>close){
            sb.append(")");
            helper(res,open,close+1,n,sb);
            sb.setLength(sb.length()-1);
        }    
    }
}
 
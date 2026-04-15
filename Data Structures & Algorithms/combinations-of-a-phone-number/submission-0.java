class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        String[] phone = new String[]{
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        List<String> res = new ArrayList<>();
        helper(digits,0,res,new StringBuilder(),phone);
        return res;
    }

    private void helper(
        String digits, int ind, List<String> res, StringBuilder sb,  String[] phone){
            if(ind==digits.length()){
                res.add(sb.toString());
                return;
            }
            int digit = digits.charAt(ind)-'0';
            String chars = phone[digit];
            for(int i=0;i<chars.length();i++){
                sb.append(chars.charAt(i));
                helper(digits,ind+1,res,sb,phone);
                sb.setLength(sb.length()-1);
            }
        }
}

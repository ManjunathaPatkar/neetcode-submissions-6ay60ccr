class Solution {
    public boolean isValid(String s) {
        Stack<Character> parens = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '('){
                parens.push(')');
            }
            else if(c == '['){
                parens.push(']');
            }
            else if(c == '{'){
                parens.push('}');
            }
            else{
                if(parens.size()==0 || parens.pop()!=c){
                    return false;
                }
            }
        }
        return parens.size()==0;
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String token:tokens){
            if(token.equals("+") || token.equals("*") || token.equals("-") || token.equals("/")){
                int op2 = s.pop();
                int op1 = s.pop();
                s.push(eval(token, op1,op2));
            }
            else{
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }

    private int eval(String token, int op1, int op2){
        if(token.equals("+")){
            return op1+op2;
        }
        else if(token.equals("-")){
            return op1-op2;
        }
        else if(token.equals("*")){
            return op1*op2;
        }
        else if(token.equals("/")){
            return op1/op2;
        }
        return 0;
    }
}

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// In java, comparing string should use .equals() not "=="!!!!!!!!!!!!!!!!!!!!!!!!!!

// convert String to int: Integer.parseInt(s)

public class Solution {
    public int evalRPN(String[] tokens) {
        int res=0;
        Stack<Integer> stack=new Stack<Integer>();
        
        for(int i=0;i<tokens.length;i++){
            if(isDigit(tokens[i])) stack.push(Integer.parseInt(tokens[i]));
            else{
                int temp1=stack.pop();
                int temp2=stack.pop();
              
                if(tokens[i].equals("+")) {
                    res=temp1+temp2;
                    stack.push(res);
                }else if (tokens[i].equals("-")){
                    res=temp2-temp1; 
                    stack.push(res);
                }else if(tokens[i].equals("*")){
                    res=temp1*temp2; 
                    stack.push(res);
                }else{
                    res=temp2/temp1; 
                    stack.push(res);
                }
            }
        }
        return stack.pop();
    }
    
    public boolean isDigit(String s){
        return !s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/");
    }
}

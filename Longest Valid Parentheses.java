/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

/*
Some special cases should be considered:
()()  max = 4
(()() max = 4
()(() max = 2

这个题很奇妙,需要重做一遍;
stack里存的是index, 用来跟踪最大length的起始位置, 迭代到i用来跟踪最大length的终止位置;

用一个last来保存可能很长的前面的'(' 的index

*/
public class Solution {
    public int longestValidParentheses(String s) {
        int res=0;
        int last=-1;
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0; i<s.length(); i++){
            if( s.charAt(i)=='(') stack.push(i);
            else{
                if(stack.empty()){
                    last=i;// no matching left
                }else{
                    stack.pop();
                    if(stack.empty()) res=Math.max(res, i-last);
                    else res=Math.max(res, i-stack.peek());
                }
              
            }
        }
        return res;
    }
}

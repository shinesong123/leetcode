/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

/*
brackets must close in correct order.. means: 

(((()))           TRUE
[][][]            TRUE
((([])))          TRUE
((([]{})))        TRUE
([{}])            TRUE
([{[][]}])        TRUE
]}])              FALSE
((((              FALSE       
)()()(            FALSE       

just use one stack, push front parentheses, meet back, pop. 

for HashMap 
----map.containsKey(key)
----map.containsValue(value)
----map.values():return collection


for Stack:
--- empty()
--- peek()
--- pop()
--- push()

*/


public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map=new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        
        Stack<Character> stack=new Stack<Character>();
        
        for(int i=0; i<s.length(); i++){
            char temp=s.charAt(i);
            if(map.containsKey(temp)) stack.push(temp);
            else{
                if(!stack.empty() && map.get(stack.peek())==temp){// should check whether stack is empty 
                    stack.pop();
                }else return false; 
            }
    }
    
    return stack.empty(); // should return this, not true, because may be more front parentheses. 
    }
}

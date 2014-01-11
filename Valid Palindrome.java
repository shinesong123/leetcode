/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

// need to use Character.isLetterOrDigit(s) // Character.isLetter(s)// Character.isDigit(s)

// need to turn to lower case-- Character.toLowerCase(s)

public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null ||s=="") return true;
        
        int i=0;
        int j=s.length()-1;
        while(i<j){
            char x=s.charAt(i);
            char y=s.charAt(j);
            if(!Character.isLetterOrDigit(x)){
                i++; 
                continue;// don't forgot this!!!
            }
            if(!Character.isLetterOrDigit(y)) {
                j--; 
                continue;
            }
            if(Character.toLowerCase(x)!=Character.toLowerCase(y)) return false;
            i++;
            j--;
            
        }
        return true;
        
        
    }
}

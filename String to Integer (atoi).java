/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

Discuss


*/

/*
Possible input: 
1. "123" 
2. "+/-123"
3. "   +/-123   "
4. "   +/-123abc   "
5. "   +/-abc123    "
6. ""
7. "3333333333333333", "-333333333333333" overflow

Steps: 
1. check empty, return 0;
   --- Use str.equals(""), not str=="", all varaible not of primitive type is reference in Java. 
2. check white spaces at the head
3. check "+" or "-"
4. check numeric character
5. check overflow (use long to store result)


Notice: 
1. use str.trim() to remove all leading and trailing white-space in a string
2. notice to use long=0L to store the val and use int result to store the result
3. check whether a string is a number, use >='0' and <='9' is enough
   to convert char '9' to int, just use '9'-'0'
*/



public class Solution {
    public int atoi(String str) {
        if (str.equals("")) return 0;
        
        int cur=0;
        int result=0;
        long val = 0L;
        char sign='+';
        
        str=str.trim();
        
        if (str.charAt(cur)=='+'||str.charAt(cur)=='-') {
            sign=str.charAt(cur);
            cur++;
        }
        
        while (cur<str.length() && str.charAt(cur)>='0' && str.charAt(cur)<='9'){
            val=val*10+(str.charAt(cur)-'0');
            cur++;
        }
        
        if (sign=='-') val=-val;
        
        if (val>Integer.MAX_VALUE) result=Integer.MAX_VALUE;
        else if (val<Integer.MIN_VALUE) result=Integer.MIN_VALUE;
        else result=(int) val;
        
        return result;
    }
}

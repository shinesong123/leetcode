/*
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/

// define negative is not palindrome
// Math.pow will return double; should add (int) in front, will loss precison
// should pay attention to cases : 1000110001-- getDigit will be wrong

public class Solution {
    public boolean isPalindrome(int x) {
       if (x<0) return false;
        int len=0, temp=x;
        while (temp>0) {
        temp/=10;
        len++;
         }
    int pow=(int)Math.pow(10, len-1);
    while (x>0) {
        if (x/pow!=x%10) return false;
        x=(x%pow)/10; 
        pow/=100;
    }
    return true;
    }
}

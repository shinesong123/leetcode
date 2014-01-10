/*
Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
*/

// iterate every character and compare from there O(NM)
// To improve, when the remain length is smaller than n, return null'

// 需要返回的pointer 是从第一次出现开始的地方, 后面所有的字符串

// if(needle=="") should return haystack

// string.substring(i) return a new string start from index i
// 神奇的.substring(i).startsWith(needle) 方法!!!!


public class Solution {
    public String strStr(String haystack, String needle) {
        if(needle.length()==0) return haystack;
        
        int m=haystack.length();
        int n=needle.length();
        
        if(m<n) return null;
        
        int diff=m-n+1;
        for(int i=0; i<diff; i++){
            if(haystack.substring(i).startsWith(needle)) return haystack.substring(i);
        }
        return null;
        
    }
}

/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

// 递归:只是最外层的循环
// 字符串的处理,while(i<n)每次分析上一个,append或+即可

public class Solution {
    public String countAndSay(int n) {
       if(n==1) return "1";
       String result="1";
       // i是从1开始计数的,所以有等号
       for(int i=2;i<=n;i++){
           String temp="";
           for(int j=0;j<result.length();j++){
               char current=result.charAt(j);
               int count=1;
               while(j+1<result.length()&&result.charAt(j+1)==current){
                   count++;
                   j++;
               }
               temp+=""+count+current;//一定要加"",不然当数字相加了
           }
           result=temp;
       }
       return result;
    }
}

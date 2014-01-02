/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

/* Easy Way:   
        int A=Integer.parseInt(a,2);
        int B=Integer.parseInt(b,2);
        int sum=A+B;
        String result=Integer.toBinaryString(sum);
        return result;

*/

// Pad zeros and use carry
//should add 1 for last carry
public class Solution {
    public String addBinary(String a, String b) {
        // pad zeros
       if(a.length()>b.length()){
           int dif1=a.length()-b.length();
           for(int i=0;i<dif1;i++){
               b="0"+b;
           }
       }else{
           int dif2=b.length()-a.length();
           for(int i=0;i<dif2;i++){
               a="0"+a;
           }
       }
       
       // add with carry
       String sum=new String("");
       int carry=0;
       for(int j=a.length()-1;j>=0;j--){
           String temp_a=""+a.charAt(j);
           String temp_b=""+b.charAt(j);
           int temp=Integer.parseInt(temp_a)+Integer.parseInt(temp_b)+carry;
           if(temp>=2){
               carry=1;
               sum=temp-2+""+sum;
           }else{
               carry=0;
               sum=temp+""+sum;
           }
       }
        if(carry==1) sum="1"+sum;
        return sum;
    }
}

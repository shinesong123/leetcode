/*
Given a number represented as an array of digits, plus one to the number.
*/

/* 
不用遍历整个数组,来计算carry+digits[i],找到第一个不为9的数字,就可以返回
原理: 如果为9, 该位置0, 上位加1; 不为9, 该位+1, 返回.
结束条件:整个数组跑完了,还没发现不为9的(即全为9), 就要新建一个数组, 在首端+1;
*/
public class Solution {
    public int[] plusOne(int[] digits) {
       
        for(int i=digits.length-1; i>=0;i--){
            if(digits[i]!=9){
                digits[i]++;
                return digits;
            } else{
                digits[i]=0;
            }
        }
        
        int[] res=new int[digits.length+1];
        res[0]=1;// 后面全为0, 初始化数组的时候就解决了,不需要再copy int[] digits
        return res;
        
    }
}

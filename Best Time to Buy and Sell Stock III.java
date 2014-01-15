/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

//O(n)

/*
    一个问题，用递归的方法去解决的时候，会有许多的子问题被计算很多次。
    动态规划就是将这些把问题从小往大计算，而且记录下子问题计算后的结果!!!!!!!!!!!!!!!!!这样以后需要用到子问题的结论，直接读取结果就好，不用再计算一次。简单的说，就是用空间换时间。

*/

/*
这个问题等价于,找到i点,使profit[0,i]+profit[i,n-1]最大, 蛮力法是O(n*n). 动态规划的作用就是用空间换时间, 让时间变为O(n), 同时需要空间O(n)
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;// should always remember this
        
        int[] dp1=new int[prices.length];
        int min=prices[0];
        dp1[0]=0;
        for(int i=1; i<prices.length;i++){
            if(prices[i]<min) min=prices[i];
            dp1[i]=Math.max(dp1[i-1],prices[i]-min);
        }
        
        int[] dp2=new int[prices.length];
        int max=prices[prices.length-1];
        dp2[prices.length-1]=0;
        for(int i=prices.length-2; i>=0; i--){
            if(prices[i]>max) max=prices[i];
            dp2[i]=Math.max(dp2[i+1],max-prices[i]);
        }
        
        int res=0;
        for(int i=0;i<prices.length;i++){
            res=Math.max(res, dp1[i]+dp2[i]);
        }
        return res;
    }
}

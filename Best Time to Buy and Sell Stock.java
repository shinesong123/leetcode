/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

//Find i and j that maximizes Aj-Ai, where i<j
public class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int max=0;
        int min=Integer.MAX_VALUE;//notice here, should not be 0
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            if(prices[i]-min>profit){
                max=prices[i];
                profit=max-min;
            }
        }
        return profit;
    }
}

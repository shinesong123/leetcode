/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
public class Solution {
    public int threeSumClosest(int[] num, int target) {
    Arrays.sort(num);
    int result=num[0]+num[1]+num[num.length-1];
    for (int i=0; i<num.length;i++) {
       // if (i>0 && num[i]==num[i-1])  continue;
        int j=i+1;
        int k=num.length-1;
        while (j<k) {
            int sum =num[i]+num[j]+num[k];
            // judge first, then move pointers
            if (Math.abs(sum-target) < Math.abs(result-target)) {
                result= sum;
            }
            if (sum==target) {
                return result;
            } else if(sum<target){
                j++;
            } else {
                k--;
            }
        }
    }
    return result;
    }
}



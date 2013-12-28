/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/

//Check Duplicate: use ArrayList.contains 
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
     ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
     Arrays.sort(num);
        for(int i=0;i<num.length;i++) {
            for(int j=i+1; j<num.length;j++) {
                int m=j+1;
                int n=num.length-1;
                while(m<n) {
                    int sum=num[i]+num[j]+num[m]+num[n];
                    if(sum>target)
                        n--;
                    else if(sum<target)
                        m++;
                    else {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[m]);
                        temp.add(num[n]);
                        if(!result.contains(temp))
                            result.add(temp);
                        m++;
                        n--;
                    }
                }
            }
        }
        return result;
    }
}

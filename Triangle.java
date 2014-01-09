/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n=triangle.size();
        if(n<0) return 0;
        int[] sum=new int[n];
        for(int i=0; i<n;i++){
            for(int j=i;j>=0;j--){
                if(i==0 && j==0) sum[j]=triangle.get(0).get(0);
                else {
                    sum[j]=triangle.get(i).get(j)+Math.min((j>0?sum[j-1]:Integer.MAX_VALUE), (j<i?sum[j]:Integer.MAX_VALUE));
                }
            }
        }
       Arrays.sort(sum);
       return sum[0];
    }
}

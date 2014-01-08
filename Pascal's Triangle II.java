/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/

// O(k)--use in place iteration, cover previous line from back (will not influence ; time complexity doesn't change;


public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        Integer[] result=new Integer[rowIndex+1];
        result[0]=1;
        for(int i=1;i<=rowIndex;i++){
            result[i]=1;
            for(int j=i-1; j>0;j--){
                result[j]=result[j]+result[j-1];
            }
            
        }
        
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(int k=0; k<=rowIndex;k++){
            res.add(result[k]);
        }
        return res;
    }
}

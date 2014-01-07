/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

// wirte in array! j=0, add(1); j=i, add(1)
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(numRows<=0) return result;
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> temp=new ArrayList<Integer>();
            for(int j=0; j<=i; j++){
                if(j==0) temp.add(1);
                else if(j<i){
                    int tempNum=result.get(i-1).get(j)+result.get(i-1).get(j-1);
                    temp.add(tempNum);
                } else if(j==i) temp.add(1);
            }
            result.add(temp);
        }
        return result;
    }
}

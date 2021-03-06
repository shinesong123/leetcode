/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);  
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
        res.add(new ArrayList<Integer>());  
        
        int start=0;
        for(int i=0; i<num.length; i++){
            int size=res.size();
            for(int j=start; j<size;j++){
                ArrayList<Integer> temp=new ArrayList<Integer>(res.get(j));
                temp.add(num[i]);
                res.add(temp);
            }
            if(i<num.length-1 && num[i+1]==num[i]){
                start=size;// should use previous size, so need to create one more to store
            }else
                start=0;
        }
        return res;
        
        
    }
}

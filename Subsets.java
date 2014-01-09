/*
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

// for arrayList: add(E e); addAll(Collection c)

// dp: add one more number, will use all before, and double the size
// time: O(2^n), each time it has to double the size of set. 
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(S);
        for(int i=0;i<S.length;i++){
            ArrayList<ArrayList<Integer>> temps=new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> t: res){
                ArrayList<Integer> temp=new ArrayList<Integer>();
                temp.addAll(t);
                temp.add(S[i]);
                temps.add(temp);
            }
            res.addAll(temps);
        }
        return res;
    }
}


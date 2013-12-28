/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

// O(n*n*n) method exists, we should keep it O(n*n)
//Use three pointers, two from beginning, one from tail, no necessary walk three pass

//Arrays.sort() is Dual-Pivot Quicksort, O(nlogn)
//check duplicate: !!


// Time Limit Exceed means time complexity is not good!!!!


public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	if (num.length<3) return result;
	Arrays.sort(num);
	for (int i=0; i<num.length; i++) {
		if (i==0||num[i]>num[i-1]) {
			int j=i+1;
			int k=num.length-1;
			while (j<k) {
				if (num[i]+num[j]+num[k]==0) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(num[i]);
					temp.add(num[j]);
					temp.add(num[k]);
					result.add(temp);
					j=j+1;
					k=k-1;
				    while(j<k&&num[k]==num[k+1])//jump those equals
					k=k-1;
					while(j<k&&num[j]==num[j-1])
					j=j+1;
				} else if(num[i]+num[j]+num[k]<0){
					j=j+1;
				} else {
					k=k-1;
				}
			}
	}
	}
	return result;
    }
}

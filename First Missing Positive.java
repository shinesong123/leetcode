/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/

/*
考虑到constant space, 不是不让你用space, 是用原数组的space

很简单,让几号数字待在几号位子(-1), 其他的0, <0, 或大于length的都给正确的数字让位,管它顺序怎么样,这样跑两遍就可以找到了.

一个很严重的问题是, 可能存在重复的数字, 所以要把0, <0, >length的置0, 当遇到重复时, 如果某数字已在它该在的位置, 把此数也置0, 同时i要--

最后的结束情况,有可能就是1..n各就其位,差就差n+1

不要偷懒不写括号!!!!!!!!!!!!!!!!!!只有一句也给我括起来!!!!!!!!!

这题要重做
*/


public class Solution {
    public int firstMissingPositive(int[] A) {
       int n = A.length;
        for (int i=0; i<n; i++) {
            if (A[i]<=0||A[i] > n) {
                A[i] = 0;
            } else { 
                if(A[i]==i+1) {
                    continue; 
                }else{
                    if(A[i]==A[A[i]-1]) { 
                        A[i]=0;
                    } else{ 
                        int tmp=A[A[i]-1];
                        A[A[i]-1]=A[i];
                        A[i]=tmp;
                        i--; 
                    }
                }
            }
        }
        for (int i=0; i<n; i++) {
            if (A[i]!=i+1) {
                return i+1;
            }
        }
        return n+1;
    }
}

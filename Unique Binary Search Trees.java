/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

/*
count[0]=1
count[1]=1
count[2]=count[0]*count[1]+count[1]*count[0]=2
count[3]=count[0]*count[2]+count[1]*count[1]+count[2]*count[0]=5
count[4]= \...

正常来解, 它是一维dp.

其实这是Catalan number, Cn=(2n!)/((n+1)!n!) 故Cn=2*(2n-1)*Cn-1/(n+1)
*/

public class Solution {
    public int numTrees(int n) {
        //if(n<=1) return 1; 
        int[] count=new int[n+1];
        count[0]=1;
        count[1]=1;
        
        for(int i=2; i<=n; i++){
            for(int j=0; j<i;j++){
                count[i]+=count[j]*count[i-1-j];
            }
            
        }
        
        return count[n];
    }
}

/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/

/*
是要把word1--> word2, 所以插入,删除,替换都在word1上进行.

用dp[i][j]来存储长度为i的word1变为长度为j的word2的步数, 显然, 起始条件是dp[0][j]=j;
dp[i][0]=i;

// 这里是需要记录最小的步数,在每一个位置,都有一个最优的操作让步数最小,这里并不需要记录最优的操作是什么,直接选择最小的步数就可以了
如果word1[i]==word2[j] dp[i][j]=dp[i-1][j-1]
如果word1[i]!=word2[j] dp[i][j]=插入: 1+dp[i][j-1], 如果插入,字符[j]就解决了
                                删除: 1+dp[i-1][j]  如果删除,字符[j]还没有解决;这样做可能是word1比较长,前面比较省步骤
                                替换: 1+dp[i-1][j-1],如果替换,字符[j]就解决了



dp[][]数组一般都比需要多一行一列,作为初始化. 这样就有一个错位,要注意
*/

public class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        
        int[][] dp=new int[m+1][n+1];
        
//初始化第一行第一列, 让[i-1][j-1]的时候不会没有地方指
        for(int i=0; i<=m; i++){
            dp[i][0]=i;
        }
        for(int i=0; i<=n; i++){
            dp[0][i]=i;
        }
        for(int i=1; i<=m; i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else{
                    int temp=Math.min(dp[i][j-1], dp[i-1][j]);
                    dp[i][j]=1+Math.min(temp,dp[i-1][j-1]);
                    
                }
            }
        }
        return dp[m][n];
    }
}


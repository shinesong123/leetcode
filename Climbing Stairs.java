/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

// f(n)=f(n-1)+f(n-2)
// don't use recursion, time exceeded; use math!

public class Solution {
    public int climbStairs(int n) {
     if(n<=0) return 0;
     else if(n==1) return 1;
     else if(n==2) return 2; 
     
    int sum=0;
    int fn1=1;
    int fn2=2;
    
    for(int i=3; i<=n; i++){
       sum= fn1+fn2;
       fn1=fn2;
       fn2=sum;
    }
    return sum;
        
    }
}

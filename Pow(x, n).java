/*
Implement pow(x, n). (Use binary search)
*/

/*
should keep time complexity O(lgn):

the idea is do x^n/2, x^n/4...

1. if n is even,  power(x,n/2)*power(x,n/2)
   if n is odd && n>0, power(x,n/2)*power(x,n/2)*x
               && n<0, power(x,n/2)*power(x,n/2)*(1/x)
2. end condition: n==0, x=1; could also be n==1
3. JAVA负数:-7/2=-3; 21/-5=-4;-21/-8=2; 正常触发
            -21%-8=-5; 21%-5=1; 被除数有多少完整的除数,剩下什么是什么,不求补

*/
public class Solution {
    public double pow(double x, int n) {
       if(x==0) return 0;
       return power(x,n);
    }
    
    private double power(double x, int n){
       if(n==0) return 1;
       if(n==1) return x;
       double left=power(x,n/2);
       if(n%2==0) return left*left;
       else if(n>0) return left*left*x;
       else return left*left/x;
    }
}

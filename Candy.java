/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/

/*
two passes: first pass from left to right-- guarantee right>left; 
            second pass from right to left -- guarantee left>right;
*/

public class Solution {
    public int candy(int[] ratings) {
        int[] candy=new int[ratings.length];
       // if(ratings.length==1) return 1;
        
        candy[0]=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candy[i]=candy[i-1]+1;
            }else{
                candy[i]=1;
            }
        }
        
        for (int i=ratings.length-1; i>0; i--){
            if((ratings[i-1]>ratings[i]) && (candy[i-1]<=candy[i])){
                candy[i-1]=candy[i]+1; //不能写成++啊! 瞎搞
            }
        }
        
        int sum=0;
        for(int i=0;i<candy.length;i++){
            sum+=candy[i];
        }
        return sum;
    }
}

/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.
*/

/*
暴力法: O(n*n)

需要:O(n) 只好用空间换时间

算矩形面积需要长和高,高一定是n当中的一个, 长可以通过矩形本身的高度向两边延伸=左宽+右宽

对每一个高,它能组成的最大面积是从它左边第一个比它小到右边第一个比它小的这个长

栈中存放下标, 栈里面存的一直是递增数列;之所以存下标而不是值, 就是为了回溯.

当stack是空的时候或者接下来的高度大于stack最顶端的高度，则把height的index push到stack里面去， 如果遇到height小于stack顶端的index的高度，则pop stack 一次，更新面积，持续pop和更新计算面积，一直到新的顶端的高度小于这个height。(这里计算宽用下标来表示很巧妙)

如果最后的stack，不为空的话， 还要一边pop，一边计算面积，来看看是不是大于最大值。

这题要重做, 自己用test case:[3,6,5,7,4,8,1,0], [5,4,1,2], [1,2,5,6]跑一遍

*/
public class Solution {
    public int largestRectangleArea(int[] height) {
        int area = 0;  
        Stack<Integer> stk = new Stack<Integer>();  
        
        for(int i=0; i<height.length; i++){
            if(stk.empty()||height[i]>height[stk.peek()]) stk.push(i);
            else{
                int h=stk.pop();
                int w=stk.empty()?i:i-stk.peek()-1;// 这一句太重要太重要, 它确定了对一个高来说, 它能延伸的起始点和终止点. 递增序列, 一个高的起始点是stk.peek(), 中间可能有比它高的被删掉了,但栈里一直保留这比它小的点的index. 终止点是它自己, 因为它遇到了比它小的了. 
                area=Math.max(area, w*height[h]);
                i--; 
            }
        }
        
        while(!stk.empty()){
            int h=stk.pop();
            int w=stk.empty()?height.length:height.length-stk.peek()-1;
            area=Math.max(area, w*height[h]);
        }
         return area;  
    }
}

/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

// O(n)
public class Solution {
    public int maxArea(int[] height) {
        int n1=0;
        int n2=height.length-1;
        int area=0;
        while(n1<n2){
            int newarea=(n2-n1)*Math.min(height[n1],height[n2]);
            if(newarea>area) area=newarea;
            if(height[n2]>height[n1]) n1++;
            else n2--;
        }
        return area;
    }
}

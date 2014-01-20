/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res=new ArrayList<Interval>();
        
        for(Interval i:intervals){
            if(i.start>newInterval.end){
                res.add(newInterval);
                newInterval=i;// 这里非常重要, 虽然已经排好序了, 但其实还是跟merger interval一样需要merge的过程, 因为1号跟new的结合可能跟后面的重叠, 所以要不断更新newInterval, 不断跟后面每一个merge. 
            }else if(i.end<newInterval.start){
                res.add(i);
            }else if(i.end>=newInterval.start|| i.start<=newInterval.end){
                int s=Math.min(i.start, newInterval.start);
                int e=Math.max(i.end, newInterval.end);
                newInterval=new Interval(s, e);
            }
        }
        res.add(newInterval);// 直到最后一个, 它merge完以后, 还没有来得及被加入,这里补上
        return res;
        
    }
}


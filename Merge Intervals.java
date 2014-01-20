/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
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
 
/*
Java comparator可以对类进行排序

其他的都很简单, 如果2号start在一号的start和end中间, 就可以合并1, 2, 走一遍就好了, 对每一个都把它后面所有的走一遍, 剩下的从1吞并完的下一个开始走, O(n). 

思想就是对每一个Interval, 看它能不能被前一个吞并, 可以就并,不行就自立门户.

*/

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res=new ArrayList<Interval>();
        Collections.sort(intervals, new IntervalComparator());// 注意这个用法!!!!
        for(int i=0; i<intervals.size(); i++){
            Interval cur=intervals.get(i);
            while(i<intervals.size()-1 && cur.end>=intervals.get(i+1).start){// 注意这个条件一定不能掉, get(i+1)可能不存在
                cur.end=Math.max(cur.end, intervals.get(i+1).end);
                i++;
            }
            res.add(cur);// 每一次出来了添加cur
        }
        return res;
    }
    
    public class IntervalComparator implements Comparator<Interval>{
    public int compare(Interval v1, Interval v2){
        return v1.start-v2.start;
    }
}
    
}


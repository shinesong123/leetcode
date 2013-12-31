/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 //固定一个点,来计算斜率! O(n*nlgn); 用hashmap来存<斜率,count>
 
 
 //斜率有可能不存在
 //有可能有完全重复的点
 //double精度,无法完全判定相等,需要手动乘0.0, 1.0
 
public class Solution {
    public int maxPoints(Point[] points) {
          Map<Double, Integer> map = new HashMap<Double, Integer>();
          int result=0;
          if(points.length==1) return 1;
          for(int i=0; i<points.length;i++){
              int dup=1;// should be 1, because no slope never store in map. 
              int invalid=0;
              for (int j=i+1; j<points.length;j++){
                    //situation 1
                  if(points[j].x==points[i].x){
                      if(points[j].y==points[i].y){
                          dup++;
                      }else{
                          invalid++;
                      }
                        continue;//跳过situation 2
                  }
                  //situation 2
                  double k=points[j].y==points[i].y? 0.0:1.0*(points[j].y-points[i].y)/(points[j].x-points[i].x);
                  if(!map.containsKey(k)){
                      map.put(k,1);
                  }else{
                      int count=map.get(k);
                      map.put(k,count+1);
                  }
              }
              
              
                  // map.values return Collection, Collecton has iterator
                  for(Integer t:map.values()){
                      if(t+dup>result){
                          result=t.intValue()+dup;
                      }
                  }
                  if(result<=invalid+dup){
                      result=invalid+dup;
                  }
                  map.clear();
          }
          
          return result;
        }
    }
    
   

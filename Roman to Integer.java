/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

/* String---length()
   Array----length;
   ArrayList-size();
   
   因为String和ArrayList是包装的类,()是方法; Arrays才是包装的类

*/

// s.substring(i,i+2) 包前不包后

/* 
HashMap vs HashTable:
1. HashMap几乎等价于HashTable
2. HashMap非synchronized,线程不安全; 多线程可共享一个HashTable;
   但可以通过Collections.synchronizeMap(hashMap) 来让HashMap同步
   单线程环境下,HashMap快
3. HashMap接受null为(key,value), HashTable不行
*/

// should not forgot to i++; you have use two characters!

public class Solution {
    public int romanToInt(String s) {
         HashMap<String, Integer> map=new HashMap<String, Integer>();
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);
        
        String[] bases={"M", "CM", "D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int res=0;
        
        for(int i=0; i<s.length();i++){
            if(i<s.length()-1 && map.containsKey(s.substring(i,i+2))){
                res+=map.get(s.substring(i,i+2));
                i++;
            } 
            else res+=map.get(s.substring(i,i+1));
            
        }
        return res;
    }
}

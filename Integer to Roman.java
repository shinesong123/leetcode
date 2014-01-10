/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/
// only tricy point is 4 is "IV", 9 is "IX"
// use a hashmap to store match Integer & Roman
public class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, String> map=new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        
        int[] bases={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String res=new String();
        for(int i=0; i<bases.length;i++){
            while(num>=bases[i]){
                res+=map.get(bases[i]);
                num=num-bases[i];
            }
        }
        return res;
        
    }
}

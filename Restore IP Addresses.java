/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

/*
首先我们要明确传统IP 地址的规律是分4个Part，每个Part是从0-255的数字.

0-255的数字，转换成字符，即每个Part 可能由一个字符组成，二个字符组成，或者是三个字符组成。那这又成为组合问题了，dfs便呼之欲出

所以我们写一个For循环每一层从1个字符开始取一直到3个字符，再加一个isValid的函数来验证取的字符是否是合法数字，如果是合法的数字，我们再进行下一层递归，否则跳过。

1. 35的话不能写成035, 所以0开头无效, 除0本身以外.
2. 取字符串的时候，注意位数不够的问题，不仅<4, 而且<s.length()
3. 别忘了IP 地址里面的 "."
*/

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s.length()<4||s.length()>12) return res;  
        dfs(res, s, "", 1);
        return res;
    }
    
    private void dfs(ArrayList<String> res, String s, String tmp, int count){
        if(count==4 && isValid(s)){
            res.add(tmp+s);  
            return;
        }
        
        for(int i=1; i<4 && i<s.length(); i++){//分别取1位, 2位, 3位
            String sub=s.substring(0,i);
            if(isValid(sub)){
                dfs(res, s.substring(i), tmp+sub+".", count+1);// 不要轻易在计入循环变量里写count++, 是+1就写+1
            }
        }
    }
    
    private boolean isValid(String s){
        if(s.charAt(0)=='0'&& !s.equals("0")) return false;
        int temp=Integer.parseInt(s);
        return temp>=0 && temp<256;
    }
}

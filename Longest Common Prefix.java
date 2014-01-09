/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

// Notice: array[0].length()!!!!!!!!!

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        
        StringBuffer res=new StringBuffer();
        for(int i=0;i<strs[0].length();i++){
            char temp=strs[0].charAt(i);
            boolean flag=false;
            for(int j=0;j<strs.length;j++){
                if(strs[j].length()<=i ||strs[j].charAt(i)!=temp){
                    flag=true;
                    break;
            }
        }
        if(!flag) res.append(temp);
        else break;// 必须加这一句,否则结束不了循环
        }
        return res.toString();
    }
}

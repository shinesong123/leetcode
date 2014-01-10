/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/

// use hashmap to collect groups: if has key, add value; if no key, create new key and add value; for iterator map, add to result;

// to get hashmap values----map.values()---has iterator
// ArrayList add collection, not simple elements---addAll()!!!!!!!!!!!!!!!!!!!!!!!!

// sort, check equal

// to sort string, have to change it to char array, sort arrays, then change back
// char [] to string ---Arrays.toString(s);


public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res=new ArrayList<String>();
        
        HashMap<String, ArrayList<String>> map=new HashMap<String,ArrayList<String>>();
        for(int i=0;i<strs.length;i++){
            String temp=isAnagrams(strs[i]);
            if(map.containsKey(temp)) map.get(temp).add(strs[i]);
            else{
                ArrayList<String> x=new ArrayList<String>();
                x.add(strs[i]);
                map.put(temp, x);
            }
        }
        for(ArrayList<String> y:map.values()){
            if(y.size()>1) res.addAll(y);// don't forgot, you need those >=2
        }
        return res;
        
    }
    
    private String isAnagrams(String s){
        char[] t=s.toCharArray();
        Arrays.sort(t);
        return Arrays.toString(t);
    }
}

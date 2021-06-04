// Time Complexity :O(nlogk)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach


import java.util.Arrays;
import java.util.HashSet;

public class longestWord {
    
    public String longestWord(String[] words) {
        if(words==null || words.length==0)
            return "";
        
        HashSet<String> sSet=new HashSet<String>();
        String result="";
        Arrays.sort(words);
        
        for(String s:words){
            if(s.length()==1 || sSet.contains(s.substring(0,s.length()-1))){
                if(result.length()<s.length()){
                    System.out.println(" values "+s);
                    result=s;
                }
                
                sSet.add(s);
            }
        }
        
        return result;
        
    }
}

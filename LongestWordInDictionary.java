// Time Complexity : O(n X m) number of words X length of the  largest word . 
// Space Complexity : O(n X m) number of words X length of the  largest word . extra space used per tree. 
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the code uses a trie and build the trie, then try to iterate over list of words and check if every
// word is a work present and check the largest in trie. The word must have a consecutive prefix of words. 
//need to be added to tree.
//Success
//Details 
//Runtime:Runtime: 43 ms, faster than 10.35% of Java online submissions for Longest Word in Dictionary.
//Memory Usage: 42.8 MB, less than 6.25% of Java online submissions for Longest Word in Dictionary...
class Solution {
    private Trie dict=null;
    public String longestWord(String[] words) {
        dict=new Trie();
        //create dictionary
        for (String word:words){
            dict.insert(word);
        }
        
        //find largest;
        int max=0;
        String maxWord=""; 
        
        for (String word:words){ //O(n) number of words.
          StringBuilder sb= new StringBuilder();  
          for (int i=0;i<word.length();i++){ //O(m) max length of word.
             sb.append(word.charAt(i)); 
             if (!dict.isWord(sb.toString())){
                 sb.deleteCharAt(sb.length()-1);
                 break;
             }
          }
          if (sb.length()>=max){ 
            if (max==0 || sb.length()>max){
              max=sb.length();
              maxWord=sb.toString();
            }else{
               if (maxWord.compareTo(sb.toString())>0){ 
                 maxWord=sb.toString();
               }  
            }
          }
        
        }
        return maxWord;
        
    }
    
    class Trie{
        private Trie[] trie= new Trie[26];
        private boolean isWord;
        private String word;
        public Trie(){
            
        }
        public void insert(String w){
           Trie cur=this;
           for (int i=0;i<w.length();i++){
               char c=w.charAt(i);
               if (cur.trie[c-'a']==null){
                   cur.trie[c-'a']= new Trie();   
               }
               cur= cur.trie[c-'a'];
           }
           cur.isWord=true;
           cur.word=w; 
        }
        
        public boolean isWord(String w){
            Trie cur=this;
            for (int i=0;i<w.length();i++){
                char c=w.charAt(i);
                if (cur.trie[c-'a']==null)
                    return false;
                cur=cur.trie[c-'a'];
            }
            return cur.isWord;
        }
    }
    
    
}
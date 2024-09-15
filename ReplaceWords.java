// Time Complexity : Time Complexity: O(N) where N is the length of the sentence. Every query of a word is in linear time.
// Space Complexity :  O(N), the size of our trie.
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the code code uses a trie, and uses the logic used to search a word in a trie. but instead of return boolean for isWord, we return the word itself.  
//need to be added to tree.
//Success
//Details 
//Runtime:Runtime:Runtime: 5 ms, faster than 100.00% of Java online submissions for Replace Words.
//Memory Usage: 50.9 MB, less than 91.67% of Java online submissions for Replace Words.
class Solution {
    class Trie{
        boolean isWord;
        String word;
        Trie[] children;
        public Trie(){
          isWord=false;
          word="";
          children=new Trie[26];  
        }
        
        public void insert(String w){
            Trie cur=this;
            for (int i=0;i<w.length();i++){
                char c= w.charAt(i);
                if (cur.children[c-'a']==null)
                    cur.children[c-'a']=new Trie();
                cur=cur.children[c-'a'];
            }
            cur.isWord=true;
            cur.word=w;
        }
        
        
    }
    
    Trie root;
    
    public String replaceWords(List<String> dict, String sentence) {
          //base case
          root=new Trie(); 
          //create dictionary
          for (String w:dict){
              root.insert(w);
          } 
          //split
          String[] words=sentence.split(" ");
        
        //search for root;
        String srtVal="";
        StringBuilder sb= new StringBuilder();
        for (String w:words){
           sb.append(newString(w)).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    
    
    
    private String newString(String word){
       
        Trie cur=root;
        for (int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if (cur.isWord)
                return cur.word;
            if (cur.children[c-'a']==null){
                break;
            }
            cur=cur.children[c-'a'];
        }
        return word;
    }
}
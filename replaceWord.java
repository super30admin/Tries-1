import java.util.List;

// Time Complexity :O(n*L)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

public class replaceWord {

     
    class TrieNode{
        TrieNode [] children;
        boolean isEnd;
        
        public TrieNode(){
            this.children=new TrieNode[26];
        }
    }
    
    TrieNode root;
    
     /** Inserts a word into the trie. */
    public void insert(String word) {
         TrieNode curr=root;
        
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] ==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root=new TrieNode();
        
        for(String word:dictionary)
            insert(word);
        
        
        String [] splitArr=sentence.split("\\s+");
        StringBuilder result=new StringBuilder();
        StringBuilder replacement;
        TrieNode curr;
        
        for(int k=0;k<splitArr.length;k++){
            String word=splitArr[k];
            replacement=new StringBuilder();           
            if(k>0){
                result.append(" ");
            }
            
            curr=root;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                 if(curr.children[c-'a'] ==null || curr.isEnd ) 
                     break;
                 curr=curr.children[c-'a'];
                replacement.append(c);
            }
            
            if(curr.isEnd)
                result.append(replacement.toString());
            else
                result.append(word);
            
            
            }
        return result.toString();
            
        }
    
}

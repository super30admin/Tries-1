//Time Complexity: O(n) n => no of words in sentence
//Space Complexity: O(n) size of trie
class Solution {
    
     class TrieNode{
        String word;
        //each child node is an array of 26 characters
        TrieNode[] children;
        
        public TrieNode()
        {
            children = new TrieNode[26];
        }
         
     }
         
        TrieNode root = new TrieNode();
         
       public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            //if we reach till the end insert a new node
            if(curr.children[c-'a']== null)
                curr.children[c-'a'] = new TrieNode();
            //otherwise iterate through Trie until we reach last node
            curr = curr.children[c-'a'];
            }
        
            //after processing the whole string
            curr.word = word;  
        }
     
    
    
    public String replaceWords(List<String> dict, String sentence) {
        
        //initially insert the dict into Trie
        for(int i=0; i<dict.size(); i++)
        {
            String s = dict.get(i);
            insert(s);
        }
        
        //result string
        StringBuilder sb = new StringBuilder();
        
        for(String word : sentence.split("\\s+"))
        {
            TrieNode curr = root;
            if(sb.length() > 0)
                sb.append(" ");
            
            for(int i=0; i<word.length(); i++)
            {
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null || curr.word != null) break;
                curr = curr.children[c-'a'];
            }
            
            String replacement = curr.word;
            if(replacement == null)
                sb.append(word);
            else
                sb.append(replacement);
        }
        
        return sb.toString();
        
        
    }
}

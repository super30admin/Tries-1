Time: O(m*n)
Space: O(m*n)
 
 
 
 
 class Solution {
    
    class TrieNode{
        
         boolean isEnd;
        TrieNode[] children;
        
        TrieNode(){
            children = new TrieNode[26];
        }
        
    }
    
     TrieNode root;

    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String word: dictionary){
            insert(word);
        }
        
        String[] splitArr = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        TrieNode curr;
        StringBuilder replacement;
        for(int i=0;i<splitArr.length;i++){
            if(i>0){
                result.append(" ");
            }
            curr= root;
            replacement = new StringBuilder();
            String s = splitArr[i];
            
            for(int k=0;k<s.length();k++){
                char c = s.charAt(k);
                if(curr.children[c-'a'] ==null || curr.isEnd) break;
                replacement.append(c);
                curr=curr.children[c-'a'];
            }
            
            if(curr.isEnd){
                result.append(replacement);
            } else{
                result.append(s);
            }
        }
        
        
        return result.toString();
    }
}
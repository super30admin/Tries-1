import java.util.List;

// Time Complexity : O(Nk + L)
// Space Complexity : O(Nk + L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach


class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        
        //letter does not exist so create a node
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            //next current is the next letter's TrieNode
            curr = curr.children[c - 'a'];
        }
        
        curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || dictionary.size() == 0)
            return sentence;
        
        root = new TrieNode();
        for(String word: dictionary){
            insert(word);
        }
        
        String[] splitArr = sentence.split("\\s");
        StringBuilder result = new StringBuilder();
        
        
        for(int j = 0; j < splitArr.length; j++){
            if(j > 0) result.append(' ');
            TrieNode curr = root;
            String word = splitArr[j];
            StringBuilder replace = new StringBuilder();
            
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null || curr.isEnd)
                    break;
                
                curr = curr.children[c - 'a'];
                replace.append(c);
            }
            //reached end of root
            if(curr.isEnd){
                result.append(replace.toString());
            }
            //didnt find prefix
            else{
                result.append(word);
            }
        }
        
        return result.toString();
    }
}


// Time Complexity : Add : O(m*k + n*l) m-no.of words in dic ; k - length of sentence; nl-traversal in dic
// Space Complexity : O(n*l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public void insert(String word){
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null)
                curr.children[ch-'a'] = new TrieNode();
            
            curr = curr.children[ch-'a'];
        }
        
        curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String dic: dictionary){
            insert(dic);
        }
        
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<words.length; i++){
            if(i!=0)
                result.append(" ");
            String currentWord = words[i];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for(int j=0; j<currentWord.length(); j++){
                char c = currentWord.charAt(j);
                if(curr.children[c-'a'] == null || curr.isEnd)
                    break;
                
                curr = curr.children[c-'a'];
                replacement.append(c);
            }
            
            if(curr.isEnd)
                result.append(replacement);
            else
                result.append(currentWord);
        }
        return result.toString();
    }
}

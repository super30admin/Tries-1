// Time Complexity : O(n * k) + O(m * l) 
	where n is no of words in dictionary and k is avg length
		m is no of words in sentence and l is avg length 
// Space Complexity : O(n * k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We build a Trie and put all words of dictionary into Trie.
 * Now for each word of sentence, we will search in Trie, if there exists a prefix word to replace.
 * If yes, we add prefix word to result else, we add word from sentence in our result
 * After each word of sentence, we will add a space in result except for last word.
 * After we have processed all words from sentence, we return result string
*/


class Solution {
    class TrieNode{
        TrieNode[] child;
        boolean isPresent;
        
        public TrieNode(){
            child = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    private void insert(String word){
        TrieNode curr = root;
        
        for(int i = 0; i < word.length();i++){
            char ch = word.charAt(i);
            if(curr.child[ch - 'a'] == null){
                curr.child[ch - 'a'] = new TrieNode();
            }
            curr = curr.child[ch - 'a'];
        }
        
        curr.isPresent = true;
    }
    
    private String searchPrefix(String word){
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < word.length();i++){
            char ch = word.charAt(i);
            
            if(curr.child[ch - 'a'] == null){
                return word;
            }
            
            if(curr.child[ch - 'a'].isPresent == true){
                sb.append(ch);
                return sb.toString();
            }
            
            sb.append(ch);
            curr = curr.child[ch - 'a'];
        }
        
        return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || dictionary.size() == 0)return sentence;
        
        root = new TrieNode();
        StringBuilder ans = new StringBuilder();
        String[] words = sentence.split(" ");
        
        for(String s : dictionary){
            insert(s);
        }
        
        for(int i = 0; i < words.length; i++){
            String s = words[i];
            String replace = searchPrefix(s);
            ans.append(replace);
            if(i != words.length - 1){
                ans.append(" ");
            }
        }
        
        return ans.toString();
    }
}
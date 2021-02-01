// Time Complexity : O(n), n = number of characters in input strings
// Space Complexity : O(n), n = number of characters in input strings
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Initialize a Trie and insert all the characters from the input strings and the corresponsing word formed in the Trie. Using BFS and parsing the 26 children from the end, keep iterating till a word is found in each TrieNode. 

public class LongestWordInDictionary {
    class TrieNode{
        TrieNode[] children;
        String word;
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public void insert(String word){

        TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];         
        }
        curr.word = word;
    }
    
    public String longestWord(String[] words) {
        if(words == null) return "";
        
        root = new TrieNode();
        
        for(String word : words){
            insert(word);
        }
        
        TrieNode curr = root;
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25; i >= 0; i--){
                if(curr.children[i] != null && curr.children[i].word != null){
                    q.add(curr.children[i]);
                }
            }
        }
        
        return curr.word;
    }
}

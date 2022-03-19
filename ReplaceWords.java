// Time Complexity : O(N) N is the length of sentence. we are traversing each char at max once only
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use Trie to compute this. store all the dictionary words in trie first
//Now for each word in the sentence look for its prefix in the trie
//If its there then break at that time and append the answer string
//Else just add the original. 
class Solution {
    public String replaceWords(List<String> dictionary, String sentence){
    TrieNode root = new TrieNode();
    
    StringBuilder ans = new StringBuilder();
    for(String word: dictionary){
        insert(word, root);
    }
    
    for(String word: sentence.split("\\s+")){
        if (ans.length() > 0)
                ans.append(" ");
        TrieNode node = root;
        StringBuilder curWord = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c-'a'] == null || node.end)
                break;
            curWord.append(c);
            node = node.children[c - 'a'];  
        }
        ans.append(node.end ? curWord : word);
    }
        
        
    return ans.toString();
}
    public void insert(String word, TrieNode root) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.end = true;
    }
}
class TrieNode{
    TrieNode[] children;
    boolean end;
    public TrieNode(){
        children = new TrieNode[26];
    }
}

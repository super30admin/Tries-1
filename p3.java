// Time Complexity :O(ml + nl) where m is the number of words in dictionary and n is the number of words in sentence and l is the average length of those words
// Space Complexity :O(ml + nl)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    //Creating class for trienode consisting of isEnd and children
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
        }
    }
    TrieNode root;
   //To insert a word, iterate over the characters of the word while checking if it exists in the trie or not. If it does not exixt, iniatilze and insert it in trie. In the end mark last node's isEnd to true
    public void insert(String word){
        TrieNode curr = this.root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
                
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
   ///Iterate over the word and if you find null in the trie, return the word. if you find isEnd to be true in the trie, return the word till that node. In the end return the word
    public String search(String word){
        TrieNode curr = this.root;
        StringBuilder sbb = new StringBuilder();
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            
            
            if(curr.isEnd){
                return sbb.toString();
            }
            sbb.append(c);
            if(curr.children[c-'a'] == null){
                
                return word;
                
            }
            
            curr = curr.children[c-'a'];
        }
        return word;
        
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        //Put words of dictionary in trie
        for(String word: dictionary){
            insert(word);
            
        }
        String[] strArray = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
//Check for replacement words 
        for(int i=0; i<strArray.length; i++){
            
            String word = strArray[i];
            if(i!=0) sb.append(" ");
            sb.append(search(word));
        }

        return sb.toString();
    }
}
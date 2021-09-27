// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// create a trienode and check if the vlaue isEnd true and lenght is highest
// also check the difference between the index position and give the least index first preference
// Your code here along with comments explaining your approach
class Solution {
    class TrieNode{
        TrieNode [] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    void insert(String word){
        TrieNode curr = root;
        for( int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c- 'a'] == null){
                curr.children[c- 'a'] = new TrieNode();
            }
            curr = curr.children[c- 'a'];
        }
        curr.isEnd = true;
    }
    public String longestWord(String[] words) {
        root = new TrieNode();
        // insert the words
        for(String word : words){
            insert(word);
        }
        int length = 0;
        String result = "";
        for(String word : words){
            TrieNode curr = root;
            boolean isNotWord = true;
            for( int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if( curr.children[c-'a'] == null || curr.children[c-'a'].isEnd == false){
                    isNotWord = false;
                };
                curr = curr.children[c-'a'];
            }
            if( isNotWord && length < word.length()){
                length = word.length();
                result = word;
            }
            else if( isNotWord && length == word.length() ){
                for( int i = 0; i < word.length() ; i++){
                    if( (word.charAt(i) -'a') == (result.charAt(i) -'a') ){
                        continue;
                    }else if ( (word.charAt(i) -'a') < (result.charAt(i) -'a') ){
                        result = word;
                        break;
                    }else{
                        break;
                    }
                }
            }
        }
        return result;
    }
}
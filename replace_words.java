// Time Complexity : O(mp + np), where m is the number of words in the dictionary and p is the length of each word
                    //and n is the number of words in the sentence and p is the length of each word
// Space Complexity : O(mp), where m is the number of words in the dictionary and p is the length of each word
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Correct me on the time and space complexity

//Three liner approach of your code in plain english
//1. Create a Trie of fot all the words in the dictionary
//2. search if a word in the sentence has a prefix in the Trie, if yes replace the word with prefix, else keep
        //the word as it
//3. add space inbetween all the words expect 1st, and return the newly formed string wirh replaced words

// Your code here along with comments explaining your approach

class Solution {
    
    //TrieNode class
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        
        public TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
        }
    }
    //reference that holds the Trie
    TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        StringBuilder result = new StringBuilder();
        //create a Trie for the dictionary
        for(String roots: dictionary){
            insert(roots);
        }
        //convert the sentence in array of Strings
        String[] words = sentence.split("\\s+");
        TrieNode curr;
        //iterate over each word in the sentence
        for(int i=0; i<words.length; i++){
            //add space in between all the words expect 1st
            if(i > 0){
                result.append(" ");
            }
            String s = words[i];
            curr = root;
            StringBuilder temp = new StringBuilder();
            //Iterate over all the characters of the word
            for(int j=0; j<s.length(); j++){
                char c = s.charAt(j);
                //check if this word has prefix in the Trie, if yes replace the current word with the prefix, if not keeo the same word
                if(curr.children[c-'a'] == null || curr.isEnd == true) break;
                temp.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd == true){
                result.append(temp);
            }
            else{
                result.append(s);
            }
        }
        return result.toString();
    }
    
    //create a Trie for containing all the words in the dictionary
    private void insert(String word){
        TrieNode curr = root;
        
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
}
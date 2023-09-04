// Time Complexity = O(m*n), n is the number of words and m is the length of the word
// Space Complexity = O(m*n), n is the number of words and m is the length of the word
// Did this code successfully run on Leetcode : yes

class Solution {
    //  find the longest word that can be built one character at a time
    public String longestWord(String[] words) {
        Arrays.sort(words); 
        String resultWord = ""; // the final result
        TrieNode root = new TrieNode('-'); 
        root.isEndOfValidWord = true; // root = valid node initially
        
        for(String word : words){
            if(isValidInsert(root, word)){
                if(word.length() > resultWord.length()){
                    resultWord = word;
                }
            }
        }
        return resultWord;
    }

    // Insert a word in the trie and check if the word is valid
    public boolean isValidInsert(TrieNode root, String word) {
        TrieNode currentNode = root; 
        TrieNode previousNode = root; 
        int newNodesCreated = 0;

        for(int i = 0; i < word.length(); i++){
            if(currentNode.children[word.charAt(i) - 'a'] != null){
                previousNode = currentNode;
                currentNode = currentNode.children[word.charAt(i) - 'a'];
            } else {
                newNodesCreated++;
                previousNode = currentNode;
                currentNode.children[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
                currentNode = currentNode.children[word.charAt(i) - 'a'];
            }
        }
        currentNode.isEndOfWord = true; 

        if(newNodesCreated == 1 && previousNode.isEndOfValidWord) {
            currentNode.isEndOfValidWord = true;
            return true;
        }
        return false;
    }
}

class TrieNode {
    char value; // character value of the trie node
    TrieNode[] children; // array to hold child nodes
    boolean isEndOfWord; // marker for end of word
    boolean isEndOfValidWord; // marker for valid words based on the problem's constraints

    TrieNode(char value){
        this.value = value;
        children = new TrieNode[26];
        isEndOfWord = false;
        isEndOfValidWord = false;
    }
}

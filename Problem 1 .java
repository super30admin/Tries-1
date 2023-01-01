// Time Complexity : O(l) , where l is the length of the word
// Space Complexity : O(words) , where words are the number of words inserted
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach


class Trie {
    class TrieNode{
        private TrieNode[] children;
        private Character val;
        private boolean isWord;

        TrieNode(Character newVal){
            val = newVal;
            isWord=false;
            children = new TrieNode[26];
        }
        TrieNode(){
            isWord=false;
            children = new TrieNode[26];
        }
    }
    TrieNode root; // root iteself will not have any character associated with it
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode head = root;
        //iterate over array
        for(int i=0;i<word.length();i++){
            char current = word.charAt(i);
            //check if the head children have it

            if(head.children[current - 'a'] == null){
                // start putting chars from here
                head.children[current - 'a'] = new TrieNode(current); //create node with the char in it
            }
             head = head.children[current - 'a']; // move head to the next node
        }
        head.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode head = root;
        //iterate over each char in word
        for(int i=0;i<word.length();i++){
            char current = word.charAt(i);
            // check if head children as it
            if(head.children[current - 'a'] == null){ // if there is no node inserted at that index, that means the char is not there
                return false;
            }
             head = head.children[current - 'a'];
        }
        //At the end , we also need to check if the given string in the trie was inserted before
        return head.isWord;    
    }
    
    public boolean startsWith(String prefix) {
        TrieNode head = root;
        //iterate over each char in word
        for(int i=0;i<prefix.length();i++){
            char current = prefix.charAt(i);
            // check if head children as it
            if(head.children[current - 'a'] == null){// if there is no node inserted at that index, that means the char is not there
                return false;
            }
             head = head.children[current - 'a'];
        }
        // If we are able to traverse without any problem , then it means the prefix exists
        return true;  
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
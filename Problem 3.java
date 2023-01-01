// Time Complexity : O(w * (l+P)) where w is the number of words in the sentence, l is the length of the longest word, and p is the length of prefix
// Space Complexity : O(s) , where s is the length of the replaced sentence
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        Trie root = new Trie();

        // string each root in the dictionary will be put inside the Trie

        for(String str : dictionary){ // O (d)
            root.insert(str); // O(p)
        }
        //we will split the string based on space 
        String[] arr =sentence.split(" ");
        StringBuilder result = new StringBuilder();
        //iterate over each split string
        for(int i=0;i<arr.length;i++){ // O(w)
            String newStr = root.search(arr[i]); // O(l)
            if(newStr==null){ // this means no prefix exists
            // O(l)
            result.append(arr[i]);
            }
            else{
                
                 result.append(newStr); // placing the prefix //O(p)
            }
            result.append(" "); // adding space after appending each string
        }

       return result.toString().trim(); // O(s)
    }
}

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
    
    public String search(String word) {
        TrieNode head = root;
        StringBuilder sb = new StringBuilder();
        //iterate over each char in word
        for(int i=0;i<word.length();i++){
            char current = word.charAt(i);
            // if there is no node inserted at that index, that means the char is not there
            if(head.children[current - 'a'] == null || head.isWord){  // Also if we already have found a shorter prefix, then return as questions states to use the shorter prefix
                break;
            }
             head = head.children[current - 'a'];
             sb.append(head.val);
        }
        //At the end , we also need to check if the given string in the trie was inserted before
        if(head.isWord){
        return sb.toString();    
        }
        return null;
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

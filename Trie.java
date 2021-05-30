//Time Complexity: O(l) for insert(), search() and startsWith() where l= length of input word
//Space Complexity: O(l)
//Did it run on leetcode successfully: yes
// Did you face any problem: No
class Trie {
    //TrieNode class to store characters
    class TrieNode{
        //marks if it is a word
        boolean isEnd;
        //charcters following current characters
        TrieNode[] children;
        //constructor to create TrieNode
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    //variable to store root of TrieNode
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        //initializing root
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        //getting root node
        TrieNode curr = root;
        //looping through all characters in word
        for(int i=0; i<word.length(); i++){
            //get current character
            char c = word.charAt(i);
            //if current character not present
            if(curr.children[c-'a']==null){
                //create new TrieNode
                curr.children[c-'a'] = new TrieNode();
            }
            //move current to next or child TrieNode
            curr = curr.children[c-'a'];
        }
        //mark that it is a word
        curr.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        //getting root node
        TrieNode curr = root;
        //looping through all characters in word
        for(int i=0; i<word.length(); i++){
            //get current character
            char c = word.charAt(i);
            //if current character not present
            if(curr.children[c-'a']==null){
                return false;
            }
            //move current to next or child TrieNode
            curr = curr.children[c-'a'];
        }
        //return word marker
        return curr.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        //getting root node
        TrieNode curr = root;
        //looping through all characters in word
        for(int i=0; i<prefix.length(); i++){
            //get current character
            char c = prefix.charAt(i);
            //if current character not present
            if(curr.children[c-'a']==null){
                return false;
            }
            //move current to next or child TrieNode
            curr = curr.children[c-'a'];
        }

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
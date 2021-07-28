//Time Complexity : O(n). insert(), search() and prefix() will all take O(n) time in the worst case. i.e the length of the word
//Space Complexity : O(n*k). where k is the average length of the number of words and n is the number of words.
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode[] child;
        TrieNode(){
            isEnd = false;
            child = new TrieNode[26];//each node will have 26 child nodes
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        //place each character in the word level by level
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            //if this character is null create a new node for it
            if(cur.child[c - 'a']==null){
                cur.child[c - 'a'] = new TrieNode();
            }
            //move the cur pointer to process its child node
            cur = cur.child[c - 'a'];
        }
        //after inserting mark isEnd as true indicating a complete word
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        //start iterating the word
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            //if this character's location is null then the word is not present
            if(cur.child[c - 'a']==null){
                return false;
            }
            //otherwsie go till the end
            cur = cur.child[c - 'a'];
        }
        //once the end is reached the isEnd will be true
        return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        //start iterating the prefix
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            //if this character's location is null then the word is not present
            if(cur.child[c - 'a']==null){
                return false;
            }
            //otherwsie go till the end
            cur = cur.child[c - 'a'];
        }
        //once the end is reached then the prefix is found
        return true;
    }
}
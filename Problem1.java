/**
LeetCode Submitted : YES
Time Complexity : O(Max Height of the Tree)
Space Complexity : O(Num of words in Trie)
The idea is to use char[26] array as a data structure for the node class. We can use isEnd boolean flag to determine end of word.  
**/

class Trie {

    class Node{
        Node[] children = new Node[26]; //char Array
        int value;
        boolean endOfWorld;
        public Node(){
            
        }
    }
    
    Node root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node temp = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            //System.out.println(c-'a');
            if(temp.children[c - 'a'] == null)
                temp.children[c - 'a'] =  new Node();
            
            temp.children[c - 'a'].value =  1;
            temp = temp.children[c - 'a'];
        }
        temp.endOfWorld = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node temp = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(temp.children[c - 'a'] != null && temp.children[c - 'a'].value ==  1)
                temp = temp.children[c - 'a'];
            else
                return false;
        }
        return temp.endOfWorld;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node temp = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(temp.children[c - 'a'] != null && temp.children[c - 'a'].value ==  1)
                temp = temp.children[c - 'a'];
            else
                return false;
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

/*
This program implements a Trie tree, along with three functions. A Trie is a tree which efficiently stores unique data that has common patterns,
as it stores the patterns usually only once, and does not repeat it unless the data is very uncommon.

Did this code run on leetcode: Yes
*/
class Trie {
    //We initiate the class TrieNode, which are the nodes of a Trie. Each TrieNode has an array of 26 pointers to other alphabets, and 
    //a variable isEnd that stores if this TrieNode is the last character in a particular string or not
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        
        TrieNode()
        {
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    /*
    Whenever we insert a new string into the Trie, we start at the root, and for each letter of the string starting from
    the first, we mark the corresponding pointer of that letter at that node by creating a new TrieNode at that reference,
    and then we go through the references of that TrieNode for the next letter and so on, till we reach the end of the string,
    where we mark the isEnd as true.
    
    Time Complexity: O(N) where N is the length of a word
    */
    public void insert(String word) {
        TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i++)
        {   
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
        
    }
    /* For searching a string, we go through a similar process as that of insertion, but instead of inserting a new TrieNode at each level,
     We just check if a reference for the current letter in the string exists at that particular level. If we reach the end of the string
     successfully, but that TrieNode is not marked as an end for that string, then we return false
     
     Time Complexity: O(N) where N is the length of a word
     */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        
        return curr.isEnd;
        
    }
    //Same process as that of searching, except all we do is check if a string/strings exists for the given prefix
    //Time Complexity: O(N) where N is the length of a prefix
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
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
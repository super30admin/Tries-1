/**Leetcode Question 208 - Implement Trie - prefix Tree */
/**Algorith
 * Use an array to store the children and a boolean is End to mark the end of the word
 * For insert, if the children does not exist, create a new TrieNode else use the previous one
 * For search, if the node does not exist, return false
 * For the prefix, if the node does not exist return false. 
 */
/** TC - O(N) - N= length of the longest word
 * SC - O(NK) - N = number of words, k= avg length of word
 */
public class ImplementTrie {
    class Trie {
        class TrieNode{
            TrieNode[] children;
            boolean isEnd;
            public TrieNode(){
                isEnd = false;
                children = new TrieNode[26];
            }
        }
        
        TrieNode root;
        
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
            
        }
        
        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode curr = root;
            for(int i =0; i<word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null){
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c- 'a'];
            }
            curr.isEnd = true;
        }
        
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode curr = root;
            for(int i =0; i< word.length(); i++){
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null){
                    return false;
                }
                curr = curr.children[c - 'a'];
            }
            return curr.isEnd;
        }
        
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for(int i= 0; i< prefix.length(); i++){
                char c = prefix.charAt(i);
                if(curr.children[c-'a'] == null){
                    return false;
                }
                curr = curr.children[c- 'a'];
            }
            return true;
        }
    }
    
}

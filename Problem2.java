// There are two approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.LinkedList;
import java.util.Queue;


// Your code here along with comments explaining your approach
// Approach 1: Using Previous Trie Data Structure
// 1. We build Trie Data Structure 
// 2. Now we do a BFS search, where a children is added only if it is end
// 3. We process children from 25-0 for lexicographical order -> [z-a]
// Time Complexity : O(nL + nL + nL) = O(nL)
//      n: number of words
//      L: Max length of words
//    For making Trie, for queue procesing and for creating Word string
// Space Complexity : O(nL)
//      n: number of words
//      L: Max length of words
class Problem2S1 {

    // Generic Pair class
    class Pair<K,V>{
        // members
        K key;
        V value;

        // constructor
        Pair(K k, V v){
            key = k;
            value = v;
        }

        public K getKey() {
            return key;
        }

        public V getValue(){
            return value;
        }
    }
    
    // class definition
    class TrieNode{
        
        // significes end of the word
        boolean isEnd;
        TrieNode[] children;
        
        TrieNode(){
            // for a-z
            children = new TrieNode[26];
        }
    }
    
    // global root
    TrieNode root = new TrieNode();
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null)
                current.children[index] =  new TrieNode();
            current = current.children[index];
        }
        current.isEnd = true;
    }

    /** find longest word */
    public String longestWord(String[] words) {
        
        // add all the words to trie
        for(String word:words)
            insert(word);
        
        // do BFS
        Queue<Pair<TrieNode, String>> myQueue = new LinkedList<>();
        myQueue.add(new Pair<TrieNode, String>(root, new String()));

        // holds the longest
        Pair<TrieNode, String> currentPair = null;

        // level by level
        while(!myQueue.isEmpty()){
            // cuurent 
            currentPair = myQueue.poll();
            TrieNode current = currentPair.getKey();
            // smallest lexicographical order -> [z-a]
            for(int i=25; i>= 0; i--){

                // not null and is end of the word
                if(current.children[i] != null && current.children[i].isEnd){
                    String word = currentPair.getValue() + (char)(i+'a');
                    myQueue.add(new Pair<TrieNode, String>(current.children[i], word));
                }
            }
        }
        // return longest word
        return currentPair.getValue();
    }
}
// Your code here along with comments explaining your approach
// Approach 2: Using Modified Trie Data Structure
// 1. We build Trie Data Structure and for 'is end' we add the entire word.
// 2. Now we do a BFS search where a children is added only if word is present.
// 3. We process children from 25-0 for lexicographical order -> [z-a]
// Time Complexity : O(nL + nL) = O(nL)
//      n: number of words
//      L: length of words
//    For making Trie and for queue procesing 
// Space Complexity : O(nL)
//      n: number of words
//      L: length of words
class Problem2S2 {
    
    // class definition
    class TrieNode{
        
        // members
        TrieNode[] children;
        // signfices word end
        String word;
        
        TrieNode(){
            // for a-z
            children = new TrieNode[26];
        }
    }
    
    // global
    TrieNode root;
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        // initialize
        TrieNode current = root;
        // iterate word
        for(int i=0; i<word.length(); i++){
            // Mapping index:[a-z] -> [0-25]
            int index = word.charAt(i) - 'a';

            // not present
            if(current.children[index] == null)
                current.children[index] =  new TrieNode();
            current = current.children[index];
        }
        // ending the entire word to leaf node
        current.word = word;
    }
    public String longestWord(String[] words) {
        // initialize
        root = new TrieNode();

        // build Trie
        for(String word:words)
            insert(word);
        
        // DO BFS
        Queue<TrieNode> myQueue = new LinkedList<>();
        myQueue.add(root);

        // holds the longest
        TrieNode current = null;
        // level by level
        while(!myQueue.isEmpty()){
            current = myQueue.poll();

            // smallest lexicographical order -> [z-a]
            for(int i=25; i>= 0; i--){
                // check children and also if end of word
                if(current.children[i] != null && current.children[i].word !=  null){
                    // add to queue
                    myQueue.add(current.children[i]);
                }
            }
        }
        // returns longest word
        return current.word;
    }
}
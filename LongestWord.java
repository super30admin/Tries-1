// Time Complexity : O(nk) where n is the number of words and k is the average length of the word
// Space Complexity : O(nk) where n is the number of words and k is the average length of the word, Queue at the worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Create a Trie node with the proper structure, we would store the words in the String array
for each of the trie node created. We would insert the string words from words[] in the trie, and for each field word of that trienode we would mark
it as the word for which we are creating trienode. We would do BFS using the Queue, if the Trienode has an existing word field put it in the queue
to be processed next, if the word field is null, break from it. We would store it in the queue starting from the reverse since we need to return the
result of same length in lexicographic way. At the depth, the word will have max length if present in the words[] and hence, we are satisfying both
the constraints.
*/
// BFS Approach
class Solution {
    class TrieNode{
        String word;                                                            // Trie Node structure
        TrieNode[] children;
        TrieNode(){
            this.children = new TrieNode[26];
    }
    }
    TrieNode root = new TrieNode();
    TrieNode head = root;
    public void insert(String s){                                                   // Insert the dictionary words in the TrieNode
        root = head;
        for(int i= 0; i < s.length(); i++){
            if(root.children[s.charAt(i) - 'a'] == null){
            root.children[s.charAt(i) - 'a'] = new TrieNode();                                  // Create the trie nodes for each of the letters of the words in dictionary
            }
            root = root.children[s.charAt(i) - 'a'];  
        }
        root.word = s;                                                              // Attach the word at the end of each node.
    } 
    public String longestWord(String[] words) {
        if(words == null || words.length == 0){return "";}
        for(int i = 0; i < words.length;  i++){
            insert(words[i]);                                                               // Insert all the words given in dictionary
        }
        root = head;
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = null;
        while(!q.isEmpty()){                                                                    // Process the nodes in queue
            curr = q.poll();
            for(int i = 25; i >=0; i--) {                                                       // Maintaining lexicographic ordering
            if(curr.children[i] != null && curr.children[i].word != null){
                q.add(curr.children[i]);                                            // Add to the queue if the word is existing
            }
        }
        }
        return curr.word;                                                                       // Return the last processed letter with word field
    }
}

// DFS Approach
class Solution {
    class TrieNode{
        String word;                                                                    // TrieNode Structure
        TrieNode[] children;
        TrieNode(){
            this.children = new TrieNode[26];
    }
    }
    TrieNode root = new TrieNode();
    TrieNode head = root;
    public void insert(String s){
        root = head;
        for(int i= 0; i < s.length(); i++){                                                                 // Insert the words
            if(root.children[s.charAt(i) - 'a'] == null){
            root.children[s.charAt(i) - 'a'] = new TrieNode();
            }
            root = root.children[s.charAt(i) - 'a'];  
        }
        root.word = s;
    } 
    String result ="";
    public String longestWord(String[] words) {
        if(words == null || words.length == 0){return "";}
        for(int i = 0; i < words.length;  i++){
            insert(words[i]);
        }
        root = head;
        dfs(root);                                                                                  // Start the DFS
        return result;
        }
    private void dfs(TrieNode root){
        if(root == null){return;}
        if(root.word != null){
            if(root.word.length() > result.length()){                                                       // If the length of the word is > result we got till now
                result = root.word;                                                                 // Replace with the max length
            } else
            if(root.word.length() == result.length() && root.word.compareTo(result) < 0){   // If the lengths are equal, compare lexicographically
                result = root.word;
            }
        }
        for(int i = 0; i <= 25; i++){
            if(root.children[i] != null && root.children[i].word != null){
                dfs(root.children[i]);                                                          // Continue the DFS 
            }
        }
    }
}
// TC:O(N*L)
// SC:O(N*L)
// N->no of words L->Avg length of words
// Approach
// In this the TrieNode is slightly modified to store word at its end as we need to return the lowest lexiographical word
// And BFS is performed, went to each node and checked its child node whether it has non empty string If so it is pushed into queue
// And finally after queue is empty the word of last node is returned.
class Solution {
    static class TrieNode {
        String ans;
        TrieNode[] children;
// Here in TrieNode at each node I am trying to store string at the end of each word instead of IsEnd=true
  
        TrieNode() {
            ans = null;
            children = new TrieNode[26];
        }
    }
   
//  Inserting a word into Trie
    public void insert(String word) {
        TrieNode curr = root;
        System.out.println(curr);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.ans=word;
    }

    TrieNode root;

    public String longestWord(String[] words) {
        root = new TrieNode();
        // Inserting all words in array into Trie
        for (String i : words) {
            insert(i);
        }
        //Traversing Trie Using BFS 
        // At each node going through all children i.e., 26
        // Pushing the nodes whose ans varaibales have string which is not empty
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode temp = root;

        while (!q.isEmpty()) {
            temp = q.poll();
            // Traversing in reverse order to get out the smallest lexographical word out
            for (int i = 25; i >=0; i--) {
                if (temp.children[i] != null && temp.children[i].ans!=null) {
           q.add(temp.children[i]);
           }

                
            }
        }
        // If we initaiate ans with null if there is no any word ending at first level it will be return null , ["wo","wor","worl","world"] for this test case
        if(temp.ans==null) return "";
        return temp.ans;
    }

}
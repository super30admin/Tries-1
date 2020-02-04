// Time Complexity : O(∑ length of words)
// Space Complexity : O(∑ length of words)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Trie & BFS

class longestWordInDictionary {
    
    Node root = new Node();
        
    class Node {
        Node[] children = new Node[26];
        String word;
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node();    
            }
            curr = curr.children[c - 'a'];
        }    
        curr.word = word;
    } 
    
    public String longestWord(String[] words) {
        for (String word : words) {
            insert(word); 
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node node = null;
        while (!q.isEmpty()) {
            node = q.poll();
            for (int i = 25; i >= 0; i--) {
                if (node.children[i] != null && node.children[i].word != null) {
                    q.add(node.children[i]);
                }
            }
        }
        return node.word;
    }
}
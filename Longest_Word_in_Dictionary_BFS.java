// TC : O(n * l) n - number of words & l - number of letters in a word
// SC : O(n * l) trie space
// BFS approach
class Solution {
    class TrieNode{
        TrieNode[] child;
        String str = "";
        TrieNode() {
            child = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word) {
        TrieNode temp = root;
        
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(temp.child[c - 'a'] == null)
                temp.child[c - 'a'] = new TrieNode();
            temp = temp.child[c - 'a'];
        }
        temp.str = word;
    }
    public String longestWord(String[] words) {
        if(words == null || words.length == 0) return null;
        root = new TrieNode();
        for(String s : words) {
            insert(s);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode result = new TrieNode();
            
        while(!q.isEmpty()) {
            TrieNode temp = q.poll();
            for(int i = 25; i >= 0; i--) {
                if(temp.child[i] != null && temp.child[i].str != "") {
                    q.add(temp.child[i]);
                }
            }
            result = temp;
        }
        
        return result.str; 
    }
    
}

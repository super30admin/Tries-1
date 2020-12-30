/** Given a list of strings words representing an English Dictionary, find the longest word in words
*  that can be built one character at a time by other words in words
* TC O(N*P) p is the average length of each word and there are n words. Insert will cause n*p time complexity
* SC O(N*P) 
*/
class Solution {
    class TrieNode {
        String word;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i<word.length(); i++ ) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }
    
    public String longestWord(String[] words) {
        if (words == null || words.length == 0)
            return "";
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }
        Queue<TrieNode> q = new LinkedList<TrieNode>();
        q.add(root);
        TrieNode node = root;
        while(!q.isEmpty()) {
            node = q.poll();
            for (int i = 25; i >= 0; i--) {
                if (node.children[i] != null && node.children[i].word != null)
                {
                    q.add(node.children[i]);
                }
            }
        }
        return node.word;
    }
}

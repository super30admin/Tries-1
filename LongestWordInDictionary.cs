//Time: O(nk)
//Space:O(nk)

public class Solution {
    
    class TrieNode {
        public TrieNode[] children;
        public string word;
        
        public TrieNode() {
            children = new TrieNode[26];
            word = "";
        }
    }
    TrieNode root;
    
    private void Insert(string word){
        TrieNode curr = root;
        for(int i =0; i < word.Length; i++){
            char c = word[i];    
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;    
    }
    
    public string LongestWord(string[] words) {
        root = new TrieNode();
        
        foreach(string word in words) {
            Insert(word);
        }
        Queue<TrieNode> q = new Queue<TrieNode>();
        q.Enqueue(root);
        
        TrieNode curr = null;
        while(q.Count > 0) {
            curr = q.Dequeue();
            for(int k = 25; k >=0; k--) {
                if(curr.children[k] != null && curr.children[k].word.Length > 0) {
                    q.Enqueue(curr.children[k]);
                }
            }
        }
        return curr.word;
    }
}
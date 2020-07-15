//Time complexity: O(nl) - n -number of words in the dictionary
//Space Complexity: O(n) - n - number of words in the dictionary
class TrieNode {
    
    public TrieNode[] ch = new TrieNode[26];
    public String isEnd;
    public TrieNode() {
        
    }
}
class Solution {
    private TrieNode root;
    
    public void insert(String word) {
        TrieNode wRoot = root;
        for(int i = 0 ; i < word.length();i++) {
            char c = word.charAt(i);
            if(wRoot.ch[c - 'a'] == null)
                wRoot.ch[c - 'a'] = new TrieNode();
             wRoot = wRoot.ch[c-'a']; 
        }
            wRoot.isEnd = word;
    }
    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String s: words) {
            insert(s);
            
        }
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        TrieNode curr = null;
        while(!queue.isEmpty()) {
            curr = queue.poll();
            for(int i = 25; i >= 0; i-- ) {
                if(curr.ch[i] != null && curr.ch[i].isEnd != null)
                    queue.add(curr.ch[i]);
            }
            
        }
        return curr.isEnd;
    }
}

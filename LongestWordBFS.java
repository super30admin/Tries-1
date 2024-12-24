class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            this.children = new TrieNode[26];
        }        
    }
    
    private TrieNode root;
    
    public void insert(String word) { // O(l)
        TrieNode current = root;
        for(int i=0;i< word.length();i++) {
            int idx = word.charAt(i)- 'a';
            if(current.children[idx] == null) {
                current.children[idx] = new TrieNode();
            }
            current = current.children[idx];
        }
        current.isEnd = true;
        
    }
    

    public String longestWord(String[] words) {
        this.root = new TrieNode();
        // inserted.
        for(String word: words) {
            insert(word);
        }
        Queue<TrieNode> q = new LinkedList<>();
        Queue<String> sq = new LinkedList<>();
        q.add(root);
        sq.add("");
        TrieNode curr = null;
        String str = "";
        while(!q.isEmpty()) {
            curr = q.poll();
            str = sq.poll();
            for(int i=25;i>=0;i--) {
                if(curr.children[i]!=null && curr.children[i].isEnd) {
                    q.add(curr.children[i]);
                    String newStr = str + (char)(i+'a');
                    sq.add(newStr);
                }
            }
        }
        return str;
        
    }

}
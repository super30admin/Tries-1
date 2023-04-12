/*
Time Complexity - O(L) for insert, search, remove. where L is the length string inserted / searched / removed.
Space Complexity - O(1) for search. O(L) for insert.
 */
class Trie {
    TrieNode trieNode = null;

    static class TrieNode{

        int size = 26;
        TrieNode[] child = null;
        boolean isEnd;

        protected TrieNode(){
            this.child = new TrieNode[size];
            this.isEnd = false;
        }

        protected boolean getEnd(){
            return this.isEnd;
        }

        protected void setEnd(boolean isEnd){
            this.isEnd = isEnd;
        }

        protected boolean containsKey(char ch){
            return this.child[ch - 'a'] != null;
        }

        protected TrieNode getKey(char ch){
            return this.child[ch - 'a'];
        }

        protected void setKey(char ch, TrieNode link){
            this.child[ch - 'a'] = link;
        }
    }

    public Trie() {
        trieNode = new TrieNode();
    }
    
    public void insert(String word) {
        if(word == null || word.length() == 0)
            return;
        int len = word.length();
        TrieNode ptr = trieNode;
        for(int i = 0; i < len; i++){
            char ch = word.charAt(i);
            if(!ptr.containsKey(ch))
                ptr.setKey(ch, new TrieNode());
            ptr = ptr.getKey(ch);            
        }
        ptr.setEnd(true);
    }
    
    public TrieNode find(String word) {
        if(word == null || word.length() == 0)
            return null;
        int len = word.length();
        TrieNode ptr = trieNode;
        for(int i = 0; i < len; i++){
            char ch = word.charAt(i);
            if(!ptr.containsKey(ch))
                return null;
            ptr = ptr.getKey(ch);            
        }
        return ptr;
    }

    public boolean search(String word) {
        TrieNode ptr = find(word);
        if(ptr != null && ptr.getEnd())
            return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode ptr = find(prefix);
        if(ptr != null)
            return true;
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

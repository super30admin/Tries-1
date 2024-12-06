class Trie {
    TrieNode root;

    // Define TrieNode
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        // Initialize TrieNode
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    
    // Initialize Trie
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) { // O(l)
        TrieNode curr = root; // take curr pointer on root of the Trie
        for(char ch: word.toCharArray()){
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr=curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) { // O(l)
        TrieNode curr = root; // take curr pointer on root of the Trie
        for(char ch: word.toCharArray()){
            if(curr.children[ch-'a']!=null){
                curr=curr.children[ch-'a'];
            } else{
                return false;
            }
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) { // O(l)
        TrieNode curr = root; // take curr pointer on root of the Trie
        for(char ch: prefix.toCharArray()){
            if(curr.children[ch-'a']==null){
                return false;
            } else{
                curr=curr.children[ch-'a'];
            }
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class Trie {
    TrieNode root;

    // Define TrieNode
    class TrieNode{
        HashMap<Character,TrieNode> children;
        boolean isEnd;

        // Initialize TrieNode
        public TrieNode(){
            this.children = new HashMap<>();
        }
    }
    
    // Initialize Trie
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root; // take curr pointer on root of the Trie
        for(char ch: word.toCharArray()){
            if(!curr.children.containsKey(ch)){
                curr.children.put(ch,new TrieNode());
            }
            curr=curr.children.get(ch);
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root; // take curr pointer on root of the Trie
        for(char ch: word.toCharArray()){
            if(!curr.children.containsKey(ch)){
                return false;
            } else{
                curr=curr.children.get(ch);
            }
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root; // take curr pointer on root of the Trie
        for(char ch: prefix.toCharArray()){
            if(!curr.children.containsKey(ch)){
                return false;
            } else{
                curr=curr.children.get(ch);
            }
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
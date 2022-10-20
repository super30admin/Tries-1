
class Trie {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode(){
        children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) { //TC -O(word length), sc - O(word length)
        TrieNode curr =root;
        
        for(int i=0; i<word.length(); i++)
        {
            char ch = word.charAt(i);
            
            if(curr.children[ch - 'a'] == null) // we will go to index of this children - ch-'a', if it's initialized, its not null, owise null
            {
                //intialize
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a']; 
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {//TC -O(word length), sc - O(1)
        TrieNode curr =root;
        
        for(int i=0; i<word.length(); i++)
        {
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null)
                return false;
            curr = curr.children[ch - 'a'];
        }
        return curr.isEnd;
    }
    public boolean startsWith(String prefix) { //TC -O(prefixlength), sc - O(1)
        TrieNode curr =root;
        
        for(int i=0; i<prefix.length(); i++)
        {
            char ch = prefix.charAt(i);
             
            if(curr.children[ch - 'a'] == null)
                return false;
            curr = curr.children[ch - 'a'];
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
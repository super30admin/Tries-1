//Trie is also called as prefix tree
//tries are used to store Strings

class Trie {
     class TrieNode{ //This is sde Tc O(nl) -- we dont talk about it
        boolean isEnd;
        TrieNode[] children;  
        public TrieNode() {
           children = new TrieNode[26];
        }
    }
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) { //T: O(L) //S: O(1) --> not using auxilary DS
        TrieNode curr = root;
        for(int i=0;i< word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr =  curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) { //T: O(L) //S: O(1) --> not using auxilary DS
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) { //T: O(L) //S: O(1) --> not using auxilary DS
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
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

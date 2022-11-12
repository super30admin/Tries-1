class TrieNode{
    TrieNode[] ch;
    boolean iw;

    TrieNode(){
        ch = new TrieNode[26];
    }
}



class Trie {
    private TrieNode r;
    public Trie() {
        r = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cu= r;
        for(int i =0; i<word.length(); ++i){
            int ci =word.charAt(i)-'a';
            if(cu.ch[ci]==null){
                cu.ch[ci]=new TrieNode();
            }
            cu = cu.ch[ci];
        }
        cu.iw = true;
    }
    
    public boolean search(String word) {
        TrieNode cu= r;
        for(int i =0; i<word.length(); ++i){
            int ci =word.charAt(i)-'a';
            if(cu.ch[ci]==null){
                return false;
            }
            cu = cu.ch[ci];
        }
        return cu.iw;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cu= r;
        for(int i =0; i<prefix.length(); ++i){
            int ci =prefix.charAt(i)-'a';
            if(cu.ch[ci]==null){
                return false;
            }
            cu = cu.ch[ci];
        }
        return true;
    }
}

//tc=O(l)
//sc=O(l)

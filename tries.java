class Trie {
    TrieNode root;
    class TrieNode{
        boolean isEnd;
        TrieNode[] child;
        public TrieNode(){
            child=new TrieNode[26];
        }
    }

    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            if(curr.child[word.charAt(i)-'a']==null){
                curr.child[word.charAt(i)-'a']=new TrieNode();
            }
            curr=curr.child[word.charAt(i)-'a'];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            if(curr.child[word.charAt(i)-'a']==null){
                return false;
            }
            curr=curr.child[word.charAt(i)-'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++){
            if(curr.child[prefix.charAt(i)-'a']==null){
                return false;
            }
            curr=curr.child[prefix.charAt(i)-'a'];
        }
        return true;
    }
}

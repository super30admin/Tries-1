// TC and SC = O(L) for all the three operations.

class Trie{
    
    class TriNode{
        boolean isEnd;
        TriNode[] children;
        public TriNode(){
            this.children = new TriNode[26];
        }
    }

    public TriNode root;

    public Trie(){
        this.root = new TriNode();
    }

    public void insert(String word){
        TriNode curr = root;
        for(int i = 0 ; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TriNode();
            }
            curr = curr.children[c -'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word){
        TriNode curr = root;
        for(int i = 0 ; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }

    public boolean startWith(String prefix){
        TriNode curr = root;
        for(int i = 0 ; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        return true;
    }

}
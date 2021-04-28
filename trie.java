//Runtime - O(N) where N is the length of the word
//space complexity - insert - O(N) search- O(1) 

class Trie {

    class Trienode{
        boolean isend;
        Trienode[] children;
        public Trienode(){
            isend=false;
            children=new Trienode[26];
        }
    }
    Trienode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new Trienode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trienode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(curr.children[c-'a']==null)
                curr.children[c-'a']=new Trienode();
            curr=curr.children[c-'a'];
        }
        curr.isend=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trienode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(curr.children[c-'a']==null)
                return false;
            curr=curr.children[c-'a'];
        }
        return curr.isend;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trienode curr=root;
        for(int i=0;i<prefix.length();i++)
        {
            char c=prefix.charAt(i);
            if(curr.children[c-'a']==null)
                return false;
            curr=curr.children[c-'a'];
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

class Trie {
    
    Trie[] children;
    boolean isEnd;

    public Trie() {
        
        children=new Trie[26];
        isEnd=false;
        
    }
    
    public void insert(String word) {
        
        Trie root=this;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(root.children[c-'a']==null)
                root.children[c-'a']=new Trie();
            
            root=root.children[c-'a'];
        }
        
        root.isEnd=true;
        
    }
    
    public boolean search(String word) {
        
        Trie root=this;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(root.children[c-'a']==null)
                return false;
            
            root=root.children[c-'a'];
        }
        
        return root.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        
        Trie root=this;
        for(int i=0;i<prefix.length();i++)
        {
            char c=prefix.charAt(i);
            if(root.children[c-'a']==null)
                return false;
            
            root=root.children[c-'a'];
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

//insert
// Time Complexity : O(N)
// Space Complexity : O(N)

//search
// Time Complexity : O(N)
// Space Complexity : O(1)

//startsWith
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

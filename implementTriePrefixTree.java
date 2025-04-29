// Time Complexity :  insert() - O(L), search() - O(L), startsWith() - O(L) where L = length of the word or prefix
// Space Complexity : O(N * L)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -

// Approach : 
// Build a Trie where each node has 26 children for each letter. 
// Insert by creating nodes if missing; search and startsWith by traversing nodes.
// Use a boolean 'present' flag to mark the end of a complete word.

public class implementTriePrefixTree  
{
    public class Tree
    {
        Tree[] children;
        boolean present;
        public Tree()
        {
            this.children = new Tree[26];
            this.present = false;
        }
    }

    Tree tree ;
    public implementTriePrefixTree() {
       this.tree = new Tree();
    }
    
    public void insert(String word) 
    {
        Tree dup = tree;
        char[] ch = word.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            int x = ch[i] - 'a';
            if(dup.children[x] == null)
            {
                dup.children[x] = new Tree();
            }
            dup = dup.children[x];
        }    
        dup.present = true;
    }
    
    public boolean search(String word) {
        Tree dup = tree;
        char[] ch = word.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            int x = ch[i] - 'a';
            if(dup.children[x] == null)
            {
                return false;
            }
            dup = dup.children[x];
        }
        return dup.present;
    }
    
    public boolean startsWith(String prefix) {
        Tree dup = tree;
        char[] ch = prefix.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            int x = ch[i] - 'a';
            if(dup.children[x] == null)
            {
                return false;
            }
            dup = dup.children[x];
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
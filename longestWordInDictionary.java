// Time Complexity : O(N * L)  where N = number of words, L = average length of a word 
// Space Complexity : O(N * L) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -

// Approach : 
// Insert all words into a Trie while marking complete words.
// For each word, check if all prefixes are present; if yes, consider it for longest word.
// Update the answer based on length and lexicographical order.



public class longestWordInDictionary {

    public class  Tree{
        Tree[] child ;
        boolean present;
        public Tree()
        {
            this.child = new Tree[26];
            this.present = false;
        }
    }

    Tree tree = new Tree();
    public void insert(String s)
    {
        Tree dup = tree;
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            int x = ch[i]-'a';
            if(dup.child[x]==null)
            {
                dup.child[x] =  new Tree();
            }
            dup = dup.child[x];
        }
        dup.present = true;
    }
    public boolean search(String s)
    {
        Tree dup = tree;
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            int x = ch[i]-'a';
            dup = dup.child[x];
            if(!dup.present)
            {
                return false;
            }
            
        }
        return true;
    }
    public String longestWord(String[] words) 
    {
        for(int i=0;i<words.length;i++)
        {
            insert(words[i]);
        }
        String op =""; 
        for(int i=0;i<words.length;i++)
        {
            boolean b = search(words[i]);
            //System.out.println(b);
            if(b)
            {
                if(op.length() < words[i].length())
                {
                    op = words[i];
                }
                if(op.length() == words[i].length())
                {
                    if(op.compareTo(words[i]) > 0)
                    {
                        op = words[i];
                    }
                }
            }
        }
        return op;
    }
}
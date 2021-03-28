//Time C: O(26*unique values)
//Space C: O(n*m) for insertion and O(longest word) for dfs.
//Executed on leetcode.
class Solution {
    
    class TrieNode{
        TrieNode[] children;
        String word;
        public TrieNode()
        {
            children = new TrieNode[26];
            word = "";
        }
    }
    
    TrieNode root;
    
    public void insert(String[] words)
    {
        for(String word: words)
        {
            TrieNode curr = root;
            for(int i=0;i<word.length();i++)	//Creating a Trie with trienode and string once the string inserting is completed 
            {
                if(curr.children[word.charAt(i)-'a']==null)		//Setting word value.
                    curr.children[word.charAt(i)-'a'] = new TrieNode();
                curr = curr.children[word.charAt(i)-'a'];
            }
            curr.word = word;
        }
    }
    String output = "";
    public String longestWord(String[] words) {        //Itterating through every value of the node at every level.
        root = new TrieNode();		//and if word value of the particualr node is greater than output string replacing with the word value.
        insert(words);        		//After completing the tier node returning the value.
        getLongestString(root);
        return output;
    }
    
    void getLongestString(TrieNode node)
    {        
        
        if(output.length()<node.word.length())
        {
            output = node.word;
        }
        
        for(int i=0;i<26;i++)
        {
            if(node.children[i]!=null && node.children[i].word!="")
            {
                getLongestString(node.children[i]);
            }
                
        }
    }
}
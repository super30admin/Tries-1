//Time complexity=O(N*L) (Inserting elements in Trie)
//Space complexity=O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    class TrieNode{
        String word;
        TrieNode [] children;
        public TrieNode()
        {
            children =new TrieNode [26];
        }
    }
    TrieNode root;
   
    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0 ; i<word.length() ;i++)
        {
            char c=word.charAt(i);
            if(curr.children[ c - 'a'] ==null)// Checks whether the character in the TrieNode
                curr.children[c - 'a']=new TrieNode(); // If not then add a new TrieNode in it. 
            curr=curr.children[c - 'a']; //Go to next node
        }
        curr.word=word; //We are storing the word that we added at its last character is added to Trie
    }
    public String longestWord(String[] words) {
        root=new TrieNode();
        for(int i=0;i<words.length;i++)
        {
            insert(words[i]);
        }
        Queue<TrieNode> q=new LinkedList<>();
        q.add(root);
        TrieNode curr=null;
        while(!q.isEmpty()){
        curr=q.poll();
        for(int j=25; j>=0; j--)
        { 
            if(curr.children[j] !=null && curr.children[j].word!=null)
                q.add(curr.children[j]);
        }
             
        }
        return curr.word;
    }
}
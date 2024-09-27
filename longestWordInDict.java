//TC : O(nk) n = number of words; k= avg length of each word
//SC : O(nk)
class Solution {
    TrieNode root;
    class TrieNode{
        TrieNode[] children;
        String word;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    public void insertIntoTrie(String word){
        TrieNode curr = root;
        for(int i =0; i<word.length();i++)
        {
            char c = word.charAt(i);
            if(curr.children[c - 'a'] ==null)
                curr.children[c- 'a'] = new TrieNode();

            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }
    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String word : words)
        {
            insertIntoTrie(word);
        }

        String maxWord ="";
        Queue <TrieNode>q = new LinkedList();

        q.add(root);
        TrieNode curr = new TrieNode();
        while(!q.isEmpty())
        {
            curr = q.poll();
            for(int i=25;i>=0;i--)
            {
                if(curr.children[i]!=null && curr.children[i].word!=null)
                {
                    q.add(curr.children[i]);
                }
            }
        }

        if(curr.word == null) return "";
        return curr.word;
    }
}
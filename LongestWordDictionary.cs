// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
    
    public class TrieNode{
        public TrieNode[] children;
        public string word;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    public void Insert(string word)
    {
        var curr = root;

        for(int i = 0; i < word.Length; i++)
        {
            char c = word[i];
            if(curr.children[c- 'a'] == null)
                curr.children[c-'a'] = new TrieNode();

            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }    
    
    TrieNode root;

    public string LongestWord(string[] words) {
        if(words == null || words.Length == 0)
            return "";
        
        root = new TrieNode();
        foreach(string word in words)
        {
            Insert(word);
        }
        
        //BFS
        Queue<TrieNode> queue = new  Queue<TrieNode>();
        queue.Enqueue(root);
        
        var curr = new TrieNode();
        while(queue.Count > 0)
        {
            curr = queue.Dequeue();
            for(int i = 25; i >= 0; i--)
            {
                if(curr.children[i] != null && curr.children[i].word != null)
                    queue.Enqueue(curr.children[i]);
            }
        }
        
        if(curr.word == null)
            return "";
        return curr.word;
    }
}
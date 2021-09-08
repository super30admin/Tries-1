
// Time Complexity : O(NK)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Approach:
1) we have to find the longest word in dictionary in lexicographical manner
2) Thus we choose to go with trie as we dont need to sort the strings as well
3) In trie, instead of using boolean, we use the TrieNode string word which indicates a word formed as we no more need the info whether we have reached the end of the word.
4) we create a root trieNode, and we create a TrieNode for every character and also the word associated with it. 
5) we decide to use BFS approach, we point curr to root and insert root of prefix tree in queue.
6) to maintain a lexicographic order, we start backwards
7) Once completed, 
    -> we check if(curr.children[i]!=null && curr.children[i].word!=null)
                {
                    queue.add(curr.children[i]);
                }
    This indicates if the word "wo" does not have a child then we do not insert into the queue as we cannot form the word further.
    else we enter that word in queue and then proceed ahead
*/




class LongestWordInDictionary {
    
    class TrieNode{
        
        TrieNode [] children;
        String word;
        
        public TrieNode()
        {
            children = new TrieNode[26];
        }
        
    }
    
    TrieNode root;
    
    public void insert(String word)
    {
        // pointing to the root node
        TrieNode curr = root;
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null)
            {
                curr.children[c-'a']= new TrieNode();
            }
            
            curr = curr.children[c-'a'];
            
        }
        // thus this will create "w","wo","wor" (Trie for every node)
        curr.word = word;
        
    }
    
    
    public String longestWord(String[] words) {
        if(words==null || words.length==0)
        {
            return "";
        }
        
        // creating a new Node
        root = new TrieNode();
        
        // building a Trie
        for(String word : words)
        {
            // every word, we build a trie
            insert(word);
        }
        
        // BFS to determine the longest word, and we need a queue
        Queue<TrieNode> queue = new LinkedList();
        TrieNode curr = root;
        queue.add(root); // add root of the prefix tree
        
        while(!queue.isEmpty())
        {
            curr = queue.poll();
            // to maintain a lexicographic order
            for(int i=25;i>=0;i--)
            {
                if(curr.children[i]!=null && curr.children[i].word!=null)
                {
                    queue.add(curr.children[i]);
                }
                
            }
            
        }
        if(curr.word==null)
        {
            return "";
        }
            
        return curr.word;
    }
}
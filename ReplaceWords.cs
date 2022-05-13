// Time Complexity : O(nk)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// 	1) We will build trie for root nodes
// Then we will itrate thru input to see if any string in input matches with root node, yes, replace it

public class TrieNode{
        
    public TrieNode[] children;
    public bool isEnd;
    
    public TrieNode(){
        children = new TrieNode[26];
    }
}


TrieNode root;

//insert all root nodes in trieNode;
private void Insert(string word)
{
    var curr = root;
    for(int i = 0; i < word.Length; i++)
    {
        char c = word[i];
        if(curr.children[c - 'a'] == null)
            curr.children[c-'a'] = new TrieNode();
        curr = curr.children[c - 'a'];

    }
    curr.isEnd = true;
}

public string ReplaceWords(IList<string> dictionary, string sentence) {
    
    if(dictionary == null || dictionary.Count == 0)
        return sentence;
    root = new TrieNode();
    
    foreach(var word in dictionary)
    {
        Insert(word);
    }
    
    StringBuilder result = new StringBuilder();
    var words = sentence.Split(" ");
    
    foreach(var word in words)
    {
        StringBuilder newString = new StringBuilder();
        TrieNode curr = root;

        for(int i = 0; i < word.Length; i++)
        {
            char c = word[i];
            
            if(curr.children[c - 'a'] == null || curr.isEnd == true)
                break;
            
            newString.Append(c);
            curr = curr.children[c - 'a'];
        }
        if(curr.isEnd)
            result.Append(newString);
        else
            result.Append(word);

        result.Append(" ");
    }
    return result.ToString().TrimEnd();
}
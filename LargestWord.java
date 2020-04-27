// 720.

//runtime - O(length of each word * length of dict)
//space - o(largest word in dict)

class TrieNode {
    String word;
    TrieNode[] children;
    
    public TrieNode(String word, TrieNode[] children) {
        this.word = word;
        this.children = children;
    }
}

class Solution {
    
    TrieNode root = new TrieNode("", new TrieNode[26]);
    
    public String longestWord(String[] words) {
        //build trie
        for(String word : words)
        {
            buildTrie(word);
        }
        
        //find largest word
        return findLargest(root);
    }
    
    //runtime - O(length of each word * length of dict)
    //space - o(largest word in dict)
    private void buildTrie(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++)
        {
            char current = word.charAt(i); //extract the char
            if(temp.children[current - 'a'] == null) //if the index for that char in children[] is null then initialize that index with a new trie node
            {
                temp.children[current - 'a'] = new TrieNode("", new TrieNode[26]);
            }
            temp = temp.children[current - 'a']; //move one layer down
        }
        temp.word = word; //store the string in the last node
        return;
    }
    
    //runtime - O(length of each word * length of dict)
    //space - o(largest word in dict)
    private String findLargest(TrieNode root) {
        String largest = root.word;
        
        for(TrieNode children : root.children)
        {
            //if the child is null or word of child is "" then go to that branch
            if(children != null && children.word != "")
            {
                //find  string recursively and replace if a larger one is found
                String temp = findLargest(children);
                if(temp.length() > largest.length())
                {
                    largest = temp;
                }
            }
        }
        
        return largest;
    }
    
}

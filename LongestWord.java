/*
This approach uses a Trie to solve the problem. We store all the words in the dictionary in the Trie, and then 
for each word in the dictionary, we go over the Trie to check and see if it is the largest word among other words
that can be built using other words in the dictionary. This is made possible due to the way a Trie stores its data,
wherein it stores words with the same prefixes on the same path so as to not repeat data. All we do is check if a 
particular word that can be built is the last on its path.

Did this code run on Leetcode: Yes

Problems with this approach: It only passes half of the test cases
*/
class Solution {
    
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        
        TrieNode()
        {
            children = new TrieNode[26];
        }
    
    
    public void insert(String word) {
        TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i++)
        {   
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }   
    }
        
    TrieNode root;
    int max;
    String current;
    //Time Complexity = O(NL) N = number of words, L = average length of the words 
    public String longestWord(String[] words) {
        
        root = new TrieNode();
        max = 0;
        current = new String();
        
        for(String str: words)
            root.insert(str);
        
        longest(root, 0, new StringBuilder(), false);
        
        return current;
    }
    
    private void longest(TrieNode root, int count, StringBuilder path, boolean valid)
    {   /* If we reach an end condition on a path, we perform 3 checks:
        1. We check if the node is the final node on the path i.e if it is the longest word that can be built using prefixes on that path
        2. We check if the node is a valid final node i.e we check if the path already encountered an end node previously so that a prefix
           actually exists for the word, and it is not the only word on the path.
        3. After that, we use the count variable to check if this word was the longest we have found so far. If it is, then we store the word
           in the current result, and set the maximum word length as that of the current word, so that we can compare future words to this. 
        */
        if(root.isEnd)
        {   
            if(isfinalNode(root) && valid)
            {
                if(count > max)
                {
                    max = count;
                    StringBuilder curr = path;
                    current = curr.toString();
                    return;
                }
            }
            //We set the validity of the path to true to indicate that the current path does have a prefix, and goes further down
            else
                valid = true;
        }
        //We go over all the nodes of the root and check for each path that exists
        for(int i = 0; i < 26; i++)
        {   
            //If a path exists, then we add the current character to the path, and traverse it
            if(root.children[i] != null)
            {   
                path.append((char)(i + 'a'));
                
                longest(root.children[i], count + 1, path, valid);
                
                path.deleteCharAt(path.length() - 1);
            }
        }

    }
    //Funtion for checking if a node is a final node. We are checking if all its references to its children are null or not
    public boolean isfinalNode(TrieNode root)
    {
        boolean flag = true;
        for(int i = 0; i < 26; i++)
        {
            if(root.children[i] == null)
                continue;
            else
            {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
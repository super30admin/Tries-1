// Time Complexity : O(m)  m is the length of longest word
// Space Complexity : O(n) n is the number of words  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
package Tries-1;

public class LongestWord {
    class Solution {
    
        class TrieNode{
            TrieNode [] children;
            int isEnd;
            Set<String> str;
            public TrieNode()
            {
                children = new TrieNode[26];
                isEnd = -1;
            }
        }
        
        public void insert(String word,int index)
        {
            TrieNode curr = root;
            for(int i=0;i<word.length();i++)
            {
                char ch = word.charAt(i);
                if(curr.children[ch-'a']==null)
                {
                    curr.children[ch-'a'] = new TrieNode();
                }
                curr= curr.children[ch-'a'];
            }
            curr.isEnd = index;
        }
        
        TrieNode root;
        public String longestWord(String[] words) {
            root = new TrieNode();
            for(int i=0;i<words.length;i++)
            {
                insert(words[i],i);
            }
            
            Queue<TrieNode> q = new LinkedList<>();
            q.add(root);
            TrieNode curr = root;
            while(!q.isEmpty())
            {
                curr = q.poll();
                for(int i=25;i>=0;i--)
                {
                    if(curr.children[i]!=null && curr.children[i].isEnd!=-1)
                    {
                      q.add(curr.children[i]);   
                    }
                }
                
            }
            return words[curr.isEnd];
        }
    }
    
}

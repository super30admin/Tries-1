// Time Complexity : O(m+n)l where m is the size of the dictionary and n is the number of words and l is the average length
// Space Complexity :O(m+n)l
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// we insert the words in the dictionary. then for each word in the sentence we check if the corresponding isEnd is true or null 
// if it is null their is no new replacement else we need to append the replacemnet string to the result.

class Solution {
    class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    public TrieNode() {
        this.children = new TrieNode[26];
    }
    }

    private TrieNode root;

    public void insert(String word) {
        TrieNode curr = root;
        for(int i =0; i< word.length(); i++)
        {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for(String word: dictionary)
        {
            insert(word);
        }
        String strArr[] = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int k=0;k<strArr.length;k++)
        {
            if(k>0)
                result.append(" ");
            String word = strArr[k];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr =root;
            for(int i=0;i<word.length();i++)
            {
                char c = word.charAt(i);
                if(curr.isEnd || curr.children[c-'a']== null)
                {
                    break;
                }
                curr = curr.children[c-'a'];
                replacement.append(c);
            }
            if(!curr.isEnd)
            {
                result.append(word);
            }
            else 
            {
                result.append(replacement);
            }    
        }
        return result.toString();
    }
}
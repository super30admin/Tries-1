// Time Complexity : O(nk), where n is the number of words in the dictionary and k is the length of the longest word in the dictionary
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * 1. Create a TrieNode class with children array and isEnd boolean and insert method.
 * 2. Load all the words from the dictionary into the Trie.
 * 3. Now check the whole trie using dfs and return the longest word.
 */

class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private TrieNode root;
    private String result = "" ;

    private void insert(String word){
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String word : words){
            insert(word);
        }

        dfs(root, new StringBuilder());
        return result;
    }

    private void dfs(TrieNode node, StringBuilder curr){
        if(node == null)
            return;

        if(node.isEnd){
            String currWord = curr.toString();
            if(currWord.length() > result.length())
                result = currWord;
            else if(currWord.length() == result.length() && currWord.compareTo(result) < 0)
                result = currWord;
        }

        for(int i=0; i<26; i++){
            TrieNode currNode = node.children[i];
            if(currNode != null && currNode.isEnd){
                char ch = (char) (i + 'a');
                curr.append(ch);
                dfs(currNode, curr);
                curr.deleteCharAt(curr.length()-1);
            }
        }
    }
}
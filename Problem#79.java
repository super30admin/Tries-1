// Replace Words

// Time Complexity : O(n), where n is the length of the sentence
// Space Complexity : O(n), where n is the size of the trie
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;

    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for(String word: dictionary){
            insert(word);
        }
        StringBuilder result = new StringBuilder();
        String[] splitArr = sentence.split(" ");
        for(String str: splitArr){
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(curr.isEnd || curr.children[c - 'a'] == null)
                    break;
                replacement.append(c);
                curr = curr.children[c - 'a'];
            }
            result.append(" ");
            if(curr.isEnd)
                result.append(replacement);
            else
                result.append(str);
        }
        return result.toString().trim();
    }
}
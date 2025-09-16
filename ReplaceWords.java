// Time Complexity : O(N*l + M*l) where N is number of words in dictionary and l is avg length of words, m is number of words in sentence
// Space Complexity : O(M*l)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// After inserting all the words in trie, we go through each word in the sentence and check the words in trie.
// If we find a prefix of a word in trie, we replace the word in sentence with that prefix, else we replace the word with itself.

class Solution {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            this.children = new TrieNode[26];
        }

        public void insert(TrieNode root,String word) {
            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null){
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for(String str: dictionary){
            root.insert(root, str);
        }

        StringBuilder result = new StringBuilder();
        String[] sentences = sentence.split(" ");

        for(String str: sentences){
            StringBuilder word = new StringBuilder();
            TrieNode cur = root;
            for(int k=0;k<str.length();k++){
                char c = str.charAt(k);
                if(cur.children[c-'a'] == null || cur.isEnd){
                    break;
                }
                word.append(c);
                cur = cur.children[c-'a'];
            }
            if(cur.isEnd)
                result.append(word);
            else
                result.append(str);

            result.append(" ");
        }

        return result.toString().trim();
    }
}
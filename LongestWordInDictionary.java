//https://leetcode.com/problems/longest-word-in-dictionary
//Tc : O(n * l)   n - number of words , l - average length of the words
//Sc : O(1) - Children TrieNodes of 256 - constant


class Solution {
    class TrieNode{
        private TrieNode [] children;
        private boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[256];
        }
    }
    int length;
    String result;
    TrieNode root;
    public String longestWord(String[] words) {
        length = 0;
        result = "";
        root = new TrieNode();
        for(String word : words){
            insert(word);
        }
        for(String word : words){
            if(findWord(word)){
                if(length < word.length()){
                    length = word.length();
                    result = word;
                }else if(length == word.length()){
                    if(result.compareTo(word)>0){
                        result = word;
                    }
                }
            }
        }
        return result;
    }
    private boolean findWord(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-' '] == null || !curr.children[c-' '].isEnd) return false;
            curr = curr.children[c-' '];
        }
        return true;
    }
    private void insert(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-' '] == null){
                curr.children[c-' '] = new TrieNode();
            }
            curr = curr.children[c-' '];
        }
        curr.isEnd = true;
    }
}

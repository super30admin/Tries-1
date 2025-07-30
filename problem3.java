// Time Complexity : O(total length of dictionary + sentence)
// Space Complexity : O(total length of dictionary + sentence)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I added everything to a trie and for each word in the sentence, I found the closest possible match, if no match then I add the word itself.

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String word : dictionary) trie.insert(word);
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<words.length; i++){
            String word = words[i];
            Trie.TrieNode curr = trie.root;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<word.length(); j++){
                int idx = word.charAt(j)-'a';
                if(curr.children[idx]==null || curr.inEnd) break;
                sb.append(word.charAt(j));
                curr = curr.children[idx];
            }
            if(curr.inEnd) res.append(sb.toString());
            else res.append(word);
            if(i!=words.length-1) res.append(" ");

        }
        return res.toString();
    }
}

class Trie {
    class TrieNode{
        boolean inEnd;
        TrieNode[] children;
        public TrieNode(){
            inEnd = false;
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0;i<word.length(); i++){
            int child = word.charAt(i)-'a';
            if(curr.children[child]==null){
                curr.children[child]= new TrieNode();
            }
            curr = curr.children[child];
        }
        curr.inEnd = true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
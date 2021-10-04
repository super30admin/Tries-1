package Tries1;
// Time Complexity: O(total no of words*L[average length of each word])
// Space Complexity : O(total no of words*L[average length of each word])
// Did this code successfully run on Leetcode : yes

class CustomTrie {
    TrieNode root;
    public CustomTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);

            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);

            if(curr.children[c-'a'] == null || !curr.children[c-'a'].isEnd){
                return false;
            }

            curr = curr.children[c-'a'];
        }
        return true;
    }
}

public class LongestWordInDictionary {
    Trie trie = new Trie();

    public String longestWord(String[] words) {
        String max = "";
        for (String word : words) {
            trie.insert(word);
        }
        for (String word : words) {
            if (trie.search(word)) {
                if (word.length() > max.length() || (word.length() == max.length() && word.compareTo(max) < 0)) {
                    max = word;
                }
            }
        }
        return max;
    }
}

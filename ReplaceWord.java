package tries1;

import java.util.List;

public class ReplaceWord {
	//Time Complexity : O(nl+mk), where n is size of dictionary, l is the average length of each 
	//word in dictionary for making the trie, m is the total number of words in sentence and
	//k is the average length of each word in sentence
	//Space Complexity : O(nl), for trie
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    
    TrieNode root;
    private void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String word: dictionary)
            insert(word);
        
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            if(i != 0)
                result.append(" ");
            TrieNode curr = root;
            StringBuilder sb = new StringBuilder();
            for(char c: word.toCharArray()) {
                if(curr.children[c - 'a'] != null && !curr.isEnd) {
                    sb.append(c);
                    curr = curr.children[c - 'a'];
                } else
                    break;
            }
            if(curr.isEnd)
                result.append(sb);
            else
                result.append(word);
        }
        
        return result.toString();
    }
}

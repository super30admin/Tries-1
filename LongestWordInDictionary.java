package tries1;

import java.util.LinkedList;
import java.util.Queue;

public class LongestWordInDictionary {
	class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        char ch;
        String str;
        
        public TrieNode() {
            children = new TrieNode[26];
            str = "";
        }
    }
    
    TrieNode root;
    private void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
            curr.ch = c;
        }
        curr.isEnd = true;
        curr.str = word;
    }
    
    //bfs
    //Time Complexity : O(nl) where n is the length of words array and l is the average
  	//length of each word
  	//Space Complexity : O(n) for trie and queue
  	//Did this code successfully run on Leetcode : Yes
  	//Any problem you faced while coding this : No
    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String word: words)
            insert(word);
        Queue<TrieNode> q = new LinkedList<>();
        q.offer(root);
        
        TrieNode curr = null;
        while(!q.isEmpty()) {
            curr = q.poll();
            for(int i=25; i>=0; i--) {
                if(curr.children[i] != null && curr.children[i].isEnd)
                    q.offer(curr.children[i]);
            }
        }
        
        return curr.str;
    }
    
    // dfs
    //Time Complexity : O(nl) where n is the length of words array and l is the average
  	//length of each word
  	//Space Complexity : O(n) for trie
  	//Did this code successfully run on Leetcode : Yes
  	//Any problem you faced while coding this : No
    String result = "";
    public String longestWord1(String[] words) {
        root = new TrieNode();
        TrieNode curr = root;
        for(String word: words)
            insert(word);
        backtrack(curr, new StringBuilder());
        return result;
    }
    
    private void backtrack(TrieNode root, StringBuilder sb) {
        // base
        if(sb.length() >= result.length())
            result = sb.toString();
        
        // logic
        for(int i=25; i>=0; i--) {
            TrieNode curr = root.children[i];
            if(curr != null && curr.isEnd) {
                // action
                sb.append(curr.ch);
                
                // recurse
                backtrack(curr, sb);
                
                //backtrack
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

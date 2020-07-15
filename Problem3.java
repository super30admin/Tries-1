//Time complexity:O(N) N - length of the sentence
//Space Complexity:O(N) 

class TrieNode {
    
    public TrieNode[] ch = new TrieNode[26];
    public String isEnd;
    public TrieNode() {
        
    }
}
class Solution {
    
    private TrieNode root;
    /** Initialize your data structure here. */
    public Solution() { 
        root = new TrieNode();   
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode wRoot = root;
        for(int i = 0 ; i < word.length();i++) {
            char c = word.charAt(i);
            if(wRoot.ch[c - 'a'] == null)
                wRoot.ch[c - 'a'] = new TrieNode();
             wRoot = wRoot.ch[c-'a']; 
        }
            wRoot.isEnd = word;
    }
    public String replaceWords(List<String> dict, String sentence) {
        
        for(String word: dict) {
            insert(word);
        }
        StringBuilder sb = new StringBuilder();
        String[] sentenceSplit = sentence.split("\\s+");
        for(String s: sentenceSplit) {
            TrieNode wRoot = root;
            for(int i = 0;i < s.length();i++) {
                char c = s.charAt(i);
                if (wRoot.ch[c-'a'] == null || wRoot.isEnd != null) break;
                wRoot = wRoot.ch[c-'a'];
            }
            if (wRoot.isEnd == null)
                sb.append(s + " ");
            else
                sb.append(wRoot.isEnd + " ");
        }
        return sb.toString().trim();
        
    }
}

/**
 *  Time Complexity: O(k) where k is the length of the string
 *  Space Complexity: O(k) where k is the length of the string
 */
class TrieNode {
    boolean isWord;
    TrieNode[] children;
    
    public TrieNode() {
        this.children = new TrieNode[26];
    }
    
    public void addWord(String word, TrieNode root) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int n = c - 'a';
            if (curr.children[n] == null)
                curr.children[n] = new TrieNode();
            
            curr = curr.children[n];
        }
        
        curr.isWord = true;
    }
}

class Solution {
    
    TrieNode root;
    
    public Solution() {
        this.root = new TrieNode();
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        for (String s : dict)
            this.root.addWord(s, this.root);
                
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++)
            words[i] = words[i].substring(0, dfs(this.root, words[i], 0));
                
        return buildString(words);
    }
    
    public int dfs(TrieNode curr, String word, int pos) {
        if (curr.isWord || word.length() == pos)
            return pos;
        
        int n = word.charAt(pos) - 'a';
        return curr.children[n] == null ? word.length() : dfs(curr.children[n], word, ++pos);
    }
    
    public String buildString(String[] words) {
        StringBuilder sb = new StringBuilder("");
        for (String word : words)
            sb.append(word + " ");
        
        sb.setLength(sb.length() - 1); // remove extra space
        return sb.toString();
    }
}
// Time Complexity : O(N)
// Space Complexity : O(M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class replaceWord {
    private TrieNode root;
    
    public replaceWord() {
        root = new TrieNode();
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        for (String root : dictionary) {
            addRoot(root);
        }
        String[] words = sentence.split(" ");
        String[] result = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            TrieNode node = root;
            StringBuilder rootWordBuilder = new StringBuilder();
            for (char c : chars) {
                if (!node.containsKey(c) || node.isEnd()) {
                    break;
                }
                rootWordBuilder.append(c);
                node = node.get(c);
            }
            result[i] = rootWordBuilder.length() <= 0 || !node.isEnd() ? words[i] : rootWordBuilder.toString();
        }
        return String.join(" ", result);
    }
    
    public void addRoot(String rootWord) {
        TrieNode node = root;
        char[] chars = rootWord.toCharArray();
        for (char c : chars) {
            if (!node.containsKey(c)) {
              node.add(c);  
            }
            node = node.get(c);
        }
        node.setEnd();
    }
}

class TrieNode {
    private TrieNode[] children;
    private boolean isEnd;
    
    public TrieNode() {
        children = new TrieNode[26];
    }
    
    public void add(char c) {
        children[c - 'a'] = new TrieNode();
    }
    
    public boolean containsKey(char c) {
        return children[c - 'a'] != null;
    }
    
    public TrieNode get(char c) {
        return children[c - 'a'];
    }
    
    public boolean isEnd() {
        return this.isEnd;
    }
    
    public void setEnd() {
        this.isEnd = true;
    }
}

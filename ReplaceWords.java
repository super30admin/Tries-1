package Nov19;

class ReplaceWords {
    
    TrieNode root;
    
    class TrieNode {
            TrieNode[] children;
            boolean isLast;
            public TrieNode() {
                children = new TrieNode[26];
                isLast = false;
            }
        }
        
    public void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char curChar = word.charAt(i);
                if (curr.children[curChar - 'a'] == null) {
                    curr.children[curChar - 'a'] = new TrieNode();
                }
                curr = curr.children[curChar - 'a'];
            }
            curr.isLast = true;
        }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        
        root = new TrieNode();
        
        for (String trieWord: dictionary) {
            insert(trieWord);
        }
        
        String[] splitSent = sentence.split("\\s+");
        TrieNode curr;
        StringBuilder result = new StringBuilder();
        
        for (String word: splitSent) {
            StringBuilder replacement = new StringBuilder();
            curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c-'a'] == null || curr.isLast) {
                    break;
                }
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            if (curr.isLast) {
                result.append(replacement + " ");
            } else {
                result.append(word + " ");
            }
        }
        
        return result.toString().trim();
        
    }
}

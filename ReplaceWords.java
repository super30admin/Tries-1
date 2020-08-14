class ReplaceWords {

    /**
     * Time complexity: O(N) where N is the number of words in sentence
     * Space complecity: O(N) size of the trie structure
     * 
     * Approach:
     * 1. Store all words from dictionary in trie structure. with trie node storing word as a attribute
     * at the end character of the word.
     * 2. For every word in sentence, search in trie structure till you find a charcter which has word 
     * attribute as not null, and replace the word in the sentence. 
     */
    
    class TrieNode {
        
        String word;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
        
    }
    
    TrieNode root = new TrieNode();
    
    private void insert(String word) {
        TrieNode curr = root;
        
        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        
        for(String d: dict) {
            insert(d);
        }
        
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split("\\s+");
        for(int i=0; i<words.length; i++) {
            
            String word = words[i];
            
            if(i > 0){
                sb.append(" ");
            }
            TrieNode curr = root;
            
            for(char c: word.toCharArray()){
                if(curr.children[c-'a'] == null || curr.word != null) {
                    break;
                }    
                curr = curr.children[c-'a'];
            }
            
            if(curr.word == null) {
                sb.append(word);    
            }
            else {
                sb.append(curr.word);   
            }
            
        }
        return sb.toString();
    }
}
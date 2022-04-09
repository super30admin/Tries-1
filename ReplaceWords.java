public class ReplaceWords {
  /**
   * Time Complexity: O(nk + ml)
   *    nk -> n number of words time k average length to insert dictionary into trie
   *    ml -> m words in string, l length to average replacement
   * 
   * Space Complexity: O(nk)
   *    worst case we'd have n words each of an averag length k and no word overlaps with another.
   */
  TrieNode root;
    
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        
        TrieNode() {
           this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }
    
    void insertWords(List<String> dictionary){
        this.root = new TrieNode();
        
        for(String word : dictionary){
            TrieNode curr = root;
            
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                
                if(curr.children[c - 'a'] == null){
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        insertWords(dictionary);
        
        StringBuilder sb = new StringBuilder();
        
        String[] words = sentence.split(" ");
        for(String word : words){
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = this.root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(curr.isEnd || curr.children[c - 'a'] == null) break;
                curr = curr.children[c - 'a'];
                replacement.append(c);
            }
            
            if(curr.isEnd){
                sb.append(replacement.toString());
                sb.append(" ");
            }else {
                sb.append(word);
                sb.append(" ");
            }
        }
        
        return sb.toString().trim();
    }
}

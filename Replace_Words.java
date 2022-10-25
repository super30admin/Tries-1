// TC : O(n) sentence length
// SC : O(l) size of list
class Solution {
    
    class TrieNode {
        TrieNode[] child;
        boolean isEnd;
        TrieNode() {
            child = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    private void insert(String s) {
        
        TrieNode temp = root;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(temp.child[c - 'a'] == null)
                    temp.child[c - 'a'] = new TrieNode();
                temp = temp.child[c - 'a'];
            }
            temp.isEnd = true;
    }
    
    private String search(String word) {
        TrieNode temp = root;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(temp.child[c - 'a'] == null) {
                return null;
            }
            sb.append(c);
            temp = temp.child[c - 'a'];
            if(temp.isEnd == true) {
                return sb.toString();
            }
            
        }
        return sb.toString();
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        if(sentence == null || sentence.length() == 0) return null;
        
        for(String s : dictionary) {
            insert(s);
        }
        
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word : words) {
            String rep = search(word);
            if(rep != null)
                sb.append(rep);
            else
                sb.append(word);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
       return sb.toString(); 
    }
}

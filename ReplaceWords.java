// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class ReplaceWords {
    class Trie {
        String word;
        Trie[] children;
        
        public Trie() {
            this.word = "";
            this.children = new Trie[26];
        }
    }
    
    Trie root;
    
    private void insert(String word) {
        Trie curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null)
                curr.children[ch-'a'] = new Trie();
            
            curr = curr.children[ch-'a'];
        }
        
        curr.word = word;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Trie();
        
        for(String word : dictionary)
            insert(word);
        
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<words.length;i++) {
            sb.append(getPrefix(words[i]));
            sb.append(" ");
        }
        
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    
    private String getPrefix(String word) {
        Trie curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(curr.word.length()>0)
                return curr.word;
            
            if(curr.children[ch-'a'] != null)
                curr = curr.children[ch-'a'];          
            else
                break;
        }
        
        return word;
    }
}























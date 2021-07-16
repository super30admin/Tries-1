// Time Complexity: O(nk + nl) where n is the number of words in dictionary/sentence. k and l is average number of characters in dictionary & sentence respectively
//Space Complexity: O(nk)

class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    /** Initialize your data structure here. */
    TrieNode root;
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        
        for(String str: dictionary){
            insert(str);
        }
        
        String[] splitStr = sentence.split("\\s");
        StringBuilder result = new StringBuilder();
        for(String word: splitStr){
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for(int i=0; i< word.length(); i++){
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null || curr.isEnd) break;
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd){
                result.append(replacement);
            } else {
                result.append(word);
            }
            
            result.append(" ");
            
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
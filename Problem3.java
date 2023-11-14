//Time Complexity  : O(n*l + m*l)
//Space Complexity : O(n)
//n:length of dictionary ; m:length of sentence; l:length of word

class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode(){
            this.children = new TrieNode[26];

        }
    }
    public void insert(TrieNode root, String word) {
        TrieNode curr = root;
        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for(String word: dictionary){ 
            insert(root, word);
        }
        String [] strArray = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int k=0; k< strArray.length; k++){
            TrieNode curr = root;
            String word = strArray[k];
            StringBuilder replacement = new StringBuilder();
            for(int i=0; i<word.length();i++){
                char c=word.charAt(i);
                if(curr.children[c - 'a'] == null || curr.isEnd){
                    break;
                }
                curr = curr.children[c-'a'];
                replacement.append(c);
                
                }
                if(curr.isEnd){
                    result.append(replacement);
            }
            else{
                result.append(word);
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
}

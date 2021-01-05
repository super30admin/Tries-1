//Time Complexity: O(N * average length of the word)
//Space Complexity: O(N * average length of the word)
class Solution {
    class TrieNode{
        boolean lastChar;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.lastChar = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || dictionary.size() == 0)
            return sentence;
        root = new TrieNode();
        for(String word: dictionary){
            insert(word);
        }
        String[] splitSentence = sentence.split("\\s+");
        StringBuilder finalString = new StringBuilder();
        StringBuilder interem = new StringBuilder();
        TrieNode curr = root;
        for(int i = 0; i < splitSentence.length; i++){
            if(i > 0){
                finalString.append(' ');
            }
            interem = new StringBuilder();
            curr = root;
            for(int j = 0; j < splitSentence[i].length(); j++){
                char c = splitSentence[i].charAt(j);
                if(curr.children[c - 'a'] == null || curr.lastChar){
                    break;
                }
                interem.append(c);
                curr = curr.children[c - 'a'];
            }
            if(curr.lastChar){
                finalString.append(interem);
            }else{
                finalString.append(splitSentence[i]);
            }
        }
        return finalString.toString();
        
    }
}
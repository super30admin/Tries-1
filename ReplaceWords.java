// TC - O(n) - number of words in sentence
// SC - O(n) - size of trie
// LC - 648
class Solution {
    // Creating Trie Datastructure
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        
        public TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    TrieNode root;
    
    public String replaceWords(List<String> dictionary, String sentence) {
        // Initializing root
        root = new TrieNode();
        // Insert function
        insert(dictionary);
        // creating string[] by splitting sentence into words 
        String[] words = sentence.split(" ");
        int i=0;
        // For each word call keepOrReplace function
        for(String word : words){
            words[i] = keepOrReplace(word);
            i++;
        }
    
        StringBuilder sb = new StringBuilder();
        // Words[] will be updated with new or existing words and append each word to StringBuilder and append a space as well at the end of each word
        for(String word : words){
            sb.append(word);
            sb.append(" ");
        }
        // return sb to string and trim as there will be one extra space at the end
        return sb.toString().trim();
        
    }
    
    // Insert elements into trie datastructure
    // For every word, convert it to a charArray and check if character is null, if yes, we create a new TrieNode and curr will point there, at end we add true 
    private void insert(List<String> dictionary) {
        for(int i=0; i<dictionary.size(); i++){
            TrieNode curr = root;
            String word = dictionary.get(i);
            for(char ch : word.toCharArray()){
                if(curr.children[ch-'a'] == null){
                    curr.children[ch-'a'] = new TrieNode();   
                }
                curr = curr.children[ch-'a'];       
            }
            curr.isWord = true;
        }
    }
    
    // This method checks if there is a new word to be replaced or keep the original word
    private String keepOrReplace(String word){
        // Initalizing a stringBuilder
        StringBuilder sb = new StringBuilder();
        // Storing root in curr
        TrieNode curr = root;
        // Iterating word accessing each character
        for(char ch : word.toCharArray()){
            // If curr children[ch] is not null, curr will go to children trieNode and append ch to sb and return sb converting to string if curr isWord is true
            if(curr.children[ch-'a'] != null){
                curr = curr.children[ch-'a'];
                sb.append(ch);
                if(curr.isWord){
                    return sb.toString();
                }
            // if it is null, break and return word
            }else{
                break;
            }
        }
        return word;
    }
}
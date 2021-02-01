// Time Complexity : O(n + s), n = no. of characters in dictionary strings, s = no. of characters in the sentence
// Space Complexity : O(n + s), n = no. of characters in dictionary strings, s = no. of characters in the sentence
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Initialize a Trie and insert all the characters from the dictionary strings. Divide the sentence into words, and for each word, check if the characters from that word are present in the Trie or if we reached the end in the Trie. If we reached the end in the Trie, replace that word to the word in the dictionary.

public class ReplaceWords {
        
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public void insert(String word){
        
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
    
    public String replaceWords(List<String> dictionary, String sentence) {
        
        root = new TrieNode();
        for(int i = 0; i < dictionary.size(); i++){
             insert(dictionary.get(i));
        }
        
        String [] words = sentence.split("\\s+");
        StringBuilder result = new StringBuilder("");
        
        for(String word : words){
            TrieNode curr = root;
            StringBuilder replace = new StringBuilder("");
            
            int j = 0;
            for(j = 0; j < word.length(); j++){
                char c = word.charAt(j);

                if(curr.children[c - 'a'] == null || curr.isEnd){
                    break;
                }
                
                replace.append(c);
                curr = curr.children[c - 'a'];
            }
            
            if(curr.isEnd){
                result.append(replace);
            } else {
                result.append(word);
            }

            result.append(" ");

        }
        result.setLength(result.length() - 1);
        return result.toString();
    }
}

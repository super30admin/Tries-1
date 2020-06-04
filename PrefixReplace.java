// Time Complexity : O(nk + lk) where n is the number of words in dict, k is the average length of the word in dict and l is the length of the sentence
// Space Complexity : O(n + m) where  n is the number of Trie Nodes , m is the Stringbuilder space to store the sentence
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Create a Trie node with the proper structure, we would store the prefix word at the
end of the word, at the last letter. So, if we reach that letter after the traversal, we can simply check if the last letter of the word contains
the word or not. If it does not contain, return false else return true. We would traverse the trie nodes in the same way as in previous questions 
using an array.
*/
class Solution {
    class TrieNode{
        String word;                                                                            // Trie node structure with word and children letter nodes
        TrieNode[] children;
        TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    TrieNode root = new TrieNode();
    TrieNode head = root;
    public void insert(String str){
            root = head;
            for(int i = 0; i < str.length(); i++){                                                      // Insert the string
            if(root.children[str.charAt(i) - 'a'] == null)  
               root.children[str.charAt(i) - 'a'] = new TrieNode();                                             // Create a letter node and traverse
            root = root.children[str.charAt(i) - 'a'];
            }
            root.word = str;                                                                    // Mark the last letter of the word with the word
        }
    public String replaceWords(List<String> dict, String sentence) {
        StringBuilder res = new StringBuilder();
        if(sentence == null || sentence.length() == 0){return "";}
        for(String s: dict){
            insert(s);                                                                          // Inserting all the words of dict in the trie 
        }
        String[] words = sentence.split("\\s+");                                            // Split the sentence into array of words
        for(int i = 0; i < words.length; i++){
            String w = words[i]; 
            root = head;
            int j = 0;
            while(j < w.length() && root.word == null) {                                   // For each word in sentence, check if it exists in the trie
            if(root.children[w.charAt(j) - 'a'] == null) {                                  // If any of the letter of the word is null, word is non existant
                break;
            }
            root = root.children[w.charAt(j) - 'a'];                                    // Traverse the trie nodes
            j++;
        }
            if(root.word != null){                                                          // If the word is not null at the last letter 
                res.append(root.word);                                                  // Replace the word with the prefix
                res.append(" ");
            } else {
                res.append(w);                                                              // Else put the same word from the sentence
                res.append(" ");
            }
        }
        return res.toString().trim();                                                       // Return the result without the blank space at the end
    }
}
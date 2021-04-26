/**Leetcode Question 648 - Replace Words */
/**Algorithm - Trie
 * Build a trie of the dictionary given
 * Iterate over the given strung and comapre the current word with the prefix in the dictionary
 * If the prefix is available, replace the word with that else append the word to the result string
 */
/**TC - O(MN + KL) = M= Length of the string, N = average length of each word in the string, k = Words in the dictionary, L = avg lenngth of the words in the dictionary
 * SC - O(KL) = k = Words in the dictionary, L = avg lenngth of the words in the dictionary
 */

public class ReplaceWords {
    class Solution {
        class TrieNode{
            TrieNode[] children;
            boolean isEnd;
            public TrieNode(){
                children = new TrieNode[26];
                isEnd = false;
            }
        }
        
        TrieNode root;
        
        public void insert(String word){
            TrieNode curr = root;
            for(int i =0; i<word.length(); i++){
                char c= word.charAt(i);
                if(curr.children[c - 'a'] == null){
                    curr.children[c -'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true;
        }
        
        public String replaceWords(List<String> dictionary, String sentence) {
            root =  new TrieNode();
            if(dictionary == null || dictionary.size() == 0){
                return sentence;
            }
            for(String word: dictionary){
                insert(word);
            }
            String[] sArray = sentence.split("\\s+");
            StringBuilder result = new StringBuilder();
            StringBuilder replacement;
            for(int i =0; i<sArray.length; i++){
                if(i>0){
                    result.append(' ');
                }
                TrieNode curr = root;
                String word = sArray[i];
                replacement = new StringBuilder();
                for(int j =0; j<word.length(); j++){
                    char c = word.charAt(j);
                    if(curr.children[c - 'a'] == null || curr.isEnd == true){
                        break;
                    }
                    replacement.append(c);
                    curr = curr.children[c - 'a'];
                }
                if(curr.isEnd){
                    result.append(replacement.toString());
                }
                else{
                    result.append(word);
                }
            }
            return result.toString();
        }
    }
}

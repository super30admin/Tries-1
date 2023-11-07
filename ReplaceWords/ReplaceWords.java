/* Time Complexity : O((N*L)+(M*L))
 *	N - number of words in the dictionary
 * 	L - avg. len. of the words
 *  M - length of the sentence or string */
/* Space Complexity : O((N*L)+(M)) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

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
        TrieNode root = new TrieNode();
        for(String word: dictionary){
            insert(root, word);
        }

        String[] strArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int k = 0; k < strArr.length; k++){
            TrieNode curr = root;
            String word = strArr[k];
            StringBuilder replacementStr = new StringBuilder();
            if(k > 0){
                result.append(" ");
            }
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null || curr.isEnd){
                    break;
                }
                curr = curr.children[c - 'a'];
                replacementStr.append(c);
            }
            if(curr.isEnd){
                result.append(replacementStr);
            }
            else{
                result.append(word);
            }
        }
        return result.toString();
    }
}
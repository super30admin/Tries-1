/* Time Complexity: O(m*l + n*l)
 * Space Complexity: O(n*l)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public void insert(String word) {
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
        for(String str: dictionary){//O(m*l + n* l)
            insert(str);
        }
        StringBuilder result = new StringBuilder();
        String [] strArr = sentence.split(" ");//O(n*l) - space
        for(int k = 0; k < strArr.length; k++){//O(n*l)
            String word = strArr[k];
            if(k != 0) result.append(" ");
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null || curr.isEnd){
                    break;
                }
                replacement.append(c);
                curr = curr.children[c - 'a'];
            }
            if(curr.isEnd){
                //we got the replacement
                result.append(replacement);
            } else {
                result.append(word);
            }
        }
        return result.toString();
    }
}
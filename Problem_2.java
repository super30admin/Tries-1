// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// create a trieNode and pass the dictionary to it. then check each char of every word if it is present in trait or not then add it to the result
// Your code here along with comments explaining your approach
class Solution {
    class TrieNode{
        TrieNode [] childrens;
        boolean isEnd;
        public TrieNode(){
            childrens = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for( int i = 0; i< word.length(); i++){
            char c = word.charAt(i);
            if( curr.childrens[c-'a'] == null){
                curr.childrens[c-'a'] = new TrieNode();
            }
            curr = curr.childrens[c-'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for( String word: dictionary){
            insert(word);
        }
        StringBuilder result = new StringBuilder();
        String [] allValues = sentence.split(" ");
        for( int i = 0 ; i < allValues.length; i++){
            if( i != 0 ){
                result.append(" ");
            }
            StringBuilder subWord = new StringBuilder();
            TrieNode curr = root;
            String word = allValues[i];
            for( int j = 0; j< word.length(); j++){
                char ch = word.charAt(j);
                if(curr.isEnd || curr.childrens[ch-'a'] == null) break;
                subWord.append(ch);
                curr = curr.childrens[ch -'a'];
            }
            if(curr.isEnd){
                result.append(subWord);
            }else{
                result.append(word);
            }
        }
        return result.toString();
    }
}
// Time Complexity : O(n) n is length of sentence.  
// Space Complexity : O(n) n is space for trie
// Did this code successfully run on Leetcode : Yes

class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String word: dictionary){
            insert(word);
        }
        String [] splitArray = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        TrieNode curr;
        StringBuilder temp;
        for(int i = 0; i < splitArray.length; i++){
            if(i > 0)
                result.append(" ");
            curr = root;
            temp = new StringBuilder();
            for(int j = 0; j < splitArray[i].length(); j++){
                char c = splitArray[i].charAt(j);
                if(curr.children[c - 'a'] == null || curr.isEnd == true)
                    break;
                temp.append(c);
                curr = curr.children[c - 'a'];
            }
            if(curr.isEnd){
                result.append(temp);
            }
            else{
                result.append(splitArray[i]);
            }
        }
        return result.toString();
    }
}
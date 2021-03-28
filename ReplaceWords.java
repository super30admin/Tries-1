// Time Complexity : O(n) where n is the dictionary length
// Space Complexity : O(n) to build trie tree
// Did this code successfully run on Leetcode  : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    
    class TrieNode{
        HashMap<Character,TrieNode> map;
        char c;
        boolean isWord;
        public TrieNode(char c){
            map = new HashMap<>();
            this.c = c;
            isWord = false;
        }
    }
    
    TrieNode root;
    
    public void insert(List<String> dictionary){
        // Building Trie
        for(String str:dictionary){
            TrieNode curr = root;
            for(int i=0;i<str.length();i++){
                if(!curr.map.containsKey(str.charAt(i))){
                    curr.map.put(str.charAt(i),new TrieNode(str.charAt(i)));
                }
                curr = curr.map.get(str.charAt(i));
            }
            curr.isWord = true;
        }    
    }
    
    public String getSmall(String word){
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<word.length();i++){
            if(curr.map.containsKey(word.charAt(i))){
                curr = curr.map.get(word.charAt(i));
                sb.append(word.charAt(i));
                if(curr.isWord)
                    return sb.toString();
            }
            else break;
        }
        return word;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        // insert the dict into trie
        root = new TrieNode('-');
        insert(dictionary);
        // split the sentence
        // for each word try the trie
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for(String str:words){
            sb.append(getSmall(str));
            sb.append(" ");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}

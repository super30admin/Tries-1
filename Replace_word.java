import java.util.List;
//Time Complexity : O(m*l)+O(n*k)
//if we are putting m words and inside trie average length L -->m*L
//Going through each char k from word n --> n*k
//Space Complexity : O(n*k)
class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    } 
      TrieNode root;
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] ==null){
                curr.children[c-'a'] =new TrieNode();
                
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String s : dictionary ){
            insert(s);
        }
        String [] strArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int j = 0; j < strArr.length; j++){
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            String word = strArr[j];
            if(j > 0) result.append(" ");
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null || curr.isEnd) break;
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd){
                result.append(replacement);
            }
            else{
                result.append(word);
            }
        }
        return result.toString();
    }
}

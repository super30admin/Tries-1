// Time Complexity : O(LxM + NxK)
// Space Complexity : O(LxM)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

        public class TrieNode {
            Map<Character, TrieNode> children;
            String words;

            public TrieNode(){
                children = new HashMap<>();
            }
        }

        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode current = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                TrieNode node = current.children.get(ch);
                if(node == null){
                    node = new TrieNode();
                    current.children.put(ch, node);
                }
                current = node;
            }

            current.words = word;
        }

    public String replaceWords(List<String> dict, String sentence) {
        for(String s : dict){
            insert(s);
        }
        StringBuilder sb = new StringBuilder();
        for(String word : sentence.split("\\s+")){
            TrieNode curr = root;
            
            if(sb.length() > 0){
                sb.append(" ");
            }
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                TrieNode node = curr.children.get(ch);
                if(node == null || curr.words != null){
                    break;
                }
                curr = node;
            }
            String replace = curr.words;
            if(replace == null){
                sb.append(word);
            }else{
                sb.append(replace);
            }
        }
        
        return sb.toString();
    }
}
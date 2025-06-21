// Time -> O(n * c)
// Space -> O(l * c)
class Solution {
    TrieNode root;
    public class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    public void insert(String word) {
        TrieNode currNode = root;
        for(int i = 0; i < word.length(); i++){
            // find the place if the node exists or not
            char ch = word.charAt(i);
            if(currNode.children[ch - 'a'] == null){
                currNode.children[ch - 'a'] = new TrieNode();
            }
            currNode = currNode.children[ch - 'a'];
        }
        currNode.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String word : dictionary){
            insert(word);
        }
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(String word : words){
            TrieNode currNode = root;
            StringBuilder newWord = new StringBuilder();
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(currNode.children[ch - 'a'] == null || currNode.isEnd){
                    break;
                }
                newWord.append(ch);
                currNode = currNode.children[ch - 'a'];
            }
            if(currNode.isEnd){
                result.append(newWord.toString());
            }else{
                result.append(word);
            }
            result.append(" ");
        }

        return result.toString().trim();
    }
}

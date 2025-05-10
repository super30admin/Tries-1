import java.util.List;

class Solution {
    TrieNode root;
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for(String word : dictionary){
            insert(word);
        }
        StringBuilder result = new StringBuilder();
        String[] splitArr = sentence.split(" ");

        for(int i = 0;i<splitArr.length; i++){
            String word = splitArr[i];
            if(i>0) result.append(" ");
            result.append(getShortestVersion(word));
        }

        return result.toString();
    }

    private String getShortestVersion(String word){
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] == null || curr.isEnd){
                break;
            }
            curr = curr.children[c-'a'];
            sb.append(c);
        }
        if(curr.isEnd){
            return sb.toString();
        }
        return word;
    }
}
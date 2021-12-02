class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word){
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
        for(String word : dictionary){
            insert(word);
        }
        StringBuilder result = new StringBuilder();
        String[] splitArr = sentence.split(" ");
        for(String word: splitArr){
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null || curr.isEnd) break;
                replacement.append(c);
                curr = curr.children[c - 'a'];

            }
            if(curr.isEnd){
                result.append(replacement + " ");
            }
            else{
                result.append(word + " ");
            }
        }
        return result.substring(0, result.length()-1).toString();

    }
}
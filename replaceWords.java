//Time Complexity: O((N+n)L) 
//Space Complexity: O(26^L)
class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        } curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for(String word: dictionary){
            insert(word);
        }
        StringBuilder result = new StringBuilder();
        String[] strArr = sentence.split(" ");
        for(int i = 0; i < strArr.length; i++){
            String word = strArr[i];
            StringBuilder replace = new StringBuilder();
            TrieNode curr = root;
            for(int j = 0; j < word.length(); j++){
            char c = word.charAt(j);
            if(curr.isEnd || curr.children[c-'a'] == null){
                break;
            }
            replace.append(c);
            curr = curr.children[c-'a'];
        }
        if (curr.isEnd) result.append(replace);
        else result.append(word);
        result.append(" ");
    } return result.toString().trim();
}
}
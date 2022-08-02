// TC : O(n) size of sentence
// SC : O(m) size of trie

class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
       root = new TrieNode();
        for(String word:dictionary){
            insert(word);
        }
        String[] splitStrings = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for(int i=0;i<splitStrings.length;i++){
            if(i!=0){
                result.append(" ");
            }
            String word = splitStrings[i];
            StringBuilder sb = new StringBuilder();
            TrieNode curr = root;
            for(int j=0;j<word.length();j++){
                char c = word.charAt(j);
                if(curr.children[c-'a'] == null || curr.isEnd){
                    break;
                }
                sb.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd){
                result.append(sb.toString());
            }
            else{
                result.append(word);
            }
        }
        return result.toString();
    }
} 
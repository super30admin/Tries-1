
//time - O(nk)
//space - O(nk)
class Solution {
    StringBuilder result;
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        char ch;
        public TrieNode(){
            children = new TrieNode[26];

        }
    }
    
    TrieNode root;
    private void insert(String word){
        TrieNode curr = root;
        for(int i =0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
            curr.ch = c;
        }
        curr.isEnd = true;
    }
    public String longestWord(String[] words) {
        root = new TrieNode();
        result = new StringBuilder();
        for(String word : words){
            insert(word);
        }
        backtrack(root,new StringBuilder());
        return result.toString();    
    }
    private void backtrack(TrieNode curr, StringBuilder st){
        //base
        if(result.length() < st.length()){
            result = new StringBuilder(st);
        }
        //curr
        for(int i=0; i<26; i++){
            if(curr.children[i] != null && curr.children[i].isEnd == true){
                st.append(curr.children[i].ch);
                backtrack(curr.children[i], st);
                st.setLength(st.length()-1);
            }
            
        }
    }
}
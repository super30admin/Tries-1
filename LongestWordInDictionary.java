class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    private TrieNode root;
    public Solution(){
        this.root = new TrieNode();
    }
    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new TrieNode();

            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }
    public boolean checkprefix(String word){
        TrieNode curr = root;
        for(int i =0; i<word.length(); i++){
            char ch = word.charAt(i);
            curr = curr.children[ch-'a'];
            if(curr == null || !curr.isEnd){
                return false;
            }
           
        }
        return true;
    }

    public String longestWord(String[] words) {
        for(String word : words){
            insert(word);
        }
        String output = "";
        for(String word:words){
            if(checkprefix(word)){
                if(word.length()>output.length() || word.length()==output.length() && word.compareTo(output)<0){
                    output = word;
                }
                
            }
        }
        return output;

        
    }
}
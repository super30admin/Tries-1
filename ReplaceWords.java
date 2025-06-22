class Solution {
    class TrieNode{ //class followed by constructor
    TrieNode[] children;
    boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    class Trie{
        private TrieNode root;
        public Trie(){
            this.root = new TrieNode();
        }
    
    //creatig trie for words in dictionary
        public void Insert(String word){
            TrieNode curr = root;
            for(int i = 0 ; i < word.length() ; i++){
                char ch = word.charAt(i);
                if(curr.children[ch - 'a'] == null){
                    curr.children[ch - 'a'] = new TrieNode();
                }
                curr = curr.children[ch-'a'];
            }
            curr.isEnd = true;


        }
          public TrieNode getRoot() {
            return root;
        }
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();             // Create Trie instance
        StringBuilder result = new StringBuilder();

        //Insert all words from dictionary into Trie
        for(String word : dictionary){
            trie.Insert(word);
        }
        TrieNode root = trie.getRoot();
        String[] strarr = sentence.split(" ");

        for(String word : strarr){
            //search for replacement
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;

            for(int i = 0 ; i < word.length() ; i++){
                char ch = word.charAt(i);
                 // If path breaks or current node marks end of a root word, stop
                if(curr.children[ch-'a']==null || curr.isEnd == true){
                    break;

                }
                replacement.append(ch);
                curr = curr.children[ch-'a'];
            }
             // If current node marks end of root word, append replacement else original word
            if(curr.isEnd == true){
                result.append(replacement.toString());
            }
            else{
                result.append(word);
            }
            result.append(" ");

        }
        return result.toString().trim();
    }
        
}
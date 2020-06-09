class Trie {
    class TrieNode{
        boolean isEnd; // to mark the end of the string
        TrieNode arr[]; // to store subsequent characters related to the incoming string
        
        public TrieNode(){
            arr = new TrieNode[26];
        }
    }

    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
         root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i);
            if(cur.arr[c-'a'] == null){
                cur.arr[c-'a'] = new TrieNode();
            }
            
            cur = cur.arr[c-'a'];
        }
        
        cur.isEnd = true; // after inserting the given string, mark the last char of it as true
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i);
            if(cur.arr[c-'a'] == null){
                return false;
            }
            
            cur = cur.arr[c-'a'];
        }
        
        return cur.isEnd;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i=0; i< prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.arr[c-'a'] == null){
                return false;
            }
            
            cur = cur.arr[c-'a'];
        }
        
        return true;
        
    }
}

/**
Building Trie dictionary of the given words and iterating all the nodes in the bfs manner until the end of TrieNode. 
*/
class Solution {
    TrieNode root = new TrieNode();
    class TrieNode{
        String word;
        TrieNode [] chars; // all 26 chars in a node
        
        TrieNode(){
            chars = new TrieNode[26];
        }
    }
    // filling Trie dictionary
    private void insert(String s){
        TrieNode cur = root;
        
        for(char c: s.toCharArray()){
            if(cur.chars[c-'a'] == null){
                cur.chars[c-'a'] = new TrieNode();
            }
            cur = cur.chars[c-'a'];
        }
        cur.word = s;
    }
    public String longestWord(String[] words) {
        
        for(String word: words){
            insert(word);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode cur = null;
        while(!q.isEmpty()){
             cur = q.poll();
            for(int i = 25; i >=0; i--){
                if(cur.chars[i] != null && cur.chars[i].word != null){
                    q.add(cur.chars[i]);
                }
            }
        }
        
        return cur.word;
    }
}
/**
To fill all the succesor in the sentence with the root, the root words should be in the dictionary in Trie format. Iterate over each word(each char in the word) in the sentence and check if it exists in the Trie Dictionary. 
TC= nk + kl where n is the number of words in the dict and k is the avg len of a word in dict. l is the len of sentence
SC= nk
*/
class Solution {
    TrieNode root = new TrieNode();
    class TrieNode{
        String word;
        TrieNode [] chars; // all 26 chars in a node
        
        TrieNode(){
            chars = new TrieNode[26];
        }
    }
    // filling Trie dictionary
    private void insert(String s){
        TrieNode cur = root;
        
        for(char c: s.toCharArray()){
            if(cur.chars[c-'a'] == null){
                cur.chars[c-'a'] = new TrieNode();
            }
            cur = cur.chars[c-'a'];
        }
        cur.word = s;
        
    }
    public String replaceWords(List<String> dict, String sentence) {
        
        
        // forming dict with Trei structure
        for(String word: dict){
            insert(word);
        }
        
        String[] wordsInSentence = sentence.split("\\s+"); // spliting based on empty spaces. + to omit space if there is more than 1 space between two words
        int endIndex=0;
        StringBuilder sb = new StringBuilder(); // resultant string with replacements
        for(String wrd: wordsInSentence){
            TrieNode cur = root;
            for(char c: wrd.toCharArray()){
                if( cur.chars[c-'a'] == null || cur.word != null) break;
                cur = cur.chars[c-'a'];
            }
            if(cur.word == null){
                sb.append(wrd);
            }else{
                sb.append(cur.word);
            }
             endIndex++;
                        
            if(endIndex < wordsInSentence.length){
                sb.append(" ");
            }
            
        }
        
        return sb.toString();
    }
} 

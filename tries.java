//1.implement prefix tree
//time Complexity :
//Insert - > O(l)
//search - > O(n*l)
//prefix -> O(l)
//where l is the length of the prefix
//space complexity -> n*l * 26 -> O(n*l)
class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26]; //26 because of the lowercase english alphabets
        }
    
    }
    private TrieNode root;    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a']; 
        }
        curr.isEnd = true; 
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length();i++){
            char ch = word.charAt(i);
            TrieNode baby = curr.children[ch-'a'];
            if( baby == null) return false;
            curr = baby;
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length();i++){
            char ch = prefix.charAt(i);
            if(curr.children[ch-'a'] == null) return false;
            curr = curr.children[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

//2nd longest word in a dictionary
//Time COmplexity - > O(n) + O(l*26)=> O(max(n,l))
//space Complexity -> O(n*l)
class Solution {
    class TrieNode{
        boolean isEnd;
        String word;
        TrieNode[] children;
        public TrieNode(){
            this.isEnd = false;
            this.word = null;
            this.children = new TrieNode[26];

        }
    }
    private TrieNode root;
    String result;
    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0 ;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
               
            }
            curr = curr.children[ch - 'a'];

        }
        curr.isEnd = true;
        curr.word = word;
        
    }
    private void helper(TrieNode root) {
        if (root == null)
            return;

        if (root.word != null) {
            if (root.word.length() > result.length())
                result = root.word;
            else if (root.word.length() == result.length() && root.word.compareTo(result) < 0)
                result = root.word;
        }

        for (TrieNode child : root.children)
            if (child != null && child.word != null)
                helper(child);
    }
    public String longestWord(String[] words) {
        Arrays.sort(words);
        result = "";
        root = new TrieNode();
        for(String word : words){
            insert(word);
        }
        helper(root);
        return result;

    }

}
//3rd Replace words
//using trie
//time complexity -> O(length of sentence)
//space complexity - >O(n*l)
class Solution {
    //Using Tries
    class TrieNode{
        boolean isEnd;
        TrieNode children[];
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word,TrieNode root){
        TrieNode curr = root;
        for(int i = 0 ;i < word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
                   
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder result = new StringBuilder();
        this.root = new TrieNode();
        for(String word : dictionary){
             insert(word, root);
        }
        String[] splStrings = sentence.split(" ");
        for(String word : splStrings){
            boolean flag = false;
            TrieNode curr = root;
            StringBuilder replacement = new StringBuilder();
            for(int i= 0; i< word.length();i++){
                char ch = word.charAt(i);
                if(curr.children[ch - 'a'] == null || curr.isEnd) break;
                replacement.append(ch);
                curr = curr.children[ch - 'a'];
            }
            if(curr.isEnd == true){
               result.append(replacement);
               result.append(" ");
            }else{
                result.append(word);
                result.append(" ");
            }
        }

        return result.toString().trim();
    }
}
//using hashset
//time complexity -> O(n*l^2)
//space complexity -> O(n*l)
class Solution {
    //Using hashSet
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder result = new StringBuilder();
        Set<String> set = new HashSet<>(dictionary);
        String[] splStrings = sentence.split(" ");
        for(String word : splStrings){
            boolean flag = false;
            StringBuilder replacement = new StringBuilder();
            for(int i = 0 ;i< word.length() ;i++){
                String sub = word.substring(0,i+1); //checking for substring
                if(set.contains(sub)){
                    flag = true;
                    replacement.append(sub);
                }
                if(flag == true){
                    break;
                }
            }
            if(flag == true){
                result.append(replacement);
                result.append(" ");
            }
            else{
                result.append(word);
                result.append(" ");
            }
        }
        
        return result.toString().trim();
    }
}
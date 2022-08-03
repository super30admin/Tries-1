//TC for Insert = O(length of the word)
//TC for search = O(length of the word)
//TC for prefix = O(length of the word)
//SC for Insert,search,prefix = O(length of the word)

//paypal

//Trie retrieval = consist of dictionary tree based DS. Alphates uppercase =26 ,alphabets lowercase and uppercase = 52
//keep a boolean marker that I have reached the end of the tree.Binary Tree node looks like this compare and contrast .
//How to insert a element : I'll always start with the root node and I'll always go to the index, if it is null this character is not created and go next node as't' .In the end if we reach to 't' the mark it as in boolean as true .When you are done then store true.If this the end of the word then I found my word.can start from trie root node and goes to 'c' look for 'a' then chect for 'n' if it is not there then return false.Return the value current next and end of the word if it reaches then mark it as true.If its not there in trie return false 

class Trie {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
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
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i =0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(curr.children[c-'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
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
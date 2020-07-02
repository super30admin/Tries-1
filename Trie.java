//Time COmplexity: O(l*n) l is the averge length of the words and n is number of words
//Space complexity: O(l*n)
//accepted on leetcode
class Trie {

    /** Initialize your data structure here. */
    class TrieNode{
        //hashmap to check for each char
        Map<Character,TrieNode> children;
        //for checking end of word
        boolean endOfWord;
        
        public TrieNode(){
            children=new HashMap<>();
            endOfWord=false;
        }
    }
    public final TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        //make current as the root
        TrieNode cur=root;
        //Iterate over the word
        for(int i=0;i<word.length();i++){
            //store each char in c
            char c=word.charAt(i);
            //get the value at  key c
            TrieNode node=cur.children.get(c);
            //if node is null
            if(node==null){
                //put the value
                node=new TrieNode();
                cur.children.put(c,node);
            }
            //make cur, node
            cur=node;
        }
        //make end of word is true
        cur.endOfWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur=root;
        //iterate over the word
        for(int i=0;i<word.length();i++){
            //take each char 
            char c =word.charAt(i);
            //get the value from hashmap
            TrieNode node=cur.children.get(c);
            //if value is null return false
            if(node==null){
                return false;
            }
            //else assign to cur
            cur=node;
        }
        //return end of word
        return cur.endOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        //make cur as root
        TrieNode cur=root;
        //Iterate over the prefix string
        for(int i=0;i<prefix.length();i++){
            //store char wise in c
            char c=prefix.charAt(i);
            //get the value of c 
            TrieNode node=cur.children.get(c);
            //if value is null then return false
            if(node==null){
                return false;
            }
            //store node at cur
            cur=node;
        }
        //return true
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
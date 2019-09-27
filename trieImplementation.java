//Time Complexity:O(l*n) for all three operations, where l lis the average length of each string and n is the number of strings
//Space Complexity:O(l*n)
//In this problem, I'll be creating a TrieNode data structure. I'll then be using that data structure to perform the insert, search and prefix search operations.In the insert, I'll check if a character is already inserted in to the map. Else, I'll insert that element and its corresponding node in to the map. At the end, I'll make the end of word=true. I'll be doing the same operation for search, with the difference that if I find node = null anywhere, I'll be returning false, else, I'll iterate through and return the value of end of words. I'll follow the same procedure for prefix search with the exception that after iterating through the entire prefix word, If I have not encountered any null value in between, I'll be returning true.
//This code was executed successfully and got accepted in leetcode.
class Trie {
    class TrieNode{
        Map<Character,TrieNode> children;
        boolean endOfWord;
        public TrieNode(){
            children=new HashMap<>();
            endOfWord=false;
        }
    }
    /** Initialize your data structure here. */
    public final TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            char ch =word.charAt(i);
            TrieNode node=cur.children.get(ch);
            if(node==null){
                node=new TrieNode();
                cur.children.put(ch,node);
            }
            cur=node;
        }
        cur.endOfWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            TrieNode node=cur.children.get(ch);
            if(node==null){
                return false;
            }
            cur=node;
        }
        return cur.endOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur=root;
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            TrieNode node=cur.children.get(ch);
            if(node==null){
                return false;
            }
            cur=node;
        }
        return true;
    }
}
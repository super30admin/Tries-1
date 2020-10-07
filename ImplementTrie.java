/*
TC:
insertion: O(M) M- length of key inserted
search: O(M) M - length of key
search Prefix : O(M) M - length of prefix key

SC: 
insertion: O(M) M -length of word
search: O(1)
search Prefix: O(1)

*/

class TrieNode{
    boolean isEnd;
    TrieNode[] list;

    public TrieNode(){
        this.list = new TrieNode[26];
        this.isEnd = false;
    }

    public boolean isEndofWord(){
        return isEnd;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean containsKey(char c){
        return list[c - 'a'] != null;
    }

    public TrieNode getKey(char c){
        return list[c - 'a'];
    }

    public void setKey(char c){
        list[c - 'a'] = new TrieNode();
    }

}

class PrefixTrie{

    private TrieNode root;

    public PrefixTrie(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode cur = root;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!cur.containsKey(c)){
                cur.setKey(c);
            }
            cur = cur.getKey(c);
        }
        cur.setEnd();
    }

    public boolean search(String word){
        TrieNode node = searchString(word);
        return node != null && node.isEndofWord();
    }

    public boolean startsWith(String prefix){
        TrieNode node = searchString(prefix);
        return node != null;
    }

    public TrieNode searchString(String word){
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!cur.containsKey(c)){
                return null;
            }
            cur = cur.getKey(c);
        }
        return cur;
    }
}

class Main{

    public static void main(String[] args){
        PrefixTrie trie = new PrefixTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("appl"));
    }

}


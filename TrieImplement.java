/*
Author: Akhilesh Borgaonkar
Problem: Implement trie data structure with insert, search and startsWith methods.
Approach: Implemented using a Trie structure which has a isWord boolean flag which defines if the previous alphabets make a word &
    a hashmap which stores the children in the form of character as key and trieNode as value.
*/

class TrieNode{
    boolean isWord;                                 //flag to determine if the previous characters form a word.
    HashMap<Character, TrieNode> children = new HashMap<>();    //stores next characters.
    public TrieNode(){
    }
}

class Trie {

    private static TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie.
     * Insert method checks if first character of input word is already present.
     * If not, then creates a new TrieNode and starts adding following characters of input word to its children.
     * If yes, then gets the children and returns the following children for next insertion. **/
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            TrieNode t;
            if(children.containsKey(c))
                t = children.get(c);
            else{
                t = new TrieNode();
                children.put(c,t);
            }
            children = t.children;
            if(i == word.length()-1)
                t.isWord = true;
        }
    }

//   Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);
        if(t!=null && t.isWord)
            return true;
        return false;
    }

//  Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null)
            return false;
        return true;
    }

    /** Search method is essentually a module which helps to find whole word or a prefix in the Trie.
     *   This method searches for each character in input word and if found then, returns that TrieNode else returns null. **/
    private TrieNode searchNode(String word){
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }
            else
                return null;
        }
        return t;
    }

}



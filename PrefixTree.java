//TC: O(n*l) 
//SC: O(n*l*26)  n- given list of words, l length of each word, 26 array size
//leetcode: successful

class Trie {
    Node root;
    class Node{
        boolean flag;
        Node[] children = new Node[26];
        public Node(){
            flag = false;
        }
    }

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(temp.children[c-'a'] == null){
                temp.children[c-'a'] = new Node();
            }
            temp = temp.children[c-'a'];
        }
        temp.flag = true;
    }
    
    public boolean search(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(temp.children[c-'a'] == null){
                return false;
            }
            temp = temp.children[c-'a'];
        }
        return temp.flag;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(temp.children[c-'a'] == null){
                return false;
            }
            temp = temp.children[c-'a'];
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

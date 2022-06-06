//Time Complexity :O(L)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
class Trie {
    public class Node{
        char c;
        boolean isWord;
        Node[] children;
        public Node(char c){
            this.c = c;
            this.children = new Node[26];
            this.isWord = false;
        }
    }
    Node root;
    public Trie() {
        root  = new Node('\0');
    }
    public void insert(String word) {
        Node curr = root;
        for(int i =0;i<word.length();i++){
            char cc = word.charAt(i);
            if(curr.children[cc-'a'] == null) curr.children[cc-'a'] = new Node(cc);
            curr = curr.children[cc-'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for(int i = 0;i<word.length();i++){
            char cc = word.charAt(i);
            if(curr.children[cc-'a'] == null) return false;
            curr = curr.children[cc-'a'];
        }
        return curr.isWord == true?true:false;
    }

    public boolean startsWith(String word) {
        Node curr = root;
        for(int i = 0;i<word.length();i++){
            char cc = word.charAt(i);
            if(curr.children[cc-'a'] == null) return false;
            curr = curr.children[cc-'a'];
        }
        return true;
    }
}
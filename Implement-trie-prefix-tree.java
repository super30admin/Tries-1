//time - O(nk) - all functions
//space - O(nk) - trie

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
        for(int
            i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null)
                curr.children[ch-'a'] = new TrieNode();
            curr = curr.children[ch-'a'];
            if(i==word.length()-1) curr.isEnd = true;
        }
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null) return false;
            curr = curr.children[ch-'a'];
            if(i==word.length()-1 && curr.isEnd) return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(curr.children[ch-'a']==null) return false;
            curr = curr.children[ch-'a'];
            if(i==prefix.length()-1) return true;
        }
        return false;
    }
}
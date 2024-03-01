//TimeComplexity:
//insert : O(L)
//search: O(L)
//Prefix : O(length of prefix)
//SpaceComplexity: O(number of words in trie)

class Trie {

    class TrieNode {
        boolean isEnd;
        TrieNode children[];
        TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for(int i =0; i<word.length();i++) {
            if(current.children[word.charAt(i)-'a'] == null) {
                current.children[word.charAt(i)-'a'] = new TrieNode();
            }
            current = current.children[word.charAt(i)-'a'];
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for(int i =0; i<word.length();i++) {
            if(current.children[word.charAt(i)- 'a'] == null) {
                return false;
            }
            current = current.children[word.charAt(i)-'a'];
        }
        return current.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i =0; i< prefix.length();i++) {
             if(current.children[prefix.charAt(i) - 'a'] == null) {
                 return false;
             }
             current = current.children[prefix.charAt(i) - 'a'];
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
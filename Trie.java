// Time complexity - For all the methods - O(n)
//Space compleixty - insert-O(n), Others - O(1)
//Solved on leetcod e- yes
// faced any issue s- no
//  To insert a word, it traverses the Trie character by character, creating new nodes as needed, and marks the end of the word. Searching and prefix-checking follow a similar traversal path, verifying that the characters exist in sequence and checking if the final node is marked as the end of a word (for search) or simply exists (for prefix).
class Trie {
    TrieNode root;
    class TrieNode {
        boolean isEnd;
        TrieNode nodes[];

        TrieNode() {
            this.nodes = new TrieNode[26];
        }
    }

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode currentNode = root;
        for(int i=0;i<word.length();i++) {
            int a = word.charAt(i) -'a';
            if(currentNode.nodes[a] ==null) {
                currentNode.nodes[a] = new TrieNode();
            }
            currentNode = currentNode.nodes[a];
        }
        currentNode.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode currentNode = root;
        for(int i=0;i<word.length();i++) {
            int a = word.charAt(i) -'a';
            if(currentNode.nodes[a] ==null) {
                return false;
            }
            currentNode = currentNode.nodes[a];
        }
        return currentNode.isEnd;
    }
    
    public boolean startsWith(String word) {
         TrieNode currentNode = root;
        for(int i=0;i<word.length();i++) {
            int a = word.charAt(i) -'a';
            if(currentNode.nodes[a] ==null) {
                return false;
            }
            currentNode = currentNode.nodes[a];
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

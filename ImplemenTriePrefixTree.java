class Trie {

    //Time Complexity : 0(n) where n:length of the word
    //Space Complexity: 0(n)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In brief explain your approach

    class TrieNode{ //Creation of a Trie DS
        TrieNode[] child;
        boolean isEnd;      //to store the status when a word is stored
        public TrieNode(){
            child = new TrieNode[26];
        }
    }
    TrieNode root;      //to navigate the trie

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);        //extracting characters from word 1 by 1 to compare
            if(current.child[c - 'a'] == null){     //checking if common character set already exist in the trie or not
                current.child[c - 'a'] = new TrieNode();        //if not, then creating a new node
            }
            current = current.child[c - 'a'];   //if yes, then just setting current to the child
        }
        current.isEnd = true;       //marking the status of the word true after completion

    }

    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(current.child[c - 'a'] == null){ //checking if the characters in word and trie matches or not
                return false;   //returning false if it does not
            }
            current = current.child[c - 'a'];   //setting current to the child if the character matches
        }
        return current.isEnd;   //returning isEnd because for that word to be present in trie, the status of isEnd should be true
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++){   //doing the same steps as searching a word
            char c = prefix.charAt(i);
            if(current.child[c - 'a'] == null){
                return false;
            }
            current = current.child[c - 'a'];
        }
        return true;        //returning true directly because we just need to check if the prefix exists or not rather than the entire word
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
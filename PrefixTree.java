//Time Complexity: O(nl), where n is the number of words and l is the average length of each word
//Space Complexity: O(nl), where n is the number of words and l is the average length of each word
//Did it run successfully on leetcode: Yes
//Did you face any issues coding the solution: No

class PrefixTree {
    TrieNode root = new TrieNode();
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            //every trie node has 26 children which is constant
            children = new TrieNode[26];
            //denotes if it's the end of the word
            isEnd = false;
        }
    }

    public void insert(String word) {
        //root is the empty trienode
        TrieNode curr = root;

        //For every character in a word, check if a trie node already exists for that character
        //If it already exists, go to the next character or else create a new trie node for that character
        //When the end of the word is reached, mark that character as end of the word.
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        //For every character in a word, check if a trie node already exists for that character
        //If it already exists, go to the next character or else return false
        //When the end of the word is reached, check if the entire word exists or not and return the result.
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        //For every character in a word, check if a trie node already exists for that character
        //If it already exists, go to the next character or else return false
        //When the end of the prefix word is reached, it means the entire prefix exists. So, return true
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(curr.children[c-'a'] == null) {
                return false;
            }
            curr = curr.children[c-'a'];
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
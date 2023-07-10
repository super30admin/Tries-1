public class TrieImplement {



        // TrieNode class
        class TrieNode {

            TrieNode[] children;

            boolean isEnd;

            // TrieNode constructor
            public TrieNode() {

                this.children = new TrieNode[26];
            }
        }

        private TrieNode root;

        //Trie Constructor
        public TrieImplement() {

            //a null root trie node
            this.root = new TrieNode();
        }

        //INSERT
        public void insert(String word) {

            TrieNode curr = root;

            for(int i = 0; i < word.length(); i++) { //O(L)

                char c = word.charAt(i);

                // if any appropriate word character is missing in TrieNode
                if(curr.children[c - 'a'] == null) {

                    // crreate a new TrieNode for insertion
                    curr.children[c - 'a'] = new TrieNode();
                }
                //move current from root to children
                curr = curr.children[c - 'a'];
            }
            //set boolean at current TrieNode end to zero
            curr.isEnd = true;
        }

        //SEARCH
        public boolean search(String word) { //O(L)

            TrieNode curr = root;

            for(int i = 0; i < word.length(); i++) {

                char c = word.charAt(i);

                // if any appropriate word character is missing in TrieNode, word not found
                if(curr.children[c - 'a'] == null) return false;

                // update current TrieNode
                curr = curr.children[c - 'a'];
            }
            // at times full length of word is present, but it might not have inserted priorly (isEnd != true), then return only false. Therefore, boolean of current TrieNode
            return curr.isEnd;
        }

        public boolean startsWith(String prefix) { //O(L)

            TrieNode curr = root;

            for(int i = 0; i < prefix.length(); i++) {

                char c = prefix.charAt(i);

                if(curr.children[c - 'a'] == null) return false;

                curr = curr.children[c - 'a'];
            }
            //once loop is finished, given prefix is covered
            return true;
        }


}

/*
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

/*
TIME COMPLEXITY = O(L)

L = length of word
N = number of words

SPACE COMPLEXITY = O(N*L)

For user oriented functions, space complexity = O(1)
*/
public class ImplementTrie {

    // Space complexity


    // Time complexity
    // insert -  o(n) - length of character
    // search - 0(n) - length of character


    class Trie {
        class TrieNode{
            boolean isEnd;
            TrieNode[] children;

            public TrieNode() {
                isEnd = false;
                children = new TrieNode[26];
            }

        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();

        }
        // Initialize the root.
        // iterate through the string to be inserted. At every current character,
        //check if current char is null, insert that letter.
        // at the end of for lopp, set the isEnd for current character true.

        public void insert(String word) {
            //Create new trieNode curr  and initialize to root.
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new TrieNode();
                }
                current = current.children[c - 'a'];
            }
            current.isEnd = true;
        }

        // Initialize the root.
        // iterate through the string to be searched. At every current character,
        //check if current char is null,  return false, if not null set currrent to current character
        // if al characters are found and if the last character is set to true word exists

        public boolean search(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (current.children[c - 'a'] == null) {
                    return false;
                }
                current = current.children[c - 'a'];
            }
            return current.isEnd;

        }

        // Initialize the root.
        // iterate through the string to be searched. At every current character,
        //check if current char is null,  return false, if not null set currrent to current character
        // if al characters are found  until the last return true.

        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if(current.children[c - 'a'] == null){
                    return false;
                }
                current = current.children[c - 'a'];
            }
            return true;

        }
    }


}

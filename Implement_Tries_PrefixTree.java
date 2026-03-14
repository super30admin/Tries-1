/*

Use a tree where each node represents a character and each node stores links to the next possible characters (26 children for a–z).

While inserting or searching a word, traverse character by character from the root, creating nodes if missing for insert, and verifying nodes exist for search or prefix check.

 */

/*

Insertion Time = O(L)
Search Time = O(L)
Prefix Check = O(L)
Space Complexity = O(N × L), L = length of string

 */

class Trie {
    TrieNode root;

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }



    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){ // battle
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a']; 
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) { // searching for prefix
        TrieNode curr = root;
        for(char c: prefix.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
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

// class TrieNode {
//     TrieNode[] children;
//     boolean isLeaf;

//     TrieNode()
//     {
//         children = new TrieNode[26];
//         isLeaf = false;
//     }
// }

// public class Trie {
//     TrieNode root;

//     public Trie() { root = new TrieNode(); }

//     // Method to insert a key into the Trie
//     public void insert(String key)
//     {
//         TrieNode curr = root;
//         for (char c : key.toCharArray()) {
//             if (curr.children[c - 'a'] == null) {
//                 curr.children[c - 'a'] = new TrieNode();
//             }
//             curr = curr.children[c - 'a'];
//         }
//         curr.isLeaf = true;
//     }

//     // Method to search a key in the Trie
//     public boolean search(String key)
//     {
//         TrieNode curr = root;
//         for (char c : key.toCharArray()) {
//             if (curr.children[c - 'a'] == null) {
//                 return false;
//             }
//             curr = curr.children[c - 'a'];
//         }
//         return curr.isLeaf;
//     }

//     // Method to check if a prefix exists in the Trie
//     public boolean isPrefix(String prefix)
//     {
//         TrieNode curr = root;
//         for (char c : prefix.toCharArray()) {
//             if (curr.children[c - 'a'] == null) {
//                 return false;
//             }
//             curr = curr.children[c - 'a'];
//         }
//         return true;
//     }

//     public static void main(String[] args)
//     {
//         Trie trie = new Trie();
//         String[] arr
//             = {"and", "ant", "do", "dad"};
//         for (String s : arr) {
//             trie.insert(s);
//         }
//         String[] searchKeys = { "do", "gee", "bat" };
//         for (String s : searchKeys) {
//             if (trie.search(s))
//                 System.out.print("true ");
//             else
//                 System.out.print("false ");
//         }
//         System.out.println();
//         String[] prefixKeys = { "ge", "ba", "do", "de" };
//         for (String s : prefixKeys) {
//             if (trie.isPrefix(s))
//                 System.out.print("true ");
//             else
//                 System.out.print("false ");
//         }
//     }
// }
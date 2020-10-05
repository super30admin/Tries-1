// Time Complexity :Insertion of m words - O(m*n) n is avg length
// findprefix O(n*m) where n is the length of the word... m= number of word

// Space Complexity : for each level we create array of 26 so we will create n times such arrays(since n=word length) for m words 
// so O(m*n) n=word length m=words....or O(n) where n = the number of unique trienodes in trie ds 

// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
Trie ds with TrieNodes

first we insert all the words in the dictionary

for each word in the sentence we do findPrefix function
which returns the prefix if it gets else gives the word itself

findprefix(str) if str == cattle and prefix = cat
for each char in given str, c->a->t we return the word formed so far if (isEnd = true) for any level 
else while going from c->a of cattle if we see that 'a' is null then return word, else add it to string builder



*/

////////////////////////////////////////// Approach 2
// instead of isEnd we can have word which stores the word if its at end else word is""

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie T = new Trie();

        StringBuilder res = new StringBuilder();
        for (String str : dictionary) {
            T.insert(str);
        }

        String list[] = sentence.split("\\s+");
        for (String str : list) {
            res.append(T.findPrefix(str) + " ");
        }

        // to the trim the last white space
        return res.toString().trim();
    }

    public class Trie {
        TrieNode head;
        TrieNode temp;

        public Trie() {
            head = new TrieNode();
            temp = head;
        }

        public String findPrefix(String word) {
            temp = head;
            StringBuilder sbr = new StringBuilder();

            for (char ch : word.toCharArray()) {

                if (temp.isEnd == true)
                    return sbr.toString();
                if (temp.children[ch - 'a'] == null)
                    return word;
                temp = temp.children[ch - 'a'];
                sbr.append(ch);
            }
            return word;
        }

        public void insert(String word) {
            temp = head;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (temp.children[ch - 'a'] == null) {
                    temp.children[ch - 'a'] = new TrieNode();
                }
                temp = temp.children[ch - 'a'];
            }
            temp.isEnd = true;
        }
    }

    public class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }
}
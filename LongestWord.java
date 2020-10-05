// Time Complexity :insertion - O(n*m) where n is number of words and m is average word length
// dfs - worst case is we have to search all the trie nodes in the ds.
// so O(n) where n is the total number of unique TrieNode at all level

// Space Complexity :O(n) where n is the total number of unique TrieNode at all level
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*

trie ds is used,
but instead of isEnd we used (String)word to store the whole word at the end,
and if that TrieNode isnt the end we put "" for word (String)


first we insert all the strings given

then we do dfs for each available option using temp (place this at head) 
BASE CASE -> if the word stored in temp (either "" or the word) is bigger than the stored max then replace it

else for all the elements in children array,
if temp.children has any TrieNode available and the word at that children is not ""(i.e. it is the end) then go explore it (do dfs for that node)
here the lexicogarphical order is maintained since we are exploring from i=0 to 25 (a to z)

*/

class Solution {
    public String longestWord(String[] words) {
        String result = "";
        Trie T = new Trie();
        T.insert(words);
        T.dfs(T.head);

        return T.result;
    }

    class TrieNode {
        String word;
        TrieNode[] children;

        public TrieNode() {
            word = "";
            children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode head;
        TrieNode temp;
        String result = "";

        public Trie() {
            head = new TrieNode();
            temp = head;
        }

        public void insert(String[] stringSet) {
            for (String str : stringSet) {
                temp = head;
                for (char ch : str.toCharArray()) {
                    if (temp.children[ch - 'a'] == null) {
                        temp.children[ch - 'a'] = new TrieNode();
                    }
                    temp = temp.children[ch - 'a'];
                }
                temp.word = str;
            }
        }

        public void dfs(TrieNode temp) {
            if (temp.word.length() > result.length()) {
                result = temp.word;
            }

            for (int i = 0; i < 26; i++) {
                if (temp.children[i] != null && temp.children[i].word != "") {
                    dfs(temp.children[i]);
                }
            }
        }
    }
}
//Time complexity : O(n) (n for inserting and searching one word)
//Space complexity : O(n) Number of words stored in the trie
//Runs successfully on leetcode
//No Problem

//Here in the begining we will be inserting all the words into the trie
//After inserting we'll be applying dfs on the whole tire tree
//If at some point we find that a word is not present at node, we'll return that call

public class Tries_1_Problem_2_longestWord {
    class Solution {
        TrieNode root;
        String max = "";
        int maxlen = 0;
        public String longestWord(String[] words) {
            if(words == null || words.length == 0) return "";

            root = new TrieNode();

            for(String str : words)
            {
                insertIntoTrie(str);
            }

            dfsTrie(root);

            return max;
        }

        public void insertIntoTrie(String str)
        {
            TrieNode temp = root;
            for(int i = 0 ; i < str.length() ; i ++)
            {
                if(temp.children[str.charAt(i) - 'a'] == null)
                {
                    temp.children[str.charAt(i) - 'a'] = new TrieNode();
                }
                temp = temp.children[str.charAt(i) - 'a'];
            }
            temp.word = str;
        }

        public void dfsTrie(TrieNode root)
        {
            if(root == null) return;

            if(root.word!=null)
            {
                if(root.word.length() == maxlen)
                {
                    if(root.word.compareTo(max)>0)
                    {
                        max = root.word;
                        maxlen = root.word.length();
                    }

                }
                else if(root.word.length()>maxlen)
                {
                    max = root.word;
                    maxlen = root.word.length();
                }
            }

            for(int i = 0 ; i < 26 ; i ++)
            {
                dfsTrie(root.children[i]);
            }
        }

    }

    class TrieNode
    {
        String word;
        TrieNode[] children;
        TrieNode()
        {
            word = null;
            children = new TrieNode[26];
        }
    }
}

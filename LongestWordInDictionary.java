/*
Time Complexity: O(N*L), here N is the number of the words in the String array and L is the length of each word
Space Complexity: O(N*L), inserting all the words in the Trie data structure
Run on Leetcode: Yes

Approach:
1. Create TrieNode, Trie class with insert method, and use depth first search on the TrieNode
2. First I will add all the words given in the String array in to the Trie data structure, that would enable us to
build tree and do DFS on the tree, which base condition where we have node.isEnd == false or no further node is there,
that means node == null, very time whenever I would encounter a word whose length is greater than my answer,
I am gonna update my answer with that word
 */
public class LongestWordInDictionary {
    public class TrieNode{
        TrieNode [] children;
        boolean isFalse;
        String word;

        TrieNode(){
            children = new TrieNode[26];
        }
    }

    public class Trie{
        TrieNode root;

        Trie(){
            root = new TrieNode();
            root.isFalse = true;
            root.word = "";
        }

        public void addWord(String word){
            TrieNode node = root;
            for(int i = 0; i<word.length(); i++){
                char ch = word.charAt(i);
                if(node.children[ch-'a'] == null){
                    node.children[ch-'a'] = new TrieNode();
                }
                node = node.children[ch-'a'];
            }
            node.isFalse = true;
            node.word = word;
        }
    }

    public String ans = "";
    public String longestWordInDictionary(String[] words){
        Trie trie = new Trie();

        // add all the words in the trie data structure

        for(String word: words){
            trie.addWord(word);
        }

        // Depth first search on the Trie data structure
        doDepthSearchOnTheTrieNode(trie.root);
        return ans;
    }
    public void doDepthSearchOnTheTrieNode(TrieNode node){
        // base condition
        if(node == null || node.isFalse == false){
            return;
        }

        if(node.word.length()> ans.length()){
            ans = node.word;
        }

        for(int i =0; i<26; i++){
            doDepthSearchOnTheTrieNode(node.children[i]);
        }
    }

    public static void main(String[] args){
        LongestWordInDictionary obj = new LongestWordInDictionary();
        LongestWordInDictionary obj1 = new LongestWordInDictionary();
        String[] words = {"w","wo","wor","worl","world"};
        String[] words1 = {"a","banana","app","appl","ap","apply","apple"};
        System.out.println("Longest word in dictionary: "+obj.longestWordInDictionary(words));
        System.out.println("Longest word in dictionary in lexicographical order: "+obj1.longestWordInDictionary(words1));
    }
}

/*
Time Complexity: O(L), where L is the length of the given word
Space Complexity: O(1), constant as we created our own TrieNode class
Run on Leetcode: yes
Any difficulties: No

Approach:
1. Implementing Character tree Trie data structure using TrieNode class with children and isEnd as a variables
2. Attempted after discussed in the class
 */
public class ImplementTriePrefixTree {
    public static class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        TrieNode(){
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
    public static class Trie{
        TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            TrieNode node = root;

            for(int i = 0; i<word.length(); i++){
                char c = word.charAt(i);

                if(node.children[c-'a'] == null){
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.isEnd = true;
        }

        public boolean search(String word){
            TrieNode node = root;

            for(int i = 0; i<word.length(); i++){
                char c = word.charAt(i);
                if(node.children[c-'a'] == null){
                    return false;
                }
                node = node.children[c-'a'];
            }
            return node.isEnd;
        }
        public boolean isPrefix(String prefix){
            TrieNode node = root;

            for(int i = 0; i<prefix.length(); i++){
                char c = prefix.charAt(i);
                if(node.children[c-'a'] == null){
                    return false;
                }
                node = node.children[c-'a'];
            }
            return true;
        }
    }
    public static void main(String[] args){
        Trie obj = new Trie();
        obj.insert("priyanshi");
        System.out.println(obj.search("priya"));
        System.out.println(obj.isPrefix("priya"));
    }
}

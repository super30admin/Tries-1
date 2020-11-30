/*
Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. 
If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:
Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
Input: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: 
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
Note:

All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].
*/


// Time Complexity Using Trie + DFS: O(n * L) // n = length of the list, L = length of the longest word in the list

class Solution {
    
    public String longestWord(String[] words) {
        
        Trie node = new Trie();
        int index = 0;
        
        for(String word: words){
            
            node.insert(word, ++index);
        }
        
        
        return node.dfs(words);
    }
    
    class TrieNode {

        public char value;
        public TrieNode[] character = new TrieNode[26];
        public int end = 0;

        public TrieNode() {}

        public TrieNode(char c){

            // TrieNode node = new TrieNode();
            // node.value = c;

            value = c;
        }
    }
    
    class Trie {
    
        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {

            root = new TrieNode(' ');
        }

        /** Inserts a word into the trie. */
        public void insert(String word, int index) {


            TrieNode cur = root;

            for(int i = 0; i < word.length(); i++){

                char letter = word.charAt(i);

                if(cur.character[letter - 'a'] == null){

                    cur.character[letter - 'a'] = new TrieNode(letter);
                }

                cur = cur.character[letter - 'a'];
            }

            cur.end = index;
        }
        
        public String dfs(String[] words){
            
            String res = "";
            Stack<TrieNode> stack = new Stack<TrieNode>();
            stack.push(root);
            
            while(!stack.empty()){
                
                TrieNode node = stack.pop();
                
                //System.out.println(node.value);
                
                if(node.end > 0 || node == root){
                    
                    if(node != root){
                        
                        String word = words[node.end - 1];
                    
                        if(word.length() > res.length() || (word.length() == res.length()) && word.compareTo(res) < 0){
                            res = word;
                           // System.out.println(res);
                        }
                    }
                    for(int i = 0; i < node.character.length; i++){

                        if(node.character[i] != null){
                            stack.push(node.character[i]);
                        }
                    }
                }
            }
            
            return res;
        }
    }

}


// Alternate Solution by sorting and using HashSet

// T: O(n log(n * L)) where n = length of the list, and L = Average length of the word (or the length of the longest word)

class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<String>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                built.add(w);
            }
        }
        return res;
    }
}
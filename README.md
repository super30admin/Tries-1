# Tries-1

## Problem1

Implement Trie (Prefix Tree)(https://leetcode.com/problems/implement-trie-prefix-tree/)

//Time Complexity : O(L)
//Space Complexity : O(L)

class Trie {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c-'a'];
        }
        current.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(current.children[c-'a'] == null) {
                return false;
            } else {
                current = current.children[c-'a'];
            }
        }
        return current.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(current.children[c-'a'] == null) {
                return false;
            } else {
                current = current.children[c-'a'];
            }
        }
        return true;
    }

}

/\*\*

- Your Trie object will be instantiated and called as such:
- Trie obj = new Trie();
- obj.insert(word);
- boolean param_2 = obj.search(word);
- boolean param_3 = obj.startsWith(prefix);
  \*/

## Problem2

Longest Word in Dictionary(https://leetcode.com/problems/longest-word-in-dictionary/)

//Time Complexity : O(Nk + L)
//Space Complexity : O(L)

class Solution {
class TrieNode {
boolean isEnd;
TrieNode[] children;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;

    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
        }
        current.isEnd = true;
    }
    public String longestWord(String[] words) {
        if(words == null || words.length == 0) {
            return "";
        }
        root = new TrieNode();
        for(String word : words) {
            insert(word);
        }
        String result = new String();
        //Arrays.sort(words);
        for(String word : words) {
            StringBuilder temp = new StringBuilder();
            TrieNode current = root;

            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(current.children[c-'a'].isEnd) {
                    current = current.children[c-'a'];
                    temp.append(c);
                } else {
                    break;
                }
            }
            if(current.isEnd) {
                if(result.length() < temp.toString().length()) {
                    result = temp.toString();
                  //  System.out.println(result);
                } else if(result.length() == temp.toString().length()) {
                    if(result.compareTo (temp.toString()) > 0) {
                        result = temp.toString();
                       // System.out.println(result);
                    }
                }
            }
        }
        return result;
    }

}

## Problem3

Replace Words (https://leetcode.com/problems/replace-words/)

//Time Complexity : O(Nk + L)
//Space Complexity : O(Nk + L)

class Solution {
class TrieNode {
boolean isEnd;
TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root;

    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
        }
        current.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || dictionary.size() == 0) {
            return sentence;
        }
        root = new TrieNode();
        for(String word : dictionary) {
            insert(word);
        }

        String[] splitArray = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();

        for(int j = 0; j < splitArray.length; j++) {
            if(j > 0) {
                result.append(' ');
            }
            TrieNode current = root;
            String word = splitArray[j];
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(current.children[c-'a'] == null || current.isEnd) {
                    break;
                }
                current = current.children[c-'a'];
                temp.append(c);
            }

            if(current.isEnd) {
                result.append(temp.toString());
            } else {
                result.append(word);
            }
        }
        return result.toString();

    }

}

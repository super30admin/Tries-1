/*
Approach1:
- As the problem says you need to replace the derivative with the smallest root, we need to find the prefix that means we can use trie for storing the words in the dictionary and then iterate through the words in sentence and swap by its smallest prefix, if no smallest prefix found, keep the word as is
- TC to create trie: O(n * l) -> lenght of each word and total number of words in the dictionary
- TC to search and replace with shortest prefix: O(m * l) -> number of words in a sentence ans length of each word
- TC: O(n*l + m*l)
- SC:O(n*l + m*l) -> for creating tries and for splitting the sentence into array of string 

Approach2:
- We can use HashSet as well to search for the smallest prefix but the search becomes O(l^2) for each word as we will have to do nested isterations
- Overall TC: O(n*l (for creating a hashset) + m * l^2)
- Overall SC: O(n*l + m*l)
 */
class Solution {
    TrieNode root;
    //create a trieNode class
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        private TrieNode() {
            this.children = new TrieNode[26];
        }
    }
    //insert elements into the trieNode
    private void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new TrieNode();
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    private String getShortestVersion(String word) {
        TrieNode curr = root;
        StringBuilder temp = new StringBuilder();
        for (char ch : word.toCharArray()) {
            // if we dont find the trienode on the particular index OR we have found the shortest prefix, get out of the for loop
            if (curr.children[ch - 'a'] == null || curr.isEnd) {
                break;
            }
            // else append the character and increment the level of the curr pointer
            temp.append(ch);
            curr = curr.children[ch - 'a'];
        }
        if(curr.isEnd)
            return temp.toString();
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        //insert words from dictionary into trie
        for (int i = 0; i < dictionary.size(); i++) {
            insert(dictionary.get(i));
        }
        // iterate over each word from sentence to replace it with a new shorterversion of the derivative
        StringBuilder res = new StringBuilder();
        String[] splitArr = sentence.split(" ");

        for (int i = 0; i < splitArr.length; i++) {
            if (i > 0)
                res.append(" ");
            res.append(getShortestVersion(splitArr[i]));
        }

        return res.toString();
    }
}
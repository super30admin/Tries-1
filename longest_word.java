//tc: O(nl), where n is the number of words and l is the average length of each word
//sc: O(nl)
//leetcode: successful
class Solution {
    TrieNode root = new TrieNode();
    class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private void insert(String word) {
        //root is the empty trienode
        TrieNode curr = root;

        //When the end of the word is reached, mark that character as end of the word.
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }

    public String longestWord(String[] words) {
        //base case
        if(words == null || words.length == 0) return "";

        for(String word: words) {
            insert(word);
        }
        TrieNode curr = root;
        Queue<TrieNode> q = new LinkedList<>();
        q.add(curr);

        // Traverse the trie from right to left to return the longest word with the smallest lexicographical order.
        // Add the children to queue if it's children not null and the word of the children is not null
        while(!q.isEmpty()) {
            curr = q.poll();
            for(int i=25; i>=0; i--) {
                if(curr.children[i] != null && curr.children[i].word != null) {
                    q.add(curr.children[i]);
                }
            }
        }

        //if none of the children's words is not null
        // for example., if 'a' doesn't exist in the dict but 'apple' exists and the same happens for all words
        if(curr.word == null) return "";

        else return curr.word;

    }
} 
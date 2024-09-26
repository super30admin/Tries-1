// Time Complexity - O(m*n) = m = words and n = maxLength of word;
// Space Complexity - O(L) = maxLength of word

class Solution {

    class TrieNode{
        TrieNode[] children;
        String str;
        TrieNode(){
            children = new TrieNode[26];
            str = "";
        }
    }

    TrieNode root;
    public String longestWord(String[] words) {
        root = new TrieNode();
        insert(words);
        return recursive(root);
    }

    private String recursive(TrieNode curr){
        String longestStr = curr.str;

        for(TrieNode node : curr.children){

            if(node == null || node.str == "")
                continue;
            String temp = recursive(node);
            if(temp.length() > longestStr.length())
                longestStr = temp;
        }
        return longestStr;
    }

    /** Inserts a words into the trie. */
    private void insert(String[] words) {
        for(String word: words){
            TrieNode curr = root;
            for(char ch : word.toCharArray()){
                if(curr.children[ch-'a'] == null)
                    curr.children[ch-'a'] = new TrieNode();

                curr = curr.children[ch-'a'];
            }
            curr.str = word;
        }
    }
}
// Time Complexity O(N x L^2)
// Space Complexity O(N x L)
// Runs on LeetCode YES
class Solution {
    TrieNode root;

    class TrieNode {
        Character val;
        boolean isEnd;
        TrieNode[] children;

        TrieNode(char ch) {
            this.val = ch;
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }

    public String longestWord(String[] words) {
        root = new TrieNode(' ');
        for (String word : words) {
            insert(word);
        }

        String result = "";
        for (String word : words) {
            StringBuilder sb = new StringBuilder();

            for(int i=0; i< word.length(); i++){
                sb.append(word.charAt(i));

                if(!search(sb.toString())){
                    break;
                }

                if( i == word.length() -1 && result.length() <= word.length()){
                    if(result.length() == word.length() && word.compareTo(result) > 0){
                        break;
                    }else{
                        result = word;
                    }

                }
            }

        }
        return result;
    }

    private void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new TrieNode(ch);
            }
            current = current.children[ch - 'a'];
        }
        current.isEnd = true;
    }

    private boolean search(String prefix){
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if (current.children[ch - 'a'] == null) {
                return false;
            }
            current = current.children[ch - 'a'];
        }
        return current.isEnd;
    }
}

// Time - O( Summation of w) w is the length of words used
// Space - O (Summation of w) Space used by Trie



class Solution {

    private String result = "";
    private TrieNode root;


    class TrieNode {

        TrieNode [] children = new TrieNode[26];
        String word;

        public TrieNode() {

        }

    }


    public void insert(String word) {

        TrieNode curr = root;

        for(int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null) {

                curr.children[c - 'a'] = new TrieNode();

            }

            curr = curr.children[c - 'a'];

        }
        curr.word = word;

    }


    public String longestWord(String[] words) {

        root = new TrieNode();


        for(String w: words) {

            insert(w);

        }

        dfs(root);

        return result;



    }


    private void dfs(TrieNode node) {

        if(node == null) return;


        if(node.word != null) {

            if(node.word.length() > result.length()) {
                result = node.word;
            }
            else if(node.word.length() == result.length() && node.word.compareTo(result) < 0 ){
                result = node.word;
            }

        }

        for(TrieNode child: node.children) {

            if(child != null && child.word != null)
                dfs(child);

        }



    }
}
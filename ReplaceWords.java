// Time COmplexity: O(n)
// Space COmplexity: O(n)
class TrieNode {
    char val;
    boolean isWord = false;
    TrieNode[] children = new TrieNode[26];
    TrieNode() {

    }
    TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }
}

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        if(dict == null || dict.size() == 0 || sentence == null ||sentence.length() == 0) {
            return sentence;
        }

        String[] tokens = sentence.split(" ");
        TrieNode root = buildTrie(dict);
        return replaceTokens(root, tokens);
    }

    private String replaceTokens(TrieNode root, String[] tokens) {
        StringBuilder sb = new StringBuilder();
        for(String token : tokens) {
            sb.append(getShortestLength(root, token));
            sb.append(" ");
        }
        return sb.toString().substring(0,sb.length()-1);
    }

    private String getShortestLength(TrieNode root, String token) {
        StringBuilder replace = new StringBuilder();
        TrieNode node = root;
        for(int i = 0; i < token.length(); i++) {
            char c = token.charAt(i);
            if(node.children[c-'a'] != null) {
                replace.append(c);
                node = node.children[c-'a'];
                if(node.isWord) {
                    return replace.toString();
                }
            } else {
                return token;
            }
        }
        return token;

    }

    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode();
        for(String str : dict) {
            TrieNode node = root;
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
        return root;
    }
}
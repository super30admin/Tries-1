/***
 TC - O(kn)
 SC - O(kn)
 */
class LongestWordInDict {

    String result = "";
    TrieNode root;

    public String longestWord(String[] words) {
        if(words == null || words.length == 0)
            return "";

        root = new TrieNode();

        for(String str : words) {
            insertInTrie(str);
        }

        dfs(root);
        return result;
    }

    public void dfs(TrieNode node) {
        if(node == null)
            return;

        if(node.word != null) {
            if((node.word.length() > result.length()))
                result = node.word;
        }

        for(TrieNode child : node.children) {
            if(child != null && child.word != null)
                dfs(child);
        }

    }

    public void insertInTrie(String str) {
        TrieNode curr = root;
        for(char ch : str.toCharArray()) {
            if(curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new TrieNode();

            curr = curr.children[ch-'a'];
        }

        curr.word = str;
    }

    class TrieNode{
        String word;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

}
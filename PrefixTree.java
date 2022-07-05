// Time Complexity:
    // Insert: O(m), where m is the length of the string
    // Search: O(m), where m is the length of the string
//Space Complexity: O(1)
public class PrefixTree {
    class TreeNode {
        boolean isEnd;
        TreeNode[] children;

        public TreeNode(){
            children = new TreeNode[26];
        }
    }
    private TreeNode root;

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode curr = root;
        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TreeNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TreeNode curr = root;
        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TreeNode curr = root;
        for(int i=0; i< prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        return true;
    }
}

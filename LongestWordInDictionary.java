public class LongestWordInDictionary {


    String result="";
    TreeNode root;
    public String longestWord(String[] words) {
        root = new TreeNode();

        for (String w : words)
            insert(w);

        dfs(root);

        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;

        if (node.word != null) {
            if (node.word.length() > result.length())
                result = node.word;
            else if (node.word.length() == result.length() && node.word.compareTo(result) < 0)
                result = node.word;
        }

        for (TreeNode child : node.children)
            if (child != null && child.word != null)
                dfs(child);
    }

    class TreeNode {
        TreeNode[] children = new TreeNode[26];
        String word;
        TreeNode () {}
    }

    private void insert(String word) {
        TreeNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null)
                current.children[c - 'a'] = new TreeNode();
            current = current.children[c - 'a'];
        }
        current.word = word;
    }
    public static void main(String[] s){
        LongestWordInDictionary lwd=new LongestWordInDictionary();
        //String result=lwd.longestWord(new String[]{"w","wo","wor","worl","world"});
        String result=lwd.longestWord(new String[]{"a","banana","app","appl","ap","apply","apple"});
        System.out.println(result);
    }

}

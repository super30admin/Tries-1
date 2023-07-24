//DFS:
// Time Complexity :O(n*l) where n is the number of words and l is the avg length of each word
// Space Complexity :O(n*l) where n is the number of words and l is the avg length of each word
// Did this code successfully run on Leetcode :yes

//BFS:
// Time Complexity :O(n*l) where n is the number of words and l is the avg length of each word
// Space Complexity :O(n*l) where n is the number of words and l is the avg length of each word
// Did this code successfully run on Leetcode :yes
public class LongestWord {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private TrieNode root;
    private String longestWord;

    public String longestWord(String[] words) {

        this.root = new TrieNode();
        this.longestWord = new String("");

        for(String word: words){
            insert(word);
        }

        dfs(root, new StringBuilder());
        return longestWord;
    }

    private void insert(String word){
        TrieNode current = root;
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<word.length(); i++){
            Character c = word.charAt(i);
            sb.append(c);
            if(current.children[c-'a'] == null){
                current.children[c-'a'] = new TrieNode();
            }
            current = current.children[c-'a'];
        }
        current.isEnd = true;
    }

    private void dfs(TrieNode node, StringBuilder sb){
        if(sb.length() > longestWord.length()){
            longestWord = sb.toString();
        }

        for(int i=0; i<26; i++){
            TrieNode child = node.children[i];
            if(child != null && child.isEnd){
                int len = sb.length();
                //action
                sb.append((char)('a'+ i));
                //recurse
                dfs(child, sb);
                //backtrack
                sb.setLength(len);
            }
        }
    }
}

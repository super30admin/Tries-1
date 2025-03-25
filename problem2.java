public class problem2

    //Time Complexity: o(n*l)
    // Space Complexity: o(n*l)
{
    class Solution {
        TrieNode root;

        class TrieNode{
            boolean isEnd;
            TrieNode[] children;

            public TrieNode(){
                this.children= new TrieNode[26];
            }
        }
        private void insert(String word)
        {
            TrieNode curr= root;
            for(char c: word.toCharArray())
            {
                if(curr.children[c-'a'] ==null)
                {
                    curr.children[c-'a']= new TrieNode();
                }
                curr= curr.children[c-'a'];

            }
            curr.isEnd= true;
        }
        String result;
        public String longestWord(String[] words) {
            this.root= new TrieNode();
            for(String word: words)
            {
                insert(word);
            }
            this.result="";
            dfs(root, new StringBuilder());
            return result;

        }
        private void dfs(TrieNode curr, StringBuilder path)
        {
            //base case
            if(result.length()<path.length())
            {
                result= path.toString();
            }

            //logic
            for(int i=0;i<26;i++)
            {
                if(curr.children[i]!=null && curr.children[i].isEnd)
                {
                    //action
                    int len= path.length();
                    path.append((char)(i+'a'));

                    //recurse
                    dfs(curr.children[i], path);
                    //backtrack
                    path.setLength(len);
                }
            }
        }
    }
}

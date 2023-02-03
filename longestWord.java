// Time Complexity: O(nl)
// Space Complexity: O(26^L)

class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public String longestWord(String[] words) {
        StringBuilder result = new StringBuilder();
        root = new TrieNode();
        for(String word: words){
            insert(word);
        }

        Queue<TrieNode> q= new LinkedList<>();
        q.add(root);
        Queue<StringBuilder> sq = new LinkedList<>();
        sq.add(new StringBuilder());

        while(!q.isEmpty()){
            TrieNode curr = q.poll();
            result = sq.poll();

            for(int i = 25; i >= 0; i--){
                if(curr.children[i] != null && curr.children[i].isEnd){
                    q.add(curr.children[i]);
                    StringBuilder copyStr = new StringBuilder(result);
                    copyStr.append((char)('a' + i));
                    sq.add(copyStr);
                }
            }
        }
        return result.toString();
    }
}
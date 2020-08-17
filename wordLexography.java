/* Time complexity: O(n*L); where L is the length of the longest word
Space complexity: O(L)
*/

class Solution{
    class TrieNode{
        String word;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    public void insert(String word){
        TrieNode curr = root;
        for(int i=0; i<word.length; i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }

    public String longestWord(String[] words){
        root = new TrieNode();
        for(String word: words){
            insert(word);
        }

        Queue<TrieNode> q = new LinkedList<>();
        q.add(root); TrieNode curr = null;
        while(!q.isEmpty()){
            TrieNode curr = q.poll();
            for(int i=25; i>=0; i--){
                if(curr.children[i] != null && curr.children[i].word != null){
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}
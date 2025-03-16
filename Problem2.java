// BFS based search/traversal of trie/tree
// TC: O(n x l) n: words array length, l: avg length of word
// SC: O(n x l)
class Solution {
    class TrieNode{
        String word;
        TrieNode[] children;
        TrieNode(){
            children = new TrieNode[26];
            word = "";
        }
    }

    TrieNode root;

    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }


    public String longestWord(String[] words) {
        if(words == null || words.length == 0) return "";
        root = new TrieNode();
        for(String w : words){
            insert(w);
        }
        Queue<TrieNode> q = new LinkedList<>();
        TrieNode curr = root;
        q.add(root);
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25; i >= 0; i--){
                if(curr.children[i] != null && curr.children[i].word != ""){
                    q.add(curr.children[i]);
                }
            }  
        }
        return curr.word;
    }
}

/*TC -O(L) sum of length of all the words , SC - O(L)
 * */

class TrieNode{
    String word;
    TrieNode[] children;
    public TrieNode(){
        this.children = new TrieNode[26];
    }
}
class Solution {
    TrieNode root = new TrieNode();
     public void insert(String word){
        TrieNode curr = root;
        for (int i = 0 ; i < word.length(); i++){
             char ch = word.charAt(i);
            if (curr.children[ch-'a'] == null){
                  curr.children[ch-'a'] = new TrieNode();
            }

             curr = curr.children[ch-'a'];
        }
        curr.word = word;

    }
    public String longestWord(String[] words) {

        // add all the words to the prefix tree
        // check for the length of longest word
        for (String wordl: words){
            insert(wordl);
        }
        // move from z - a for maintining the lexicographical order of the nodes
        Queue<TrieNode> queue  = new LinkedList<>();
        TrieNode curr= null;
        queue.add(root);
        while(!queue.isEmpty()){
             curr = queue.poll();
            // iteratie through its childeren from right to left
            for (int i = 25; i >= 0 ; i--){
                if (curr.children[i] != null && curr.children[i].word != null){
                    queue.add(curr.children[i]);
                }
            }



        }
        if (curr.word == null) return "";
        return curr.word;

    }


}

/**
// Time Complexity : O(n) ~= 26^l
                     in worst case
                     n = number of nodes.
                     l = level of trie tree.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// nope

// Your code here along with comments explaining your approach
 */
class Solution {
    public String longestWord(String[] words) {
        Trie tr = new Trie();
        for(String word : words)
            tr.add(word);

        return tr.getString();
    }
}

class Trie{
    String retString;
    class Node{
        char letter;
        Node child[];
        String word;
        Node(char letter, boolean last){
            this.word = null;
            this.letter = letter;
            this.child = new Node[26];
        }
    }
    Node head;

    Trie(){
        head = new Node(' ', false);
        retString = "";
    }
    public void add(String word){
        Node node = head;
        int indx = 0;

        while(indx < word.length()){
            char ch = word.charAt(indx++);
            Node cnode = node.child[ch-'a'];
            if(cnode == null){
                cnode = new Node(ch, false);
                node.child[ch-'a'] = cnode;
            }
            node = cnode;
        }
        node.word = word;
    }
    public String getString(){
        Queue<Node> qu = new LinkedList<>();
        Node node = head;
        qu.offer(node);
        while(!qu.isEmpty()){
            node = qu.poll();
            for(int i = 25; i >= 0 ; i--){
                Node cnode = node.child[i];
                if(cnode != null && cnode.word != null){
                    qu.offer(cnode);
                }
            }
        }
        return node.word;
    }

}

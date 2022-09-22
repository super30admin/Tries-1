// Time Complexity : O(Nk)
// Space Complexity : O(Nk)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Form the trie and attach each word to the trie node and perform BFS, from z to a
if children is present and isend then add to queue
the last node in queue is the answer.
*/
public class LongestWordInDict {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        String word;
        TrieNode(){
            children= new TrieNode[26];
        }
    }

    TrieNode root;
    public String longestWord(String[] words) {

        if(words==null || words.length==0) return "";
        root= new TrieNode();

        for(String word:words){
            insert(word);
        }

        Queue<TrieNode> queue= new ArrayDeque<>();
        queue.offer(root);
        TrieNode curr= new TrieNode();
        while(!queue.isEmpty()){
            curr= queue.poll();
            for(int i=25;i>=0;i--){
                if(curr.children[i]!=null && curr.children[i].isEnd){
                    queue.offer(curr.children[i]);
                }
            }
        }

        return curr.word==null ? "" :  curr.word;
    }

    private void insert(String word){
        TrieNode curr= root;

        for(char ch: word.toCharArray()){
            if(curr.children[ch-'a']==null) curr.children[ch-'a']= new TrieNode();
            curr= curr.children[ch-'a'];
        }
        curr.word=word;
        curr.isEnd=true;
    }
}

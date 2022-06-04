// Time Complexity : O(n*m), n = dictionary size, m=word length
// Space Complexity : O(N) Nsize of trie
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class ReplaceWords {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode() {
            children  = new TrieNode[26];
        }
    }

    private TrieNode root;
    public void insert(String word) {
        //point curr to parent/root
        TrieNode  curr = root;
        //traverse the word character by character
        for(int i=0; i<word.length(); i++) {
            //calculate the index to add TrieNode
            char c = word.charAt(i);
            //check for the index if it  has TriieNode or it is null
            //if it is null then create TrieNode
            if(curr.children[c - 'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            //updatee curr to that TrieNode
            curr = curr.children[c - 'a'];
        }
        curr.isEnd  = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String s : dictionary)
            insert(s);
        String[] strArr = sentence.split(" ");
        StringBuilder result  = new StringBuilder();
        for(String word : strArr) {
            StringBuilder replacement  = new StringBuilder();
            TrieNode curr = root;

            for(int i=0;i<word.length();i++) {
                char c = word.charAt(i);
                if(curr.children[c-'a']==null || curr.isEnd) break;
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            if(curr.isEnd)  {
                replacement.append(" ");
                result.append(replacement);
            }else{
                result.append(word+" ");
            }
        }
        return result.toString().trim();
    }
}

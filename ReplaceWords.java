// Time Complexity : O((N+M)L)
// Space Complexity : O(NL)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Create a trie with all the words in the dictionary
// Then go over the words in the sentence letter by letter and compare it against the trie

class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a']==null) curr.children[ch-'a'] = new TrieNode();
            curr = curr.children[ch-'a'];
            if(curr.isEnd==true) break;
        }
        curr.isEnd = true;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        root = new TrieNode();
        for(String word:dictionary){
            insert(word);
        }
        for(int i=0;i<words.length;i++){
            TrieNode curNode = root;
            String cur = words[i];
            StringBuilder rep = new StringBuilder(); 
            for(int j=0;j<cur.length();j++){
                char ch = cur.charAt(j);
                if(curNode.children[ch-'a']==null || curNode.isEnd) break;
                rep.append(ch);
                curNode = curNode.children[ch-'a'];
            }
            if(curNode.isEnd) result.append(rep.toString());
            else result.append(cur);
            result.append(" ");
        }
        return result.toString().trim();
    }
}
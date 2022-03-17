// Time Complexity : o(n *l) where l is the length of word being inserted
// Space Complexity : o(n *l) whre is n is number of words i dictionary and l is average length of word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach, create TrieNode and perform operations in iterative fashion, at each step we need to check if tehre is word, if its not word then return

class Solution {

    TrieNode root;
    int len;
    String res;

    public String longestWord(String[] words) {

        Arrays.sort(words);

        root = new TrieNode();
        len = Integer.MIN_VALUE;
        res = "";

        insert("");

        for(String word: words){
            insert(word);
        }

        return res;
    }

    public void insert(String word){

        int currLen = 0;

        TrieNode curr = root;

        for( char ch : word.toCharArray()){

            if(!curr.end) return;

            TrieNode temp = curr.map[ch-'a'];

            if(temp == null){
                temp = new TrieNode();
            }

            curr.map[ch-'a'] = temp;
            curr = temp;
            currLen++;

        }

        curr.end = true;

        if(currLen > len){
            len = currLen;
            res = word;
        }

    }
}

class TrieNode{

    public TrieNode[] map;
    public boolean end;

    public TrieNode(){
        map = new TrieNode[26];
        end = false;
    }
}

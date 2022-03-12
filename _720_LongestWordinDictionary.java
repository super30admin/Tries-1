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

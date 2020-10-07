/*
TC: O(W) W - sum of length of all words in array words.To build Trie and search it. 
SC: O(W) space required to create trie. 

1. A Trie is built for all words in the array. 
2. The longest word must have all its prefixes in the array. It is denoted by variable word in TNode.
3. Length of word is stored as global variable and updated. 
4. If word at any list TNode is null, and length is less than result we need not process that Trie. 

*/

class LongestWord {
    
    private TNode root;
    private String result = "";
    public String longestWord(String[] words){

        root = new TNode();
        insert(words);
        dfs(root);
        return result;

    }

    private void insert(String[] words){
        for(String word : words){
            TNode cur = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(cur.list[c - 'a'] == null){
                    cur.list[c - 'a'] = new TNode();
                }
                cur = cur.list[c - 'a'];
            }
            cur.word = word;
        }
    }

    private void dfs(TNode root){

        if(root.word.length() > result.length())
            result = root.word;
        
        for(int i = 0; i < 26; i++){
            if(root.list[i] != null){
                dfs(root.list[i]);
            }
        }
    }

    public static void main(String[] args){
        LongestWord lw = new LongestWord();
        String[] words = {"a","b","app","ba","ap","ban","bana"};
        System.out.println(lw.longestWord(words));
    }
}



class TNode{

    TNode[] list;
    String word;

    public TNode(){
        this.list = new TNode[26];
        this.word = "";
    }
}

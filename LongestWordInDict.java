//DFS + Trie
//TC: N * l +  N *l, N = number of words in dictionary , l = avg length of the words. For inserting and then finding the longest string
//SC: N * l, for making the trie
// Did this code successfully run on Leetcode : yes
// Approach : put all the words in dictionary and then traverse over trie using DFS to find longest word possible.

class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    String maxStr = new String();

    public String longestWord(String[] words) {
        for(String word : words){
            insert(word);
        }

        backtrack(root,new StringBuilder());
        
        return maxStr;

    }

    private void backtrack(TrieNode curr , StringBuilder path){
        //base
        if(path.length() > maxStr.length()){
            maxStr = path.toString();
        }

        //logic
        for(int i = 0 ; i < 26 ; i++){
            if(curr.children[i] != null && curr.children[i].isEnd){
                int len = path.length();
                //action
                path.append((char)(i + 'a'));

                //recurse
                backtrack(curr.children[i], path);

                //backtrack
                path.setLength(len);
            }
        }

    }
}

//BFS + Trie
//TC: N * l +  N *l, N = number of words in dictionary , l = avg length of the words. For inserting and then finding the longest string
//SC: N * l, for making the trie
// Did this code successfully run on Leetcode : yes

class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }


    public String longestWord(String[] words) {
        for(String word : words){
            insert(word);
        }

        Queue<TrieNode> q = new LinkedList<>();
        Queue<String> sq = new LinkedList<>(); // to maintain the string generated

        q.add(root);
        sq.add("");

        String str = "";

        while(!q.isEmpty()){
            TrieNode curr = q.poll();
            str = sq.poll();

            //process the children - in reverse order such that we get lexicographical smaller character is given out in the end
            for(int i = 25 ; i >= 0 ; i--){
                if(curr.children[i] != null && curr.children[i].isEnd){
                    q.add(curr.children[i]);
                    sq.add(str + (char)(i + 97));
                }
            }
        }

        return str;
    }

    
}
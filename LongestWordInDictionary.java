/*
- Create a trie with all the words given in the array of string
- We can either traverse the trie using BFS or DFS. 
- DFS: Go deeper only if the path forms a valid word(check using the isEnd flag)
TC: O(n * l) -> to create a trie and to iterate over the trie -> n - number of words, l - length of the word
SC: O(n * l) -> to store the words in trie and recursive stack space (which will be the length of each word)
 */

class Solution {
    TrieNode root;
    String result;
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        private TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word){
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new TrieNode();
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    public String longestWord(String[] words) {
        this.root = new TrieNode();
        this.result = "";
        for(int i = 0; i < words.length; i++){
            insert(words[i]);
        }

        dfs(root, new StringBuilder());

        return result;
    }

    private void dfs(TrieNode curr, StringBuilder path){
        //base
        // if the current path is greater than the previously set result, update the result
        // if the length of path and result is same, that means we have already found a word that is lexicographically smaller than the currently found word of the same length
        if(path.length() > result.length()){
            result = path.toString();
        }

        //logic
        // iterate over all the cells within the children array, if the cell has a TrieNode and the flag isEnd is true
        // get the length of the path (for backtracking), append the current character in the path, run dfs on the children of the current node and backtrack if no matching character found
        for(int i = 0; i < 26; i++){
            if(curr.children[i] != null && curr.children[i].isEnd){
                int len = path.length();

                //action
                path.append((char)(i + 'a'));
                //recurse
                dfs(curr.children[i], path);

                //backtrack
                path.setLength(len);
            }
        }
    }
}

// Approach2: BFS
//TC: O(n * l) -> to create a trie and to iterate over the trie -> n - number of words, l - length of the word
//SC: O(n * l) -> to store the words in trie and maintain BFS queues

class Solution {
    
    String result;
    TrieNode root;

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word){
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public String longestWord(String[] words) {
        this.root = new TrieNode();
        for(String word: words){
            insert(word);
        }

        bfs(root);

        return result;
    }

    private void bfs(TrieNode curr){
     
        String currStr = "";
        //child queue
        Queue<TrieNode> q = new LinkedList<>();
        //corresponding string queue
        Queue<String> strQ = new LinkedList<>();

        q.add(root);
        strQ.add(currStr);
       
        while(!q.isEmpty()){
            curr = q.poll();
            currStr = strQ.poll();
            // backward tracking to maintain lexicographical order
            for(int i=25; i>=0; i--){
                if(curr.children[i] != null && curr.children[i].isEnd){
                    q.add(curr.children[i]);
                    strQ.add(currStr+(char)(i+'a'));
                }
            }
        }

        result = currStr;
    }

}

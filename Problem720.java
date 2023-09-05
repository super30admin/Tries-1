class Problem720 {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    TrieNode root;

    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    public String longestWord(String[] words) {
        this.root = new TrieNode();
        if (words == null || words.length == 0) 
            return "";
        for (String word : words) {
            insert(word);
        }
        Queue<TrieNode> q=new LinkedList<>();
        Queue<String> sq=new LinkedList<>();
        q.add(root);
        sq.add("");
        String maxStr="";
        while(!q.isEmpty()){
            TrieNode curr=q.poll();
            maxStr=sq.poll();
            for(int i=25; i>=0;i--){
                TrieNode child=curr.children[i];
                if(child!=null && child.isEnd){
                    q.add(child);
                    sq.add(maxStr + (char)('a' + i));
                }
            }   
        }
        return maxStr;
    }
    
}

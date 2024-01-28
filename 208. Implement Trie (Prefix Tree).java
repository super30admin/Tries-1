class Trie {

    private class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        boolean terminate = false;

        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("terminate: ");
            sb.append(this.terminate);
            sb.append("\n");
            this.map.forEach((key, value) -> sb.append(key + "\n"));
            return sb.toString();
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        char[] w = word.toCharArray();
        TrieNode node = root;

        for(char c : w){
            if(!node.map.containsKey(c)){
                node.map.put(c, new TrieNode());
            }
            //System.out.println(node);
            node = node.map.get(c);
        }

        node.terminate = true;
        //System.out.println(node);
        
    }
    
    public boolean search(String word) {

        char[] w = word.toCharArray();
        TrieNode node = root;

        for(char c : w){
            if(!node.map.containsKey(c)){
                return false;
            } else {
                node = node.map.get(c);
            }
        }

        return node.terminate;
        
    }
    
    public boolean startsWith(String prefix) {
        char[] w = prefix.toCharArray();
        TrieNode node = root;

        for(char c : w){
            if(!node.map.containsKey(c)){
                return false;
            } else {
                node = node.map.get(c);
            }
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

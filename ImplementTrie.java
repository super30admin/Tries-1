class Trie {
    boolean isTerminated;
    Trie sub[];
    public Trie() {
        isTerminated = false;
        sub = new Trie[26];
    }

    public void insert(String word) {
        if(word.length()==0)
            return;
        int index = word.charAt(0)-'a';
        if(sub[index]==null)
            sub[index] = new Trie();
        sub[index].insert(word.substring(1));
        if(word.length()==1)
            sub[index].isTerminated = true;
    }

    public boolean search(String word) {
        int index = word.charAt(0)-'a';
        if(word.length()==1)
            return sub[index] != null && sub[index].isTerminated;
        return sub[index] !=null && sub[index].search(word.substring(1));
    }

    public boolean startsWith(String prefix) {
        int index = prefix.charAt(0)-'a';
        if(prefix.length()==1)
            return sub[index] != null;
        return sub[index] !=null && sub[index].startsWith(prefix.substring(1));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
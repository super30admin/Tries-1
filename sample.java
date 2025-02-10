class Trie {
    class TrieNode {
        TrieNode[] children=new TrieNode[26];
        boolean isEnd;
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr=root;
        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr=root;
        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        if (curr.isEnd == true){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for (int i=0;i<prefix.length();i++) {
            char c = prefix.charAt(i);
            if (curr.children[c-'a'] == null) {
                return false;
            }
            curr = curr.children[c-'a'];
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



class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    StringBuilder answer = new StringBuilder();

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for (int j=0;j<dictionary.size();j++) {
            insert(dictionary.get(j));
        }
        String[] words= sentence.split(" ");

        for (int i=0;i<words.length;i++) {
            if (i != 0) {
                answer.append(" ");
            }
            search(words[i]);
        }
        return answer.toString();
    }

    private void insert(String word) {
        TrieNode curr = root;
        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    private void search(String word) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if (curr.isEnd == true) {
                break;
            }
            if (curr.children[c-'a'] == null) {
                break;
            }
            curr = curr.children[c-'a'];
            sb.append(word.charAt(i));
        }
        if (curr.isEnd == true) {
            answer.append(sb.toString());
        } else {
            answer.append(word);
        }
    }
}

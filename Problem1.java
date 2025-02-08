public class Problem1 {
    class Trie {
        class TrieNode{
            TrieNode[] children;
            boolean isEnd;
            TrieNode(){
                children = new TrieNode[26];
                isEnd = false;
            }
        }
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        //t.c -> O(n)
        public void insert(String word) {
            TrieNode curr = root;
            //for each char go check the children for root and check if its null or not
            for(int i = 0;i<word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null){
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true;
        }
        //t.c -> O(n)
        public boolean search(String word) {
            TrieNode curr = root;
            for(int i = 0;i<word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null){
                    return false;
                }
                curr = curr.children[c-'a'];
            }
            return curr.isEnd;
        }
        //t.c -> O(n)
        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for(int i = 0;i<prefix.length();i++){
                char c = prefix.charAt(i);
                if(curr.children[c-'a'] == null){
                    return false;
                }
                curr = curr.children[c-'a'];
            }
            return true;
        }
    }
}

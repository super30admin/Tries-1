
//Time Complexity: O(n)
// Space Complexity: O(1)

public class ImplementTrie {
        class TrieNode{
            TrieNode[] children;
            boolean isEnd;
            public TrieNode(){
                children = new TrieNode[26];
                isEnd = false;
            }
        }

        TrieNode root;
        public ImplementTrie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                int val = c - 'a';
                if(curr.children[val] == null){
                    curr.children[val] = new TrieNode();
                }
                curr = curr.children[val];
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c -'a'] == null){
                    return false;
                }else{
                    curr = curr.children[c -'a'];
                    if(i == (word.length()-1) && curr.isEnd ){
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for(int i=0;i<prefix.length();i++){
                char c = prefix.charAt(i);
                if(curr.children[c -'a'] == null){
                    return false;
                }else{
                    curr = curr.children[c -'a'];
                }
            }
            return true;
        }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}

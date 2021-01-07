/*
class TrieNode:
    def __init__(self):
        #self.word = ""   it is not same as None dont uncomment
        self.word = None 
        self.children = [None]*26
        
class Solution:
    def insert(self, word):
        cur = self.root
        for c in word:
            if cur.children[ord(c) - ord('a')] is None:
                cur.children[ord(c) - ord('a')] = TrieNode()
            cur = cur.children[ord(c) - ord('a')]
        
        cur.word = word
        
        
    def longestWord(self, words: List[str]) -> str:
        if words is None or len(words) == 0:
            return ""
        
        self.root = TrieNode()
        for word in words:
            self.insert(word)
        
        queue = collections.deque()
        queue.append(self.root)
        node = self.root
        while len(queue) > 0:
            node = queue.popleft()
            for i in range(25, -1, -1):
                if node.children[i] is not None and node.children[i].word is not None:
                    queue.append(node.children[i])
                    
        if node is None:
            return ""
        return node.word
*/
/*
// dfs based approach
class Solution {
    class TrieNode {
        String word;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    private void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }
    StringBuilder ans;
    public String longestWord(String[] words) {
        root = new TrieNode();
        root.word = "&";
        ans = new StringBuilder();
        for(String word : words) {
            insert(word);
        }
        dfs(root);
        return ans.toString();
    }
    private void dfs(TrieNode root) {
        if(root == null || root.word == null) {
            return;
        }
        for(int i = 25; i >= 0; i --) {
            if(root.children[i] != null && root.children[i].word != null && ans.length() <= root.children[i].word.length()){
                ans = new StringBuilder();
                ans.append(root.children[i].word);
            }
            dfs(root.children[i]);
        }
    }
}

*/

// Time Complexity : O(n*m) where n is words size and m is average length of each word
// Space Complexity : O(n*m) as in worst case all the words might be in queue
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach: I maintained a trie and instead of maintaining a boolean value at each
// level i maintained a string upto that level

class TrieNode{
    String word;
    TrieNode[] children;
    
    public TrieNode(){
        children = new TrieNode[26];
    }
}
class Solution {
    TrieNode root;
    
    private void insert(String word){
        TrieNode cur = root;
        for (int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = word;
    }
    
    public String longestWord(String[] words) {
        if (words == null || words.length == 0)
            return "";
        
        root = new TrieNode();
        for (String word: words){
            insert(word);
        }
        
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode cur = root;
        
        while (!q.isEmpty()){
            cur = q.poll();
            for (int i=25; i>=0; i--){
                if (cur.children[i] != null && cur.children[i].word != null){
                    q.add(cur.children[i]);
                }
            }
        }
        if (cur.word == null)
            return "";
        return cur.word;
    }
}